package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.DbArrange;
import com.ruoyi.system.service.IDbArrangeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 安排Controller
 * 
 * @author admin
 * @date 2023-01-01
 */
@RestController
@RequestMapping("/system/arrange")
public class DbArrangeController extends BaseController
{
    @Autowired
    private IDbArrangeService dbArrangeService;

    /**
     * 查询安排列表
     */
    @PreAuthorize("@ss.hasPermi('system:arrange:list')")
    @GetMapping("/list")
    public TableDataInfo list(DbArrange dbArrange)
    {
        startPage();
        List<DbArrange> list = dbArrangeService.selectDbArrangeList(dbArrange);
        return getDataTable(list);
    }

    /**
     * 导出安排列表
     */
    @PreAuthorize("@ss.hasPermi('system:arrange:export')")
    @Log(title = "安排", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DbArrange dbArrange)
    {
        List<DbArrange> list = dbArrangeService.selectDbArrangeList(dbArrange);
        ExcelUtil<DbArrange> util = new ExcelUtil<DbArrange>(DbArrange.class);
        util.exportExcel(response, list, "安排数据");
    }

    /**
     * 获取安排详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:arrange:query')")
    @GetMapping(value = "/{aId}")
    public AjaxResult getInfo(@PathVariable("aId") Long aId)
    {
        return success(dbArrangeService.selectDbArrangeByAId(aId));
    }

    /**
     * 新增安排
     */
    @PreAuthorize("@ss.hasPermi('system:arrange:add')")
    @Log(title = "安排", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DbArrange dbArrange)
    {
        return toAjax(dbArrangeService.insertDbArrange(dbArrange));
    }

    /**
     * 修改安排
     */
    @PreAuthorize("@ss.hasPermi('system:arrange:edit')")
    @Log(title = "安排", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DbArrange dbArrange)
    {
        return toAjax(dbArrangeService.updateDbArrange(dbArrange));
    }

    /**
     * 删除安排
     */
    @PreAuthorize("@ss.hasPermi('system:arrange:remove')")
    @Log(title = "安排", businessType = BusinessType.DELETE)
	@DeleteMapping("/{aIds}")
    public AjaxResult remove(@PathVariable Long[] aIds)
    {
        return toAjax(dbArrangeService.deleteDbArrangeByAIds(aIds));
    }
}
