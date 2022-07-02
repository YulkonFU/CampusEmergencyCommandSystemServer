package cn.edu.cupk.admin.mapper;

import cn.edu.cupk.admin.pojo.entity.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/28/22:01
 * @Description:
 */
@Mapper
@Repository
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
}
