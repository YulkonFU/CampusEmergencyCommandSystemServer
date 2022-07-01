package cn.edu.cupk.admin.service.impl;

import cn.edu.cupk.admin.convert.ClientConvert;
import cn.edu.cupk.admin.mapper.OauthClientMapper;
import cn.edu.cupk.admin.pojo.entity.OauthClient;
import cn.edu.cupk.admin.pojo.query.ClientPageQuery;
import cn.edu.cupk.admin.pojo.vo.client.ClientPageVO;
import cn.edu.cupk.admin.service.OAuthClientService;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author 赵希奥
 * @date 2022/7/1 10:07
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Service
@RequiredArgsConstructor
public class OAuthClientServiceImpl extends ServiceImpl<OauthClientMapper, OauthClient> implements OAuthClientService {

    private final ClientConvert clientConvert;

    private  StringRedisTemplate stringRedisTemplate;

    @Override
    public IPage<ClientPageVO> listPageClients(ClientPageQuery queryParams) {
        int pageNum =queryParams.getPageNum();
        int pageSize =queryParams.getPageSize();
        String keywords =queryParams.getKeywords();

        Page<OauthClient> page = new Page<>(pageNum, pageSize);

        // 查询数据
        Page<OauthClient> entityPage = this.page(page,
                new LambdaQueryWrapper<OauthClient>()
                        .like(StrUtil.isNotBlank(keywords), OauthClient::getClientId, keywords)
        );

        // 实体转换
        Page<ClientPageVO> voPage = clientConvert.entity2PageVO(entityPage);

        return voPage;
    }

    /**
     * 清理客户端缓存
     */
    @Override
    public void cleanCache() {
        Set<String> keys = stringRedisTemplate.keys("auth:oauth-client:*");
        if (CollectionUtil.isNotEmpty(keys)) {
            stringRedisTemplate.delete(keys);
        }
    }
}
