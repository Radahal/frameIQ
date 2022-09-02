package com.rgosiewski.frameiq.server.common.populator;

import java.util.Map;

public abstract class MapPopulator<SOURCE_KEY, SOURCE_VALUE, TARGET> {

    public abstract TARGET populateCollection(Map<SOURCE_KEY, SOURCE_VALUE> sourceMap);
}
