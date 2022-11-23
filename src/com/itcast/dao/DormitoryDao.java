package com.itcast.dao;

import com.itcast.entity.Dormitory;

import java.util.List;

/**
 * The interface Dormitory dao.
 */
public interface DormitoryDao {
    /**
     * Available list list.
     *
     * @return the list
     */
    public List<Dormitory> availableList();
}
