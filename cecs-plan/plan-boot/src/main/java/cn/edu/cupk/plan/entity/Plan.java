package cn.edu.cupk.plan.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author 赵希奥
 * @date 2022/7/3 21:18
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Data
@TableName("plan")
public class Plan {
    @TableId(value="plan_id", type = IdType.AUTO)
    private Long id;
    @TableField("plan_title")
    private String title;
    @TableField("plan_category")
    private String category;
    @TableField("author")
    private String author;
    @TableField("content")
    private String content;
    @TableLogic
    private Integer deleted;
}
