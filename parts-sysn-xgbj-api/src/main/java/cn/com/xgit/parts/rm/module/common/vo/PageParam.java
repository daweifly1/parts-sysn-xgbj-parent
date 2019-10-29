package cn.com.xgit.parts.rm.module.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString(callSuper = true)
public class PageParam extends Object implements Serializable  {
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "页大小", example = "20")
    protected Integer pageSize;
    @ApiModelProperty(value = "当前页", example = "1")
    protected Integer current;
    @ApiModelProperty(value = "顺序依据", example = "")
    protected String ascs;
    @ApiModelProperty(value = "逆序依据", example = "")
    protected String descs;

}
