package cn.com.xgit.parts.rm.module.warehouse.vo;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
/**
 * //待完善 VO类
 */
@Data
@ToString
public class WarehouseAreaLocationVO  implements Serializable{
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "储位编号")
    private String locationCode;
    @ApiModelProperty(value = "仓库区域标识")
    private String warehouseAreaId;
    @ApiModelProperty(value = "货架排编号")
    private String rowNo;
    @ApiModelProperty(value = "层编号")
    private String floorNo;
    @ApiModelProperty(value = "列编号")
    private String columnNo;
    @ApiModelProperty(value = "位编号")
    private String seqNo;
    @ApiModelProperty(value = "货架类型")
    private String shelfType;
    @ApiModelProperty(value = "货架编码")
    private String shelfNo;
    @ApiModelProperty(value = "")
    private String locationDesc;
    @ApiModelProperty(value = "")
    private String orgId;
    @ApiModelProperty(value = "添加时间")
    private Date createTime;
}
