package cn.edu.cupk.cecs.event.controller;
import cn.edu.cupk.cecs.event.pojo.entity.Source;
import cn.edu.cupk.cecs.event.service.EventService;
import cn.edu.cupk.cecs.event.service.HumanResourceService;
import cn.edu.cupk.cecs.event.service.SupplyService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventService eventService;
    @ResponseBody
    @PostMapping("/deploy")
    public Boolean deploy(@RequestBody JSONObject source){
        Integer eventId= Integer.valueOf(source.getString("eventId"));
        System.out.println(source.getString("eventId"));
        Gson gson = new Gson();
        List<Source> sources=new ArrayList<Source>();
        sources=gson.fromJson(source.getString("tableData"),new TypeToken<List<Source>>(){}.getType());
        //人力资源
        List<Source> humanResource = new  ArrayList<>();
        //物资资源
        List<Source> goodsResource = new  ArrayList<>();
        for (int i=0;i<sources.size();i++){
            if(sources.get(i).getCategory().equals("救援人力")){
                humanResource.add(sources.get(i));
            }else {
                goodsResource.add(sources.get(i));
            }
        }
        return eventService.deploy(eventId,humanResource,goodsResource);
    }
}
