/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.common.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathConverter extends TypeAdapter<Path> {
    @Override
    public void write(JsonWriter jsonWriter, Path path) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("path");
        jsonWriter.value(path.toString());
        jsonWriter.endObject();
    }

    @Override
    public Path read(JsonReader jsonReader) throws IOException {
        Path path = null;
        String fieldname = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            JsonToken jsonToken = jsonReader.peek();
            if (jsonToken.equals(JsonToken.NAME)) {
                //get the current token
                fieldname = jsonReader.nextName();
            }

            if ("path".equals(fieldname)) {
                //move to next token
                jsonToken = jsonReader.peek();
                path = Paths.get(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return path;
    }
}
