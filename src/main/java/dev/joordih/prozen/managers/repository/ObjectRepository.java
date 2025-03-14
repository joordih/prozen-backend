package dev.joordih.prozen.managers.repository;

import dev.joordih.prozen.managers.models.Model;

/*
 *
 *  * Copyright © 2025 Jordi Xavier
 *  *
 *  * Class: ObjectRepository
 *  * Project: prozen-backend
 *  * Module: prozen-backend
 *  *
 *  * Last modified: 2025-03-14 14:18:48
 *  *
 *  * All rights reserved. This source code is the property of Jordi Xavier
 *  * and may not be copied, modified, or distributed without explicit permission.
 *
 */

public interface ObjectRepository<T extends Model> {
    T find(String id);
    void remove(String id);
    void save(T model);
}
