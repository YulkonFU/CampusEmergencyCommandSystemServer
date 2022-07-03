package cn.edu.cupk.cecs.event.mapper;

import cn.edu.cupk.cecs.event.pojo.entity.HumanResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Process_HumanResourceMapper {

    Boolean insertList(List<HumanResource> selectList, Integer processId);
}
