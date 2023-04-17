//package com.example.system.demo.config;
//
//import com.example.system.demo.dto.AdminUserDetails;
//import com.example.system.mbg.mapper.UmsAdminMapper;
//import com.example.system.mbg.mapper.UmsResourceMapper;
//import com.example.system.mbg.model.UmsAdmin;
//import com.example.system.mbg.model.UmsAdminExample;
//import com.example.system.mbg.model.UmsResource;
//import com.example.system.security.component.dynamicSecurity.DynamicSecurityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.List;
//
//@Configuration
//public class DemoSecurityConfig {
//    @Autowired
//    private UmsAdminMapper adminMapper;
//
//    /**
//     * 获取用户信息
//     * @return
//     */
//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        //获取登录用户信息
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                UmsAdminExample example = new UmsAdminExample();
//                example.createCriteria().andUsernameEqualTo(username);
//                List<UmsAdmin> umsAdmins = adminMapper.selectByExample(example);
//                if(username != null && umsAdmins.size() > 0) {
//                    return new AdminUserDetails(umsAdmins.get(0));
//                }
//                throw new UsernameNotFoundException("没有该用户");
//            }
//        };
//    }
//}
