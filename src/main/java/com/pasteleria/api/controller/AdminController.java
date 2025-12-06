package com.pasteleria.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    @GetMapping("/only")
    @PreAuthorize("hasRole('ADMIN')")
    public String onlyAdmin() {
        return "Solo admins";
    }

    @GetMapping("/user-or-admin")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String adminOrUser() {
        return "Admin o user";
    }
}
