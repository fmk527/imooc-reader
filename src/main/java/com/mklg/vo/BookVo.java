package com.mklg.vo;

public class BookVo {
    private String categoryName;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Double getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(Double evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public Integer getEvaluationQuantity() {
        return evaluationQuantity;
    }

    public void setEvaluationQuantity(Integer evaluationQuantity) {
        this.evaluationQuantity = evaluationQuantity;
    }

    @Override
    public String toString() {
        return "BookVo{" +
                "categoryName='" + categoryName + '\'' +
                ", bookId=" + bookId +
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
