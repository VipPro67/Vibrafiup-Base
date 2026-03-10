package com.vibrafiup.base.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

import com.vibrafiup.base.entity.Config;
import com.vibrafiup.base.entity.enums.EConfigType;
import com.vibrafiup.base.service.ConfigService;

@RestController
@RequestMapping("/api/config")
@RequiredArgsConstructor
public class ConfigController {

    private final ConfigService configService;

    @PostMapping
    public ResponseEntity<Config> createConfig(@RequestBody Config config) {
        return ResponseEntity.ok(configService.createConfig(config));
    }

    @GetMapping
    public ResponseEntity<List<Config>> getAllConfigs() {
        return ResponseEntity.ok(configService.getAllConfigs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Config> getConfigById(@PathVariable Long id) {
        return ResponseEntity.ok(configService.getConfigById(id));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<Config> getConfigByType(@PathVariable EConfigType type) {
        return ResponseEntity.ok(configService.getConfigByType(type));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Config> updateConfig(@PathVariable Long id, @RequestBody Config configDetails) {
        return ResponseEntity.ok(configService.updateConfig(id, configDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConfig(@PathVariable Long id) {
        configService.deleteConfig(id);
        return ResponseEntity.noContent().build();
    }
}
