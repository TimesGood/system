//package com.example.admin.service.special;
//
//import com.example.mbg.model.UmsResource;
//import com.example.security.component.dynamicSecurity.DynamicSecurityService;
//import com.example.admin.service.UmsResourceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Service
//public class DynamicSecurityServiceImpl implements DynamicSecurityService {
//    @Autowired
//    UmsResourceService resourceService;
//
//    @Override
//    public Map<String, ConfigAttribute> loadDataSource() {
//        Map<String,ConfigAttribute> map = new ConcurrentHashMap<>();
//        List<UmsResource> resourceList = resourceService.listAll();
//        for(UmsResource res : resourceList){
//            map.put(res.getUrl(),new org.springframework.security.access.SecurityConfig(res.getId()+":"+res.getName()));
//        }
//        return map;
//    }
//}
