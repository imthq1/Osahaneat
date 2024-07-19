package com.food.Osahaneat.Controller;

import com.food.Osahaneat.payLoad.ResponseDate;
import com.food.Osahaneat.payLoad.SignUpRequest;
import com.food.Osahaneat.service.LoginService;
import com.food.Osahaneat.service.imp.LoginServiceImp;
import com.food.Osahaneat.utils.JwtUtilsHelper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.beans.Encoder;
import java.util.Base64;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServiceImp loginServiceImp;

    @Autowired
    JwtUtilsHelper jwtUtilsHelper;
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String email,@RequestParam String password){
        ResponseDate responseDate=new ResponseDate();
//     Lay key ma hoa
//        SecretKey key= Jwts.SIG.HS256.key().build();
//        String secretString = Encoders.BASE64.encode(key.getEncoded());
//        System.out.println(secretString);

        if(loginServiceImp.checkLogin(email, password)){
            String token=jwtUtilsHelper.generateJwtToken(email);
            responseDate.setData(token);
        }else{
            responseDate.setData("");
            responseDate.setSuccess(false);
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