package com.ruoyi.web.controller.shop;

import java.util.List;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.shop.domain.NideshopCategory;
import com.ruoyi.shop.service.INideshopCategoryService;
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
 * 商品分类Controller
 *
 * @author ruoyi
 * @date 2019-11-28
 */
@Controller
@RequestMapping("/system/category")
public class NideshopCategoryController extends BaseController
{
    private String prefix = "system/category";

    @Autowired
    private INideshopCategoryService nideshopCategoryService;

    @RequiresPermissions("system:category:view")
    @GetMapping()
    public String category()
    {
        return prefix + "/category";
    }

    /**
     * 查询商品分类列表
     */
    @RequiresPermissions("system:category:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NideshopCategory nideshopCategory)
    {
        startPage();
        List<NideshopCategory> list = nideshopCategoryService.selectNideshopCategoryList(nideshopCategory);
        return getDataTable(list);
    }

    /**
     * 导出商品分类列表
     */
    @RequiresPermissions("system:category:export")
    @Log(title = "商品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NideshopCategory nideshopCategory)
    {
        List<NideshopCategory> list = nideshopCategoryService.selectNideshopCategoryList(nideshopCategory);
        ExcelUtil<NideshopCategory> util = new ExcelUtil<NideshopCategory>(NideshopCategory.class);
        return util.exportExcel(list, "category");
    }

    /**
     * 新增商品分类
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品分类
     */
    @RequiresPermissions("system:category:add")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NideshopCategory nideshopCategory)
    {
        return toAjax(nideshopCategoryService.insertNideshopCategory(nideshopCategory));
    }

    /**
     * 修改商品分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        NideshopCategory nideshopCategory = nideshopCategoryService.selectNideshopCategoryById(id);
        mmap.put("nideshopCategory", nideshopCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品分类
     */
    @RequiresPermissions("system:category:edit")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NideshopCategory nideshopCategory)
    {
        return toAjax(nideshopCategoryService.updateNideshopCategory(nideshopCategory));
    }

    /**
     * 删除商品分类
     */
    @RequiresPermissions("system:category:remove")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(nideshopCategoryService.deleteNideshopCategoryByIds(ids));
    }

    /**
     * 加载商城商品分类树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = nideshopCategoryService.selectNideshopCategoryTree();
        return ztrees;
    }

}
