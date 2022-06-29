package cn.edu.cupk.cecs.admin.service;

import cn.edu.cupk.cecs.admin.pojo.utils.PageResult;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/29/16:12
 * @Description:
 */
public interface UserService {

    PageResult selectUserbyName(Integer currentPage, Integer pageSize, String str);
}
