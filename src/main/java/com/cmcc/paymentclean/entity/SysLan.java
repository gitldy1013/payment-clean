package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by lumma on 2020/9/21.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysLan对象", description="地域编码字典表")
public class SysLan {

    @TableId
    @ApiModelProperty(value = "lanId")
    private String lanId;

    @ApiModelProperty(value = "lanName")
    private String lanName;

    @ApiModelProperty(value = "lanCode")
    private String lanCode;

    @ApiModelProperty(value = "provinceId")
    private String provinceId;
}
