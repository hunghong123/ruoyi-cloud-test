package com.fdu.daily.controller;

import com.fdu.daily.domain.FduDailyUpdate;
import com.fdu.daily.domain.FduStudents;
import com.fdu.daily.service.IFduDailyUpdateService;
import com.fdu.daily.service.IFduStudentsService;
import com.fdu.daily.vo.Student;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class FduController  extends BaseController {

    @Autowired
    private IFduStudentsService fduStudentsService;
    @Autowired
    private IFduDailyUpdateService fduDailyUpdateService;

    @PostMapping(value = "/checkStudent")
    public AjaxResult checkStudent(@RequestBody Student student)
    {
        List<FduStudents> studentsList = fduStudentsService.selectFduStudentsByNameAndNo(student.getName(),student.getStudent_no());
        if (studentsList == null || studentsList.size()==0){
            return AjaxResult.error("该学生信息不存在！");
        }
        if (studentsList.size()>1){
            return AjaxResult.error("学生数据异常，多个学生信息存在！");
        }
        return AjaxResult.success();
    }

    @GetMapping(value = "/getStuInfo")
    public AjaxResult getStuInfo(String student_no) {
        List<FduStudents> studentsList = fduStudentsService.selectFduStudentsByNo(student_no);
        if (studentsList == null || studentsList.size()==0){
            return AjaxResult.error("该学生信息不存在！");
        }
        if (studentsList.size()>1){
            return AjaxResult.error("学生数据异常，多个学生信息存在！");
        }
        return AjaxResult.success(studentsList.get(0));
    }

    @PostMapping(value = "/saveDailyUpdate")
    public AjaxResult saveDailyUpdate(@RequestBody FduDailyUpdate fduDailyUpdate)
    {
        List<FduDailyUpdate> fduDailyUpdates = fduDailyUpdateService.selectFduDailyUpdateListByDateAndNo(fduDailyUpdate);

        if (fduDailyUpdates == null || fduDailyUpdates.size()==0){
            fduDailyUpdateService.insertFduDailyUpdate(fduDailyUpdate);
            return AjaxResult.success("插入日报成功！");
        }
        if (fduDailyUpdates.size()==1){
            fduDailyUpdate.setId(fduDailyUpdates.get(0).getId());
            fduDailyUpdateService.updateFduDailyUpdate(fduDailyUpdate);
            return AjaxResult.success("更新日报成功！");
        }
        if (fduDailyUpdates.size()>1){
            return AjaxResult.error("日报数据异常，无法插入或更新！");
        }
        return AjaxResult.success();
    }
}
