package com.cn.mall.service;

import com.cn.mall.pojo.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressService {
    public List<Address> findByMember(int id) throws SQLException;
    public void add(Address address);
    public Address findById(int id);
}
