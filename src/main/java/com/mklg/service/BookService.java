package com.mklg.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mklg.pojo.Book;
import com.mklg.vo.BookVo;

/**
* @author fmk
* @description 针对表【book】的数据库操作Service
* @createDate 2022-11-18 16:00:02
*/
public interface BookService extends IService<Book> {
IPage<Book> selectPage(Long categoryId,String order,Integer page,Integer rows);

    Book selectById(Integer id);
    void updateScore();

    IPage<BookVo> getPage(Integer page, Integer pageSize, BookVo bookVo);

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(Book book);
}
