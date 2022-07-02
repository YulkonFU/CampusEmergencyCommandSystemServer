package cn.edu.cupk.cecs.watchkeeper.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/10:20
 * @Description:
 */
@Data
@TableName("plan")
@NoArgsConstructor
public class Plan {

    @TableId(value = "plan_id",type = IdType.AUTO)
    private long id;

    @TableField("plan_title")
    private String title;

    @TableField("plan_category")
    private String category;

    private String author;

    private String content;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
