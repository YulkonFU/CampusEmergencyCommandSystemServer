package cn.edu.cupk.common.base;

import lombok.Data;

/**
 * @author huawei
 * @desc 基础分页请求对象
 * @email huawei_code@163.com
 * @date 2021/2/28
 */
@Data
public class BasePageQuery {

    private int pageNum = 1;

    private int pageSize = 5;
}
