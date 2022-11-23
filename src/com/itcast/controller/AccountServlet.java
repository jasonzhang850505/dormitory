package com.itcast.controller;

import com.itcast.dto.SystemAdminDto;
import com.itcast.sevice.SystemAdminService;
import com.itcast.sevice.impl.SystemAdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The type Account servlet.
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    private SystemAdminService systemAdminService = new SystemAdminServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        switch (method) {
            case "login":
                String username = req.getParameter("username");// 从浏览器获取username
                String password = req.getParameter("password");// 从浏览器获取密码
                SystemAdminDto systemAdminDto = this.systemAdminService.login(username, password);
                if (systemAdminDto.getCode() == -1) {
                    req.setAttribute("usernameError", "用户名不存在");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                } else if (systemAdminDto.getCode() == -2) {
                    req.setAttribute("passwordError", "密码错误");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                } else {
                    HttpSession session = req.getSession();
                    session.setAttribute("systemAdmin", systemAdminDto.getSystemAdmin());
                    resp.sendRedirect("/systemadmin.jsp");
                    break;
                }
                break;
            case "logout":
                req.getSession().invalidate();//销毁session
                resp.sendRedirect("/login.jsp");
                break;
        }
    }
}
