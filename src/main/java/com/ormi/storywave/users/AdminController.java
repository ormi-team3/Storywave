package com.ormi.storywave.users;


import com.ormi.storywave.admin.BanDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;
    private List<User> users = new ArrayList<>();



    @GetMapping("/userList")
    public String getAllUsers(HttpSession httpSession, Model model) {

        String findUserId = (String)httpSession.getAttribute("userId");

        UserDto userDto = userService.getUserById(findUserId).orElse(null);

        // 사용자 정보가 없으면 로그인 페이지로 리디렉션
        if (userDto == null) {
            return "redirect:/login";
        }

        List<UserDto> users = userService.getAllUsers();
        model.addAttribute("users", users);

        String role = userService.getUserRole(userDto.getUserId());


        if ("ADMIN".equals(role)){
            return "mypage/userList";
        } else if ("USER".equals(role)) {
            return "donotaccess";
        } else {
            return "redirect:/error";
        }

    }

    @GetMapping("/adminMypage")
    public String showAdminMyPage() {
        return "mypage/adminMypage"; // 관리자 마이페이지 뷰
    }


    @GetMapping("/mypage/{userId}")
    @ResponseBody
    public UserDto getUserInfo(@PathVariable String userId) {
        User user = userService.findByUserId(userId);
        if (user != null) {
            return UserDto.fromUsers(user);
        } else {
            return new UserDto();
        }

    }

    @PostMapping("/mypage/{userId}/reject")
    @ResponseBody
    public ResponseEntity<UserDto> updateUserStatus(
            @PathVariable String userId,
            @RequestBody Map<String, Object> requestBody) {

        // Map에서 UserDto와 BanDto 추출
        UserDto userDto = parseUserDto(requestBody);
        BanDto banDto = parseBanDto(requestBody);

        UserDto changeUserStatus = userService.changeUserStatus(userId, userDto, banDto);
        return ResponseEntity.ok(changeUserStatus);
    }

    private UserDto parseUserDto(Map<String, Object> requestBody) {
        // Map에서 UserDto 정보 추출
        UserDto userDto = new UserDto();
        userDto.setActiveStatus((Boolean) requestBody.get("isActiveStatus"));
        return userDto;
    }

    private BanDto parseBanDto(Map<String, Object> requestBody) {
        // Map에서 BanDto 정보 추출
        BanDto banDto = new BanDto();
        banDto.setBanReason((String) requestBody.get("banReason"));
        banDto.setBanPeriod((Integer) requestBody.get("banPeriod"));
        return banDto;
    }





}
