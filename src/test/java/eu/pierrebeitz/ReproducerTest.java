package eu.pierrebeitz;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ReproducerTest {

    @Inject
    Reproducer reproducer;

    @Test
    void serializationIsWorking() throws IOException {
        assertEquals("{\"clasz\":\"java.lang.Object\"}", reproducer.serializeMe(new Object()));
    }
}