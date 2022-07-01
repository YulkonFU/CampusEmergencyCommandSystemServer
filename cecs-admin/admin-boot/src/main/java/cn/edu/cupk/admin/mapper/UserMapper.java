package cn.edu.cupk.admin.mapper;

import cn.edu.cupk.admin.pojo.entity.User;
import cn.edu.cupk.admin.dto.UserAuthDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 赵希奥
 * @date 2022/6/29 11:49
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    UserAuthDTO getAuthInfoByUsername(String username);

}