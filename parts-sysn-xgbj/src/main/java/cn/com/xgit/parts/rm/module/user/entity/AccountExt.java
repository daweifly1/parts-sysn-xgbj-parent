package cn.com.xgit.parts.rm.module.user.entity;

import cn.com.xgit.platform.common.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * 用户扩展信息 实体类
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName("parts_account_ext")
@ApiModel(value = "AccountExt", description = "用户扩展信息")
@KeySequence("mybatisKeyGenerator")
public class AccountExt extends BaseEntity {
    private static final long serialVersionUID = -1L;

    @TableId(type = IdType.INPUT)
    @ApiModelProperty(
            value = "Id",
            name = "id", example = "1"
    )
    private Long id;
    //账号ID
    @ApiModelProperty(value = "账号ID", name = "account_id", example = "1")
    private Long accountId;
    //ERP编号
    @ApiModelProperty(value = "ERP编号", name = "erp_no", example = "1")
    private String erpNo;
    //其他详细，不做查询条件直接json存储
    @ApiModelProperty(value = "其他详细，不做查询条件直接json存储", name = "detail", example = "其他详细")
    private String detail;
    //创建者ID
    @ApiModelProperty(value = "创建者ID", name = "createdBy", example = "1")
    private Long createdBy;
    //创建时间
    @ApiModelProperty(value = "创建时间", name = "created_time", example = "2019-07-08 00:00:00")
    private Date createdTime;
    //更新者
    @ApiModelProperty(value = "更新者", name = "updated_by", example = "1")
    private Long updatedBy;
    //更新时间
    @ApiModelProperty(value = "更新时间", name = "updated_time", example = "2019-07-08 00:00:00")
    private Date updatedTime;


}
