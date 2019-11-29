package com.ruoyi.web.controller.shop;

import java.util.List;

import com.ruoyi.shop.domain.NideshopCoupon;
import com.ruoyi.shop.service.INideshopCouponService;
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
 * 优惠卷红包Controller
 *
 * @author ruoyi
 * @date 2019-11-29
 */
@Controller
@RequestMapping("/system/coupon")
public class NideshopCouponController extends BaseController
{
    private String prefix = "system/coupon";

    @Autowired
    private INideshopCouponService nideshopCouponService;

    @RequiresPermissions("system:coupon:view")
    @GetMapping()
    public String coupon()
    {
        return prefix + "/coupon";
    }

    /**
     * 查询优惠卷红包列表
     */
    @RequiresPermissions("system:coupon:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NideshopCoupon nideshopCoupon)
    {
        startPage();
        List<NideshopCoupon> list = nideshopCouponService.selectNideshopCouponList(nideshopCoupon);
        return getDataTable(list);
    }

    /**
     * 导出优惠卷红包列表
     */
    @RequiresPermissions("system:coupon:export")
    @Log(title = "优惠卷红包", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NideshopCoupon nideshopCoupon)
    {
        List<NideshopCoupon> list = nideshopCouponService.selectNideshopCouponList(nideshopCoupon);
        ExcelUtil<NideshopCoupon> util = new ExcelUtil<NideshopCoupon>(NideshopCoupon.class);
        return util.exportExcel(list, "coupon");
    }

    /**
     * 新增优惠卷红包
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存优惠卷红包
     */
    @RequiresPermissions("system:coupon:add")
    @Log(title = "优惠卷红包", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NideshopCoupon nideshopCoupon)
    {
        return toAjax(nideshopCouponService.insertNideshopCoupon(nideshopCoupon));
    }

    /**
     * 修改优惠卷红包
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        NideshopCoupon nideshopCoupon = nideshopCouponService.selectNideshopCouponById(id);
        mmap.put("nideshopCoupon", nideshopCoupon);
        return prefix + "/edit";
    }

    /**
     * 修改保存优惠卷红包
     */
    @RequiresPermissions("system:coupon:edit")
    @Log(title = "优惠卷红包", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NideshopCoupon nideshopCoupon)
    {
        return toAjax(nideshopCouponService.updateNideshopCoupon(nideshopCoupon));
    }

    /**
     * 删除优惠卷红包
     */
    @RequiresPermissions("system:coupon:remove")
    @Log(title = "优惠卷红包", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(nideshopCouponService.deleteNideshopCouponByIds(ids));
    }
}
