package com.code.whiskers.mic_e_commerce_auth.role.domain.services;

import com.code.whiskers.mic_e_commerce_auth.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_auth.role.domain.entities.Role;
import org.springframework.http.ResponseEntity;

public interface RoleServiceCU {
    public ResponseEntity<ResultResponse<Role>> getRoles(int page, int size, String search, String filter);
    public ResponseEntity<Role> getRole(Long id);
    public ResponseEntity<Role> postRole(Role role);
    public ResponseEntity<Role> putRole(Role role, Long id);
    public ResponseEntity<Role> deleteRole(Long id);
}
