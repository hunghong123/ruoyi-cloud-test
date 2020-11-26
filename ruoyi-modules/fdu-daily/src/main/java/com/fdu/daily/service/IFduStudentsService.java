package com.fdu.daily.service;

import java.util.List;
import com.fdu.daily.domain.FduStudents;

/**
 * 学生信息Service接口
 * 
 * @author hf
 * @date 2020-11-17
 */
public interface IFduStudentsService 
{
    /**
     * 查询学生信息
     * 
     * @param id 学生信息ID
     * @return 学生信息
     */
    public FduStudents selectFduStudentsById(Long id);

    /**
     * 查询学生信息列表
     * 
     * @param fduStudents 学生信息
     * @return 学生信息集合
     */
    public List<FduStudents> selectFduStudentsList(FduStudents fduStudents);
    public List<FduStudents> selectFduStudentsByName(String name);
    public List<FduStudents> selectFduStudentsByNameAndNo(String name,String studentNo);
    public List<FduStudents> selectFduStudentsByNo(String studentNo);

    /**
     * 新增学生信息
     * 
     * @param fduStudents 学生信息
     * @return 结果
     */
    public int insertFduStudents(FduStudents fduStudents);

    /**
     * 修改学生信息
     * 
     * @param fduStudents 学生信息
     * @return 结果
     */
    public int updateFduStudents(FduStudents fduStudents);

    /**
     * 批量删除学生信息
     * 
     * @param ids 需要删除的学生信息ID
     * @return 结果
     */
    public int deleteFduStudentsByIds(Long[] ids);

    /**
     * 删除学生信息信息
     * 
     * @param id 学生信息ID
     * @return 结果
     */
    public int deleteFduStudentsById(Long id);
}
