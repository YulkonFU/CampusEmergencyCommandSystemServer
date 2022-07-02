package cn.edu.cupk.cecs.watchkeeper.mapper;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/11:35
 * @Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    int updatePassword(String password,String username);

    String searchName(long id);
}
