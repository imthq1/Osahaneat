package com.food.Osahaneat.service;

import com.food.Osahaneat.Repository.UserRepository;
import com.food.Osahaneat.dto.UserDTO;
import com.food.Osahaneat.entity.Users;
import com.food.Osahaneat.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService  implements UserServiceImp {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUser() {
        List<Users> users = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (Users user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setFullname(user.getFullname());
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            userDTOList.add(userDTO);

        }
        return userDTOList;
    }
}
