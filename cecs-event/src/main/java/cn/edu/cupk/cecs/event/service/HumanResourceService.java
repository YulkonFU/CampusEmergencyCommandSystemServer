package cn.edu.cupk.cecs.event.service;

import cn.edu.cupk.cecs.event.mapper.HumanResourceMapper;
import cn.edu.cupk.cecs.event.pojo.entity.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanResourceService {
    @Autowired
    HumanResourceMapper humanResourceMapper;
    //获取人力资源
//    public Boolean getResource(List<Source> humanResource){
//        return humanResourceMapper.getResource(humanResource);
//    }
}
