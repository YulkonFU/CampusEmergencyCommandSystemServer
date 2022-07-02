package cn.edu.cupk.admin.pojo.entity;

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
 * @Description:权限表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("permission")
public class Permission {
    @TableId(value = "id",type = IdType.AUTO)
    private Long permissionId;

    private String name;

    private String authority;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
