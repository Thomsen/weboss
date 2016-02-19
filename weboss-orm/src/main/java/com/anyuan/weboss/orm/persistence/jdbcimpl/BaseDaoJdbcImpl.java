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
package com.anyuan.weboss.orm.persistence.jdbcimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anyuan.weboss.orm.persistence.BaseDao;

/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Jul 7, 2013 11:11:51 AM
 */
public class BaseDaoJdbcImpl<T> implements BaseDao<T> {

    private JdbcTemplate jdbcTemplate;

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.dao.BaseJdbcDao#getConnection()
     */
    @Override
    public Connection getConnection() {
        
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://127.0.0.1:5432/thomdb";
//    	String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/thomdb";
        String username = "thomoss";
        String password = "ossthom";
        
        Connection connection = null;
        BasicDataSource dataSource = new BasicDataSource();  
        
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/thomdb");
//        dataSource.setUsername("thomoss");
//        dataSource.setPassword("ossthom");
        
//        /home/thom/workspace/thomweboss/target/classes/
//        String path = this.getClass().getClassLoader().getResource("").toString();
        
        String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
        
//        try {
//            String path = this.getClass().getClassLoader().getResource("").toString();
//            InputStream inStream = new FileInputStream(path + "../properties/jdbc.properties");
//            Properties properties = new Properties();
//            properties.load(inStream);
//            inStream.close();
//        } catch (FileNotFoundException e1) {
//            e1.printStackTrace();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
        
//        try {
//            dataSource.setConnectionProperties(path + "../properties/jdbc.properties");
//            System.out.print(path + "../properties/jdbc.properties");
//            connection = dataSource.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        
        // jdbc connection
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (null == connection) {
            throw new NullPointerException("数据库连接为空");
        } else {
            return connection;
        }
        
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.BaseDao#save(java.lang.Object)
     */
    @Override
    public boolean save(T entity) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.BaseDao#saveAll(java.util.List)
     */
    @Override
    public boolean saveAll(List<T> entities) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.BaseDao#listAll()
     */
    @Override
    public List<T> listAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.BaseDao#findById(long)
     */
    @Override
    public T findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.BaseDao#deleteAll()
     */
    @Override
    public boolean deleteAll() {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.BaseDao#deleteById(long)
     */
    @Override
    public boolean deleteById(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @return the jdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

}
