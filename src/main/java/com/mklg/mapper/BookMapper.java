package com.mklg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mklg.pojo.Book;
import com.mklg.vo.BookVo;
import org.apache.ibatis.annotations.Param;

/**
* @author fmk
* @description 针对表【book】的数据库操作Mapper
* @createDate 2022-11-18 16:00:02
* @Entity com.mklg.pojo.Book
*/
public interface BookMapper extends BaseMapper<Book> {
    public void updateScore();

    IPage<BookVo> MySelectPage(@Param("bookPage") IPage<Book> bookPage, @Param("bookVo") BookVo bookVo);
}




