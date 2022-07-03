package cn.edu.cupk.plan.service;

import cn.edu.cupk.common.result.PageResult;
import cn.edu.cupk.plan.entity.Plan;
import cn.edu.cupk.plan.entity.query.PlanPageQuery;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 赵希奥
 * @date 2022/7/3 21:36
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public interface PlanService extends IService<Plan> {

    PageResult listPlanPages(PlanPageQuery queryParams);
}
