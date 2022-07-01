package cn.edu.cupk.admin.convert;

import cn.edu.cupk.admin.pojo.entity.OauthClient;
import cn.edu.cupk.admin.pojo.vo.client.ClientPageVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;


/**
 * @author 赵希奥
 * @date 2022/7/1 10:24
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Mapper(componentModel = "spring")
public interface ClientConvert {
    ClientPageVO entity2PageVO(OauthClient entity);

    Page<ClientPageVO> entity2PageVO(Page<OauthClient> entityPage);
}
