package com.fdu.daily.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.fdu.daily.vo.Student;
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
import com.fdu.daily.domain.FduStudents;
import com.fdu.daily.service.IFduStudentsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 学生信息Controller
 * 
 * @author hf
 * @date 2020-11-17
 */
@RestController
@RequestMapping("/student")
public class FduStudentsController extends BaseController
{
    @Autowired
    private IFduStudentsService fduStudentsService;

    /**
     * 查询学生信息列表
     */
    @PreAuthorize(hasPermi = "daily:student:list")
    @GetMapping("/list")
    public TableDataInfo list(FduStudents fduStudents)
    {
        startPage();
        List<FduStudents> list = fduStudentsService.selectFduStudentsList(fduStudents);
        return getDataTable(list);
    }

    /**
     * 导出学生信息列表
     */
    @PreAuthorize(hasPermi = "daily:student:export")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FduStudents fduStudents) throws IOException
    {
        List<FduStudents> list = fduStudentsService.selectFduStudentsList(fduStudents);
        ExcelUtil<FduStudents> util = new ExcelUtil<FduStudents>(FduStudents.class);
        util.exportExcel(response, list, "student");
    }

    /**
     * 获取学生信息详细信息
     */
    @PreAuthorize(hasPermi = "daily:student:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fduStudentsService.selectFduStudentsById(id));
    }

    /**
     * 新增学生信息
     */
    @PreAuthorize(hasPermi = "daily:student:add")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FduStudents fduStudents)
    {
        return toAjax(fduStudentsService.insertFduStudents(fduStudents));
    }

    /**
     * 修改学生信息
     */
    @PreAuthorize(hasPermi = "daily:student:edit")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FduStudents fduStudents)
    {
        return toAjax(fduStudentsService.updateFduStudents(fduStudents));
    }

    /**
     * 删除学生信息
     */
    @PreAuthorize(hasPermi = "daily:student:remove")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fduStudentsService.deleteFduStudentsByIds(ids));
    }
}
