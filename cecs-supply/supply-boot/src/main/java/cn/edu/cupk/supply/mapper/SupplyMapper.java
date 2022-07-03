package cn.edu.cupk.supply.mapper;

import cn.edu.cupk.supply.entity.Supply;
import cn.edu.cupk.supply.entity.dto.SupplyAmountDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author 赵希奥
 * @date 2022/7/3 16:18
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public interface SupplyMapper extends BaseMapper<Supply> {

    List<SupplyAmountDTO> getRemaining();

}
