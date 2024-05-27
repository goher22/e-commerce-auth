package com.code.whiskers.mic_e_commerce_auth.user.infrastructure.service;

import com.code.whiskers.mic_e_commerce_auth.user.application.port.out.UserPortOut;
import com.code.whiskers.mic_e_commerce_auth.user.domain.entities.User;
import com.code.whiskers.mic_e_commerce_auth.user.infrastructure.models.UserModelDTO;
import com.code.whiskers.mic_e_commerce_auth.user.infrastructure.repositories.UserRepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserMysqlAdapter implements UserPortOut {

    @Autowired
    private UserRepositoryDTO userRepositoryDTO;

    @Override
    public User findByUsername(String username) {
        Optional<UserModelDTO> optional = userRepositoryDTO.findByUsername(username);
        return optional.orElse(null);
    }

    @Override
    public User saveUser(User user) {
        UserModelDTO userModelDTO = new UserModelDTO(user.getUsername(), user.getPassword(), user.getRoleId());
        return userRepositoryDTO.save(userModelDTO);
    }
}
