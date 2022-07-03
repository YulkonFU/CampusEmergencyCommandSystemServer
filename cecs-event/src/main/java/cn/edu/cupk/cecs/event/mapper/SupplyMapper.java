package cn.edu.cupk.cecs.event.mapper;

import cn.edu.cupk.cecs.event.pojo.entity.Source;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupplyMapper  {
    Boolean updateSupply(String name, Integer number);

    long findSupplyID(String name);

}
