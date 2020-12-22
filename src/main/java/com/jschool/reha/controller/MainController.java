package com.jschool.reha.controller;

import com.jschool.reha.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;

@Controller
public class MainController {

    private static final String LOGIN_PAGE ="login";
    private static final String LOGGED_IN_PAGE ="loggedIn";
    private static final String REDIRECT_LOGGED_IN ="redirect:/"+ LOGGED_IN_PAGE;

    @RequestMapping("/")
    public String loginPage(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) return LOGIN_PAGE;
        else return REDIRECT_LOGGED_IN;
    }

    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password)
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        final String login="admin";
        final String pass="admin";
        if (user != null) {
            return REDIRECT_LOGGED_IN;
        }
        else
        {
            if (username.equals(login)&&password.equals(pass))
            {
                user = new User();
                user.setUsername(username);
                user.setPassword(password);

                session.setAttribute("user", user);
                return REDIRECT_LOGGED_IN;
            }
        }
        return LOGIN_PAGE;
    }
    
    @RequestMapping("/loggedIn")
    public String loggedInPage(Model model)
    {

        //Get list of all users from DB
        ArrayList<User> users=new ArrayList<>();
        String dbUrl = "jdbc:mysql://localhost:3306/reha?useUnicode=true&serverTimezone=UTC";
        String username = "rehauser";
        String password = "user1234";

        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(dbUrl, username, password);
            stmt = conn.createStatement();

            String sql = "select * from user";
            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                User user = new User();
                user.setUsername(set.getString("username"));
                user.setEmail(set.getString("email"));
                user.setPassword(set.getString("password"));
                user.setRole(set.getString("role"));

                users.add(user);
            }

            //Add user data to model and present it in logged in page
            model.addAttribute("users",users);
            return LOGGED_IN_PAGE;

        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
            return "error";
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }
}
