package com.itcast.sevice;

import com.itcast.dto.SystemAdminDto;

/**
 * The interface System admin service.
 */
public interface SystemAdminService {
    /**
     * Login system admin dto.
     *
     * @param username the username
     * @param password the password
     * @return the system admin dto
     */
    public SystemAdminDto login(String username, String password);
}