package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.DbCourse;

/**
 * 课程Service接口
 * 
 * @author admin
 * @date 2023-01-01
 */
public interface IDbCourseService 
{
    /**
     * 查询课程
     * 
     * @param crNo 课程主键
     * @return 课程
     */
    public DbCourse selectDbCourseByCrNo(Long crNo);

    /**
     * 查询课程列表
     * 
     * @param dbCourse 课程
     * @return 课程集合
     */
    public List<DbCourse> selectDbCourseList(DbCourse dbCourse);

    /**
     * 新增课程
     * 
     * @param dbCourse 课程
     * @return 结果
     */
    public int insertDbCourse(DbCourse dbCourse);

    /**
     * 修改课程
     * 
     * @param dbCourse 课程
     * @return 结果
     */
    public int updateDbCourse(DbCourse dbCourse);

    /**
     * 批量删除课程
     * 
     * @param crNos 需要删除的课程主键集合
     * @return 结果
     */
    public int deleteDbCourseByCrNos(Long[] crNos);

    /**
     * 删除课程信息
     * 
     * @param crNo 课程主键
     * @return 结果
     */
    public int deleteDbCourseByCrNo(Long crNo);
}
