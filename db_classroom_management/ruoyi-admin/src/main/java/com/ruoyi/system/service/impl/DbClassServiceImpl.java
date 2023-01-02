package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DbClassMapper;
import com.ruoyi.system.domain.DbClass;
import com.ruoyi.system.service.IDbClassService;

/**
 * 教室管理Service业务层处理
 * 
 * @author admin
 * @date 2023-01-01
 */
@Service
public class DbClassServiceImpl implements IDbClassService 
{
    @Autowired
    private DbClassMapper dbClassMapper;

    /**
     * 查询教室管理
     * 
     * @param cId 教室管理主键
     * @return 教室管理
     */
    @Override
    public DbClass selectDbClassByCId(Long cId)
    {
        return dbClassMapper.selectDbClassByCId(cId);
    }

    /**
     * 查询教室管理列表
     * 
     * @param dbClass 教室管理
     * @return 教室管理
     */
    @Override
    public List<DbClass> selectDbClassList(DbClass dbClass)
    {
        return dbClassMapper.selectDbClassList(dbClass);
    }

    /**
     * 新增教室管理
     * 
     * @param dbClass 教室管理
     * @return 结果
     */
    @Override
    public int insertDbClass(DbClass dbClass)
    {
        return dbClassMapper.insertDbClass(dbClass);
    }

    /**
     * 修改教室管理
     * 
     * @param dbClass 教室管理
     * @return 结果
     */
    @Override
    public int updateDbClass(DbClass dbClass)
    {
        return dbClassMapper.updateDbClass(dbClass);
    }

    /**
     * 批量删除教室管理
     * 
     * @param cIds 需要删除的教室管理主键
     * @return 结果
     */
    @Override
    public int deleteDbClassByCIds(Long[] cIds)
    {
        return dbClassMapper.deleteDbClassByCIds(cIds);
    }

    /**
     * 删除教室管理信息
     * 
     * @param cId 教室管理主键
     * @return 结果
     */
    @Override
    public int deleteDbClassByCId(Long cId)
    {
        return dbClassMapper.deleteDbClassByCId(cId);
    }
}
