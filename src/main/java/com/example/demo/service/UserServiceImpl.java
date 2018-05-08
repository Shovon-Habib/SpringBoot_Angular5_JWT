package com.example.demo.service;

import com.example.demo.config.STATUS;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findByStatus(STATUS.ACTIVE)
                .stream()
                .map(user -> {
                    return new UserDto(String.valueOf(user.getId()),
                            user.getName(),
                            user.getEmail(),
                            user.getPassword());
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUser(Long id) {
        return Optional.of(userRepository.findByIdAndStatus(id, STATUS.ACTIVE))
                .map(user -> {
                    return new UserDto(String.valueOf(user.getId()),
                            user.getName(),
                            user.getEmail(),
                            user.getPassword());
                })
                .orElse(new UserDto());
    }

    @Override
    public String delete(Long id) {
        User user = userRepository.findByIdAndStatus(id, STATUS.ACTIVE);
        user.setStatus(STATUS.INACTIVE);
        userRepository.save(user);
        return "deleted";
    }

    @Override
    public String createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setStatus(STATUS.ACTIVE);
        user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        ArrayList list = new ArrayList() {{
            add(roleRepository.findByRole("USER"));
        }};
        user.setRoles(list);
        userRepository.save(user);
        return "Inserted";
    }

    @Override
    public String updateUser(UserDto userDto) {
        User user = userRepository.findByIdAndStatus(Long.valueOf(userDto.getId()), STATUS.ACTIVE);
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return "User updated.";
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmailAndStatus(email, STATUS.ACTIVE);
    }
}
