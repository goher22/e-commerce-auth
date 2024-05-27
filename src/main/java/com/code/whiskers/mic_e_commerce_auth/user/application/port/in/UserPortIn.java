package com.code.whiskers.mic_e_commerce_auth.user.application.port.in;

import com.code.whiskers.mic_e_commerce_auth.user.domain.response.LoginResponse;

public interface UserPortIn {

    public LoginResponse auth(String username, String password);

    public String registerUser(String username, String password);

}
