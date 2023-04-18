package com.example.system.security.component.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.system.common.api.CommonResult;
import com.example.system.security.exception.CaptchaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆失败时自定义处理逻辑
 */
//@Component
public class JwtLoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        CommonResult<String> unauthorized = null;
        //可根据UserDetailsServiceImpl中抛出的异常返回不同信息
        if (exception instanceof AccountExpiredException) {
            //账号过期
            unauthorized = CommonResult.validateFailed("账号已过期，请重新登录");
        } else if (exception instanceof BadCredentialsException){
            unauthorized = CommonResult.validateFailed("用户或密码错误");
        } else if (exception instanceof CaptchaException || exception instanceof UsernameNotFoundException){
            unauthorized = CommonResult.validateFailed(exception.getMessage());
        }else{
            unauthorized = CommonResult.validateFailed("登录异常");
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(JSONObject.toJSON(unauthorized));
        response.getWriter().flush();
    }
}
