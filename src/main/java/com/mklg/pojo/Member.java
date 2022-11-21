package com.mklg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName member
 */
@TableName(value ="member")
public class Member implements Serializable {
    /**
     * 会员编号
     */
    @TableId(type = IdType.AUTO)
    private Long memberId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private Integer salt;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 昵称
     */
    private String nickname;

    public Member() {
    }

    public Member(String username, String password, Integer salt, Date createTime, String nickname) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.createTime = createTime;
        this.nickname = nickname;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
     * 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 盐值
     */
    public Integer getSalt() {
        return salt;
    }

    /**
     * 盐值
     */
    public void setSalt(Integer salt) {
        this.salt = salt;
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
     * 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt=" + salt +
                ", createTime=" + createTime +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}