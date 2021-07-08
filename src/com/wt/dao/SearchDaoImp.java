package com.wt.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wt.bean.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class SearchDaoImp implements SearchDao {
    ComboPooledDataSource dataSource =  new ComboPooledDataSource();
    QueryRunner qr = new QueryRunner(dataSource);
    @Override
    public List<Student> findByName(String str) {
        String sql = "select * from student where 1=1 ";
        if(str != null && str.trim() != "") {
            sql += "and sname like '%" + str + "%'";
        }
        List<Student> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        System.out.println(dataSource);
        System.out.println(qr);
        return list;
    }
}
