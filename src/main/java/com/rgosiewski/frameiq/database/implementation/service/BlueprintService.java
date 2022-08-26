package com.rgosiewski.frameiq.database.implementation.service;

import com.rgosiewski.frameiq.database.definition.repository.BlueprintRepository;
import com.rgosiewski.frameiq.database.definition.service.IBlueprintService;
import com.rgosiewski.frameiq.database.implementation.model.BlueprintEntity;
import com.rgosiewski.frameiq.server.blueprint.data.BlueprintData;
import com.rgosiewski.frameiq.server.blueprint.data.CreateBlueprintData;
import com.rgosiewski.frameiq.server.blueprint.populator.BlueprintDataFromBlueprintEntityPopulator;
import com.rgosiewski.frameiq.server.configuration.data.ConfigurationData;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlueprintService implements IBlueprintService {
    private final BlueprintRepository blueprintRepository;
    private final ConfigurationService configurationService;
    private final BlueprintDataFromBlueprintEntityPopulator fromBlueprintEntityPopulator;

    public BlueprintService(BlueprintRepository blueprintRepository,
                            ConfigurationService configurationService,
                            BlueprintDataFromBlueprintEntityPopulator fromBlueprintEntityPopulator) {
        this.blueprintRepository = blueprintRepository;
        this.configurationService = configurationService;
        this.fromBlueprintEntityPopulator = fromBlueprintEntityPopulator;
    }

    @Override
    public BlueprintData getBlueprint(Long blueprintId) {
        return fromBlueprintEntityPopulator.populate(blueprintRepository.getById(blueprintId));
    }

    @Override
    public List<BlueprintData> listBlueprints(Long projectId) {
        return null;
    }

    @Override
    public BlueprintData createBlueprint(CreateBlueprintData createBlueprintData) {
        ConfigurationData configurationData = configurationService.getConfiguration(createBlueprintData.getConfigurationId());
        BlueprintEntity entity = new BlueprintEntity();
        entity.setConfigurationId(configurationData.getId());
        entity.setCreationTime(new Date());
        entity.setModificationTime(new Date());
        entity.setAlgorithm(configurationData.getAlgorithm());
        entity.setAlgorithmProperties(configurationData.getAlgorithmProperties());
        entity.setName(configurationData.getName());
        entity.setDescription(configurationData.getDescription());
        entity.setInputFileName(configurationData.getInputFilename());
        entity.setStrategy(configurationData.getStrategy());
        entity.setTag(configurationData.getTag());
        return fromBlueprintEntityPopulator.populate(blueprintRepository.saveAndFlush(entity));
    }
}
