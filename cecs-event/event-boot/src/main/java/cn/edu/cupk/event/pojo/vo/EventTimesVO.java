package cn.edu.cupk.event.pojo.vo;

import lombok.Data;

/**
 * @author 赵希奥
 * @date 2022/7/3 0:30
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Data
public class EventTimesVO {

    /**
     * 事件类型
     */
    private String eventType;

    /**
     * 事件发生次数
     */
    private Long times;

}
