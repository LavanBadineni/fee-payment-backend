package com.app.feepayment.controller;

import com.app.feepayment.beans.CreateResponse;
import com.app.feepayment.beans.UserVo;
import com.app.feepayment.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    UserService userService;



    @PostMapping("/createUser")
    public CreateResponse createUser(@Validated @RequestBody UserVo userVo){
        return userService.createUser(userVo);
    }
}
