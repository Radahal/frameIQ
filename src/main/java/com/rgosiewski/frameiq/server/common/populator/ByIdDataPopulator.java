package com.rgosiewski.frameiq.server.common.populator;

public abstract class ByIdDataPopulator<SOURCE, TARGET> {

    public abstract TARGET populate(int sourceId, SOURCE source);
}
