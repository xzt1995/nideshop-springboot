package com.ruoyi.web.controller.shop;

import java.util.List;

import com.ruoyi.shop.domain.NideshopOrder;
import com.ruoyi.shop.service.INideshopOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单Controller
 *
 * @author ruoyi
 * @date 2019-11-28
 */
@Controller
@RequestMapping("/system/order")
public class NideshopOrderController extends BaseController
{
    private String prefix = "system/order";

    @Autowired
    private INideshopOrderService nideshopOrderService;

    @RequiresPermissions("system:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询订单列表
     */
    @RequiresPermissions("system:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NideshopOrder nideshopOrder)
    {
        startPage();
        List<NideshopOrder> list = nideshopOrderService.selectNideshopOrderList(nideshopOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @RequiresPermissions("system:order:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NideshopOrder nideshopOrder)
    {
        List<NideshopOrder> list = nideshopOrderService.selectNideshopOrderList(nideshopOrder);
        ExcelUtil<NideshopOrder> util = new ExcelUtil<NideshopOrder>(NideshopOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单
     */
    @RequiresPermissions("system:order:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NideshopOrder nideshopOrder)
    {
        return toAjax(nideshopOrderService.insertNideshopOrder(nideshopOrder));
    }

    /**
     * 修改订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        NideshopOrder nideshopOrder = nideshopOrderService.selectNideshopOrderById(id);
        mmap.put("nideshopOrder", nideshopOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单
     */
    @RequiresPermissions("system:order:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NideshopOrder nideshopOrder)
    {
        return toAjax(nideshopOrderService.updateNideshopOrder(nideshopOrder));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("system:order:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(nideshopOrderService.deleteNideshopOrderByIds(ids));
    }
}
