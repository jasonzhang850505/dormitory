package com.itcast.sevice.impl;

import com.itcast.dao.DormitoryAdminDao;
import com.itcast.dao.impl.DormitoryAdminDaoImpl;
import com.itcast.entity.DormitoryAdmin;
import com.itcast.sevice.DormitoryAdminService;

import java.util.List;

/**
 * The type Dormitory service admin.
 */
public class DormitoryServiceAdminImpl implements DormitoryAdminService{
    private DormitoryAdminDao dormitoryAdminDao = new DormitoryAdminDaoImpl();

    @Override
    public List<DormitoryAdmin> list() {
        return this.dormitoryAdminDao.list();
    }

    @Override
    public List<DormitoryAdmin> search(String key, String value) {
        if (value.equals("")) return this.dormitoryAdminDao.list();
        return this.dormitoryAdminDao.search(key,value);
    }

    @Override
    public Integer save(DormitoryAdmin dormitoryAdmin) {
       Integer save =  this.dormitoryAdminDao.save(dormitoryAdmin);
       if (save !=1) throw new RuntimeException("宿管添加信息失败");
       return save;
    }

    @Override
    public Integer update(DormitoryAdmin dormitoryAdmin) {
        Integer update = this.dormitoryAdminDao.update(dormitoryAdmin);
        if (update !=1) throw new RuntimeException("宿管修改信息失败");
        return update;
    }

    @Override
    public void deleteById(Integer id) {
        Integer delete = this.dormitoryAdminDao.deleteById(id);
        if (delete != 1) throw new RuntimeException("宿管信息删除失败");
    }
}
