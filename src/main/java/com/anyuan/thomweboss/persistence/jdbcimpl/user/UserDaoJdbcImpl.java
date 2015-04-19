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
package com.anyuan.thomweboss.persistence.jdbcimpl.user;

import com.anyuan.thomweboss.model.user.Address;
import com.anyuan.thomweboss.model.user.Contact;
import com.anyuan.thomweboss.model.user.Phone;
import com.anyuan.thomweboss.model.user.User;
import com.anyuan.thomweboss.persistence.dao.user.UserDao;
import com.anyuan.thomweboss.persistence.jdbcimpl.BaseDaoJdbcImpl;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Jul 7, 2013 9:09:52 AM
 */
public class UserDaoJdbcImpl extends BaseDaoJdbcImpl<User> implements UserDao {

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.jdbcimpl.BaseJdbcDaoImpl#save(java.lang.Object)
     */
    @Override
    public boolean save(User entity) {
        Connection conn = getConnection();
        boolean result = false;
        
        String userSql = "insert into t_user (f_username, f_nickname, f_loginname, f_password, " +
                "f_birthday, f_gender, f_createtime, f_logintime, f_roleid, f_contactid, " +
                "f_description) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            conn.setAutoCommit(false);
            Contact contact = entity.getContact();
            
            Address address = contact.getAddress();
            saveAddress(conn, address);  // address id not modify, 由于Address中的getter和setter没有设置
            
            Phone phone = contact.getPhone();
            savePhone(conn, phone);
            
            saveContact(conn, contact);
            
            PreparedStatement preState = conn.prepareStatement(userSql);
            preState.setObject(1, entity.getUsername());
            preState.setString(2, entity.getNickname());
            preState.setString(3, entity.getLoginname());
            preState.setString(4, entity.getPassword());
            preState.setObject(5, entity.getBirthday());
            preState.setObject(6, entity.getGender());
            preState.setObject(7, entity.getCreatetime());
            preState.setObject(8, entity.getLogintime());  // 改变频率大
            preState.setObject(9, null);
            preState.setObject(10, entity.getContact().getId());
            preState.setObject(11, entity.getDescription());    
            result = preState.execute();
            conn.commit();
            
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    private long savePhone(Connection conn, Phone phone) {
        String sql = "insert into t_phone(f_number, f_phonetype) values(?, ?)";
        long id = -1;
        try {
               // 必须有第二个参数,不然getGeneratedKeys为空
            PreparedStatement preState = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preState.setString(1, phone.getNumber());
            preState.setInt(2, phone.getPhoneType());
            preState.execute();
            id = generateId(preState);
            if (-1 != id) {
                phone.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return id;
    }
    
    private long saveAddress(Connection conn, Address address) {
        long id = -1;
        String sql = "insert into t_address(f_country, f_province, f_city, f_street, f_postcode)"
                + " values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preState = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preState.setString(1, address.getCountry());
            preState.setString(2, address.getProvince());
            preState.setString(3, address.getCity());
            preState.setString(4, address.getStreet());
            preState.setString(5, address.getPostcode());
            preState.execute();
            id = generateId(preState);
            if (-1 != id) {
                address.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return id;
    }
    
    private long saveContact(Connection conn, Contact contact) {
        long id = -1;
        String sql = "insert into t_contact(f_email, f_phoneid, f_addressid)"
                + " values(?, ?, ?)";
        try {
            PreparedStatement preState = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preState.setString(1, contact.getEmail());
            preState.setLong(2, contact.getPhone().getId());
            preState.setLong(3, contact.getAddress().getId());
            preState.execute();
            id = generateId(preState);
            if (-1 != id) {
                contact.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * TODO
     * @author Thomsen
     * @since Jul 14, 2013 10:34:57 PM
     * @param id
     * @param preState
     * @return
     * @throws SQLException
     */
    private long generateId(PreparedStatement preState) throws SQLException {
        long id = -1;
        ResultSet rs = preState.getGeneratedKeys();
        if (null != rs && rs.next()) {
           id = rs.getLong(1);
        }
        return id;
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.jdbcimpl.BaseJdbcDaoImpl#listAll()
     */
    @Override
    public List<User> listAll() {
//        Connection conn = getConnection();
        final List<User> listUser = new ArrayList<User>();
      
        String sql = "select * from t_user";
        getJdbcTemplate().query(sql, new RowCallbackHandler() {

            @Override
            public void processRow(ResultSet rs) throws SQLException {
                listUser.clear();
                User user = null;
                while (rs.next()) {
                    user = new User();
                    user.setId(rs.getLong("f_id"));
                    user.setUsername(rs.getString("f_username"));
                    user.setNickname(rs.getString("f_nickname"));
                    listUser.add(user);

                    }
//                rs.close(); // 报错, 这个 ResultSet 已经被关闭。
                }
            
        });

//        try {
//            Statement state = conn.createStatement();
//            ResultSet rs = state.executeQuery(sql);
//            listUser = new ArrayList<User>();
//            User user = null;
//            while (rs.next()) {
//                System.out.println(rs.getString(3));
//                user = new User();
//                user.setId(rs.getLong("f_id"));
//                user.setUsername(rs.getString("f_username"));
//                user.setNickname(rs.getString("f_nickname"));
//                listUser.add(user);
//                
//            }
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        return listUser;
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.jdbcimpl.BaseDaoJdbcImpl#saveAll(java.util.List)
     */
    @Override
    public boolean saveAll(List<User> entities) {
        
        if (null != entities) {
            Connection conn = getConnection();
            try {
                conn.setAutoCommit(false);
                for (User user : entities) {
                    save(user);
                }
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            
        }
        
        return super.saveAll(entities);
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.jdbcimpl.BaseDaoJdbcImpl#findById(long)
     */
    @Override
    public User findById(long id) {
        // TODO Auto-generated method stub
        return super.findById(id);
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.jdbcimpl.BaseDaoJdbcImpl#deleteAll()
     */
    @Override
    public boolean deleteAll() {
        boolean result = false;
        String sql = "delete from t_user;";
        
        try {
            Statement state = getConnection().createStatement();
            result = state.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.jdbcimpl.BaseDaoJdbcImpl#deleteById(long)
     */
    @Override
    public boolean deleteById(long id) {
        // TODO Auto-generated method stub
        return super.deleteById(id);
    }
    
}
