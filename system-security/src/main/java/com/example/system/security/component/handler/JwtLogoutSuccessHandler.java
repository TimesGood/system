package com.example.system.security.component.handler;

import cn.hutool.json.JSONUtil;
import com.example.system.common.api.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登出成功时的自定义处理逻辑
 */
//@Component
public class JwtLogoutSuccessHandler implements LogoutSuccessHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtLogoutSuccessHandler.class);
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LOGGER.info("登出成功处理");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(JSONUtil.parse(CommonResult.success("登出成功")));
        response.getWriter().flush();
    }
}
