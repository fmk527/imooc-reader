package com.mklg.controller;

import com.mklg.pojo.Member;
import com.mklg.service.MemberService;
import com.mklg.util.Result;
import com.mklg.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/member/")
public class MemberController {
    @Resource
    private MemberService memberService;


    @PostMapping("/register")
    public Result<Member> register(@RequestBody UserVo userVo, HttpServletRequest request ){
        String verifyCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        if(StringUtils.isBlank(userVo.getVerifyCode()) ||StringUtils.isBlank(verifyCode)  || !userVo.getVerifyCode().equalsIgnoreCase(verifyCode)) {
            return Result.fail("验证码错误！");
        }else {
         Boolean register = memberService.register(userVo);
         if(register) {
             return Result.success();
         }else {
             return Result.fail("出现了小问题，请重试！");
         }
        }
    }

    @PostMapping("/check_login")
    public Result<Member> login(@RequestBody Member myMember){
       Member member = memberService.login(myMember);
           return Result.success(member);
    }

    @GetMapping("/selectById/{mid}")
    public Result<Member> selectById(@PathVariable("mid") Long id) {
       Member member=  memberService.selectById(id);
       return Result.success(member);
    }

    @GetMapping("/readState/{bid}/{mid}")
    public Result<Map<String,Integer>> selectReadState(@PathVariable("bid") Long bid, @PathVariable("mid") Long mid) {
        Integer readState = memberService.selectReadState(bid,mid);
        Map<String, Integer> map = new HashMap<>();
        map.put("readState",readState);
        return Result.success(map);
    }

    @PostMapping("/member_read_state/{mid}/{bid}/{readState}")
    public Result<Map<String,Integer>> updateReadState(@PathVariable("mid")Long mid,@PathVariable("bid")Long bid,@PathVariable("readState") Integer readState) {
        Map<String, Integer> map = new HashMap<>();
        memberService.updateReadState(mid,bid,readState);
       map.put("readState",readState);
       return Result.success(map);
    }


}
