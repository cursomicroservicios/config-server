package com.deivid.microservices.config.handler;

import com.deivid.microservices.exception.BranchNotAllowedException;
import com.deivid.microservices.exception.ProfileNotAllowedException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.List;

@Component
public class BranchAndProfileValidationInterceptor implements HandlerInterceptor {

    @Value("${spring.cloud.config.server.git.default-label}")
    private String allowedBranch;

    @Value("${spring.profiles.active}")
    private String allowedProfile;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        List<String> parts = Arrays.stream(requestURI.split("/")).toList();

        if(parts.size() >= 3 && !validateProfile(parts.get(2))) {
            throw new ProfileNotAllowedException(parts.get(2), allowedProfile);
        }

        if (parts.size() >= 4 && !validateBranch(parts.get(3))) {
            throw new BranchNotAllowedException(parts.get(3), allowedBranch);
        }

        return true;
    }

    private boolean validateProfile(String pathProfile) {
        return allowedProfile.equals(pathProfile);
    }

    private boolean validateBranch(String pathBranch) {
        return allowedBranch.equals(pathBranch);
    }
}
