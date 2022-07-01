package cn.edu.cupk.admin.pojo.query;

import cn.edu.cupk.common.base.BasePageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 赵希奥
 * @date 2022/7/1 10:02
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Data
@EqualsAndHashCode(callSuper=false)
public class ClientPageQuery extends BasePageQuery {
    private String keywords;
}
