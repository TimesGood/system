package com.example.system.security.component.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.system.common.api.CommonResult;
import com.example.system.security.common.util.JwtTokenUtil;
import com.example.system.security.properties.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功后处理逻辑
 */
//@Component
public class JwtLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtProperties jwtProperties;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        //制作token
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenPrefix", jwtProperties.getTokenPrefix());
        //此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
        //进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展
        //处理编码方式，防止中文乱码的情况
        response.setContentType("application/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        response.getWriter().print(JSONObject.toJSON(CommonResult.success(tokenMap)));
        response.getWriter().flush();
    }
}
