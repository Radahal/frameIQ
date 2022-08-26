package com.rgosiewski.frameiq.database.implementation.service;

import com.rgosiewski.frameiq.database.definition.repository.ProcessingRepository;
import com.rgosiewski.frameiq.database.definition.service.IProcessingService;
import com.rgosiewski.frameiq.database.implementation.model.ProcessingEntity;
import com.rgosiewski.frameiq.server.processing.data.CreateProcessingData;
import com.rgosiewski.frameiq.server.processing.data.EditProcessingData;
import com.rgosiewski.frameiq.server.processing.data.ProcessingData;
import com.rgosiewski.frameiq.server.processing.populator.ProcessingDataFromProcessingEntityPopulator;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProcessingService implements IProcessingService {
    private final ProcessingRepository processingRepository;
    private final ProcessingDataFromProcessingEntityPopulator fromProcessingEntityPopulator;

    public ProcessingService(ProcessingRepository processingRepository, ProcessingDataFromProcessingEntityPopulator fromProcessingEntityPopulator) {
        this.processingRepository = processingRepository;
        this.fromProcessingEntityPopulator = fromProcessingEntityPopulator;
    }

    @Override
    public ProcessingData getProcessing(Long processingId) {
        return fromProcessingEntityPopulator.populate(processingRepository.getById(processingId));
    }

    @Override
    public List<ProcessingData> listAll() {
        return fromProcessingEntityPopulator.populateAll(processingRepository.findAll());
    }

    @Override
    public List<ProcessingData> listAllByBlueprintId(Long blueprintId) {
        return fromProcessingEntityPopulator.populateAll(processingRepository.findAllByBlueprintId(blueprintId));
    }

    @Override
    public ProcessingData createProcessing(CreateProcessingData createProcessingData) {
        ProcessingEntity entity = new ProcessingEntity();
        entity.setBlueprintId(createProcessingData.getBlueprintId());
        entity.setCreationTime(createProcessingData.getStartTime());
        entity.setState(createProcessingData.getState().name());
        entity.setCreationTime(new Date());
        entity.setModificationTime(new Date());
        return fromProcessingEntityPopulator.populate(processingRepository.saveAndFlush(entity));
    }

    @Override
    public ProcessingData editProcessing(EditProcessingData editProcessingData) {
        ProcessingEntity entity = processingRepository.getById(editProcessingData.getId());
        entity.setState(editProcessingData.getState().name());
        return fromProcessingEntityPopulator.populate(processingRepository.saveAndFlush(entity));
    }
}
