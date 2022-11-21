package com.mklg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mklg.config.MenberException;
import com.mklg.mapper.MemberReadStateMapper;
import com.mklg.pojo.Member;
import com.mklg.pojo.MemberReadState;
import com.mklg.service.MemberService;
import com.mklg.mapper.MemberMapper;
import com.mklg.util.Md5Utils;
import com.mklg.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

/**
* @author fmk
* @description 针对表【member】的数据库操作Service实现
* @createDate 2022-11-18 22:03:01
*/
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)//默认不使用事务
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService{

    @Resource
    private MemberMapper memberMapper;
    @Resource
    private MemberReadStateMapper memberReadStateMapper;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean register(UserVo userVo) {
        LambdaQueryWrapper<Member> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Member::getUsername,userVo.getUsername());
        Member member = memberMapper.selectOne(wrapper);
        System.out.println(member);
        if(member!=null){
            throw new MenberException("用户名已经存在");
        }
        wrapper.or().eq(Member::getNickname,userVo.getNickname());
        Member member1 = memberMapper.selectOne(wrapper);
        System.out.println(member1);
        if(member1!=null){
            throw new MenberException("此昵称太火了，请换一个吧");
        }
        int salt = new Random().nextInt(1000) + 1000;
        userVo.setSalt(salt);
        Member user  = new Member(userVo.getUsername(), Md5Utils.md5Digest(userVo.getPassword(),userVo.getSalt()) , userVo.getSalt(), new Date(), userVo.getNickname());
        return memberMapper.insert(user) > 0;
    }


    @Override
    public Member login(Member myMember) {

        LambdaQueryWrapper<Member> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Member::getUsername,myMember.getUsername());
        Member member = memberMapper.selectOne(wrapper);
        if(member==null){
            throw new MenberException("用户密码不正确");
        }
        String password = Md5Utils.md5Digest(myMember.getPassword(), member.getSalt());
        wrapper.eq(Member::getPassword,password);
       return memberMapper.selectOne(wrapper);
    }

    @Override
    public Member selectById(Long id) {
        LambdaQueryWrapper<Member> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Member::getMemberId,id);
        Member member = memberMapper.selectOne(wrapper);
        if(member==null){
            throw new MenberException("无此用户！");
        }
        return member;
    }

    @Override
    public Integer selectReadState(Long bid, Long mid) {
        LambdaQueryWrapper<MemberReadState> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MemberReadState::getMemberId,mid).eq(MemberReadState::getBookId,bid);
        MemberReadState memberReadState = memberReadStateMapper.selectOne(wrapper);
        if(memberReadState==null) {
            return -1;
        }
        return memberReadState.getReadState();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateReadState(Long mid, Long bid, Integer readState) {
        LambdaQueryWrapper<MemberReadState> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MemberReadState::getMemberId,mid).eq(MemberReadState::getBookId,bid);
        MemberReadState memberReadState = memberReadStateMapper.selectOne(wrapper);
        if(memberReadState==null){
            int insert = memberReadStateMapper.insert(new MemberReadState(bid, mid, readState, new Date()));
            if(insert <= 0){
                throw new MenberException("状态数据异常！");
            }
        }else {
            LambdaQueryWrapper<MemberReadState> wrapper1 = new LambdaQueryWrapper<>();
            wrapper1.eq(MemberReadState::getMemberId,bid).eq(MemberReadState::getBookId,bid);
            int update = memberReadStateMapper.update(new MemberReadState(bid, mid, readState, new Date()), wrapper);
            if(update <= 0){
                throw new MenberException("状态数据异常！");
            }
        }


    }
}




