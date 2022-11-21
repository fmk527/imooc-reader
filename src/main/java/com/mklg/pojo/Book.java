package com.mklg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName book
 */
@TableName(value ="book")
public class Book implements Serializable {
    /**
     * 图书编号
     */
    @TableId(type = IdType.AUTO)
    private Long bookId;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 子标题
     */
    private String subTitle;

    /**
     * 作者
     */
    private String author;

    /**
     * 封面图片URL
     */
    private String cover;

    /**
     * 图书详情
     */
    private String description;

    /**
     * 分类编号
     */
    private Long categoryId;

    /**
     * 图书评分
     */
    private Double evaluationScore;

    /**
     * 评价数量
     */
    private Integer evaluationQuantity;

    public Book() {
    }

    public Book(Long bookId, String bookName, String subTitle, String author, String cover, String description, Long categoryId, Double evaluationScore, Integer evaluationQuantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.subTitle = subTitle;
        this.author = author;
        this.cover = cover;
        this.description = description;
        this.categoryId = categoryId;
        this.evaluationScore = evaluationScore;
        this.evaluationQuantity = evaluationQuantity;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 图书编号
     */
    public Long getBookId() {
        return bookId;
    }

    /**
     * 图书编号
     */
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    /**
     * 书名
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 书名
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * 子标题
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * 子标题
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 封面图片URL
     */
    public String getCover() {
        return cover;
    }

    /**
     * 封面图片URL
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * 图书详情
     */
    public String getDescription() {
        return description;
    }

    /**
     * 图书详情
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 分类编号
     */
    public  Long getCategoryId() {
        return categoryId;
    }

    /**
     * 分类编号
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 图书评分
     */
    public Double getEvaluationScore() {
        return evaluationScore;
    }

    /**
     * 图书评分
     */
    public void setEvaluationScore(Double evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    /**
     * 评价数量
     */
    public Integer getEvaluationQuantity() {
        return evaluationQuantity;
    }

    /**
     * 评价数量
     */
    public void setEvaluationQuantity(Integer evaluationQuantity) {
        this.evaluationQuantity = evaluationQuantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                ", evaluationScore=" + evaluationScore +
                ", evaluationQuantity=" + evaluationQuantity +
                '}';
    }
}