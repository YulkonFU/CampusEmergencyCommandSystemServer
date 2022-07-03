package cn.edu.cupk.supply.service;

import cn.edu.cupk.common.result.PageResult;
import cn.edu.cupk.supply.entity.dto.SupplyAmountDTO;
import cn.edu.cupk.supply.entity.Supply;
import cn.edu.cupk.supply.entity.query.SupplyPageQuery;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 赵希奥
 * @date 2022/7/3 16:01
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

public interface SupplyService extends IService<Supply> {

    PageResult listEventPages(SupplyPageQuery queryParams);

    List<SupplyAmountDTO> getRemaining();
}

