package me.dgpr;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;

class JwtTest {

    @Test
    void HS256_test() {
        String secret = "this is my secret key";
        String key = "id";
        String value = "1";

        Algorithm algorithm = Algorithm.HMAC256(secret);
        long prev = System.currentTimeMillis();

        for (int i = 0; i < 100_000; i++) {
            JWT.create()
                    .withClaim(key, value)
                    .sign(algorithm);
        }

        long after = System.currentTimeMillis();

        System.out.println(after - prev);
    }
}
