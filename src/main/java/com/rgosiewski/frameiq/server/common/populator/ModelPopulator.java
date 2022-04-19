package com.rgosiewski.frameiq.server.common.populator;

public abstract class ModelPopulator<SOURCE, TARGET> {

    public abstract void populate(SOURCE source, TARGET target);
}
