package com.wt.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wt.bean.Student;
import com.wt.service.SearchServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setContentType("text/html;charset=utf8");

        String searchContent = req.getParameter("searchContent");
        System.out.println(searchContent);
        List<Student> list = new SearchServiceImp().findByName(searchContent);
        System.out.println("lsit:"+ list);
        ObjectMapper mapper = new ObjectMapper();
        String res = mapper.writeValueAsString(list);

        PrintWriter out = resp.getWriter();
        out.print(res);
        out.close();
    }
}
