package eu.pierrebeitz;

import io.quarkus.test.junit.main.Launch;
import io.quarkus.test.junit.main.LaunchResult;
import io.quarkus.test.junit.main.QuarkusMainIntegrationTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusMainIntegrationTest
public class ReproducerNativeTest {

    @Test
    @Launch("")
    public void testLaunchCommand(LaunchResult result) {
        assertTrue(result.getOutput().contains("{\"clasz\":\"java.lang.Object\"}"));
    }

}