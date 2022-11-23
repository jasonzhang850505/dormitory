package com.itcast.controller;

import com.itcast.entity.Student;
import com.itcast.sevice.DormitoryService;
import com.itcast.sevice.StudentService;
import com.itcast.sevice.impl.DormitoryServiceImpl;
import com.itcast.sevice.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Student servlet.
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    private DormitoryService dormitoryService = new DormitoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        switch (method) {
            case "list":
                req.setAttribute("list", this.studentService.list());
                //传入可用宿舍的信息
                req.setAttribute("dormitoryList", this.dormitoryService.availableList());
                req.getRequestDispatcher("studentmanager.jsp").forward(req, resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list", this.studentService.search(key, value));
                req.getRequestDispatcher("studentmanager.jsp").forward(req, resp);
                break;
            case "save":
                String dormitoryIdStr = req.getParameter("dormitory_id");
                Integer dormitoryId = Integer.parseInt(dormitoryIdStr);
                String number = req.getParameter("number");
                String name = req.getParameter("name");
                String gender = req.getParameter("gender");
                this.studentService.save(new Student(gender,number,name,dormitoryId));
                resp.sendRedirect("/student?method=list");
                break;

        }
    }
}
