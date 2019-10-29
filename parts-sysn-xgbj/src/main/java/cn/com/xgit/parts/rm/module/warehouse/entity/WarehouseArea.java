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
 * 仓库区域表 DO
 */
@Data
@ToString(callSuper = true)
@TableName("T_WAREHOUSE_AREA")
@ApiModel(value = "WarehouseArea",description = "仓库区域表")
public class WarehouseArea  implements Serializable{
    private static final long serialVersionUID = -1L;
    //区域属性描述
    @TableField(value = "ATTR_DESC")
    @ApiModelProperty(value="区域属性描述",name="ATTR_DESC")
    private String attrDesc;
    //SAP编码
    @TableField(value = "SAP_CODE")
    @ApiModelProperty(value="SAP编码",name="SAP_CODE")
    private String sapCode;
    //
    @TableField(value = "ORG_ID")
    @ApiModelProperty(value="",name="ORG_ID")
    private String orgId;
    //是否直投默认库区
    @TableField(value = "IS_DIRECT")
    @ApiModelProperty(value="是否直投默认库区",name="IS_DIRECT")
    private Integer isDirect;
    //区域标识
    @TableField(value = "ID")
    @ApiModelProperty(value="区域标识",name="ID")
    private String id;
    //区域编号
    @TableField(value = "AREA_CODE")
    @ApiModelProperty(value="区域编号",name="AREA_CODE")
    private String areaCode;
    //仓库标识
    @TableField(value = "WAREHOUSE_ID")
    @ApiModelProperty(value="仓库标识",name="WAREHOUSE_ID")
    private String warehouseId;
    //描述
    @TableField(value = "DESCRIPTION")
    @ApiModelProperty(value="描述",name="DESCRIPTION")
    private String description;
    //区域属性标识
    @TableField(value = "ATTR_ID")
    @ApiModelProperty(value="区域属性标识",name="ATTR_ID")
    private String attrId;

}
