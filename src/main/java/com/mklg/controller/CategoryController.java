package com.mklg.controller;

import com.mklg.pojo.Category;
import com.mklg.service.CategoryService;
import com.mklg.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @RequestMapping("/list")
    public Result<List> list() {
        List<Category> list = categoryService.list();
        if(list.isEmpty()){
            return Result.fail("没有数据!");
        }
        return Result.success(list);
    }
}
