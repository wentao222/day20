package com.wt.service;

import com.wt.bean.Student;
import com.wt.dao.SearchDaoImp;

import java.util.List;

public class SearchServiceImp implements SearchService {

    SearchDaoImp sdi = new SearchDaoImp();
    @Override
    public List<Student> findByName(String sName) {
        return sdi.findByName(sName);
    }
}
