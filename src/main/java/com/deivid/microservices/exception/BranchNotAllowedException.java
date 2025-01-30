package com.deivid.microservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class BranchNotAllowedException extends RuntimeException {

    public BranchNotAllowedException(String notAllowedBranch, String allowBranch) {
        super("""
                El acceso al branch '%s' está restringido. Solo se permite: '%s'""".formatted(notAllowedBranch, allowBranch)
        );
    }
}
