package com.theironyard.controllers;

import com.sun.deploy.net.HttpResponse;
import com.theironyard.Utils.PasswordStorage;
import com.theironyard.entities.User;
import com.theironyard.services.PhotoRepository;
import com.theironyard.services.UserRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by branden on 3/15/16 at 11:08.
 */
@RestController  //this returns a serialized JSON object
public class IronGramController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PhotoRepository photoRepository;

    Server dbui = null;

    @PostConstruct
    public void init() throws SQLException {
        dbui = Server.createWebServer().start();
    }

    @PreDestroy
    public void preDestory() {
        dbui.stop();
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public User login(String userName, String password, HttpSession session, HttpServletResponse response) throws Exception {
        User user = userRepository.findByName(userName);
        if (user == null) {
            user = new User(userName, PasswordStorage.createHash(password));
            userRepository.save(user);
        } else if (!PasswordStorage.verifyPassword(password, user.getPasswordHash())){
            throw new Exception("Wrong Password");
        }

        session.setAttribute("userName", userName);
        response.sendRedirect("/");  //this redirects. may not need this for front end projects
        return user;
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public User getUser(HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        return userRepository.findByName(userName);
    }


}