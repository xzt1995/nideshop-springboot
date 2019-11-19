/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月17日 下午3:55:17   
 * @version V1.0 
 */
package com.newland.nideshopserver.model.dto;

import java.util.List;

import com.newland.nideshopserver.model.NideshopGoodsSpecification;

import lombok.Data;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月17日 下午3:55:17   
 * @version V1.0 
 */
@Data
public class Specification {

	private String name;
	private Integer specificationId;
	private List<NideshopGoodsSpecification> valueList;
	
}
