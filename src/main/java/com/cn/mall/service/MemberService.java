package com.cn.mall.service;


import com.cn.mall.pojo.Member;

public interface MemberService {

     Member login(String mobile, String pwd);


     boolean regist(Member member);
}
