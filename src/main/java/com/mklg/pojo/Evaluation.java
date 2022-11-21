package com.mklg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName evaluation
 */
@TableName(value ="evaluation")
public class Evaluation implements Serializable {
    /**
     * 评价编号
     */
    @TableId(type = IdType.AUTO)
    private Long evaluationId;

    /**
     * 短评内容
     */
    private String content;

    /**
     * 评分-5分制
     */
    private Integer score;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 会员编号
     */
    private Long memberId;

    /**
     * 图书编号
     */
    private Long bookId;

    /**
     * 点赞数量
     */
    private Integer enjoy;

    /**
     * 审核状态 enable-有效 disable-已禁用
     */
    private String state;

    /**
     * 禁用理由
     */
    private String disableReason;

    /**
     * 禁用时间
     */
    private Date disableTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 评价编号
     */
    public Long getEvaluationId() {
        return evaluationId;
    }

    /**
     * 评价编号
     */
    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
    }

    /**
     * 短评内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 短评内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 评分-5分制
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 评分-5分制
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 会员编号
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * 会员编号
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

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
     * 点赞数量
     */
    public Integer getEnjoy() {
        return enjoy;
    }

    /**
     * 点赞数量
     */
    public void setEnjoy(Integer enjoy) {
        this.enjoy = enjoy;
    }

    /**
     * 审核状态 enable-有效 disable-已禁用
     */
    public String getState() {
        return state;
    }

    /**
     * 审核状态 enable-有效 disable-已禁用
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 禁用理由
     */
    public String getDisableReason() {
        return disableReason;
    }

    /**
     * 禁用理由
     */
    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
    }

    /**
     * 禁用时间
     */
    public Date getDisableTime() {
        return disableTime;
    }

    /**
     * 禁用时间
     */
    public void setDisableTime(Date disableTime) {
        this.disableTime = disableTime;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "evaluationId=" + evaluationId +
                ", content='" + content + '\'' +
                ", score=" + score +
                ", createTime=" + createTime +
                ", memberId=" + memberId +
                ", bookId=" + bookId +
                ", enjoy=" + enjoy +
                ", state='" + state + '\'' +
                ", disableReason='" + disableReason + '\'' +
                ", disableTime=" + disableTime +
                '}';
    }

}