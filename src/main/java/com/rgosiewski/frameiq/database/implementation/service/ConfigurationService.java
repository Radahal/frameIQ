package com.rgosiewski.frameiq.database.implementation.service;

import com.rgosiewski.frameiq.database.definition.repository.ConfigurationRepository;
import com.rgosiewski.frameiq.database.definition.service.IConfigurationService;
import com.rgosiewski.frameiq.database.implementation.model.ConfigurationEntity;
import com.rgosiewski.frameiq.server.configuration.data.ConfigurationData;
import com.rgosiewski.frameiq.server.configuration.data.CreateConfigurationData;
import com.rgosiewski.frameiq.server.configuration.data.EditConfigurationData;
import com.rgosiewski.frameiq.server.configuration.populator.ConfigurationDataFromConfigurationEntityPopulator;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConfigurationService implements IConfigurationService {
    private final ConfigurationRepository configurationRepository;
    private final ConfigurationDataFromConfigurationEntityPopulator fromConfigurationEntityPopulator;

    public ConfigurationService(ConfigurationRepository configurationRepository,
                                ConfigurationDataFromConfigurationEntityPopulator fromConfigurationEntityPopulator) {
        this.configurationRepository = configurationRepository;
        this.fromConfigurationEntityPopulator = fromConfigurationEntityPopulator;
    }

    @Override
    public ConfigurationData getConfiguration(Long configurationId) {
        return fromConfigurationEntityPopulator.populate(configurationRepository.getById(configurationId));
    }

    @Override
    public List<ConfigurationData> listConfigurations(Long projectId) {
        return fromConfigurationEntityPopulator.populateAll(configurationRepository.findAllByProjectId(projectId));
    }

    @Override
    public ConfigurationData createConfiguration(CreateConfigurationData createConfigurationData) {
        ConfigurationEntity entity = new ConfigurationEntity();
        entity.setProjectId(createConfigurationData.getProjectId());
        entity.setAlgorithm(createConfigurationData.getAlgorithm());
        entity.setAlgorithmProperties(createConfigurationData.getAlgorithmProperties());
        entity.setDescription(createConfigurationData.getDescription());
        entity.setName(createConfigurationData.getName());
        entity.setInputFileName(createConfigurationData.getInputFilename());
        entity.setStrategy(createConfigurationData.getStrategy());
        entity.setTag(createConfigurationData.getTag());
        entity.setCreationTime(new Date());
        entity.setModificationTime(new Date());
        return fromConfigurationEntityPopulator.populate(configurationRepository.saveAndFlush(entity));
    }

    @Override
    public ConfigurationData editConfiguration(EditConfigurationData editConfigurationData) {
        ConfigurationEntity entity = configurationRepository.getById(editConfigurationData.getId());
        entity.setAlgorithm(editConfigurationData.getAlgorithm());
        entity.setAlgorithmProperties(editConfigurationData.getAlgorithmProperties());
        entity.setDescription(editConfigurationData.getDescription());
        entity.setName(editConfigurationData.getName());
        entity.setInputFileName(editConfigurationData.getInputFilename());
        entity.setStrategy(editConfigurationData.getStrategy());
        entity.setTag(editConfigurationData.getTag());
        entity.setModificationTime(new Date());
        return fromConfigurationEntityPopulator.populate(configurationRepository.saveAndFlush(entity));
    }
}
