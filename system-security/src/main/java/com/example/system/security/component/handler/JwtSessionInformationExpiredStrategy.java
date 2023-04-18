package com.example.system.security.component.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.system.common.api.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 会话失效(账号被挤下线)处理逻辑
 */
//@Component
public class JwtSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        HttpServletResponse response = event.getResponse();
        response.getWriter().print(JSONObject.toJSON(CommonResult.failed("您已在另一处登录")));
        response.getWriter().flush();
    }
}
