package com.itcast.sevice;

import com.itcast.entity.Dormitory;

import java.util.List;

/**
 * The interface Dormitory service.
 */
public interface DormitoryService {
    /**
     * Available list list.
     *
     * @return the list
     */
    public List<Dormitory> availableList();
}
