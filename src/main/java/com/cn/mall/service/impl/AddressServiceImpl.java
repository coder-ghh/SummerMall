package com.cn.mall.service.impl;

import com.cn.mall.dao.AddressDao;
import com.cn.mall.dao.impl.AddressDaoImpl;
import com.cn.mall.pojo.Address;
import com.cn.mall.service.AddressService;

import java.sql.SQLException;
import java.util.List;

public class AddressServiceImpl implements AddressService {
    AddressDao addressDao=new AddressDaoImpl();
    @Override
    public List<Address> findByMember(int id) throws SQLException {

        return addressDao.findByMember(id);
    }

    @Override
    public void add(Address address) {
        //应该对address进行判断如果不是默认地址，则直接将期添加到数据库中
        if(address.getDefault_value()==0){
            addressDao.add(address);
        }else{
            //如果address是默认地址，则需要将该会员所对应的地址的default_value先更新成0,然后再添加
            addressDao.updateDefaultValue(address.getMbr_id());
            addressDao.add(address);
        }
    }

    @Override
    public Address findById(int id) {

            return addressDao.findById(id);

    }
}
