package cn.edu.cupk.plan.entity.query;

import cn.edu.cupk.common.base.BasePageQuery;
import lombok.Data;

/**
 * @author 赵希奥
 * @date 2022/7/3 21:33
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Data
public class PlanPageQuery extends BasePageQuery {
    private String keywords;
}
