package edu.cauc.cabin.controller;

import edu.cauc.cabin.common.ApiResult;
import edu.cauc.cabin.model.request.LoginRequest;
import edu.cauc.cabin.model.request.RegisterRequest;
import edu.cauc.cabin.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("register")
    public ApiResult<String> register(@RequestBody RegisterRequest request){

        int register = userService.register(request);

        return register == 1 ?
                ApiResult.buildSuccess("注册成功！") :
                ApiResult.buildError("注册失败，请检查输入");
    }


    @PostMapping("login")
    public ApiResult<String> login(@RequestBody LoginRequest request){

        String token = userService.login(request);

        return token != null ?
                ApiResult.buildSuccess(token,"登录成功，令牌已发放，有效期一周"):
                ApiResult.buildError("登录失败，请检查账号密码");
    }

}
