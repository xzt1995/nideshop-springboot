/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年10月17日 下午3:04:52
 * @version V1.0
 */
package com.newland.nideshopserver.service.impl;
import com.newland.nideshopserver.model.dto.CollectGoods;
import com.newland.nideshopserver.model.dto.CountSelect;
import com.newland.nideshopserver.utis.Utis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.CollectMapper;
import com.newland.nideshopserver.model.NideshopCollect;
import com.newland.nideshopserver.service.CollectService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年10月17日 下午3:04:52
 * @version V1.0
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public int isUserHasCollect(Integer userId, int typeId, Integer valueId) {
        NideshopCollect collect = new NideshopCollect();
        collect.setUserId(userId);
        collect.setTypeId(typeId);
        collect.setValueId(valueId);
        return collectMapper.selectCount(collect);
    }

    /**
     * 商品收藏
     * @param typeId
     * @param userId
     * @return
     */
    @Override
    public CountSelect listCount(int typeId, int userId) {
        int listCount = collectMapper.listCount(typeId, userId);
        List<CollectGoods> nideshopGoods = collectMapper.listAll(typeId, userId);
        // TODO: 2019/11/5 前端在收藏页面未做分页，故先自定义页面size以正常返回参数。
        CountSelect countSelect = new CountSelect();
        countSelect.setCount(listCount);
        countSelect.setTotalPages(Utis.totalPages(listCount, 10));
        countSelect.setPageSize(10);
        countSelect.setCurrentPage(1);
        countSelect.setData(nideshopGoods);
        return countSelect;
    }


    @Override
    public String addordelete(int typeId, int valueId, int userId) {
        Example e = new Example(NideshopCollect.class);
        Example.Criteria c = e.createCriteria();
        c.andEqualTo("typeId", typeId);
        c.andEqualTo("valueId", valueId);
        c.andEqualTo("userId", userId);
        NideshopCollect collect = collectMapper.selectOneByExample(e);
        String type ;
        //如果改商品未收藏过，则收藏，否则，取消收藏
        if (collect == null) {
            NideshopCollect newCollect = new NideshopCollect();
            newCollect.setUserId(userId);
            newCollect.setValueId(valueId);
            newCollect.setAddTime(System.currentTimeMillis() / 1000);
            newCollect.setTypeId(typeId);
            newCollect.setIsAttention(0);
            collectMapper.insert(newCollect);
            type = "add";
        } else {
            collectMapper.deleteByPrimaryKey(collect.getId());
            type = "delete";
        }
        return type;
    }
}
