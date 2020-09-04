package com.cn.mall.dao;

import com.cn.mall.pojo.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {
    public List<Address> findByMember(int id) throws SQLException;
    //将当前会员的地址的默认值修改为0
    public void updateDefaultValue(int memberid);

    public void add(Address address);
    Address findById(int id);
}

