package com.mklg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mklg.mapper.CategoryMapper;
import com.mklg.pojo.Category;
import com.mklg.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* @author fmk
* @description 针对表【category】的数据库操作Service实现
* @createDate 2022-11-17 20:10:46
*/
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)//默认不使用事务
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{
   @Resource
    private CategoryMapper categoryMapper;


    @Override
    public List<Category> selectAll() {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Category::getCategoryId);
        return categoryMapper.selectList(wrapper);
    }
}




