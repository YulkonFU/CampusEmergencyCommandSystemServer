package cn.edu.cupk.admin.service;

import cn.edu.cupk.admin.pojo.entity.OauthClient;
import cn.edu.cupk.admin.pojo.query.ClientPageQuery;
import cn.edu.cupk.admin.pojo.vo.client.ClientPageVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 赵希奥
 * @date 2022/7/1 1:10
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public interface OAuthClientService extends IService<OauthClient> {

    IPage<ClientPageVO> listPageClients(ClientPageQuery queryParams);

    void cleanCache();

}
