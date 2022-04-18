package com.rgosiewski.frameiq.common.populator;

import java.util.List;
import java.util.stream.Collectors;

public abstract class DataPopulator<SOURCE, TARGET> {

    public abstract TARGET populate(SOURCE source);

    public List<TARGET> populateAll(List<SOURCE> sourceList) {
        return sourceList.stream()
                .map(this::populate)
                .collect(Collectors.toList());
    }
}
