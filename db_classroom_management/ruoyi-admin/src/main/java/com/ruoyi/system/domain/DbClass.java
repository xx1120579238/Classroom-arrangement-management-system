package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教室管理对象 db_class
 * 
 * @author admin
 * @date 2023-01-01
 */
public class DbClass extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教室编号 */
    private Long cId;

    /** 教室名称 */
    @Excel(name = "教室名称")
    private String cName;

    /** 教室类型 */
    @Excel(name = "教室类型")
    private String cKind;

    /** 最大容纳人数 */
    @Excel(name = "最大容纳人数")
    private Long cSeat;

    /** 教室状态 */
    @Excel(name = "教室状态")
    private String cStatus;

    public void setcId(Long cId) 
    {
        this.cId = cId;
    }

    public Long getcId() 
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
    public void setcKind(String cKind) 
    {
        this.cKind = cKind;
    }

    public String getcKind() 
    {
        return cKind;
    }
    public void setcSeat(Long cSeat) 
    {
        this.cSeat = cSeat;
    }

    public Long getcSeat() 
    {
        return cSeat;
    }
    public void setcStatus(String cStatus) 
    {
        this.cStatus = cStatus;
    }

    public String getcStatus() 
    {
        return cStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cId", getcId())
            .append("cName", getcName())
            .append("cKind", getcKind())
            .append("cSeat", getcSeat())
            .append("cStatus", getcStatus())
            .toString();
    }
}
