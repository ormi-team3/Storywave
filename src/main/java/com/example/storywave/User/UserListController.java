package com.example.storywave.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/StoryWave")
public class UserListController {

    @Autowired
    private UserService userService;

    private List<User> users = new ArrayList<>();


    //유저 조회 페이지 - 마이페이지랑 연결
    /*@GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView("mypage/userList");
        modelAndView.addObject("User", users);
        return modelAndView;
    }*/

    @GetMapping
    public String getAllUsers(Model model) {
        List<UserDto> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "mypage/userList";
    }




    //모달
    /*@PutMapping
    public ResponseEntity<UserDto> updateUserStatus(@PathVariable("id") Long id, @RequestBody UserDto updateuserDto){
        UserDto updatedUserStatusDto = userService.updateUserStatus(id, updateuserDto);

        return ResponseEntity.ok(updatedUserStatusDto);
    }*/

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createuserDto = userService.createUser(userDto);
        return ResponseEntity.ok(createuserDto);

    }
}
