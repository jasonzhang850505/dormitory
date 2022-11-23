package com.itcast.dao;

import com.itcast.entity.DormitoryAdmin;

import java.util.List;

/**
 * The interface Dormitory admin dao.
 */
public interface DormitoryAdminDao {
    /**
     * List list.
     *
     * @return the list
     */
    public List<DormitoryAdmin> list();

    /**
     * Search list.
     *
     * @param key   the key
     * @param value the value
     * @return the list
     */
    public List<DormitoryAdmin> search(String key, String value);

    /**
     * Save integer.
     *
     * @param dormitoryAdmin the dormitory admin
     * @return the integer
     */
    public Integer save(DormitoryAdmin dormitoryAdmin);

    /**
     * Update integer.
     *
     * @param dormitoryAdmin the dormitory admin
     * @return the integer
     */
    public Integer update(DormitoryAdmin dormitoryAdmin);

    /**
     * Delete by id integer.
     *
     * @param id the id
     * @return the integer
     */
    public Integer deleteById(Integer id);
}
