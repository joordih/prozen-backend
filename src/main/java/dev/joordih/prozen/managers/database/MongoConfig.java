package dev.joordih.prozen.managers.database;

/*
 *
 *  * Copyright 2025 Jordi Xavier
 *  *
 *  * Class: MongoConfig
 *  * Project: prozen-backend
 *  * Module: prozen-backend
 *  *
 *  * Last modified: 2025-03-14 14:22:49
 *  *
 *  * All rights reserved. This source code is the property of Jordi Xavier
 *  * and may not be copied, modified, or distributed without explicit permission.
 *
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MongoConfig {
    private String uri;
    private String database;
}
