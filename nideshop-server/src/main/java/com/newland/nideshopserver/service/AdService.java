package com.newland.nideshopserver.service;

import com.newland.nideshopserver.model.NideshopAd;

import java.util.List;

/**
 * @author xzt
 * @CREATE2019-09-29 14:21
 */
public interface AdService {
    List<NideshopAd> selectByPositionId(int positionId);
}
