package com.code.whiskers.mic_e_commerce_auth.role.infrastructure.service;

import com.code.whiskers.mic_e_commerce_auth.common.domain.PageDomain;
import com.code.whiskers.mic_e_commerce_auth.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_auth.role.application.port.out.RolePortOut;
import com.code.whiskers.mic_e_commerce_auth.role.domain.entities.Role;
import com.code.whiskers.mic_e_commerce_auth.role.infrastructure.models.RoleModelDTO;
import com.code.whiskers.mic_e_commerce_auth.role.infrastructure.repositories.RoleRepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleMysqlAdapter implements RolePortOut {
    @Autowired
    private RoleRepositoryDTO roleRepositoryDTO;

    @Override
    public ResultResponse<Role> consult(int page, int size, String search, String filter) {
        Page<RoleModelDTO> rolesPage = roleRepositoryDTO.findAll(PageRequest.of(page, size));
        List<RoleModelDTO> roles = rolesPage.getContent();

        List<Role> rolesT = roles.stream()
                .map(roleModelDTO -> new Role(roleModelDTO.getId(), roleModelDTO.getName()))
                .collect(Collectors.toList());

        PageDomain pageDomain = new PageDomain(
                rolesPage.getTotalElements(),
                size,
                page,
                "/api/roles"
        );

        return new ResultResponse<>(pageDomain, rolesT);
    }

    @Override
    public Role show(Long id) {
        Optional<RoleModelDTO> optionalRole = roleRepositoryDTO.findById(id);
        return optionalRole.orElse(null);
    }

    @Override
    public Role create(Role role) {
        return roleRepositoryDTO.save(new RoleModelDTO(role.getName()));
    }

    @Override
    public Role update(Role role, Long id) {
        Optional<RoleModelDTO> optionalRole = roleRepositoryDTO.findById(id);
        if(optionalRole.isPresent()){
            RoleModelDTO editRole = optionalRole.get();
            editRole.setName(role.getName());
            return roleRepositoryDTO.save(editRole);
        }

        return null;
    }

    @Override
    public Role delete(Long id) {
        Optional<RoleModelDTO> optionalRole = roleRepositoryDTO.findById(id);
        if(optionalRole.isPresent()){
            roleRepositoryDTO.deleteById(id);
            return optionalRole.get();
        }

        return null;
    }
}
