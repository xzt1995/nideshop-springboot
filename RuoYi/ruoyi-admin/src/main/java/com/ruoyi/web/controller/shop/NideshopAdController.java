package com.ruoyi.web.controller.shop;

import java.util.List;

import com.ruoyi.shop.domain.NideshopAd;
import com.ruoyi.shop.service.INideshopAdService;
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
 * 首页轮播广告Controller
 *
 * @author ruoyi
 * @date 2019-11-26
 */
@Controller
@RequestMapping("/system/ad")
public class NideshopAdController extends BaseController
{
    private String prefix = "system/ad";

    @Autowired
    private INideshopAdService nideshopAdService;

    @RequiresPermissions("system:ad:view")
    @GetMapping()
    public String ad()
    {
        return prefix + "/ad";
    }

    /**
     * 查询首页轮播广告列表
     */
    @RequiresPermissions("system:ad:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NideshopAd nideshopAd)
    {
        startPage();
        List<NideshopAd> list = nideshopAdService.selectNideshopAdList(nideshopAd);
        return getDataTable(list);
    }

    /**
     * 导出首页轮播广告列表
     */
    @RequiresPermissions("system:ad:export")
    @Log(title = "首页轮播广告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NideshopAd nideshopAd)
    {
        List<NideshopAd> list = nideshopAdService.selectNideshopAdList(nideshopAd);
        ExcelUtil<NideshopAd> util = new ExcelUtil<NideshopAd>(NideshopAd.class);
        return util.exportExcel(list, "ad");
    }

    /**
     * 新增首页轮播广告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存首页轮播广告
     */
    @RequiresPermissions("system:ad:add")
    @Log(title = "首页轮播广告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NideshopAd nideshopAd)
    {
        return toAjax(nideshopAdService.insertNideshopAd(nideshopAd));
    }

    /**
     * 修改首页轮播广告
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        NideshopAd nideshopAd = nideshopAdService.selectNideshopAdById(id);
        mmap.put("nideshopAd", nideshopAd);
        return prefix + "/edit";
    }

    /**
     * 修改保存首页轮播广告
     */
    @RequiresPermissions("system:ad:edit")
    @Log(title = "首页轮播广告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NideshopAd nideshopAd)
    {
        return toAjax(nideshopAdService.updateNideshopAd(nideshopAd));
    }

    /**
     * 删除首页轮播广告
     */
    @RequiresPermissions("system:ad:remove")
    @Log(title = "首页轮播广告", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(nideshopAdService.deleteNideshopAdByIds(ids));
    }
}
