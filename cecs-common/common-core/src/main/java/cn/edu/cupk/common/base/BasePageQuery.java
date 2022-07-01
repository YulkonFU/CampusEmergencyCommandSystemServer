package cn.edu.cupk.common.base;

import lombok.Data;

/**
 * @author 赵希奥
 * @date 2022/6/29 5:13
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Data
public class BasePageQuery {

    private int pageNum = 1;

    private int pageSize = 5;
}