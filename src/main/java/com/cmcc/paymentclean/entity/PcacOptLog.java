package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 操作日志表 
 * </p>
 *
 * @author cmcc
 * @since 2020-09-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="PcacOptLog对象", description="操作日志表 ")
public class PcacOptLog extends Model<PcacOptLog> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id序号")
    @TableId(value = "pcac_opt_log_id", type = IdType.AUTO)
    private Integer pcacOptLogId;

    @ApiModelProperty(value = "操作人")
    private String createdBy;

    @ApiModelProperty(value = "操作内容")
    private String optContent;

    @ApiModelProperty(value = "操作时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新人")
    private String updatedBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatedTime;


    @Override
    protected Serializable pkVal() {
        return this.pcacOptLogId;
    }

}
