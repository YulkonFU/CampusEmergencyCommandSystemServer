package cn.edu.cupk.cecs.event.service;

import cn.edu.cupk.cecs.event.mapper.SupplyMapper;
import cn.edu.cupk.cecs.event.pojo.entity.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyService {
    @Autowired
    SupplyMapper supplyMapper;
    //获取物资资源
//    public Boolean getSupply(List<Source> supplyResource){
//        return supplyMapper.updateSupply(supplyResource);
//    }
}
