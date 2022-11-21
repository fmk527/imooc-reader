package com.mklg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mklg.config.SystemException;
import com.mklg.mapper.BookMapper;
import com.mklg.mapper.EvaluationMapper;
import com.mklg.mapper.MemberReadStateMapper;
import com.mklg.pojo.Book;
import com.mklg.pojo.Evaluation;
import com.mklg.pojo.MemberReadState;
import com.mklg.service.BookService;
import com.mklg.vo.BookVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author fmk
* @description 针对表【bookVo】的数据库操作Service实现
* @createDate 2022-11-18 16:00:02
*/
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)//默认不使用事务
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService{
    @Resource
    private BookMapper bookMapper;
    @Resource
    private EvaluationMapper evaluationMapper;
    @Resource
    private MemberReadStateMapper memberReadStateMapper;
    @Override
    public IPage<Book> selectPage(Long categoryId, String order, Integer page, Integer rows) {
        Page<Book> bookPage = new Page<>(page, rows);
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        if(categoryId != null&&categoryId!=-1) {
            wrapper.eq(Book::getCategoryId,categoryId);
        }
        if(order != null) {
            if(order.equals("quantity")){
                wrapper.orderByDesc(Book::getEvaluationQuantity);
            }else if(order.equals("score")){
                wrapper.orderByDesc(Book::getEvaluationScore);
            }
        }else {
            wrapper.orderByDesc(Book::getEvaluationQuantity);
        }
        return bookMapper.selectPage(bookPage, wrapper);
    }

    @Override
    public Book selectById(Integer id) {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Book::getBookId,id);
        Book book = bookMapper.selectOne(wrapper);
        return book;
    }

    @Override
    public IPage<BookVo> getPage(Integer page, Integer pageSize, BookVo bookVo) {
        IPage<Book> bookPage = new Page<>(page, pageSize);
        //由于涉及多表查询，重写  使用动态sql
//        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
//        wrapper.like(StringUtils.isNoneBlank(bookVo.getBookName()),Book::getBookName, bookVo.getBookName())
//                .like(StringUtils.isNoneBlank(bookVo.getAuthor()),Book::getAuthor, bookVo.getAuthor())
//                .like(StringUtils.isNoneBlank(bookVo.getDescription()),Book::getDescription, bookVo.getDescription());

//        IPage<BookVo> bookIPage = bookMapper.selectPage(bookPage, wrapper);
      IPage<BookVo> bookIPage = bookMapper.MySelectPage(bookPage,bookVo);
        if(bookIPage==null){
            throw new SystemException("书籍数据错误！");
        }
        return bookIPage;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addBook(Book book) {
        int insert = bookMapper.insert(book);
        if(insert <= 0){
            throw new SystemException("插入失败！");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBook(Book book) {
        int update = bookMapper.updateById(book);
        if(update <= 0){
            throw new SystemException("更新失败！");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBook(Book book) {
        int i = bookMapper.deleteById(book);
        LambdaQueryWrapper<Evaluation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Evaluation::getBookId,book.getBookId());
        int delete = evaluationMapper.delete(wrapper);
        LambdaQueryWrapper<MemberReadState> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(MemberReadState::getBookId,book.getBookId());
        int i1 = memberReadStateMapper.delete(wrapper1);
//        if(i<=0 || delete<=0 || i1<=0){
//            throw new SystemException("数据错错误！");
//        }
    }


    //定时任务
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateScore() {
        bookMapper.updateScore();
    }
}




