package cn.edu.cupk.cecs.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/28/16:47
 * @Description:职能表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("role")
public class Role {
    @TableId(value = "id",type = IdType.AUTO)
    private long roleId;

    private String roleName;
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
