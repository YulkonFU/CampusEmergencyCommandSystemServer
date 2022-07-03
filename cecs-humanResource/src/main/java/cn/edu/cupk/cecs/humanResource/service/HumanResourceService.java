package cn.edu.cupk.cecs.humanResource.service;

import cn.edu.cupk.cecs.humanResource.pojo.entity.HumanResource;
import cn.edu.cupk.cecs.humanResource.pojo.utils.PageResult;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/04/3:49
 * @Description:
 */
public interface HumanResourceService {
    PageResult<HumanResource> getHumanResource(Integer currentPage, Integer pageSize);

    Boolean updateHumanResource(HumanResource humanResource);
    //删除对象
    Boolean deleteHumanResource(Long id);

    Boolean addNewHumanResource(HumanResource humanResource);
}
