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
package com.anyuan.weboss.orm.persistence.hibimpl.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.anyuan.weboss.orm.model.user.User;
import com.anyuan.weboss.orm.persistence.dao.user.UserDao;
import com.anyuan.weboss.orm.persistence.hibimpl.BaseDaoHibImpl;


/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Jul 7, 2013 5:37:13 PM
 */
public class UserDaoHibImpl extends BaseDaoHibImpl<User> implements UserDao {

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.hibimpl.BaseDaoHibImpl#listAll()
     */
    @Override
    public List<User> listAll() {

        Configuration config = new Configuration().configure();
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
                config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(registry);
        Session session = sessionFactory.openSession();
        
        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User> listUser = query.list();

        session.close();
        
        return listUser;
    }

    
}
