package com.ruoyi.web.controller.shop;

import java.util.List;

import com.ruoyi.shop.domain.NideshopUser;
import com.ruoyi.shop.service.INideshopUserService;
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
 * 会员Controller
 *
 * @author ruoyi
 * @date 2019-11-28
 */
@Controller
@RequestMapping("/system/Nuser")
public class NideshopUserController extends BaseController
{
    private String prefix = "system/Nuser";

    @Autowired
    private INideshopUserService nideshopUserService;

    @RequiresPermissions("system:Nuser:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询会员列表
     */
    @RequiresPermissions("system:Nuser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NideshopUser nideshopUser)
    {
        startPage();
        List<NideshopUser> list = nideshopUserService.selectNideshopUserList(nideshopUser);
        return getDataTable(list);
    }

    /**
     * 导出会员列表
     */
    @RequiresPermissions("system:Nuser:export")
    @Log(title = "会员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NideshopUser nideshopUser)
    {
        List<NideshopUser> list = nideshopUserService.selectNideshopUserList(nideshopUser);
        ExcelUtil<NideshopUser> util = new ExcelUtil<NideshopUser>(NideshopUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增会员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存会员
     */
    @RequiresPermissions("system:Nuser:add")
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NideshopUser nideshopUser)
    {
        return toAjax(nideshopUserService.insertNideshopUser(nideshopUser));
    }

    /**
     * 修改会员
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        NideshopUser nideshopUser = nideshopUserService.selectNideshopUserById(id);
        mmap.put("nideshopUser", nideshopUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存会员
     */
    @RequiresPermissions("system:Nuser:edit")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NideshopUser nideshopUser)
    {
        return toAjax(nideshopUserService.updateNideshopUser(nideshopUser));
    }

    /**
     * 删除会员
     */
    @RequiresPermissions("system:Nuser:remove")
    @Log(title = "会员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(nideshopUserService.deleteNideshopUserByIds(ids));
    }
}
