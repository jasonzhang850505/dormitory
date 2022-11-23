package com.itcast.controller;

import com.itcast.entity.DormitoryAdmin;
import com.itcast.sevice.DormitoryAdminService;
import com.itcast.sevice.impl.DormitoryServiceAdminImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Dormitory servlet.
 */
@WebServlet("/dormitoryAdmin")
public class DormitoryServlet extends HttpServlet {
    private DormitoryAdminService dormitoryAdminService = new DormitoryServiceAdminImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        switch (method) {
                // 查询宿管信息
            case "list":
                req.setAttribute("list", this.dormitoryAdminService.list());
                req.getRequestDispatcher("adminmanager.jsp").forward(req, resp);
                break;
                // 宿管信息搜索
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list", this.dormitoryAdminService.search(key, value));
                req.getRequestDispatcher("adminmanager.jsp").forward(req, resp);
                break;
                // 添加宿管信息
            case "save":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String name = req.getParameter("name");
                String gender = req.getParameter("gender");
                String telephone = req.getParameter("telephone");
                this.dormitoryAdminService.save(new DormitoryAdmin(username, password, name, gender, telephone));
                resp.sendRedirect("/dormitoryAdmin?method=list");
                break;
                // 修改宿管信息
            case "update":
                username = req.getParameter("username");
                password = req.getParameter("password");
                name = req.getParameter("name");
                gender = req.getParameter("gender");
                telephone = req.getParameter("telephone");
                String strID = req.getParameter("id");
                Integer id = Integer.parseInt(strID);
                this.dormitoryAdminService.update(new DormitoryAdmin(id, username, password, name, gender, telephone));
                resp.sendRedirect("/dormitoryAdmin?method=list");
                break;
                // 删除宿管信息
            case "delete":
                id = Integer.parseInt(req.getParameter("id"));
                this.dormitoryAdminService.deleteById(id);
                resp.sendRedirect("/dormitoryAdmin?method=list");
                break;

        }

    }
}
