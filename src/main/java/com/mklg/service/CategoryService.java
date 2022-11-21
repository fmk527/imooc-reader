package com.mklg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mklg.pojo.Category;

import java.util.List;

/**
* @author fmk
* @description 针对表【category】的数据库操作Service
* @createDate 2022-11-17 20:10:46
*/
public interface CategoryService extends IService<Category> { List<Category> selectAll();

}
