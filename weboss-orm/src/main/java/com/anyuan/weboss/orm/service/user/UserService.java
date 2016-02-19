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
package com.anyuan.weboss.orm.service.user;

import java.util.List;

import com.anyuan.weboss.orm.model.user.User;
import com.anyuan.weboss.orm.persistence.dao.user.UserDao;
import com.anyuan.weboss.orm.service.BasePersistService;

/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Jul 7, 2013 9:19:36 AM
 */
public class UserService implements BasePersistService<User> {

    private static UserDao userDao;
    
//    static {
////        userDao = new UserDaoHibImpl();
//        userDao = new UserDaoJdbcImpl();
//    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.service.BasePersistService#save(java.lang.Object)
     */
    @Override
    public boolean save(User entity) {
        return getUserDao().save(entity);
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.service.BasePersistService#saveAll(java.util.List)
     */
    @Override
    public boolean saveAll(List<User> entities) {
        return getUserDao().saveAll(entities);
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.service.BasePersistService#listAll()
     */
    @Override
    public List<User> listAll() {
        return getUserDao().listAll();
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.service.BasePersistService#findById(long)
     */
    @Override
    public User findById(long id) {
        return getUserDao().findById(id);
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.service.BasePersistService#deleteAll()
     */
    @Override
    public boolean deleteAll() {
        return getUserDao().deleteAll();
    }

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.service.BasePersistService#deleteById(long)
     */
    @Override
    public boolean deleteById(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @return the userDao
     */
    public static UserDao getUserDao() {
        return userDao;
    }

    /**
     * @param userDao the userDao to set
     */
    public static void setUserDao(UserDao userDao) {
        UserService.userDao = userDao;
    }
    

    
}
