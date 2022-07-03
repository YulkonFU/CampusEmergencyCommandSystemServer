package cn.edu.cupk.event.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 赵希奥
 * @date 2022/7/3 13:22
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Data
public class EventTimesItemDTO {

    private LocalDateTime day;

    private Integer type;

    private Integer count;

}
