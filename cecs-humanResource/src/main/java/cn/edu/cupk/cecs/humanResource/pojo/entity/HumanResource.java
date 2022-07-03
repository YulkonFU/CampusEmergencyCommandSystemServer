package cn.edu.cupk.cecs.humanResource.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/04/3:43
 * @Description:
 */
@Data
@TableName("human_resource")
public class HumanResource {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private Integer type;

    private String location;

    private Integer number;

    private float distance;

    @TableField("phone_number")
    private String phoneNumber;

    private String name;
}
