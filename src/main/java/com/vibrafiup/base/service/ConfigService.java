package com.vibrafiup.base.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

import com.vibrafiup.base.entity.Config;
import com.vibrafiup.base.entity.enums.EConfigType;
import com.vibrafiup.base.repository.ConfigRepository;

@Service
@RequiredArgsConstructor
public class ConfigService {

    private final ConfigRepository configRepository;

    public Config createConfig(Config config) {
        return configRepository.save(config);
    }

    public List<Config> getAllConfigs() {
        return configRepository.findAll();
    }

    public Config getConfigById(Long id) {
        return configRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Config not found"));
    }

    public Config getConfigByType(EConfigType type) {
        return configRepository.findByType(type)
                .orElseThrow(() -> new RuntimeException("Config not found"));
    }

    public Config updateConfig(Long id, Config configDetails) {
        Config config = getConfigById(id);
        config.setValue(configDetails.getValue());
        config.setType(configDetails.getType());
        return configRepository.save(config);
    }

    public void deleteConfig(Long id) {
        Config config = getConfigById(id);
        configRepository.delete(config);
    }
}
