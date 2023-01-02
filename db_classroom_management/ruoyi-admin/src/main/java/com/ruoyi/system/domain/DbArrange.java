package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 安排对象 db_arrange
 * 
 * @author admin
 * @date 2023-01-01
 */
public class DbArrange extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 上课编号 */
    private Long aId;

    /** 教室编号 */
    @Excel(name = "教室编号")
    private String cId;

    /** 教室名称 */
    @Excel(name = "教室名称")
    private String cName;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private Long crNo;

    /** 教师姓名 */
    @Excel(name = "教师姓名")
    private String crTeachername;

    /** 星期 */
    @Excel(name = "星期")
    private Long aWeek;

    /** 时段 */
    @Excel(name = "时段")
    private String aTime;

    public void setaId(Long aId) 
    {
        this.aId = aId;
    }

    public Long getaId() 
    {
        return aId;
    }
    public void setcId(String cId) 
    {
        this.cId = cId;
    }

    public String getcId() 
    {
        return cId;
    }
    public void setcName(String cName) 
    {
        this.cName = cName;
    }

    public String getcName() 
    {
        return cName;
    }
    public void setCrNo(Long crNo) 
    {
        this.crNo = crNo;
    }

    public Long getCrNo() 
    {
        return crNo;
    }
    public void setCrTeachername(String crTeachername) 
    {
        this.crTeachername = crTeachername;
    }

    public String getCrTeachername() 
    {
        return crTeachername;
    }
    public void setaWeek(Long aWeek) 
    {
        this.aWeek = aWeek;
    }

    public Long getaWeek() 
    {
        return aWeek;
    }
    public void setaTime(String aTime) 
    {
        this.aTime = aTime;
    }

    public String getaTime() 
    {
        return aTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("aId", getaId())
            .append("cId", getcId())
            .append("cName", getcName())
            .append("crNo", getCrNo())
            .append("crTeachername", getCrTeachername())
            .append("aWeek", getaWeek())
            .append("aTime", getaTime())
            .toString();
    }
}
