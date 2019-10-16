package com.newland.nideshopserver.service.impl;

import com.newland.nideshopserver.mapper.ChannelMapper;
import com.newland.nideshopserver.model.NideshopChannel;
import com.newland.nideshopserver.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author xzt
 * @CREATE2019-10-11 11:23
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelMapper channelMapper;


    @Override
    public List<NideshopChannel> selectAllOrder() {
        Example example = new Example(NideshopChannel.class);
        example.orderBy("sortOrder").asc();
        List<NideshopChannel> list = channelMapper.selectByExample(example);
        return list;
    }
}
