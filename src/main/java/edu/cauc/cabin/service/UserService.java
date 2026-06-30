package edu.cauc.cabin.service;

import edu.cauc.cabin.model.request.LoginRequest;
import edu.cauc.cabin.model.request.RegisterRequest;

public interface UserService {

    int register(RegisterRequest request);

    String login(LoginRequest request);

}
