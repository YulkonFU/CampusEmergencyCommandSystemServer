package cn.edu.cupk.plan.service.impl;


import cn.edu.cupk.common.result.PageResult;
import cn.edu.cupk.plan.entity.Plan;
import cn.edu.cupk.plan.entity.query.PlanPageQuery;
import cn.edu.cupk.plan.mapper.PlanMapper;
import cn.edu.cupk.plan.service.PlanService;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author 赵希奥
 * @date 2022/7/3 21:37
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@Service
public class PlanServiceImpl extends ServiceImpl<PlanMapper, Plan> implements PlanService {

    @Override
    public PageResult listPlanPages(PlanPageQuery queryParams) {
        IPage<Plan> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<Plan> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Plan::getDeleted, 0)
                .like(StringUtils.hasText(queryParams.getKeywords()), Plan::getTitle, queryParams.getKeywords()).or()
                .like(StringUtils.hasText(queryParams.getKeywords()), Plan::getContent, queryParams.getKeywords()).or()
                .like(StringUtils.hasText(queryParams.getKeywords()), Plan::getAuthor, queryParams.getKeywords());
        IPage<Plan> planIPage = baseMapper.selectPage(page, wrapper);
        return PageResult.success(planIPage);
    }


}