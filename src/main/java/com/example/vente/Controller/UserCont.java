package com.example.vente.Controller;

import com.example.vente.Entity.UserEntity;
import com.example.vente.Service.IUser;
import com.example.vente.request.user.createUserReq;
import com.example.vente.request.user.updateUserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserCont {

    @Autowired
    private IUser userService;

    @PostMapping
    public UserEntity createUser(@RequestBody createUserReq user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser( @RequestBody updateUserReq user) {

        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.delete(id);

    }
}
