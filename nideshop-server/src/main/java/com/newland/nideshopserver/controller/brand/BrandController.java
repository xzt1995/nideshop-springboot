package com.newland.nideshopserver.controller.brand;

import com.newland.nideshopserver.model.NideshopBrand;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author xzt
 * @CREATE2019-10-23 11:16
 */
@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/brand/detail")
    public Result detailAction(int id){
        NideshopBrand brand = brandService.findOneById(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("brand",brand);
        Result result = new Result();
        result.setData(map);
        return result;
    }
}
