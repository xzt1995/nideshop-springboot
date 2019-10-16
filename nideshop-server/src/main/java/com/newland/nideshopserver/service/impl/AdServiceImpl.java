package com.newland.nideshopserver.service.impl;

import com.newland.nideshopserver.mapper.AdMapper;
import com.newland.nideshopserver.mapper.AdminMapper;
import com.newland.nideshopserver.model.NideshopAd;
import com.newland.nideshopserver.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xzt
 * @CREATE2019-09-29 14:22
 */
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdMapper adMapper;

    @Override
    public List<NideshopAd> selectByPositionId(int positionId) {
        NideshopAd ad = new NideshopAd();
        ad.setAdPositionId(positionId);
        List<NideshopAd> list = adMapper.select(ad);
        return list;
    }
}
