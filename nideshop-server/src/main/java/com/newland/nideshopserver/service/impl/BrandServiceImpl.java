package com.newland.nideshopserver.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newland.nideshopserver.mapper.BrandMapper;
import com.newland.nideshopserver.model.NideshopBrand;
import com.newland.nideshopserver.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
        Example e = new Example(NideshopBrand.class);
        e.orderBy("newSortOrder");
        Example.Criteria c = e.createCriteria();
        c.andEqualTo("isNew", 1);
        Page<NideshopBrand> list = PageHelper.startPage(0, 4).doSelectPage(() -> brandMapper.selectByExample(e));
        return list;
    }

    @Override
    public NideshopBrand getById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public NideshopBrand findOneById(int id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
