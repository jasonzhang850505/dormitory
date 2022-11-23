package com.itcast.dto;

import com.itcast.entity.SystemAdmin;

/**
 * The type System admin dto.
 */
public class SystemAdminDto {
    private int code;
    private SystemAdmin systemAdmin;

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets system admin.
     *
     * @return the system admin
     */
    public SystemAdmin getSystemAdmin() {
        return systemAdmin;
    }

    /**
     * Sets system admin.
     *
     * @param systemAdmin the system admin
     */
    public void setSystemAdmin(SystemAdmin systemAdmin) {
        this.systemAdmin = systemAdmin;
    }
}
