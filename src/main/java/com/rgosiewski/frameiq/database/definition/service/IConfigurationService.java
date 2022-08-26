package com.rgosiewski.frameiq.database.definition.service;

import com.rgosiewski.frameiq.server.configuration.data.ConfigurationData;
import com.rgosiewski.frameiq.server.configuration.data.CreateConfigurationData;
import com.rgosiewski.frameiq.server.configuration.data.EditConfigurationData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IConfigurationService {

    public ConfigurationData getConfiguration(Long configurationId);

    public List<ConfigurationData> listConfigurations(Long projectId);

    public ConfigurationData createConfiguration(CreateConfigurationData createConfigurationData);

    public ConfigurationData editConfiguration(EditConfigurationData editConfigurationData);
}
