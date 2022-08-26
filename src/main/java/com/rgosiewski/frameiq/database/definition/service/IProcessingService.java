package com.rgosiewski.frameiq.database.definition.service;

import com.rgosiewski.frameiq.server.processing.data.CreateProcessingData;
import com.rgosiewski.frameiq.server.processing.data.EditProcessingData;
import com.rgosiewski.frameiq.server.processing.data.ProcessingData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProcessingService {

    public ProcessingData getProcessing(Long processingId);

    public List<ProcessingData> listAll();

    public List<ProcessingData> listAllByBlueprintId(Long blueprintId);

    public ProcessingData createProcessing(CreateProcessingData createProcessingData);

    public ProcessingData editProcessing(EditProcessingData editProcessingData);
}
