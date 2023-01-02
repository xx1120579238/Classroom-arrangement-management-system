package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.DbArrange;

/**
 * 安排Service接口
 * 
 * @author admin
 * @date 2023-01-01
 */
public interface IDbArrangeService 
{
    /**
     * 查询安排
     * 
     * @param aId 安排主键
     * @return 安排
     */
    public DbArrange selectDbArrangeByAId(Long aId);

    /**
     * 查询安排列表
     * 
     * @param dbArrange 安排
     * @return 安排集合
     */
    public List<DbArrange> selectDbArrangeList(DbArrange dbArrange);

    /**
     * 新增安排
     * 
     * @param dbArrange 安排
     * @return 结果
     */
    public int insertDbArrange(DbArrange dbArrange);

    /**
     * 修改安排
     * 
     * @param dbArrange 安排
     * @return 结果
     */
    public int updateDbArrange(DbArrange dbArrange);

    /**
     * 批量删除安排
     * 
     * @param aIds 需要删除的安排主键集合
     * @return 结果
     */
    public int deleteDbArrangeByAIds(Long[] aIds);

    /**
     * 删除安排信息
     * 
     * @param aId 安排主键
     * @return 结果
     */
    public int deleteDbArrangeByAId(Long aId);
}
