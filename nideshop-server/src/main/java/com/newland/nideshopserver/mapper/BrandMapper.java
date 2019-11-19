package com.newland.nideshopserver.mapper;

import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xzt
 * @create 2019-10-11 10:48
 */
@Mapper
public interface BrandMapper extends MyMapper<NideshopBrand> {

}
