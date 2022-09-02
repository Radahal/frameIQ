package com.rgosiewski.frameiq.database.definition.service;

import com.rgosiewski.frameiq.server.metadata.frameMetadata.data.CreateFrameMetadataData;
import com.rgosiewski.frameiq.server.metadata.frameMetadata.data.FrameMetadataData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFrameMetadataService {

    public FrameMetadataData getFrameMetadata(Long frameMetadataId);

    public List<FrameMetadataData> listFrameMetadata(Long frameId);

    public FrameMetadataData createFrameMetadata(CreateFrameMetadataData createFrameMetadataData);
}
