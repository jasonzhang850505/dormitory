package com.itcast.dao;

import com.itcast.entity.SystemAdmin;

/**
 * The interface System admin dao.
 */
public interface SystemAdminDao {
    /**
     * Find by username system admin.
     *
     * @param username the username
     * @return the system admin
     */
    public SystemAdmin findByUsername(String username);
}
