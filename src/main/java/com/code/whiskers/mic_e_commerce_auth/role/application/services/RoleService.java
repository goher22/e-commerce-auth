package com.code.whiskers.mic_e_commerce_auth.role.application.services;

import com.code.whiskers.mic_e_commerce_auth.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_auth.role.application.port.in.RolePortIn;
import com.code.whiskers.mic_e_commerce_auth.role.application.port.out.RolePortOut;
import com.code.whiskers.mic_e_commerce_auth.role.domain.entities.Role;

public class RoleService implements RolePortIn {

    private final RolePortOut rolePortOut;

    public RoleService(RolePortOut rolePortOut) {
        this.rolePortOut = rolePortOut;
    }

    @Override
    public ResultResponse<Role> consult(int page, int size, String search, String filter) {
        return this.rolePortOut.consult(page, size, search, filter);
    }

    @Override
    public Role show(Long id) {
        return this.rolePortOut.show(id);
    }

    @Override
    public Role create(Role role) {
        return this.rolePortOut.create(role);
    }

    @Override
    public Role update(Role role, Long id) {
        return this.rolePortOut.update(role, id);
    }

    @Override
    public Role delete(Long id) {
        return this.rolePortOut.delete(id);
    }
}
