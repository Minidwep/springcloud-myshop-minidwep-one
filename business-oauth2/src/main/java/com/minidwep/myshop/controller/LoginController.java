package com.minidwep.myshop.controller;

import com.google.common.collect.Maps;
import com.minidwep.myshop.config.service.UserDetailServiceImpl;
import com.minidwep.myshop.dto.LoginInfo;
import com.minidwep.myshop.dto.LoginParam;
import com.minidwep.myshop.dto.ResponseResult;
import com.minidwep.myshop.util.MapperUtils;
import com.minidwep.myshop.util.OkHttpClientUtil;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;
import org.springframework.security.core.userdetails.UserDetailsService;
/**
 * @author minid
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class LoginController {

    private static final String URL_OAUTH_TOKEN = "http://localhost:9041/oauth/token";

    @Value("${business.oauth2.grant_type}")
    public String oauth2GrantType;

    @Value("${business.oauth2.client_id}")
    public String oauth2ClientId;

    @Value("${business.oauth2.client_secret}")
    public String oauth2ClientSecret;


    @Resource(name = "userDetailsService")
    public UserDetailsService userDetailService;

    @Resource
    public BCryptPasswordEncoder passwordEncoder;

    @Resource
    public TokenStore tokenStore;

    @PostMapping("/user/login")
    public ResponseResult<Map<String,Object>> login(@RequestBody LoginParam loginParam){
        Map<String,Object> result = Maps.newHashMap();

        UserDetails userDetails = userDetailService.loadUserByUsername(loginParam.getUsername());
        if(userDetails == null || !passwordEncoder.matches(loginParam.getPassword(),userDetails.getPassword())){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"账号或密码错误",null);
        }
        Map<String,String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", oauth2GrantType);
        params.put("client_id", oauth2ClientId);
        params.put("client_secret", oauth2ClientSecret);
        try {
            Response response = OkHttpClientUtil.getInstance().postData(URL_OAUTH_TOKEN, params);
            String jsonString = Objects.requireNonNull(response.body()).string();
            Map<String, Object> stringObjectMap = MapperUtils.json2map(jsonString);
            String token = String.valueOf(stringObjectMap.get("access_token"));
            result.put("token",token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseResult(ResponseResult.CodeStatus.OK,"登陆成功",result);
    }

    @GetMapping("/user/info")
    public ResponseResult<LoginInfo> info(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(name);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"获取用户信息",loginInfo);
    }

    @PostMapping("/user/logout")
    public ResponseResult<Void> logout(HttpServletRequest request){
        String token = request.getParameter("access_token");
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"用户注销",null);
    }
}
