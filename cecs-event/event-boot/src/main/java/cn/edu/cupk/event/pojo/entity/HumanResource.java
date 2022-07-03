package cn.edu.cupk.event.pojo.entity;

import lombok.Data;

@Data
public class HumanResource {
    private Integer id;//id
    private Integer type;//组织类型（0.医院1.消防2.警务）
    private Integer number;//剩余数量
    private float distance;//距离

    public HumanResource(Integer id, Integer type, Integer number, float distance) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.distance = distance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}
