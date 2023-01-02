package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DbArrangeMapper;
import com.ruoyi.system.domain.DbArrange;
import com.ruoyi.system.service.IDbArrangeService;

/**
 * 安排Service业务层处理
 * 
 * @author admin
 * @date 2023-01-01
 */
@Service
public class DbArrangeServiceImpl implements IDbArrangeService 
{
    @Autowired
    private DbArrangeMapper dbArrangeMapper;

    /**
     * 查询安排
     * 
     * @param aId 安排主键
     * @return 安排
     */
    @Override
    public DbArrange selectDbArrangeByAId(Long aId)
    {
        return dbArrangeMapper.selectDbArrangeByAId(aId);
    }

    /**
     * 查询安排列表
     * 
     * @param dbArrange 安排
     * @return 安排
     */
    @Override
    public List<DbArrange> selectDbArrangeList(DbArrange dbArrange)
    {
        return dbArrangeMapper.selectDbArrangeList(dbArrange);
    }

    /**
     * 新增安排
     * 
     * @param dbArrange 安排
     * @return 结果
     */
    @Override
    public int insertDbArrange(DbArrange dbArrange)
    {
        return dbArrangeMapper.insertDbArrange(dbArrange);
    }

    /**
     * 修改安排
     * 
     * @param dbArrange 安排
     * @return 结果
     */
    @Override
    public int updateDbArrange(DbArrange dbArrange)
    {
        return dbArrangeMapper.updateDbArrange(dbArrange);
    }

    /**
     * 批量删除安排
     * 
     * @param aIds 需要删除的安排主键
     * @return 结果
     */
    @Override
    public int deleteDbArrangeByAIds(Long[] aIds)
    {
        return dbArrangeMapper.deleteDbArrangeByAIds(aIds);
    }

    /**
     * 删除安排信息
     * 
     * @param aId 安排主键
     * @return 结果
     */
    @Override
    public int deleteDbArrangeByAId(Long aId)
    {
        return dbArrangeMapper.deleteDbArrangeByAId(aId);
    }
}
