package com.fdu.daily.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
import com.fdu.daily.domain.FduDailyUpdate;
import com.fdu.daily.service.IFduDailyUpdateService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 每日上报Controller
 *
 * @author hf
 * @date 2020-11-19
 */
@RestController
@RequestMapping("/dailyupdate")
public class FduDailyUpdateController extends BaseController {
    @Autowired
    private IFduDailyUpdateService fduDailyUpdateService;

    /**
     * 查询每日上报列表
     */
    @PreAuthorize(hasPermi = "daily:dailyupdate:list")
    @GetMapping("/list")
    public TableDataInfo list(FduDailyUpdate fduDailyUpdate) {
        startPage();
        List<FduDailyUpdate> list = fduDailyUpdateService.selectFduDailyUpdateList(fduDailyUpdate);
        return getDataTable(list);
    }

    /**
     * 导出每日上报列表
     */
    @PreAuthorize(hasPermi = "daily:dailyupdate:export")
    @Log(title = "每日上报", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FduDailyUpdate fduDailyUpdate) throws IOException {
        List<FduDailyUpdate> list = fduDailyUpdateService.selectFduDailyUpdateList(fduDailyUpdate);
        ExcelUtil<FduDailyUpdate> util = new ExcelUtil<FduDailyUpdate>(FduDailyUpdate.class);
        util.exportExcel(response, list, "dailyupdate");
    }

    /**
     * 获取每日上报详细信息
     */
    @PreAuthorize(hasPermi = "daily:dailyupdate:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(fduDailyUpdateService.selectFduDailyUpdateById(id));
    }

    /**
     * 新增每日上报
     */
    @PreAuthorize(hasPermi = "daily:dailyupdate:add")
    @Log(title = "每日上报", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FduDailyUpdate fduDailyUpdate) {
        return toAjax(fduDailyUpdateService.insertFduDailyUpdate(fduDailyUpdate));
    }

    /**
     * 修改每日上报
     */
    @PreAuthorize(hasPermi = "daily:dailyupdate:edit")
    @Log(title = "每日上报", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FduDailyUpdate fduDailyUpdate) {
        return toAjax(fduDailyUpdateService.updateFduDailyUpdate(fduDailyUpdate));
    }

    /**
     * 删除每日上报
     */
    @PreAuthorize(hasPermi = "daily:dailyupdate:remove")
    @Log(title = "每日上报", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(fduDailyUpdateService.deleteFduDailyUpdateByIds(ids));
    }
}
