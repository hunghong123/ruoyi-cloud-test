package com.fdu.daily.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fdu.daily.mapper.FduStudentsMapper;
import com.fdu.daily.domain.FduStudents;
import com.fdu.daily.service.IFduStudentsService;

/**
 * 学生信息Service业务层处理
 * 
 * @author hf
 * @date 2020-11-17
 */
@Service
public class FduStudentsServiceImpl implements IFduStudentsService 
{
    @Autowired
    private FduStudentsMapper fduStudentsMapper;

    /**
     * 查询学生信息
     * 
     * @param id 学生信息ID
     * @return 学生信息
     */
    @Override
    public FduStudents selectFduStudentsById(Long id)
    {
        return fduStudentsMapper.selectFduStudentsById(id);
    }

    /**
     * 查询学生信息列表
     * 
     * @param fduStudents 学生信息
     * @return 学生信息
     */
    @Override
    public List<FduStudents> selectFduStudentsList(FduStudents fduStudents)
    {
        return fduStudentsMapper.selectFduStudentsList(fduStudents);
    }

    @Override
    public List<FduStudents> selectFduStudentsByName(String name) {
        return fduStudentsMapper.selectFduStudentsByName(name);
    }

    @Override
    public List<FduStudents> selectFduStudentsByNameAndNo(String name, String studentNo) {
        return fduStudentsMapper.selectFduStudentsByNameAndNo(name,studentNo);
    }

    @Override
    public List<FduStudents> selectFduStudentsByNo(String studentNo) {
        return fduStudentsMapper.selectFduStudentsByNo(studentNo);
    }


    /**
     * 新增学生信息
     * 
     * @param fduStudents 学生信息
     * @return 结果
     */
    @Override
    public int insertFduStudents(FduStudents fduStudents)
    {
        return fduStudentsMapper.insertFduStudents(fduStudents);
    }

    /**
     * 修改学生信息
     * 
     * @param fduStudents 学生信息
     * @return 结果
     */
    @Override
    public int updateFduStudents(FduStudents fduStudents)
    {
        return fduStudentsMapper.updateFduStudents(fduStudents);
    }

    /**
     * 批量删除学生信息
     * 
     * @param ids 需要删除的学生信息ID
     * @return 结果
     */
    @Override
    public int deleteFduStudentsByIds(Long[] ids)
    {
        return fduStudentsMapper.deleteFduStudentsByIds(ids);
    }

    /**
     * 删除学生信息信息
     * 
     * @param id 学生信息ID
     * @return 结果
     */
    @Override
    public int deleteFduStudentsById(Long id)
    {
        return fduStudentsMapper.deleteFduStudentsById(id);
    }
}
