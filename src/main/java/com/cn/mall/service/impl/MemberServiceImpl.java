package com.cn.mall.service.impl;


import com.cn.mall.dao.MemberDao;
import com.cn.mall.dao.impl.MemberDaoImpl;
import com.cn.mall.pojo.Member;
import com.cn.mall.service.MemberService;

public class MemberServiceImpl implements MemberService {

    MemberDao memberDao = new MemberDaoImpl();  //创建数据库访问的对象

    @Override
    public Member login(String mobile, String pwd) {

        Member member = memberDao.findByMobileAndPwd(mobile, pwd);
        return member;
    }


    @Override
    public boolean regist(Member member) {
        //判断手机号是否存在
        Member mobile = memberDao.findByMobile(member.getMobile());
        if(mobile!=null){   //如果存存则返加null
            return false;
        }

        //如果不存在则完成添加的操作
        memberDao.add(member);
        return true;
    }
}
