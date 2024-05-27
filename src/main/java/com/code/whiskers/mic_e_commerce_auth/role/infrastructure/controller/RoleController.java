package com.code.whiskers.mic_e_commerce_auth.role.infrastructure.controller;

import com.code.whiskers.mic_e_commerce_auth.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_auth.role.application.port.in.RolePortIn;
import com.code.whiskers.mic_e_commerce_auth.role.application.services.RoleService;
import com.code.whiskers.mic_e_commerce_auth.role.domain.entities.Role;
import com.code.whiskers.mic_e_commerce_auth.role.domain.services.RoleServiceCU;
import com.code.whiskers.mic_e_commerce_auth.role.infrastructure.service.RoleMysqlAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RoleController implements RoleServiceCU {

    private final RolePortIn rolePortIn;

    public RoleController(RoleMysqlAdapter roleMysqlAdapter) {
        this.rolePortIn = new RoleService(roleMysqlAdapter);
    }

    @Override
    @GetMapping
    public ResponseEntity<ResultResponse<Role>> getRoles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10")int size,
            @RequestParam(required = false) String search,
            @RequestParam(required = false)String filter) {
        ResultResponse<Role> roles = rolePortIn.consult(page, size, search, filter);
        return ResponseEntity.ok(roles);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRole(@PathVariable Long id) {
        Role role = rolePortIn.show(id);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<Role> postRole(@RequestBody Role role) {
        try{
            Role createdRole = rolePortIn.create(role);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Role> putRole(@RequestBody Role role, @PathVariable Long id) {
        Role updatedRole = rolePortIn.update(role, id);
        if (updatedRole != null) {
            return ResponseEntity.ok(updatedRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable Long id) {
        Role deletedRole = rolePortIn.delete(id);
        if (deletedRole != null) {
            return ResponseEntity.ok(deletedRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
