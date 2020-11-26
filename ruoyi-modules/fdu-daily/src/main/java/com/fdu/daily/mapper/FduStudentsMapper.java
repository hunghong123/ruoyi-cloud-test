package com.fdu.daily.mapper;

import java.util.List;
import com.fdu.daily.domain.FduStudents;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 学生信息Mapper接口
 * 
 * @author hf
 * @date 2020-11-17
 */

public interface FduStudentsMapper 
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
     * 删除学生信息
     * 
     * @param id 学生信息ID
     * @return 结果
     */
    public int deleteFduStudentsById(Long id);

    /**
     * 批量删除学生信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFduStudentsByIds(Long[] ids);

    List<FduStudents> selectFduStudentsByNameAndNo(@Param("name") String name, @Param("studentNo") String studentNo);

    List<FduStudents> selectFduStudentsByNo(@Param("studentNo") String studentNo);
}
