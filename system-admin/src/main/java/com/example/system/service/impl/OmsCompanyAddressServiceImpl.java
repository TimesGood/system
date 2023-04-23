package com.example.system.service.impl;

import com.example.system.mbg.mapper.OmsCompanyAddressMapper;
import com.example.system.mbg.model.OmsCompanyAddress;
import com.example.system.mbg.model.OmsCompanyAddressExample;
import com.example.system.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
