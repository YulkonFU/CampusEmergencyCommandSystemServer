package cn.edu.cupk.supply.entity.dto;

import cn.edu.cupk.supply.entity.enums.SupplyTypeEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author 赵希奥
 * @date 2022/7/3 16:31
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Data
public class SupplyDTO {

    private Long id;

    private String name;

    private SupplyTypeEnum category;

    private Integer inventory;
}
