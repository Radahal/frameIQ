package com.rgosiewski.frameiq.common.populator;

public abstract class ByIdDataPopulator<SOURCE, TARGET> {

    public abstract TARGET populate(int sourceId, SOURCE source);
}
