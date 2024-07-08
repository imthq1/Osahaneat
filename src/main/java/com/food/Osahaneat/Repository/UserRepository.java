package com.food.Osahaneat.Repository;

import com.food.Osahaneat.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    //select * user where email and password
    List<Users> findByEmailAndPassword(String email,String password);
}
