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
package com.anyuan.thomweboss.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anyuan.thomweboss.dto.BaseResponse;
import com.google.gson.Gson;

/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Oct 27, 2012 8:03:24 PM
 */
public class AuthServlet extends HttpServlet {
    
    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().print("hello servlet");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        Connection connection = null;
        String url = "jdbc:postgresql://127.0.0.1:5432/thomdb";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, "thomoss", "ossthom");
            connection.getCatalog();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String username = req.getParameter("loginUsername");
        String password = req.getParameter("loginPassword");
        
        String sql = "select * from t_user where f_username = '" + username + "';";
        Statement statement = null;
        ResultSet resultSet = null;
        
        BaseResponse extResult = new BaseResponse();
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            String pass = "";
            while (resultSet.next()) {
                pass = resultSet.getString("f_password");
            }
            
            if (password.equals(pass)) {
                extResult.setSuccess(true);
                extResult.setText("登录成功");
            } else {
                extResult.setSuccess(false);
                extResult.setReason("密码不正确");
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/x-json");
        
        resp.getWriter().print(new Gson().toJson(extResult));
        resp.getWriter().close();
        
        
        
//        Configuration configuration = new Configuration().configure();
//        SessionFactory sessionFactory = configuration.buildSessionFactory();  // hibernate4 deprecated
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        
        // 通过自身的api来实现数据库的访问，hibernate4不再使用getHibernateTemplate
//        Configuration configuration = new Configuration().configure();
//        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
//                configuration.getProperties()).buildServiceRegistry();
//        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        
//        User user = new User();
//        user.setUsername("thom");
//        user.setPassword(EncryptionUtil.encodeMd5("thom"));
//        session.save(user);
//        transaction.commit();
        
    }
    
}
