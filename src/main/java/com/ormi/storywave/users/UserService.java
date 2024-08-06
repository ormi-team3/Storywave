package com.ormi.storywave.users;


import com.ormi.storywave.admin.Ban;
import com.ormi.storywave.admin.BanDto;
import com.ormi.storywave.admin.BanRepository;
import com.ormi.storywave.admin.BanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import static com.ormi.storywave.users.UserDto.fromUsers;

@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BanService banService;
    private final BanRepository banRepository;

    @Autowired
    public UserService(UserRepository userRepository, BanService banService, BanRepository banRepository) {
        this.userRepository = userRepository;
        this.banService = banService;
        this.banRepository = banRepository;
    }


    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDto::fromUsers)
                .collect(Collectors.toList());
    }

    public UserDto createUser(UserDto usersDto) {
        User users = usersDto.toUsers();
        users.setCreatedAt(LocalDateTime.now());
        User savedUsers = userRepository.save(users);
        return UserDto.fromUsers(savedUsers);
    }

    public Optional<UserDto> getUserById(String userId) {
        return userRepository.findById(userId)
                .map(UserDto::fromUsers);
    }

    public Optional<UserDto> getUserByPostId(Long postId) {
        return userRepository.findByPosts_Id(postId)
                .map(UserDto::fromUsers);
    }

    public Optional<UserDto> updateUser(String userId, UserDto updatedUsers) {
        return userRepository.findById(userId)
                .map(users -> {
                    users.setPassword(updatedUsers.getPassword());
                    users.setUsername(updatedUsers.getUsername());
                    users.setEmail(updatedUsers.getEmail());
                    users.setNickname(updatedUsers.getNickname());
                    users.setUpdatedAt(LocalDateTime.now());
                    return UserDto.fromUsers(userRepository.save(users));
                });
    }

    public boolean selectId(String userId) {
        return userRepository.findById(userId).isPresent();
    }

    public boolean selectNickname(String nickname) {
        System.out.println(nickname);
        return userRepository.existsByNickname(nickname);
    }

    public boolean deleteUser(String userId) {
        return userRepository.findById(userId)
                .map(u -> {
                    userRepository.delete(u);
                    return true;
                })
                .orElse(false);
    }

    @Transactional
    public UserDto addUser(UserRequest.JoinDto joinDto) {
        //default 값 부여
        String defaultRole = "USER";
        boolean defaultStatus = true;

        // 유저 객체 저장
        User savedUser = userRepository.save(
                User.builder()
                        .userId(joinDto.getUserId())
                        .password(joinDto.getPassword())
                        .email(joinDto.getEmail())
                        .username(joinDto.getUsername())
                        .nickname(joinDto.getNickname())
                        .role(defaultRole)
                        .activeStatus(defaultStatus)
                        .createdAt(LocalDateTime.now())
                        .build());
        return UserDto.fromUsers(savedUser);
    }

    public UserDto loginUser(UserRequest.LoginDto loginDto) {

        // 로그인 정보와 일치하는 객체 불러오기
        Optional<UserDto> foundUser = userRepository.findById(loginDto.getUserId())
                .map(UserDto::fromUsers);

        // 일치하는 사용자가 없는 경우
        if (foundUser.isEmpty()) {
            return null;
        }

        // 해당 아이디에 비밀번호가 일치하지 않는 경우
        if (!foundUser.get().getPassword().equals(loginDto.getPassword())) {
            return null;
        }

        return foundUser.orElse(null);
    }


    public String getUserRole(String userId) {
        return findByUserId(userId).getRole();
    }

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId).orElse(null);
    }


    public UserDto changeUserStatus(String userId, UserDto userDto, BanDto banDto) {
        // 사용자 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // 사용자 상태 업데이트
        user.setActiveStatus(userDto.isActiveStatus());

        // Ban 정보가 있는지 확인
        Optional<Ban> optionalBan = banRepository.findByUser_UserId(userId);

        // DateTimeFormatter 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");

        // banDate를 LocalDateTime으로 변환, null일 경우 현재 날짜와 시간으로 설정
        LocalDateTime banDate = (banDto.getBanDate() != null)
                ? banDto.getBanDate() // 이미 LocalDateTime이므로 변환 필요 없음
                : LocalDateTime.now(); // 기본값으로 현재 날짜와 시간 설정

        if (optionalBan.isPresent()) {
            // Ban 정보가 있는 경우 업데이트
            Ban ban = optionalBan.get();
            ban.setBanReason(banDto.getBanReason());
            ban.setBanPeriod(banDto.getBanPeriod());
            // banDate와 banPeriod를 더해서 업데이트
            ban.setBanDate(banDate.plusDays(banDto.getBanPeriod()));

            banRepository.save(ban);

        } else {
            Ban newBan = new Ban();
            newBan.setUser(user); // User 객체 설정
            newBan.setBanReason(banDto.getBanReason());
            newBan.setBanPeriod(banDto.getBanPeriod());
            // banDate와 banPeriod를 더해서 설정
            newBan.setBanDate(banDate.plusDays(banDto.getBanPeriod()));

            banRepository.save(newBan);
        }

        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);

        // UserDto로 변환하여 반환
        return fromUsers(user);
    }
}




