package pl.mariusz.demoannoatation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mariusz.demoannoatation.model.UserDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class UserController {

    @PostMapping("/user")
    @Validated
    public ResponseEntity<UserDto> user(@RequestBody UserDto user){


        return ResponseEntity.ok(user);
    }

}
