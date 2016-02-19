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
package com.anyuan.weboss.orm.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anyuan.weboss.orm.model.user.Address;
import com.anyuan.weboss.orm.model.user.Contact;
import com.anyuan.weboss.orm.model.user.Phone;
import com.anyuan.weboss.orm.model.user.User;
import com.anyuan.weboss.orm.persistence.dao.user.UserDao;
import com.anyuan.weboss.orm.persistence.jdbcimpl.user.UserDaoJdbcImpl;

/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Jul 7, 2013 10:22:02 AM
 */
public class JdbcTest extends TestCase {

    public void testConnJdbc() {
        BasicDataSource datSource = new BasicDataSource();
        datSource.setDriverClassName("org.postgresql.Driver");
        datSource.setUrl("jdbc:postgresql://127.0.0.1:5432/thomdb");
        datSource.setUsername("thomoss");
        datSource.setPassword("ossthom");
        
        try {
            datSource.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datSource);
    }
    
    public void testGetConnection() {
        UserDao baseDao = new UserDaoJdbcImpl();
        
        Connection conn = baseDao.getConnection();
        
//        assertEquals(null, conn);
        
    }
    
    public void testSave() {
//        UserDao baseDao = new UserDaoJdbcImpl();
//        baseDao.getConnection();
//        baseDao.save(null);
    }
    
    public void testSave2() {
        UserDao baseDao = new UserDaoJdbcImpl();
        User user = new User();
        user.setUsername("testss");
        user.setNickname("ts");
        user.setPassword("123456");
        baseDao.save(user);
    }
    
    public void testListAll() {
        UserDao baseDao = new UserDaoJdbcImpl();
//        baseDao.getConnection();
        baseDao.listAll();
    }
    
    public void testDeleteAll() {
        UserDao userdao = new UserDaoJdbcImpl();
        userdao.deleteAll();
    }
    
    public void testSaveAll() {
        UserDao userDao = new UserDaoJdbcImpl();
        List<User> lu = new ArrayList<User>();
        User u1 = new User();
        u1.setUsername("name1");
        lu.add(u1);
        User u2 = new User();
        u2.setUsername("name2");
        lu.add(u2);
        userDao.saveAll(lu);
    }
    
    public void testSaveTranscation() {
        Contact contact = new Contact();
        contact.setEmail("a@b.com");
        Phone phone = new Phone();
        phone.setNumber("02568598763");
        phone.setPhoneType(1);
        contact.setPhone(phone);
        Address address = new Address();
        address.setCity("南京");
        contact.setAddress(address);
        
        User user = new User();
        user.setUsername("thomsen");
        user.setNickname("thom");
        user.setLoginname("anyuan");
        
        user.setContact(contact);
        
        UserDao ud = new UserDaoJdbcImpl();
        assertEquals(ud.save(user), true);
        
        
    }
    
}
