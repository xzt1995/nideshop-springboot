package com.ruoyi.web.controller.shop;

import java.util.List;

import com.ruoyi.shop.domain.NideshopGoods;
import com.ruoyi.shop.service.INideshopGoodsService;
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
 * 商品信息Controller
 *
 * @author ruoyi
 * @date 2019-11-29
 */
@Controller
@RequestMapping("/system/goods")
public class NideshopGoodsController extends BaseController
{
    private String prefix = "system/goods";

    @Autowired
    private INideshopGoodsService nideshopGoodsService;

    @RequiresPermissions("system:goods:view")
    @GetMapping()
    public String goods()
    {
        return prefix + "/goods";
    }

    /**
     * 查询商品信息列表
     */
    @RequiresPermissions("system:goods:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NideshopGoods nideshopGoods)
    {
        startPage();
        List<NideshopGoods> list = nideshopGoodsService.selectNideshopGoodsList(nideshopGoods);
        return getDataTable(list);
    }

    /**
     * 导出商品信息列表
     */
    @RequiresPermissions("system:goods:export")
    @Log(title = "商品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NideshopGoods nideshopGoods)
    {
        List<NideshopGoods> list = nideshopGoodsService.selectNideshopGoodsList(nideshopGoods);
        ExcelUtil<NideshopGoods> util = new ExcelUtil<NideshopGoods>(NideshopGoods.class);
        return util.exportExcel(list, "goods");
    }

    /**
     * 新增商品信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品信息
     */
    @RequiresPermissions("system:goods:add")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NideshopGoods nideshopGoods)
    {
        return toAjax(nideshopGoodsService.insertNideshopGoods(nideshopGoods));
    }

    /**
     * 修改商品信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        NideshopGoods nideshopGoods = nideshopGoodsService.selectNideshopGoodsById(id);
        mmap.put("nideshopGoods", nideshopGoods);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品信息
     */
    @RequiresPermissions("system:goods:edit")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NideshopGoods nideshopGoods)
    {
        return toAjax(nideshopGoodsService.updateNideshopGoods(nideshopGoods));
    }

    /**
     * 删除商品信息
     */
    @RequiresPermissions("system:goods:remove")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(nideshopGoodsService.deleteNideshopGoodsByIds(ids));
    }
}
