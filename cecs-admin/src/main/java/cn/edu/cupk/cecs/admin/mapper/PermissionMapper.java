package cn.edu.cupk.cecs.admin.mapper;

import cn.edu.cupk.cecs.admin.pojo.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/28/21:58
 * @Description:
 */
@Mapper
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
}
