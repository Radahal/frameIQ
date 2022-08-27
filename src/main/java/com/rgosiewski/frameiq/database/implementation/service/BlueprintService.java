package com.rgosiewski.frameiq.database.implementation.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rgosiewski.frameiq.database.definition.repository.BlueprintRepository;
import com.rgosiewski.frameiq.database.definition.service.IBlueprintService;
import com.rgosiewski.frameiq.database.implementation.model.BlueprintEntity;
import com.rgosiewski.frameiq.server.blueprint.data.BlueprintData;
import com.rgosiewski.frameiq.server.blueprint.data.CreateBlueprintData;
import com.rgosiewski.frameiq.server.blueprint.populator.BlueprintDataFromBlueprintEntityPopulator;
import com.rgosiewski.frameiq.server.common.utils.PathConverter;
import com.rgosiewski.frameiq.server.configuration.data.AlgorithmPropertiesData;
import com.rgosiewski.frameiq.server.configuration.data.ConfigurationData;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;

@Service
public class BlueprintService implements IBlueprintService {
    private final BlueprintRepository blueprintRepository;
    private final ConfigurationService configurationService;
    private final UserService userService;
    private final BlueprintDataFromBlueprintEntityPopulator fromBlueprintEntityPopulator;

    public BlueprintService(BlueprintRepository blueprintRepository,
                            ConfigurationService configurationService,
                            UserService userService, BlueprintDataFromBlueprintEntityPopulator fromBlueprintEntityPopulator) {
        this.blueprintRepository = blueprintRepository;
        this.configurationService = configurationService;
        this.userService = userService;
        this.fromBlueprintEntityPopulator = fromBlueprintEntityPopulator;
    }

    @Override
    public BlueprintData getBlueprint(Long blueprintId) {
        return fromBlueprintEntityPopulator.populate(blueprintRepository.getById(blueprintId));
    }

    @Override
    public List<BlueprintData> listBlueprints(Long configurationId) {
        return fromBlueprintEntityPopulator.populateAll(blueprintRepository.findAllByConfigurationId(configurationId));
    }

    @Override
    public BlueprintData createBlueprint(CreateBlueprintData createBlueprintData) {
        ConfigurationData configurationData = configurationService.getConfiguration(createBlueprintData.getConfigurationId());
        BlueprintEntity entity = new BlueprintEntity();
        entity.setConfigurationId(configurationData.getId());
        entity.setCreationTime(new Date());
        entity.setModificationTime(new Date());
        entity.setAlgorithmProperties(serializeAlgorithmProperties(configurationData.getAlgorithmProperties()));
        entity.setName(configurationData.getName());
        entity.setDescription(configurationData.getDescription());
        entity.setTag(configurationData.getTag());
        entity.setCreationUsId(userService.getAdminId());
        entity.setModificationUsId(userService.getAdminId());
        return fromBlueprintEntityPopulator.populate(blueprintRepository.saveAndFlush(entity));
    }

    private String serializeAlgorithmProperties(AlgorithmPropertiesData algorithmProperties) {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(Path.class, new PathConverter())
                .setPrettyPrinting()
                .create();
        return gson.toJson(algorithmProperties, AlgorithmPropertiesData.class);
    }
}
