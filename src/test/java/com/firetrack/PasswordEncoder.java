package com.firetrack;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    @Test
    void encodePassword() {
        System.out.println(new BCryptPasswordEncoder().encode("worker"));
    }

}
