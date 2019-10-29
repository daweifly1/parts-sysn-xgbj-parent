package cn.com.xgit.parts.rm.module.warehouse.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 仓库表 VO类
 */
@Data
@ToString
public class WarehouseVO implements Serializable {
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "仓库标识")
    private String id;
    @ApiModelProperty(value = "仓库编号")
    private String warehouseCode;
    @ApiModelProperty(value = "ERP仓库编号")
    private String erpWarehouseCode;
    @ApiModelProperty(value = "仓库归属的企业标识")
    private String orgId;
    @ApiModelProperty(value = "保管员标识")
    private String keeperId;
    @ApiModelProperty(value = "说明")
    private String description;
    @ApiModelProperty(value = "是否计划仓库")
    private Integer isPlan;
    @ApiModelProperty(value = "是否中心仓库")
    private Integer isCenter;
    @ApiModelProperty(value = "")
    private Integer firstInOut;
    @ApiModelProperty(value = "是否条码化 0-否，1-是")
    private Integer isBarCode;
}
