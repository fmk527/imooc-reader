package com.mklg.controller.management;

import com.baomidou.mybatisplus.core.metadata.IPage;;
import com.mklg.pojo.Book;
import com.mklg.service.BookService;
import com.mklg.util.Result;
import com.mklg.vo.BookVo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/management/book")
public class MBookController {
    @Resource
    private BookService bookService;

    @PostMapping("/select/{page}/{pageSize}")
    public Result<IPage<BookVo>> getAll(@PathVariable("page") Integer page, @PathVariable("pageSize")Integer pageSize,@RequestBody BookVo bookVo) {
      IPage<BookVo> pages = bookService.getPage(page,pageSize,bookVo);
      return Result.success(pages);
    }
    @PostMapping("/upload")
    public Map uploadFile(@RequestParam("img")MultipartFile file, HttpServletRequest request) throws IOException {
        String uploadPath = request.getServletContext().getResource("/").getPath()+"/upload/";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String fileName = simpleDateFormat.format(new Date());

        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//富文本返回数据格式有要求
        file.transferTo(new File(uploadPath+fileName+suffix));
        Map result = new HashMap();
        result.put("errno",0);
        result.put("data",new String[]{"/upload/"+fileName+suffix});
        return result;
    }

    @PostMapping("/create")
    public Result<String> addBook(@RequestBody Book book){
        Document document = Jsoup.parse(book.getDescription());
        Elements elements = document.select("img");
        if(elements.size()==0){
          return Result.fail("图书未包含封面图片！");
        }
        //以第一张图片为图书封面
        String cover = elements.first().attr("src");
        book.setCover(cover);
        book.setEvaluationQuantity(0);
        book.setEvaluationScore(0d);
        bookService.addBook(book);
        return Result.success();
    }



    @PostMapping("/update")
    public Result<String> updatBook(@RequestBody BookVo bookVo){
        Document document = Jsoup.parse(bookVo.getDescription());
        Elements elements = document.select("img");
        if(elements.size()==0){
            return Result.fail("图书未包含封面图片！");
        }
        String cover = elements.first().attr("src");
        Book book = new Book(bookVo.getBookId(), bookVo.getBookName(), bookVo.getSubTitle(), bookVo.getAuthor(), cover, bookVo.getDescription(), bookVo.getCategoryId(), bookVo.getEvaluationScore(), bookVo.getEvaluationQuantity());
         bookService.updateBook(book);
         return Result.success();

    }

    @DeleteMapping("/delete/{bookId}")
    public Result<String> deleteBook(@PathVariable("bookId") Long bookId){
        Book book = new Book();
        book.setBookId(bookId);
        bookService.deleteBook(book);
        return Result.success();
    }
}
