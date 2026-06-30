package edu.cauc.cabin.service.impl;

import edu.cauc.cabin.mapper.UserMapper;
import edu.cauc.cabin.model.entity.User;
import edu.cauc.cabin.model.request.LoginRequest;
import edu.cauc.cabin.model.request.RegisterRequest;
import edu.cauc.cabin.service.UserService;
import edu.cauc.cabin.util.JWTUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;


    @Override
    public int register(RegisterRequest request) {

        //解包请求
        String account = request.getAccount();
        String userName = request.getUserName();
        String password = request.getPassword();

        if(account != null && userName != null && password != null){

            User user = this.parseToUser(request);
            int save = userMapper.insert(user);

            return save;
        }
        else {
            //返回空，供 controller 层报错
            System.out.println("有参数为空！");
            return -1;

        }

    }

    private User parseToUser(RegisterRequest request){

        User user = new User();

        user.setAccount(request.getAccount());
        user.setName(request.getUserName());
        user.setPassword(request.getPassword());
        user.setPoint(0L);

        return user;
    }

    @Override
    public String login(LoginRequest request) {

        String account = request.getAccount();
        String password = request.getPassword();

        User user = userMapper.selectByAccount(account);
        String passwordFromDB = user.getPassword();

        if(!password.equals(passwordFromDB)){
            return null;
        }

        String token = JWTUtils.generateJsonWebToken(user);


        return token;
    }
}
