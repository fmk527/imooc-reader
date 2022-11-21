package com.mklg.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName category
 */
@TableName(value ="category")
public class Category implements Serializable {
    /**
     * 分类编号
     */
    @TableId
    private Long categoryId;

    /**
     * 图书分类
     */
    private String categoryName;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}