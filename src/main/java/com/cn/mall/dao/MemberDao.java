package com.cn.mall.dao;


import com.cn.mall.pojo.Member;

public interface MemberDao {

    public Member findByMobileAndPwd(String mobile, String pwd);

    public Member findByMobile(String mobile);

    public void add(Member member);
}
