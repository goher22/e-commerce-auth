package com.code.whiskers.mic_e_commerce_auth.user.infrastructure.repositories;
import com.code.whiskers.mic_e_commerce_auth.user.infrastructure.models.UserModelDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryDTO extends JpaRepository<UserModelDTO, Long> {
    Optional<UserModelDTO> findByUsername(String username);
}
