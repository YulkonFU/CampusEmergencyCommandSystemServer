package cn.edu.cupk.cecs.humanResource.service.impl;

import cn.edu.cupk.cecs.humanResource.mapper.HumanResourceMapper;
import cn.edu.cupk.cecs.humanResource.pojo.entity.HumanResource;
import cn.edu.cupk.cecs.humanResource.pojo.utils.PageResult;
import cn.edu.cupk.cecs.humanResource.service.HumanResourceService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/04/3:49
 * @Description:
 */
@Service
public class HumanResourceServiceImpl implements HumanResourceService {
    @Autowired
    private HumanResourceMapper humanResourceMapper;

    @Override
    public PageResult<HumanResource> getHumanResource(Integer currentPage, Integer pageSize) {
        LambdaQueryWrapper<HumanResource> wrapper = new LambdaQueryWrapper<>();
        Page<HumanResource> page = new Page<>(currentPage,pageSize);
        IPage<HumanResource> humanResourceIPage = humanResourceMapper.selectPage(page,wrapper);
        PageResult<HumanResource> result = PageResult.success(humanResourceIPage);
        return result;
    }

    @Override
    public Boolean updateHumanResource(HumanResource humanResource) {
        int flag = humanResourceMapper.updateById(humanResource);
        if(flag > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteHumanResource(Long id) {
        int flag = humanResourceMapper.deleteById(id);
        if(flag > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean addNewHumanResource(HumanResource humanResource) {
        int flag = humanResourceMapper.insert(humanResource);
        if(flag > 0){
            return true;
        }
        return false;
    }
}
