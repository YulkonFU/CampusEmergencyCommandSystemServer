package cn.edu.cupk.cecs.admin.mapper;

import cn.edu.cupk.cecs.admin.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
}
