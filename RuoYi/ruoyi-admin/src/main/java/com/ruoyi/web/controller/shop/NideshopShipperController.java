package com.ruoyi.web.controller.shop;

import java.util.List;

import com.ruoyi.shop.domain.NideshopShipper;
import com.ruoyi.shop.service.INideshopShipperService;
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
 * 快递公司Controller
 *
 * @author ruoyi
 * @date 2019-11-28
 */
@Controller
@RequestMapping("/system/shipper")
public class NideshopShipperController extends BaseController
{
    private String prefix = "system/shipper";

    @Autowired
    private INideshopShipperService nideshopShipperService;

    @RequiresPermissions("system:shipper:view")
    @GetMapping()
    public String shipper()
    {
        return prefix + "/shipper";
    }

    /**
     * 查询快递公司列表
     */
    @RequiresPermissions("system:shipper:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NideshopShipper nideshopShipper)
    {
        startPage();
        List<NideshopShipper> list = nideshopShipperService.selectNideshopShipperList(nideshopShipper);
        return getDataTable(list);
    }

    /**
     * 导出快递公司列表
     */
    @RequiresPermissions("system:shipper:export")
    @Log(title = "快递公司", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NideshopShipper nideshopShipper)
    {
        List<NideshopShipper> list = nideshopShipperService.selectNideshopShipperList(nideshopShipper);
        ExcelUtil<NideshopShipper> util = new ExcelUtil<NideshopShipper>(NideshopShipper.class);
        return util.exportExcel(list, "shipper");
    }

    /**
     * 新增快递公司
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存快递公司
     */
    @RequiresPermissions("system:shipper:add")
    @Log(title = "快递公司", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NideshopShipper nideshopShipper)
    {
        return toAjax(nideshopShipperService.insertNideshopShipper(nideshopShipper));
    }

    /**
     * 修改快递公司
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        NideshopShipper nideshopShipper = nideshopShipperService.selectNideshopShipperById(id);
        mmap.put("nideshopShipper", nideshopShipper);
        return prefix + "/edit";
    }

    /**
     * 修改保存快递公司
     */
    @RequiresPermissions("system:shipper:edit")
    @Log(title = "快递公司", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NideshopShipper nideshopShipper)
    {
        return toAjax(nideshopShipperService.updateNideshopShipper(nideshopShipper));
    }

    /**
     * 删除快递公司
     */
    @RequiresPermissions("system:shipper:remove")
    @Log(title = "快递公司", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(nideshopShipperService.deleteNideshopShipperByIds(ids));
    }
}
