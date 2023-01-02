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
import com.ruoyi.system.domain.DbCourse;
import com.ruoyi.system.service.IDbCourseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程Controller
 * 
 * @author admin
 * @date 2023-01-01
 */
@RestController
@RequestMapping("/system/course")
public class DbCourseController extends BaseController
{
    @Autowired
    private IDbCourseService dbCourseService;

    /**
     * 查询课程列表
     */
    @PreAuthorize("@ss.hasPermi('system:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(DbCourse dbCourse)
    {
        startPage();
        List<DbCourse> list = dbCourseService.selectDbCourseList(dbCourse);
        return getDataTable(list);
    }

    /**
     * 导出课程列表
     */
    @PreAuthorize("@ss.hasPermi('system:course:export')")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DbCourse dbCourse)
    {
        List<DbCourse> list = dbCourseService.selectDbCourseList(dbCourse);
        ExcelUtil<DbCourse> util = new ExcelUtil<DbCourse>(DbCourse.class);
        util.exportExcel(response, list, "课程数据");
    }

    /**
     * 获取课程详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:course:query')")
    @GetMapping(value = "/{crNo}")
    public AjaxResult getInfo(@PathVariable("crNo") Long crNo)
    {
        return success(dbCourseService.selectDbCourseByCrNo(crNo));
    }

    /**
     * 新增课程
     */
    @PreAuthorize("@ss.hasPermi('system:course:add')")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DbCourse dbCourse)
    {
        return toAjax(dbCourseService.insertDbCourse(dbCourse));
    }

    /**
     * 修改课程
     */
    @PreAuthorize("@ss.hasPermi('system:course:edit')")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DbCourse dbCourse)
    {
        return toAjax(dbCourseService.updateDbCourse(dbCourse));
    }

    /**
     * 删除课程
     */
    @PreAuthorize("@ss.hasPermi('system:course:remove')")
    @Log(title = "课程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{crNos}")
    public AjaxResult remove(@PathVariable Long[] crNos)
    {
        return toAjax(dbCourseService.deleteDbCourseByCrNos(crNos));
    }
}
