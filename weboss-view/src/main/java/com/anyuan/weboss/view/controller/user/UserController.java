/**
 *  Copyright (c) 2012 The Anyuaning Open Source Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.anyuan.weboss.view.controller.user;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anyuan.weboss.orm.model.user.Address;
import com.anyuan.weboss.orm.model.user.Contact;
import com.anyuan.weboss.orm.model.user.Phone;
import com.anyuan.weboss.orm.model.user.User;
import com.anyuan.weboss.orm.service.user.UserService;

/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Jul 8, 2013 9:29:20 PM
 */
@Controller
@RequestMapping(value="user")
public class UserController {
    
    private static UserService userService;
    
    static {
        userService = new UserService();
    }
    
    @RequestMapping(method=RequestMethod.GET)  // 不能有重复的,默认的index
    public String index(HttpServletRequest req, HttpServletResponse resp) {
        
        req.setAttribute("listuser", userService.listAll());
        
        return "users/list_user";
    }
    
    @RequestMapping(value="add")
    public String add(HttpServletRequest req, HttpServletResponse resp) {
        
        return "users/add_user";
    }
    
    @RequestMapping(value="add_user")
    public String add_user(HttpServletRequest req, HttpServletResponse resp) {
        
        Contact contact = new Contact();
        contact.setEmail(req.getParameter("email"));
        
        Address address = new Address();
        address.setCity(req.getParameter("city"));
        contact.setAddress(address);
        
        Phone phone = new Phone();
        phone.setNumber(req.getParameter("number"));
        contact.setPhone(phone);
        
        User user = new User();
        
        user.setNickname(req.getParameter("nickname"));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setCreatetime(new Timestamp(System.currentTimeMillis()));
        user.setGender(req.getParameter("gender"));
        
        user.setContact(contact);
        
        userService.save(user);
        
        req.setAttribute("listuser", userService.listAll());
        
        return "users/list_user";
    }

}
