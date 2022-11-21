package com.mklg.vo;

;

import java.util.Date;

public class EvaluationVo {

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
     * 点赞数量
     */
    private Integer enjoy;

    private  String nickname;

    public Long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getEnjoy() {
        return enjoy;
    }

    public void setEnjoy(Integer enjoy) {
        this.enjoy = enjoy;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "EvaluationVo{" +
                "evaluationId=" + evaluationId +
                ", content='" + content + '\'' +
                ", score=" + score +
                ", createTime=" + createTime +
                ", enjoy=" + enjoy +
                ", member=" + nickname +
                '}';
    }
}
