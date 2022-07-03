package cn.edu.cupk.cecs.schedule.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/03/21:09
 * @Description:
 */
@Data
public class DutySchedule {
    @TableId(value = "schedule_id", type= IdType.AUTO)
    private Long id;
    @TableField("user_id")
    private Integer userid;
    @TableField("duty_place")
    private String dutyPlace;
    @TableField("duty_date")
    private String dutyDate;
    @TableField("duty_start_time")
    private String startTime;
    @TableField("duty_end_time")
    private String endTime;

    public DutySchedule(Long id, Integer userid, String dutyPlace, String dutyDate, String startTime, String endTime) {
        this.id = id;
        this.userid = userid;
        this.dutyPlace = dutyPlace;
        this.dutyDate = dutyDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getDutyPlace() {
        return dutyPlace;
    }

    public void setDutyPlace(String dutyPlace) {
        this.dutyPlace = dutyPlace;
    }

    public String getDutyDate() {
        return dutyDate;
    }

    public void setDutyDate(String dutyDate) {
        this.dutyDate = dutyDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
