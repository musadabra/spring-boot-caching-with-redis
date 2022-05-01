package com.redis.Redis.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.redis.Redis.model.AppResponse;

import java.io.IOException;

/**
 *
 * @author Musa Dabra
 */
public class AppResponseStatusSerializer extends StdSerializer<AppResponse.Status> {

    public AppResponseStatusSerializer() {
        this(null);
    }

    public AppResponseStatusSerializer(Class<AppResponse.Status> t) {
        super(t);
    }

    @Override
    public void serialize(AppResponse.Status value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        try {
            gen.writeString(String.valueOf(value.getId()));
        } catch (IOException e) {
        }
    }
}
