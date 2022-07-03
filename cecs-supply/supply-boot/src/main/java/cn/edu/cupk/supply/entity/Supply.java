package cn.edu.cupk.supply.entity;

import cn.edu.cupk.supply.entity.enums.SupplyTypeEnum;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author 赵希奥
 * @date 2022/7/3 16:02
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Data
@TableName("supply")
public class Supply {

    @TableId(value="supply_id", type = IdType.AUTO)
    private Long id;

    @TableField("supply_name")
    private String name;

    @TableField("supply_category")
    private SupplyTypeEnum category;

    @TableField("inventory")
    private Integer inventory;

    @TableLogic
    private Integer deleted;
}
