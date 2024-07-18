package com.food.Osahaneat.Controller;

import com.food.Osahaneat.payLoad.ResponseDate;
import com.food.Osahaneat.payLoad.SignUpRequest;
import com.food.Osahaneat.service.LoginService;
import com.food.Osahaneat.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServiceImp loginServiceImp;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String email,@RequestParam String password){
        ResponseDate responseDate=new ResponseDate();
        if(loginServiceImp.checkLogin(email, password)){
            responseDate.setData(true);
        }else{
            responseDate.setData(false);
        }

        return new ResponseEntity<>(responseDate, HttpStatus.OK);
    }
    @PostMapping("/Register")
    public ResponseEntity<?> signin(@RequestBody SignUpRequest signUpRequest){
        ResponseDate responseDate=new ResponseDate();
        if(loginServiceImp.addUser(signUpRequest))
        {
            responseDate.setData(true);
        }else{
            responseDate.setData(false);
        }

        return new ResponseEntity<>(responseDate, HttpStatus.OK);
    }


}