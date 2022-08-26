package com.example.getmesocialservice.apiResource;

import com.example.getmesocialservice.exception.RestrictedInfoException;
import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public  User saveUser(@RequestBody @Valid User user){
        return  userService.saveUser(user);

    }

    @GetMapping
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }

    @GetMapping("/get-by-id")
    public List<User> getById(@RequestParam(name = "name") String name) throws RestrictedInfoException {

        if(name.equalsIgnoreCase("root")){
            throw new RestrictedInfoException();

        }
        return userService.getById(name);
    }



    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);

    }

    @DeleteMapping
    public void deleteUser(@RequestParam(name = "userId") String userId){
        userService.deleteUser(userId);

    }


/*
    @GetMapping("/user")
    public User getUser(){
       return userService.getUser();

    }

 */


}
