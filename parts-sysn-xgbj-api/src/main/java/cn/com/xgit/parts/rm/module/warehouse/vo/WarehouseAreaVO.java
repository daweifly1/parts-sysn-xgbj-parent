package cn.com.xgit.parts.rm.module.warehouse.vo;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 仓库区域表 VO类
 */
@Data
@ToString
public class WarehouseAreaVO  implements Serializable{
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "区域属性描述")
    private String attrDesc;
    @ApiModelProperty(value = "SAP编码")
    private String sapCode;
    @ApiModelProperty(value = "")
    private String orgId;
    @ApiModelProperty(value = "是否直投默认库区")
    private Integer isDirect;
    @ApiModelProperty(value = "区域标识")
    private String id;
    @ApiModelProperty(value = "区域编号")
    private String areaCode;
    @ApiModelProperty(value = "仓库标识")
    private String warehouseId;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "区域属性标识")
    private String attrId;
}
