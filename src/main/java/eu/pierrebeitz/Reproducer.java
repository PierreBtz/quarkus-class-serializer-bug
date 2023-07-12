package eu.pierrebeitz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.annotations.RegisterForReflection;

@QuarkusMain
public class Reproducer implements QuarkusApplication {
    private final ObjectMapper objectMapper;

    Reproducer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public int run(String... args) throws Exception {
        Log.info(serializeMe(new Object()));
        return 0;
    }

    public String serializeMe(Object o) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new SerializeMe(Object.class));
    }

    // TODO uncomment below to workaround the issue
    @RegisterForReflection/*(targets = {
            ClassSerializer.class,
            SerializeMe.class
    })*/
    record SerializeMe(Class<?> clasz) {
    }
}