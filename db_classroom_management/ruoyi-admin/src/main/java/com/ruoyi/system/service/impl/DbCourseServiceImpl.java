package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DbCourseMapper;
import com.ruoyi.system.domain.DbCourse;
import com.ruoyi.system.service.IDbCourseService;

/**
 * 课程Service业务层处理
 * 
 * @author admin
 * @date 2023-01-01
 */
@Service
public class DbCourseServiceImpl implements IDbCourseService 
{
    @Autowired
    private DbCourseMapper dbCourseMapper;

    /**
     * 查询课程
     * 
     * @param crNo 课程主键
     * @return 课程
     */
    @Override
    public DbCourse selectDbCourseByCrNo(Long crNo)
    {
        return dbCourseMapper.selectDbCourseByCrNo(crNo);
    }

    /**
     * 查询课程列表
     * 
     * @param dbCourse 课程
     * @return 课程
     */
    @Override
    public List<DbCourse> selectDbCourseList(DbCourse dbCourse)
    {
        return dbCourseMapper.selectDbCourseList(dbCourse);
    }

    /**
     * 新增课程
     * 
     * @param dbCourse 课程
     * @return 结果
     */
    @Override
    public int insertDbCourse(DbCourse dbCourse)
    {
        return dbCourseMapper.insertDbCourse(dbCourse);
    }

    /**
     * 修改课程
     * 
     * @param dbCourse 课程
     * @return 结果
     */
    @Override
    public int updateDbCourse(DbCourse dbCourse)
    {
        return dbCourseMapper.updateDbCourse(dbCourse);
    }

    /**
     * 批量删除课程
     * 
     * @param crNos 需要删除的课程主键
     * @return 结果
     */
    @Override
    public int deleteDbCourseByCrNos(Long[] crNos)
    {
        return dbCourseMapper.deleteDbCourseByCrNos(crNos);
    }

    /**
     * 删除课程信息
     * 
     * @param crNo 课程主键
     * @return 结果
     */
    @Override
    public int deleteDbCourseByCrNo(Long crNo)
    {
        return dbCourseMapper.deleteDbCourseByCrNo(crNo);
    }
}
