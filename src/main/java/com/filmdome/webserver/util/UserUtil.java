package com.filmdome.webserver.util;

import com.filmdome.webserver.dto.UserDto;
import com.filmdome.webserver.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserUtil {

    public static List<UserDto> convertTo(List<User> users) {

        List<UserDto> dtoList = new ArrayList<>();

        for (User user : users) {
            dtoList.add(convertTo(user));
        }

        return dtoList;
    }

    public static UserDto convertTo(User user) {

        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setPhoneNumber(user.getPhoneNumber());

        return dto;
    }

    public static User convertTo(UserDto dto) {

        User user = new User();

        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());

        return user;
    }

}