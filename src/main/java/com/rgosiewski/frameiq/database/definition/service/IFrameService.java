package com.rgosiewski.frameiq.database.definition.service;

import com.rgosiewski.frameiq.server.frame.data.CreateFrameData;
import com.rgosiewski.frameiq.server.frame.data.EditFrameData;
import com.rgosiewski.frameiq.server.frame.data.FrameData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFrameService {

    public FrameData getFrame(Long frameId);

    public List<FrameData> listAllByMovieId(Long movieId);

    public FrameData createFrame(CreateFrameData createFrameData);

    public FrameData editFrame(EditFrameData editFrameData);
}
