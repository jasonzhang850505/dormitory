package com.itcast.sevice;

import com.itcast.entity.Student;

import java.util.List;

/**
 * The interface Student service.
 */
public interface StudentService {
    /**
     * List list.
     *
     * @return the list
     */
    public List<Student> list();

    /**
     * Search list.
     *
     * @param key   the key
     * @param value the value
     * @return the list
     */
    public List<Student>  search(String key, String value);

    /**
     * Save integer.
     *
     * @param student the student
     * @return the integer
     */
    public Integer save(Student student);
}
