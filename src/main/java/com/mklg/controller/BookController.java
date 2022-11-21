package com.mklg.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mklg.pojo.Book;
import com.mklg.service.BookService;
import com.mklg.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping("/list")
    public Result<IPage<Book>> list(Long categoryId, String order, Integer page) {
        IPage<Book> BookIPage = bookService.selectPage(categoryId, order, page, 10);
        return Result.success(BookIPage);
    }

    @GetMapping("/bid/{bid}")
    public Result<Book> selectById(@PathVariable("bid") Integer id) {
        Book book = bookService.selectById(id);
        if (book == null) {
            return Result.fail("没有数据");
        }
        return Result.success(book);
    }

}
