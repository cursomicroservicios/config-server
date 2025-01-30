package com.deivid.microservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ProfileNotAllowedException extends RuntimeException {

    public ProfileNotAllowedException(String notAllowedProfile, String allowProfile) {
        super("""
                El acceso al profile '%s' está restringido. Solo se permite: '%s'""".formatted(notAllowedProfile, allowProfile)
        );
    }
}
