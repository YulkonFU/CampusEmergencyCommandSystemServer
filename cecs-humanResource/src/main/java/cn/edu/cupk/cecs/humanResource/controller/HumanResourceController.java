package cn.edu.cupk.cecs.humanResource.controller;

import cn.edu.cupk.cecs.humanResource.pojo.entity.HumanResource;
import cn.edu.cupk.cecs.humanResource.pojo.utils.PageResult;
import cn.edu.cupk.cecs.humanResource.service.impl.HumanResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/04/3:57
 * @Description:
 */
@Controller
@RequestMapping("/humanResource")
public class HumanResourceController {

    @Autowired
    private HumanResourceServiceImpl humanResourceService;

    @ResponseBody
    @GetMapping("/list")
    public PageResult<HumanResource> getHumanResource(@RequestParam(defaultValue = "1",value = "pageNum") Integer currentPage,
                                                      @RequestParam(defaultValue = "5",value = "pageSize") Integer pageSize){
        return humanResourceService.getHumanResource(currentPage,pageSize);
    }

    @ResponseBody
    @PutMapping("/modification")
    public Boolean updateHumanResource(@RequestBody HumanResource humanResource){
        return humanResourceService.updateHumanResource(humanResource);
    }

    @ResponseBody
    @DeleteMapping("/")
    public Boolean deleteHumanResource(Long id){
        return humanResourceService.deleteHumanResource(id);
    }

    @ResponseBody
    @PostMapping("/newHumanResource")
    public Boolean addNewHumanResource(@RequestBody HumanResource humanResource){
        return humanResourceService.addNewHumanResource(humanResource);
    }

}
