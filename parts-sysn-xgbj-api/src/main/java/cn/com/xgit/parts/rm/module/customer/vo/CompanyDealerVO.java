package cn.com.xgit.parts.rm.module.customer.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业客户关系表 VO类
 */
@Data
@ToString
public class CompanyDealerVO implements Serializable {
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "企业编码")
    private String orgId;
    @ApiModelProperty(value = "下游编码")
    private String dealerOrgId;
    @ApiModelProperty(value = "客户编号")
    private String dealerCode;
    @ApiModelProperty(value = "下游企业名称")
    private String companyName;
    @ApiModelProperty(value = "下游简称")
    private String shortName;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "邮编")
    private String zip;
    @ApiModelProperty(value = "传真")
    private String fax;
    @ApiModelProperty(value = "下游联系人")
    private String contact;
    @ApiModelProperty(value = "下游联系方式")
    private String contactTel;
    @ApiModelProperty(value = "客户分类id")
    private Integer dealerClassId;
    @ApiModelProperty(value = "是否平台企业")
    private Integer isPlatCompany;
    @ApiModelProperty(value = "平台企业号")
    private String platOrgId;
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @ApiModelProperty(value = "创建人")
    private String createId;
    @ApiModelProperty(value = "修改时间")
    private Date updateDate;
    @ApiModelProperty(value = "修改人")
    private String updateId;
    @ApiModelProperty(value = "删除标识")
    private Integer isDel;
    @ApiModelProperty(value = "所属部门id")
    private String departemntId;
    @ApiModelProperty(value = "所属业务员id")
    private String owerId;
    @ApiModelProperty(value = "下游企业在平台状态（1未邀请，2已邀请，3待审核，4审核拒绝，5审核通过）")
    private Integer applyStatus;
    @ApiModelProperty(value = "")
    private String customerGroup;
    @ApiModelProperty(value = "")
    private String priceGroup;
    @ApiModelProperty(value = "")
    private String saleGroup;
    @ApiModelProperty(value = "")
    private String saleDept;
    @ApiModelProperty(value = "是否查看供应商库存，0否1是")
    private Integer isStorage;
    @ApiModelProperty(value = "总额度")
    private Integer totalLimit;
    @ApiModelProperty(value = "已用额度")
    private Integer usedLimit;
    @ApiModelProperty(value = "是否启用额度 0否1是")
    private Integer enableLimit;
    @ApiModelProperty(value = "是否直投件 0否1是")
    private Integer isDirect;
    @ApiModelProperty(value = "直投达标金额")
    private Integer directLimit;
    @ApiModelProperty(value = "客户分级id")
    private String dealerLevelId;
    @ApiModelProperty(value = "客户分级名称")
    private String dealerLevelName;
}
