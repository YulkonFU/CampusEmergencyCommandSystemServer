package cn.edu.cupk.cecs.admin.mapper;

import cn.edu.cupk.cecs.admin.pojo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/28/17:45
 * @Description:
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    
    /**
    * @Description: 查询用户列表，分页显示
    * @Param: [page, state]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<cn.edu.cupk.cecs.admin.entity.User>
    * @Author: rst
    * @Date: 2022/6/29
    */

    IPage<User> selectPageVo(Page<User> page);
}
