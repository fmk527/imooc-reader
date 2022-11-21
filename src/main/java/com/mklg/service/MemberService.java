package com.mklg.service;

import com.mklg.pojo.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mklg.vo.UserVo;

/**
* @author fmk
* @description 针对表【member】的数据库操作Service
* @createDate 2022-11-18 22:03:01
*/
public interface MemberService extends IService<Member> {

    Boolean register(UserVo userVo);

    Member login(Member myMember);

    Member selectById(Long id);

    Integer selectReadState(Long bid, Long mid);

    void updateReadState(Long mid, Long bid, Integer readState);

}
