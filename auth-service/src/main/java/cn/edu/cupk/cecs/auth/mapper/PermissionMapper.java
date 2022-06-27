package cn.edu.cupk.cecs.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 赵希奥
 * @date 2022/6/27 18:32
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@Mapper
public interface PermissionMapper {

    /**
     * 通过用户ID查询用户权限
     * @param userId
     * @return
     */
    public List<String> selectPermsByUserId(Long userId);
}
