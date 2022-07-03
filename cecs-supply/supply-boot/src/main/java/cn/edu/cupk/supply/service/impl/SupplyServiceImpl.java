package cn.edu.cupk.supply.service.impl;

import cn.edu.cupk.common.result.PageResult;
import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.supply.entity.Supply;
import cn.edu.cupk.supply.entity.dto.SupplyAmountDTO;
import cn.edu.cupk.supply.entity.query.SupplyPageQuery;
import cn.edu.cupk.supply.mapper.SupplyMapper;
import cn.edu.cupk.supply.service.SupplyService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 赵希奥
 * @date 2022/7/3 16:16
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Service
public class SupplyServiceImpl extends ServiceImpl<SupplyMapper, Supply> implements SupplyService {

    @Resource
    private SupplyMapper supplyMapper;

    @Override
    public PageResult listEventPages(SupplyPageQuery queryParams) {
        IPage<Supply> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<Supply> wrapper = new LambdaQueryWrapper<>();
        IPage<Supply> supplyIPage = supplyMapper.selectPage(page, wrapper);
        return PageResult.success(supplyIPage);
    }

    @Override
    public List<SupplyAmountDTO> getRemaining() {
        return supplyMapper.getRemaining();
    }
}
