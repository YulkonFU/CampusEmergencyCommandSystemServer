package cn.edu.cupk.event.mapper;

import cn.edu.cupk.event.pojo.entity.HumanResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProcessHumanResourceMapper {

    Boolean insertList(List<HumanResource> selectList, Integer processId);
}