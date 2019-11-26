package com.ruoyi.web.controller.shop;

import java.util.List;

import com.ruoyi.shop.domain.NideshopBrand;
import com.ruoyi.shop.service.INideshopBrandService;
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
 * 商城品牌列Controller
 *
 * @author ruoyi
 * @date 2019-11-26
 */
@Controller
@RequestMapping("/system/brand")
public class NideshopBrandController extends BaseController
{
    private String prefix = "system/brand";

    @Autowired
    private INideshopBrandService nideshopBrandService;

    @RequiresPermissions("system:brand:view")
    @GetMapping()
    public String brand()
    {
        return prefix + "/brand";
    }

    /**
     * 查询商城品牌列列表
     */
    @RequiresPermissions("system:brand:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NideshopBrand nideshopBrand)
    {
        startPage();
        List<NideshopBrand> list = nideshopBrandService.selectNideshopBrandList(nideshopBrand);
        return getDataTable(list);
    }

    /**
     * 导出商城品牌列列表
     */
    @RequiresPermissions("system:brand:export")
    @Log(title = "商城品牌列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NideshopBrand nideshopBrand)
    {
        List<NideshopBrand> list = nideshopBrandService.selectNideshopBrandList(nideshopBrand);
        ExcelUtil<NideshopBrand> util = new ExcelUtil<NideshopBrand>(NideshopBrand.class);
        return util.exportExcel(list, "brand");
    }

    /**
     * 新增商城品牌列
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商城品牌列
     */
    @RequiresPermissions("system:brand:add")
    @Log(title = "商城品牌列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NideshopBrand nideshopBrand)
    {
        return toAjax(nideshopBrandService.insertNideshopBrand(nideshopBrand));
    }

    /**
     * 修改商城品牌列
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        NideshopBrand nideshopBrand = nideshopBrandService.selectNideshopBrandById(id);
        mmap.put("nideshopBrand", nideshopBrand);
        return prefix + "/edit";
    }

    /**
     * 修改保存商城品牌列
     */
    @RequiresPermissions("system:brand:edit")
    @Log(title = "商城品牌列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NideshopBrand nideshopBrand)
    {
        return toAjax(nideshopBrandService.updateNideshopBrand(nideshopBrand));
    }

    /**
     * 删除商城品牌列
     */
    @RequiresPermissions("system:brand:remove")
    @Log(title = "商城品牌列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(nideshopBrandService.deleteNideshopBrandByIds(ids));
    }
}
