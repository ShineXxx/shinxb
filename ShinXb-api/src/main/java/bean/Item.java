package bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Morty
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("item")
@ApiModel(value="Item对象", description="")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目标题")
    private String title;

    @ApiModelProperty(value = "项目周期")
    @TableField("ProjectCycle")
    private String ProjectCycle;

    @ApiModelProperty(value = "参与人角色")
    private String roles;

    @ApiModelProperty(value = "应用技术")
    @TableField("AppliedTechnology")
    private String AppliedTechnology;

    @ApiModelProperty(value = "项目简介")
    private String profile;

    @ApiModelProperty(value = "演示地址")
    @TableField("Demoaddress")
    private String Demoaddress;

    @ApiModelProperty(value = "项目截图")
    private String screenshot;


}
