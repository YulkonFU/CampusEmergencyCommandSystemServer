package cn.edu.cupk.event.mapper;

import cn.edu.cupk.event.pojo.entity.HumanResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HumanResourceMapper {
    public Boolean getResource(List<HumanResource> selectList);
    //获取同类型组织的列表
    List<HumanResource> getListByType(Integer type);
}
