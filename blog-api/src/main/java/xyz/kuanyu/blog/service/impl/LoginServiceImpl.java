package xyz.kuanyu.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import xyz.kuanyu.blog.dao.pojo.SysUser;
import xyz.kuanyu.blog.service.LoginService;
import xyz.kuanyu.blog.service.SysUserService;
import xyz.kuanyu.blog.utils.JWTUtils;
import xyz.kuanyu.blog.vo.ErrorCode;
import xyz.kuanyu.blog.vo.Result;
import xyz.kuanyu.blog.vo.params.LoginParam;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String slat = "mszlu!@#";

    @Override
    public Result login(LoginParam loginParam) {
        /**
         * 1。检查参数是否合法
         * 2。根据用户名和密码去 user 表中查询 是否存在
         * 3。如果不存在，登录失败
         * 4。如果存在，使用jwt，生成token 返回给前端
         * 5。token放入redis中，redis token：user信息 设置过期时间
         * （登录认证时候 先认证token字符串是否合法，去redis认证是否存在）
         */
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        password = DigestUtils.md5Hex(password + slat);
        SysUser sysUser = sysUserService.findUser(account, password);
        if (sysUser == null){
            return Result.fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        String token = JWTUtils.createToken(sysUser.getId());

        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(sysUser),100, TimeUnit.DAYS);
        return Result.success(token);
    }

    @Override
    public SysUser checkToken(String token) {
        if (StringUtils.isBlank(token)){
            return null;
        }
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        if (stringObjectMap == null){
            return null;
        }
        String userJson = redisTemplate.opsForValue().get("TOKEN_"+token);
        if (StringUtils.isBlank(userJson)){ //过期
            return null;
        }
        SysUser sysUser = JSON.parseObject(userJson, SysUser.class);
        return sysUser;
    }
}