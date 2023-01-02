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
import com.ruoyi.system.domain.DbClass;
import com.ruoyi.system.service.IDbClassService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教室管理Controller
 * 
 * @author admin
 * @date 2023-01-01
 */
@RestController
@RequestMapping("/system/class")
public class DbClassController extends BaseController
{
    @Autowired
    private IDbClassService dbClassService;

    /**
     * 查询教室管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:class:list')")
    @GetMapping("/list")
    public TableDataInfo list(DbClass dbClass)
    {
        startPage();
        List<DbClass> list = dbClassService.selectDbClassList(dbClass);
        return getDataTable(list);
    }

    /**
     * 导出教室管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:class:export')")
    @Log(title = "教室管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DbClass dbClass)
    {
        List<DbClass> list = dbClassService.selectDbClassList(dbClass);
        ExcelUtil<DbClass> util = new ExcelUtil<DbClass>(DbClass.class);
        util.exportExcel(response, list, "教室管理数据");
    }

    /**
     * 获取教室管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:class:query')")
    @GetMapping(value = "/{cId}")
    public AjaxResult getInfo(@PathVariable("cId") Long cId)
    {
        return success(dbClassService.selectDbClassByCId(cId));
    }

    /**
     * 新增教室管理
     */
    @PreAuthorize("@ss.hasPermi('system:class:add')")
    @Log(title = "教室管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DbClass dbClass)
    {
        return toAjax(dbClassService.insertDbClass(dbClass));
    }

    /**
     * 修改教室管理
     */
    @PreAuthorize("@ss.hasPermi('system:class:edit')")
    @Log(title = "教室管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DbClass dbClass)
    {
        return toAjax(dbClassService.updateDbClass(dbClass));
    }

    /**
     * 删除教室管理
     */
    @PreAuthorize("@ss.hasPermi('system:class:remove')")
    @Log(title = "教室管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cIds}")
    public AjaxResult remove(@PathVariable Long[] cIds)
    {
        return toAjax(dbClassService.deleteDbClassByCIds(cIds));
    }
}
