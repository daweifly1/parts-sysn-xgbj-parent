package cn.com.xgit.parts.rm.module.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户扩展信息 VO类
 */
@Data
@ToString
public class AccountExtVO implements Serializable {
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "账号ID", example = "1")
    private Long accountId;
    @ApiModelProperty(value = "ERP编号", example = "1")
    private String erpNo;
    @ApiModelProperty(value = "其他详细，不做查询条件直接json存储", example = "1")
    private String detail;
    @ApiModelProperty(value = "创建者ID", example = "1")
    private Long createdBy;
    @ApiModelProperty(value = "创建时间", example = "2019-07-08 00:00:00")
    private Date createdTime;
    @ApiModelProperty(value = "更新者", example = "1")
    private Long updatedBy;
    @ApiModelProperty(value = "更新时间", example = "2019-07-08 00:00:00")
    private Date updatedTime;
}
