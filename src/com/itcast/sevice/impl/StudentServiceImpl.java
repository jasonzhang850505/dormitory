package com.itcast.sevice.impl;

import com.itcast.dao.StudentDao;
import com.itcast.dao.impl.StudentDaoImpl;
import com.itcast.entity.Student;
import com.itcast.sevice.StudentService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The type Student service.
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> list() {
        return this.studentDao.list();
    }
    @Override
    public List<Student> search(String key, String value) {
        if (value.equals("")) return this.studentDao.list();
        return this.studentDao.search(key,value);
    }

    @Override
    public Integer save(Student student) {
        student.setState("入住");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        student.setCreate_date(sdf.format(date));
        Integer save = this.studentDao.save(student);
        if (save !=1) throw new RuntimeException("添加学生信息失败");
        return save;
    }

    @Override
    public Integer update(Student student) {
        Integer update = this.studentDao.update(student);
        if (update !=1) throw new RuntimeException("更新学生信息失败");
        return update;
    }
}
