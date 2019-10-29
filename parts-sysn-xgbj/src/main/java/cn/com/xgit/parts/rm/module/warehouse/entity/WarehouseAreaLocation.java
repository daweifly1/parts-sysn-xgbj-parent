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
 * //待完善 DO
 */
@Data
@ToString(callSuper = true)
@TableName("T_WAREHOUSE_AREA_LOCATION")
@ApiModel(value = "WarehouseAreaLocation",description = "//待完善")
public class WarehouseAreaLocation  implements Serializable{
    private static final long serialVersionUID = -1L;
    //储位编号
    @TableField(value = "LOCATION_CODE")
    @ApiModelProperty(value="储位编号",name="LOCATION_CODE")
    private String locationCode;
    //仓库区域标识
    @TableField(value = "WAREHOUSE_AREA_ID")
    @ApiModelProperty(value="仓库区域标识",name="WAREHOUSE_AREA_ID")
    private String warehouseAreaId;
    //货架排编号
    @TableField(value = "ROW_NO")
    @ApiModelProperty(value="货架排编号",name="ROW_NO")
    private String rowNo;
    //层编号
    @TableField(value = "FLOOR_NO")
    @ApiModelProperty(value="层编号",name="FLOOR_NO")
    private String floorNo;
    //列编号
    @TableField(value = "COLUMN_NO")
    @ApiModelProperty(value="列编号",name="COLUMN_NO")
    private String columnNo;
    //位编号
    @TableField(value = "SEQ_NO")
    @ApiModelProperty(value="位编号",name="SEQ_NO")
    private String seqNo;
    //货架类型
    @TableField(value = "SHELF_TYPE")
    @ApiModelProperty(value="货架类型",name="SHELF_TYPE")
    private String shelfType;
    //货架编码
    @TableField(value = "SHELF_NO")
    @ApiModelProperty(value="货架编码",name="SHELF_NO")
    private String shelfNo;
    //
    @TableField(value = "LOCATION_DESC")
    @ApiModelProperty(value="",name="LOCATION_DESC")
    private String locationDesc;
    //
    @TableField(value = "ORG_ID")
    @ApiModelProperty(value="",name="ORG_ID")
    private String orgId;
    //添加时间
    @TableField(value = "CREATE_TIME")
    @ApiModelProperty(value="添加时间",name="CREATE_TIME")
    private Date createTime;

}
