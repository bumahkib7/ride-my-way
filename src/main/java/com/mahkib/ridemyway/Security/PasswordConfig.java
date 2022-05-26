package com.mahkib.ridemyway.Security;


import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordConfig {

    private static PasswordEncoder passwordEncoder;

    public PasswordConfig(PasswordEncoder passwordEncoder) {
        PasswordConfig.passwordEncoder = passwordEncoder;
    }

    public static PasswordEncoder bCryptPasswordEncoder() {
        return passwordEncoder;

    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        PasswordConfig.passwordEncoder = passwordEncoder;
    }


}
