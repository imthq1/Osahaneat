package com.food.Osahaneat.service.imp;

import com.food.Osahaneat.dto.UserDTO;
import com.food.Osahaneat.payLoad.SignUpRequest;

import java.util.List;

public interface LoginServiceImp {


     boolean checkLogin(String email, String password);
     boolean addUser(SignUpRequest signUpRequest);


}
