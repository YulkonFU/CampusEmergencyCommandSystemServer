package cn.edu.cupk.event.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupplyMapper  {
    Boolean updateSupply(String name, Integer number);

    long findSupplyID(String name);

}
