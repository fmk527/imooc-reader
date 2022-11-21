package com.mklg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName member_read_state
 */
@TableName(value ="member_read_state")
public class MemberReadState implements Serializable {
    /**
     * 会员阅读状态
     */
    @TableId(type = IdType.AUTO)
    private Long rsId;

    /**
     * 图书编号
     */
    private Long bookId;

    /**
     * 会员编号
     */
    private Long memberId;

    /**
     * 阅读状态 1-想看 2-看过
     */
    private Integer readState;

    /**
     * 创建时间
     */
    private Date createTime;

    public MemberReadState() {
    }

    public MemberReadState(Long bookId, Long memberId, Integer readState, Date createTime) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.readState = readState;
        this.createTime = createTime;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 会员阅读状态
     */
    public Long getRsId() {
        return rsId;
    }

    /**
     * 会员阅读状态
     */
    public void setRsId(Long rsId) {
        this.rsId = rsId;
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
     * 阅读状态 1-想看 2-看过
     */
    public Integer getReadState() {
        return readState;
    }

    /**
     * 阅读状态 1-想看 2-看过
     */
    public void setReadState(Integer readState) {
        this.readState = readState;
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

    @Override
    public String toString() {
        return "MemberReadState{" +
                "rsId=" + rsId +
                ", bookId=" + bookId +
                ", memberId=" + memberId +
                ", readState=" + readState +
                ", createTime=" + createTime +
                '}';
    }
}