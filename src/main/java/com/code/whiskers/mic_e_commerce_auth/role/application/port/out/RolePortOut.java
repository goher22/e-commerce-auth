package com.code.whiskers.mic_e_commerce_auth.role.application.port.out;

import com.code.whiskers.mic_e_commerce_auth.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_auth.role.domain.entities.Role;

public interface RolePortOut {
    public ResultResponse<Role> consult(int page, int size, String search, String filter);
    public Role show(Long id);
    public Role create(Role role);
    public Role update(Role role, Long id);
    public Role delete(Long id);
}
