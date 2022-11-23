package com.itcast.sevice.impl;

import com.itcast.dao.DormitoryDao;
import com.itcast.dao.impl.DormitoryDaoImpl;
import com.itcast.entity.Dormitory;
import com.itcast.sevice.DormitoryService;

import java.util.List;

/**
 * The type Dormitory service.
 */
public class DormitoryServiceImpl implements DormitoryService {
    private DormitoryDao dormitoryDao = new DormitoryDaoImpl();
    @Override
    public List<Dormitory> availableList() {
        return this.dormitoryDao.availableList();
    }
}
