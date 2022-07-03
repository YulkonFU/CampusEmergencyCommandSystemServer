package cn.edu.cupk.event.pojo.entity;

import lombok.Data;

@Data
public class Source {
    //资源名称
    private String name;
    //资源类别
    private String category;
    //资源数量
    private String number;

    public Source(String name, String category, String number) {
        this.name = name;
        this.category = category;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
