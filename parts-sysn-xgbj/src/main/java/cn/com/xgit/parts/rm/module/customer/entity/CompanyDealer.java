package cn.com.xgit.parts.rm.module.customer.entity;

import cn.com.xgit.platform.common.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业客户关系表 DO
 */
@Data
@ToString(callSuper = true)
@TableName("COMPANY_DEALER")
@ApiModel(value = "CompanyDealer", description = "企业客户关系表")
public class CompanyDealer  extends BaseEntity {
    private static final long serialVersionUID = -1L;
    //id
    @TableField(value = "ID")
    @ApiModelProperty(value = "id", name = "id")
    private Long id;
    //企业编码
    @TableField(value = "ORG_ID")
    @ApiModelProperty(value = "企业编码", name = "orgId")
    private String orgId;
    //下游编码
    @TableField(value = "DEALER_ORG_ID")
    @ApiModelProperty(value = "下游编码", name = "dealerOrgId")
    private String dealerOrgId;
    //客户编号
    @TableField(value = "DEALER_CODE")
    @ApiModelProperty(value = "客户编号", name = "dealerCode")
    private String dealerCode;
    //下游企业名称
    @TableField(value = "COMPANY_NAME")
    @ApiModelProperty(value = "下游企业名称", name = "companyName")
    private String companyName;
    //下游简称
    @TableField(value = "SHORT_NAME")
    @ApiModelProperty(value = "下游简称", name = "shortName")
    private String shortName;
    //地址
    @TableField(value = "ADDRESS")
    @ApiModelProperty(value = "地址", name = "address")
    private String address;
    //邮编
    @TableField(value = "ZIP")
    @ApiModelProperty(value = "邮编", name = "zip")
    private String zip;
    //传真
    @TableField(value = "FAX")
    @ApiModelProperty(value = "传真", name = "fax")
    private String fax;
    //下游联系人
    @TableField(value = "CONTACT")
    @ApiModelProperty(value = "下游联系人", name = "contact")
    private String contact;
    //下游联系方式
    @TableField(value = "CONTACT_TEL")
    @ApiModelProperty(value = "下游联系方式", name = "contactTel")
    private String contactTel;
    //客户分类id
    @TableField(value = "DEALER_CLASS_ID")
    @ApiModelProperty(value = "客户分类id", name = "dealerClassId")
    private Integer dealerClassId;
    //是否平台企业
    @TableField(value = "IS_PLAT_COMPANY")
    @ApiModelProperty(value = "是否平台企业", name = "isPlatCompany")
    private Integer isPlatCompany;
    //平台企业号
    @TableField(value = "PLAT_ORG_ID")
    @ApiModelProperty(value = "平台企业号", name = "platOrgId")
    private String platOrgId;
    //创建时间
    @TableField(value = "CREATE_DATE")
    @ApiModelProperty(value = "创建时间", name = "createDate")
    private Date createDate;
    //创建人
    @TableField(value = "CREATE_ID")
    @ApiModelProperty(value = "创建人", name = "createId")
    private String createId;
    //修改时间
    @TableField(value = "UPDATE_DATE")
    @ApiModelProperty(value = "修改时间", name = "updateDate")
    private Date updateDate;
    //修改人
    @TableField(value = "UPDATE_ID")
    @ApiModelProperty(value = "修改人", name = "updateId")
    private String updateId;
    //删除标识
    @TableField(value = "IS_DEL")
    @ApiModelProperty(value = "删除标识", name = "isDel")
    private Integer isDel;
    //所属部门id
    @TableField(value = "DEPARTEMNT_ID")
    @ApiModelProperty(value = "所属部门id", name = "departemntId")
    private String departemntId;
    //所属业务员id
    @TableField(value = "OWER_ID")
    @ApiModelProperty(value = "所属业务员id", name = "owerId")
    private String owerId;
    //下游企业在平台状态（1未邀请，2已邀请，3待审核，4审核拒绝，5审核通过）
    @TableField(value = "APPLY_STATUS")
    @ApiModelProperty(value = "下游企业在平台状态（1未邀请，2已邀请，3待审核，4审核拒绝，5审核通过）", name = "applyStatus")
    private Integer applyStatus;
    //
    @TableField(value = "CUSTOMER_GROUP")
    @ApiModelProperty(value = "", name = "customerGroup")
    private String customerGroup;
    //
    @TableField(value = "PRICE_GROUP")
    @ApiModelProperty(value = "", name = "priceGroup")
    private String priceGroup;
    //
    @TableField(value = "SALE_GROUP")
    @ApiModelProperty(value = "", name = "saleGroup")
    private String saleGroup;
    //
    @TableField(value = "SALE_DEPT")
    @ApiModelProperty(value = "", name = "saleDept")
    private String saleDept;
    //是否查看供应商库存，0否1是
    @TableField(value = "IS_STORAGE")
    @ApiModelProperty(value = "是否查看供应商库存，0否1是", name = "isStorage")
    private Integer isStorage;
    //总额度
    @TableField(value = "TOTAL_LIMIT")
    @ApiModelProperty(value = "总额度", name = "totalLimit")
    private Integer totalLimit;
    //已用额度
    @TableField(value = "USED_LIMIT")
    @ApiModelProperty(value = "已用额度", name = "usedLimit")
    private Integer usedLimit;
    //是否启用额度 0否1是
    @TableField(value = "ENABLE_LIMIT")
    @ApiModelProperty(value = "是否启用额度 0否1是", name = "enableLimit")
    private Integer enableLimit;
    //是否直投件 0否1是
    @TableField(value = "IS_DIRECT")
    @ApiModelProperty(value = "是否直投件 0否1是", name = "isDirect")
    private Integer isDirect;
    //直投达标金额
    @TableField(value = "DIRECT_LIMIT")
    @ApiModelProperty(value = "直投达标金额", name = "directLimit")
    private Integer directLimit;
    //客户分级id
    @TableField(value = "DEALER_LEVEL_ID")
    @ApiModelProperty(value = "客户分级id", name = "dealerLevelId")
    private String dealerLevelId;
    //客户分级名称
    @TableField(value = "DEALER_LEVEL_NAME")
    @ApiModelProperty(value = "客户分级名称", name = "dealerLevelName")
    private String dealerLevelName;

}
