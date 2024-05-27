package com.code.whiskers.mic_e_commerce_auth.user.application.port.out;

import com.code.whiskers.mic_e_commerce_auth.user.domain.entities.User;

public interface UserPortOut {

    public User findByUsername(String username);

    public User saveUser(User user);

}
