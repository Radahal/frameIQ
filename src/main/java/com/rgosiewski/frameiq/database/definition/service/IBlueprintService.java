package com.rgosiewski.frameiq.database.definition.service;

import com.rgosiewski.frameiq.server.blueprint.data.BlueprintData;
import com.rgosiewski.frameiq.server.blueprint.data.CreateBlueprintData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlueprintService {

    public BlueprintData getBlueprint(Long blueprintId);

    public List<BlueprintData> listBlueprints(Long projectId);

    public BlueprintData createBlueprint(CreateBlueprintData createBlueprintData);

}
