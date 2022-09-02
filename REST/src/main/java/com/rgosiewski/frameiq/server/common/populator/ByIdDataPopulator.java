package com.rgosiewski.frameiq.server.common.populator;

public abstract class ByIdDataPopulator<SOURCE, TARGET> {

    public abstract TARGET populate(Long sourceId, SOURCE source);
}
