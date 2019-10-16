package com.newland.nideshopserver.service.impl;

import com.newland.nideshopserver.mapper.BrandMapper;
import com.newland.nideshopserver.model.NideshopBrand;
import com.newland.nideshopserver.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xzt
 * @CREATE2019-10-11 13:05
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<NideshopBrand> list() {
        return brandMapper.list();
    }
}
