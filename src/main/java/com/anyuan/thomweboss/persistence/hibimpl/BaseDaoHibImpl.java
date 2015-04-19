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
package com.anyuan.thomweboss.persistence.hibimpl;

import com.anyuan.thomweboss.persistence.BaseDao;

import java.sql.Connection;
import java.util.List;

/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Jul 7, 2013 4:59:56 PM
 */
public class BaseDaoHibImpl<T> implements BaseDao<T> {

    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.persistence.BaseDao#getConnection()
     */
    @Override
    public Connection getConnection() {
        // TODO Auto-generated method stub
        return null;
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


}
