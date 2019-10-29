package cn.com.xgit.parts.rm.module.warehouse.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 仓库表 DO
 */

@Data
@ToString(callSuper = true)
@TableName("T_WAREHOUSE")
@ApiModel(value = "Warehouse",description = "仓库表")
public class Warehouse  implements Serializable{
    private static final long serialVersionUID = -1L;
    //仓库标识
    @TableField(value = "ID")
    @ApiModelProperty(value="仓库标识",name="ID")
    private String id;
    //仓库编号
    @TableField(value = "WAREHOUSE_CODE")
    @ApiModelProperty(value="仓库编号",name="WAREHOUSE_CODE")
    private String warehouseCode;
    //ERP仓库编号
    @TableField(value = "ERP_WAREHOUSE_CODE")
    @ApiModelProperty(value="ERP仓库编号",name="ERP_WAREHOUSE_CODE")
    private String erpWarehouseCode;
    //仓库归属的企业标识
    @TableField(value = "ORG_ID")
    @ApiModelProperty(value="仓库归属的企业标识",name="ORG_ID")
    private String orgId;
    //保管员标识
    @TableField(value = "KEEPER_ID")
    @ApiModelProperty(value="保管员标识",name="KEEPER_ID")
    private String keeperId;
    //说明
    @TableField(value = "DESCRIPTION")
    @ApiModelProperty(value="说明",name="DESCRIPTION")
    private String description;
    //是否计划仓库
    @TableField(value = "IS_PLAN")
    @ApiModelProperty(value="是否计划仓库",name="IS_PLAN")
    private Integer isPlan;
    //是否中心仓库
    @TableField(value = "IS_CENTER")
    @ApiModelProperty(value="是否中心仓库",name="IS_CENTER")
    private Integer isCenter;
    //
    @TableField(value = "FIRST_IN_OUT")
    @ApiModelProperty(value="",name="FIRST_IN_OUT")
    private Integer firstInOut;
    //是否条码化 0-否，1-是
    @TableField(value = "IS_BAR_CODE")
    @ApiModelProperty(value="是否条码化 0-否，1-是",name="IS_BAR_CODE")
    private Integer isBarCode;

}
