package com.newland.nideshopserver.model.dto;

import lombok.Data;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年11月6日 上午11:33:22
 * @version V1.0
 */
@Data
public class HandleOption {

	private Boolean cancel=false;
	private Boolean delete=false;
	private Boolean pay=false;
	private Boolean comment=false;
	private Boolean delivery=false;
	private Boolean confirm=false;
	private Boolean return0=false;
	private Boolean buy=false;
	

}
