package com.itcast.sevice.impl;

import com.itcast.dao.SystemAdminDao;
import com.itcast.dao.impl.SystemAdminDaoImpl;
import com.itcast.dto.SystemAdminDto;
import com.itcast.entity.SystemAdmin;
import com.itcast.sevice.SystemAdminService;

/**
 * The type System admin service.
 */
public class SystemAdminServiceImpl implements SystemAdminService {
    private SystemAdminDao systemAdminDao = new SystemAdminDaoImpl();

    @Override
    public SystemAdminDto login(String username, String password) {
        /**
         * 1.需要username查询数据库
         * 2.查询结果为空,username错误
         * 3.查询结果不为空,再判断password是否正确
         * 0代表验证成功 -1 代表用户名错误 -2 代表密码错误
         */
        SystemAdmin systemAdmin= this.systemAdminDao.findByUsername(username);
        SystemAdminDto systemAdminDto = new SystemAdminDto();
        if (systemAdmin == null) {
            systemAdminDto.setCode(-1);
        } else if (!systemAdmin.getPassword().equals(password)){
            systemAdminDto.setCode(-2);
        }else {
            systemAdminDto.setCode(0);
            systemAdminDto.setSystemAdmin(systemAdmin);
        }
        return systemAdminDto;
    }
}
