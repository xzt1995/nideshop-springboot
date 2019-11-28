package com.ruoyi.web.controller.shop;

import java.util.List;

import com.ruoyi.shop.domain.NideshopTopic;
import com.ruoyi.shop.service.INideshopTopicService;
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
 * 商品专题Controller
 *
 * @author ruoyi
 * @date 2019-11-26
 */
@Controller
@RequestMapping("/system/topic")
public class NideshopTopicController extends BaseController
{
    private String prefix = "system/topic";

    @Autowired
    private INideshopTopicService nideshopTopicService;

    @RequiresPermissions("system:topic:view")
    @GetMapping()
    public String topic()
    {
        return prefix + "/topic";
    }

    /**
     * 查询商品专题列表
     */
    @RequiresPermissions("system:topic:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NideshopTopic nideshopTopic)
    {
        startPage();
        List<NideshopTopic> list = nideshopTopicService.selectNideshopTopicList(nideshopTopic);
        return getDataTable(list);
    }

    /**
     * 导出商品专题列表
     */
    @RequiresPermissions("system:topic:export")
    @Log(title = "商品专题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NideshopTopic nideshopTopic)
    {
        List<NideshopTopic> list = nideshopTopicService.selectNideshopTopicList(nideshopTopic);
        ExcelUtil<NideshopTopic> util = new ExcelUtil<NideshopTopic>(NideshopTopic.class);
        return util.exportExcel(list, "topic");
    }

    /**
     * 新增商品专题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品专题
     */
    @RequiresPermissions("system:topic:add")
    @Log(title = "商品专题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NideshopTopic nideshopTopic)
    {
        return toAjax(nideshopTopicService.insertNideshopTopic(nideshopTopic));
    }

    /**
     * 修改商品专题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        NideshopTopic nideshopTopic = nideshopTopicService.selectNideshopTopicById(id);
        mmap.put("nideshopTopic", nideshopTopic);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品专题
     */
    @RequiresPermissions("system:topic:edit")
    @Log(title = "商品专题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NideshopTopic nideshopTopic)
    {
        return toAjax(nideshopTopicService.updateNideshopTopic(nideshopTopic));
    }

    /**
     * 删除商品专题
     */
    @RequiresPermissions("system:topic:remove")
    @Log(title = "商品专题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(nideshopTopicService.deleteNideshopTopicByIds(ids));
    }


    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(NideshopTopic topic){
        return toAjax(nideshopTopicService.updateNideshopTopic(topic));
    }
}
