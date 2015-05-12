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
package com.anyuan.thomweboss.persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.anyuan.thomweboss.model.user.User;

/**
 * hibernate4中api的工具类
 * @author Thomsen
 * @version 1.0
 * @since Dec 15, 2012 11:15:28 PM
 */
@Repository
public class HibernateDaoTemplate {
    
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
    
    private static Session session;
    
    /**
     * 获取hibernate的jdbc的事务（transaction）
     * @author Thomsen
     * @since Dec 15, 2012 11:20:02 PM
     * @return
     */
    public static Transaction getTranscation() {
        
        Transaction transaction = null;
        try {
            Configuration configuration = new Configuration().configure(); // 默认找classpath下的hibernate.cfg.xml
            ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();
            SessionFactory sessionFactory = configuration.buildSessionFactory(registry);  // hibernate4.0 之前用buildSessionFactory()
//            Session session = sessionFactory.getCurrentSession();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        if (transaction == null) {
            throw new HibernateException("transaction is null");
        }
        
        return transaction;
        
    }
    
    protected Serializable save(Object obj) {
        Transaction trans = getTranscation();
        Serializable serial = session.save(obj);
        trans.commit();
        closeSession();
        
        return serial;
    }
    
    protected List<User> list() {
//        getTranscation();
        
        Session session = this.getSessionFactory().getCurrentSession();

        
        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User> list = query.list();
        closeSession();
        return list;
    }
    
    public static void closeSession() {
        if (session != null) {
            session.close();
        }
    }

    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
