package cn.edu.cupk.cecs.event.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProcessSupplyMapper {
    Boolean insertNewOne(long supplyId, Integer processId,Integer amount);
}
