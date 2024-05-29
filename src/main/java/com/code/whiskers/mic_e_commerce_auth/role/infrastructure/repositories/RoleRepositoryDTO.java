package com.code.whiskers.mic_e_commerce_auth.role.infrastructure.repositories;

import com.code.whiskers.mic_e_commerce_auth.role.infrastructure.models.RoleModelDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositoryDTO extends JpaRepository<RoleModelDTO, Long> {
}
