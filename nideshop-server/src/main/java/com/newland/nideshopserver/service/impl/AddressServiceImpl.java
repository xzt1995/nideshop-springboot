package com.newland.nideshopserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.AddressMapper;
import com.newland.nideshopserver.model.NideshopAddress;
import com.newland.nideshopserver.service.AddressService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年11月7日 上午10:32:23
 * @version V1.0
 */
@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressMapper addressMapper;

	@Override
	public NideshopAddress findUserDefaultAddress(Integer userId) {
		NideshopAddress adress = new NideshopAddress();
		adress.setUserId(userId);
		adress.setIsDefault(1);
		return addressMapper.selectOne(adress);
	}

	@Override
	public NideshopAddress findAddress(Integer addressId, Integer userId) {
		NideshopAddress adress = new NideshopAddress();
		adress.setUserId(userId);
		adress.setId(addressId);
		return addressMapper.selectOne(adress);
	}

	@Override
	public void add(NideshopAddress nideshopAddress) {
		addressMapper.insert(nideshopAddress);
	}

	@Override
	public void updateByIdAndUser(NideshopAddress nideshopAddress, Integer id, Integer userId) {
		Example example = new Example(NideshopAddress.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("id", id);
		criteria.andEqualTo("userId", userId);
		addressMapper.updateByExampleSelective(nideshopAddress, example);
	}

	@Override
	public void resetOtherDefault(Integer id, Integer userId) {
		if (id == null || userId == null) {
			return;
		}
		NideshopAddress record = new NideshopAddress();
		record.setIsDefault(0);

		Example example = new Example(NideshopAddress.class);
		Criteria c = example.createCriteria();
		c.andEqualTo("userId", userId);
		c.andNotEqualTo("id", id);
		addressMapper.updateByExampleSelective(record, example);
	}

	@Override
	public List<NideshopAddress> selectByUserId(Integer userId) {
		NideshopAddress record = new NideshopAddress();
		record.setUserId(userId);

		return addressMapper.select(record);
	}

	@Override
	public void delete(Integer id, Integer userId) {
		NideshopAddress address = new NideshopAddress();
		address.setId(id);
		address.setUserId(userId);
		addressMapper.delete(address);
	}

	@Override
	public NideshopAddress findByAddressId(int addressId) {
		Example e = new Example(NideshopAddress.class);
		Criteria c = e.createCriteria();
		c.andEqualTo("id",addressId);
		NideshopAddress nideshopAddress = addressMapper.selectOneByExample(e);
		return nideshopAddress;
	}
}
