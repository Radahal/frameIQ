package com.rgosiewski.frameiq.database.implementation.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rgosiewski.frameiq.database.definition.repository.ConfigurationRepository;
import com.rgosiewski.frameiq.database.definition.service.IConfigurationService;
import com.rgosiewski.frameiq.database.implementation.model.ConfigurationEntity;
import com.rgosiewski.frameiq.server.common.utils.PathConverter;
import com.rgosiewski.frameiq.server.configuration.data.AlgorithmPropertiesData;
import com.rgosiewski.frameiq.server.configuration.data.ConfigurationData;
import com.rgosiewski.frameiq.server.configuration.data.CreateConfigurationData;
import com.rgosiewski.frameiq.server.configuration.data.EditConfigurationData;
import com.rgosiewski.frameiq.server.configuration.populator.ConfigurationDataFromConfigurationEntityPopulator;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;

@Service
public class ConfigurationService implements IConfigurationService {
    private final ConfigurationRepository configurationRepository;
    private final UserService userService;
    private final ConfigurationDataFromConfigurationEntityPopulator fromConfigurationEntityPopulator;

    public ConfigurationService(ConfigurationRepository configurationRepository,
                                UserService userService, ConfigurationDataFromConfigurationEntityPopulator fromConfigurationEntityPopulator) {
        this.configurationRepository = configurationRepository;
        this.userService = userService;
        this.fromConfigurationEntityPopulator = fromConfigurationEntityPopulator;
    }

    @Override
    public ConfigurationData getConfiguration(Long id) {
        ConfigurationEntity entity = configurationRepository.getById(id);
        return fromConfigurationEntityPopulator.populate(entity);
    }

    @Override
    public List<ConfigurationData> listConfigurations(Long projectId) {
        return fromConfigurationEntityPopulator.populateAll(configurationRepository.findAllByProjectId(projectId));
    }

    @Override
    public ConfigurationData createConfiguration(CreateConfigurationData createConfigurationData) {
        ConfigurationEntity entity = new ConfigurationEntity();
        entity.setProjectId(createConfigurationData.getProjectId());
        entity.setAlgorithmProperties(serializeAlgorithmProperties(createConfigurationData.getAlgorithmProperties()));
        entity.setDescription(createConfigurationData.getDescription());
        entity.setName(createConfigurationData.getName());
        entity.setTag(createConfigurationData.getTag());
        entity.setCreationTime(new Date());
        entity.setModificationTime(new Date());
        entity.setCreationUsId(userService.getAdminId());
        entity.setModificationUsId(userService.getAdminId());
        return fromConfigurationEntityPopulator.populate(configurationRepository.saveAndFlush(entity));
    }

    @Override
    public ConfigurationData editConfiguration(EditConfigurationData editConfigurationData) {
        ConfigurationEntity entity = configurationRepository.getById(editConfigurationData.getId());
        entity.setAlgorithmProperties(serializeAlgorithmProperties(editConfigurationData.getAlgorithmProperties()));
        entity.setDescription(editConfigurationData.getDescription());
        entity.setName(editConfigurationData.getName());
        entity.setTag(editConfigurationData.getTag());
        entity.setModificationTime(new Date());
        entity.setModificationUsId(userService.getAdminId());
        return fromConfigurationEntityPopulator.populate(configurationRepository.saveAndFlush(entity));
    }

    private String serializeAlgorithmProperties(AlgorithmPropertiesData algorithmProperties) {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(Path.class, new PathConverter())
                .setPrettyPrinting()
                .create();
        return gson.toJson(algorithmProperties, AlgorithmPropertiesData.class);
    }
}
