package cn.edu.cupk.common.web.utils;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 赵希奥
 * @date 2022/5/28 0:02
 * @gitHub https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public class WebUtils {

    /**
     * 将字符串渲染到客户端
     * @param response 渲染对象
     * @param string 待渲染的字符串
     * @return null
     */
    public static String renderString(HttpServletResponse response, String string) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
