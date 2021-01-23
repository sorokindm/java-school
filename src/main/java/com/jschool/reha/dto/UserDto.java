package com.jschool.reha.dto;

import com.jschool.reha.entity.User;
import com.jschool.reha.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Dto for User
 */
@Data
@NoArgsConstructor
public class UserDto {

    private int idUser;

    private String username;

    private String password;

    private Role role;

    private String email;

    private LocalDateTime createTime;

    private boolean enabled;

    /**
     * UserDto constructor from entity
     *
     * @param user - user entity
     */
    public UserDto(User user) {
        idUser = user.getIdUser();
        username = user.getUsername();
        password = user.getPassword();
        role = user.getRole();
        email = user.getEmail();
        createTime = user.getCreateTime();
        enabled = user.isEnabled();
    }
}
