package com.wt.service;

import com.wt.bean.Student;

import java.util.List;

public interface SearchService {
    List<Student> findByName(String sName);
}
