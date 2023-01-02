package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.DbClass;

/**
 * 教室管理Mapper接口
 * 
 * @author admin
 * @date 2023-01-01
 */
public interface DbClassMapper 
{
    /**
     * 查询教室管理
     * 
     * @param cId 教室管理主键
     * @return 教室管理
     */
    public DbClass selectDbClassByCId(Long cId);

    /**
     * 查询教室管理列表
     * 
     * @param dbClass 教室管理
     * @return 教室管理集合
     */
    public List<DbClass> selectDbClassList(DbClass dbClass);

    /**
     * 新增教室管理
     * 
     * @param dbClass 教室管理
     * @return 结果
     */
    public int insertDbClass(DbClass dbClass);

    /**
     * 修改教室管理
     * 
     * @param dbClass 教室管理
     * @return 结果
     */
    public int updateDbClass(DbClass dbClass);

    /**
     * 删除教室管理
     * 
     * @param cId 教室管理主键
     * @return 结果
     */
    public int deleteDbClassByCId(Long cId);

    /**
     * 批量删除教室管理
     * 
     * @param cIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDbClassByCIds(Long[] cIds);
}
