package com.wt.dao;

import com.wt.bean.Student;

import java.util.List;

public interface SearchDao {
    List<Student> findByName(String str);
}
