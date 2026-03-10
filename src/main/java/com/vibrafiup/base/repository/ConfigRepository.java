package com.vibrafiup.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vibrafiup.base.entity.Config;
import com.vibrafiup.base.entity.enums.EConfigType;

import java.util.Optional;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {
    Optional<Config> findByType(EConfigType type);
}
