package me.dgpr;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.Clock;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import me.dgpr.node.NodeIdentifier;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FlakeTest {

    @Test
    void ID_생성() {
        NodeIdentifier nodeIdentifier = () -> 123456789L;
        Clock clock = Clock.tick(Clock.systemUTC(), Duration.ofMinutes(1));
        Flake flake = Flake.newInstance(nodeIdentifier, clock);

        Set<String> ids = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            ids.add(Flake.asHexString(flake.generateId()));
        }

        assertThat(ids).hasSize(100);
        assertThat(ids.stream()
                .map(id -> id.substring(16, 28)))
                .allMatch(s -> s.equals("0000075bcd15")
                )
                .hasSize(100);
    }

    @Test
    void 순서_오버플로우() {
        NodeIdentifier nodeIdentifier = () -> 123456789L;
        Clock clock = Clock.tick(Clock.systemUTC(), Duration.ofMinutes(1));
        Flake flake = Flake.newInstance(nodeIdentifier, clock);

        assertThatThrownBy(() -> {
            for (int i = 0; i <= 0xFFFF + 0x1; i++) {
                flake.generateId();
            }
        })
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 순서_리셋() throws InterruptedException {
        NodeIdentifier nodeIdentifier = () -> 123456789L;
        Flake f4j = Flake.newInstance(nodeIdentifier);
        String seq1 = Flake.asHexString(Arrays.copyOfRange(f4j.generateId(), 14, 15));

        Thread.sleep(10);

        String seq2 = Flake.asHexString(Arrays.copyOfRange(f4j.generateId(), 14, 15));

        assertThat(seq1).isEqualTo(seq2);
    }
}