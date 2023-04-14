package com.example.system.service;


import com.example.system.common.api.CommonResult;

/**
 * 会员管理Service
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult<String> generateAuthCode(String telephone);
    CommonResult<String> generateAuthCodeBack(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult<String> verifyAuthCode(String telephone, String authCode);

    CommonResult<String> verifyAuthCodeBack(String telephone, String authCode);

}
