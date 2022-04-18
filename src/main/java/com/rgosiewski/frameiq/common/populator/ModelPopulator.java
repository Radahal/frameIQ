package com.rgosiewski.frameiq.common.populator;

public abstract class ModelPopulator<SOURCE, TARGET> {

    public abstract void populate(SOURCE source, TARGET target);
}
