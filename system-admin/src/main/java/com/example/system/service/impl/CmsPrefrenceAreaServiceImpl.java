package com.example.system.service.impl;

import com.example.system.mbg.mapper.CmsPrefrenceAreaMapper;
import com.example.system.mbg.model.CmsPrefrenceArea;
import com.example.system.mbg.model.CmsPrefrenceAreaExample;
import com.example.system.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选管理Service实现类
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
