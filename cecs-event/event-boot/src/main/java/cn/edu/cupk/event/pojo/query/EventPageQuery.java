package cn.edu.cupk.event.pojo.query;

import cn.edu.cupk.common.base.BasePageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 赵希奥
 * @date 2022/7/2 17:00
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@Data
public class EventPageQuery extends BasePageQuery {

    private String keywords;

    private Integer status;


/*     @ApiModelProperty("关键字(用户名/昵称/手机号)")
    private String keywords;

    @ApiModelProperty("用户状态")
    private Integer status;

    @ApiModelProperty("部门ID")
    private Long deptId; */

}