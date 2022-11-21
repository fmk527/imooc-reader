package com.mklg.vo;


public class UserVo {
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
     * 昵称
     */
    private String nickname;

    private String verifyCode;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "memberId=" + memberId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt=" + salt +
                ", nickname='" + nickname + '\'' +
                ", vc='" + verifyCode + '\'' +
                '}';
    }
}
