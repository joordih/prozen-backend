package dev.joordih.prozen.managers.models.impl.user;

import dev.joordih.prozen.managers.models.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
 *
 *  * Copyright © 2025 Jordi Xavier
 *  *
 *  * Class: User
 *  * Project: prozen-backend
 *  * Module: prozen-backend
 *  *
 *  * Last modified: 2025-03-14 14:34:22
 *  *
 *  * All rights reserved. This source code is the property of Jordi Xavier
 *  * and may not be copied, modified, or distributed without explicit permission.
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Model {
    private String id;
    private String username;
    private String email;
    private String passwordHash;
    private UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;
    private boolean isActive;

    public enum UserRole {
        ADMIN("Admin"),
        USER("User"),
        GUEST("Guest");

        private final String displayName;

        UserRole(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}
