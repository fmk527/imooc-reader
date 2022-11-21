//package com.mklg.service;
//
//import com.mklg.pojo.Book;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.annotation.Resource;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:applicationContext.xml"})
//public class BookServiceTest {
//    @Resource
//    private BookService bookService;
//
//    @Test
//    public void selectById() {
//        Book book = bookService.selectById(2);
//        System.out.println(book);
//    }
//}