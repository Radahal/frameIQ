package com.rgosiewski.frameiq.server.common.populator;

import java.util.Collection;

public abstract class CollectionPopulator<SOURCE, TARGET> {

    public abstract TARGET populateCollection(Collection<SOURCE> sourceCollection);
}
