package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程对象 db_course
 * 
 * @author admin
 * @date 2023-01-01
 */
public class DbCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程序号 */
    private Long crNo;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private String crCno;

    /** 课程名 */
    @Excel(name = "课程名")
    private String crName;

    /** 教师姓名 */
    @Excel(name = "教师姓名")
    private String crTeachername;

    /** 教师工号 */
    @Excel(name = "教师工号")
    private String crTeacherid;

    /** 上课人数 */
    @Excel(name = "上课人数")
    private Long crNumber;

    public void setCrNo(Long crNo) 
    {
        this.crNo = crNo;
    }

    public Long getCrNo() 
    {
        return crNo;
    }
    public void setCrCno(String crCno) 
    {
        this.crCno = crCno;
    }

    public String getCrCno() 
    {
        return crCno;
    }
    public void setCrName(String crName) 
    {
        this.crName = crName;
    }

    public String getCrName() 
    {
        return crName;
    }
    public void setCrTeachername(String crTeachername) 
    {
        this.crTeachername = crTeachername;
    }

    public String getCrTeachername() 
    {
        return crTeachername;
    }
    public void setCrTeacherid(String crTeacherid) 
    {
        this.crTeacherid = crTeacherid;
    }

    public String getCrTeacherid() 
    {
        return crTeacherid;
    }
    public void setCrNumber(Long crNumber) 
    {
        this.crNumber = crNumber;
    }

    public Long getCrNumber() 
    {
        return crNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("crNo", getCrNo())
            .append("crCno", getCrCno())
            .append("crName", getCrName())
            .append("crTeachername", getCrTeachername())
            .append("crTeacherid", getCrTeacherid())
            .append("crNumber", getCrNumber())
            .toString();
    }
}
