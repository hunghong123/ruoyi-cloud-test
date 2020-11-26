package com.fdu.daily.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 学生信息对象 fdu_students
 * 
 * @author hf
 * @date 2020-11-17
 */
public class FduStudents extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String name;

    /** 学号 */
    @Excel(name = "学号")
    private String studentNo;

    /** 手机 */
    @Excel(name = "手机")
    private String mobile;

    /** 院系 */
    @Excel(name = "院系")
    private String school;

    /** 学生分类 */
    @Excel(name = "学生分类")
    private String category;

    /** 学生类型 */
    @Excel(name = "学生类型")
    private String type;

    /** 辅导员 */
    @Excel(name = "辅导员")
    private String teacher;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setStudentNo(String studentNo) 
    {
        this.studentNo = studentNo;
    }

    public String getStudentNo() 
    {
        return studentNo;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setSchool(String school) 
    {
        this.school = school;
    }

    public String getSchool() 
    {
        return school;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setTeacher(String teacher) 
    {
        this.teacher = teacher;
    }

    public String getTeacher() 
    {
        return teacher;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("studentNo", getStudentNo())
            .append("mobile", getMobile())
            .append("school", getSchool())
            .append("category", getCategory())
            .append("type", getType())
            .append("teacher", getTeacher())
            .append("remark", getRemark())
            .toString();
    }
}
