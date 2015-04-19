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
package com.anyuan.thomweboss.persistence;

import java.sql.Connection;
import java.util.List;

/**
 * 基本的数据访问层
 * @author Thomsen
 * @version 1.0
 * @since Jul 7, 2013 10:58:37 AM
 */
public interface BaseDao<T> {

    public Connection getConnection();

    /**
     * 保存单条数据
     * @author Thomsen
     * @since Jul 13, 2013 1:11:03 PM
     * @param entity
     * @return
     */
    public boolean save(T entity);
    
    /**
     * 保存全部数据
     * @author Thomsen
     * @since Jul 13, 2013 1:11:26 PM
     * @param entities
     * @return
     */
    public boolean saveAll(List<T> entities);
    
    /**
     * 查询所有数据
     * @author Thomsen
     * @since Jul 13, 2013 1:11:44 PM
     * @return
     */
    public List<T> listAll();
    
    /**
     * 根据id查询数据
     * @author Thomsen
     * @since Jul 13, 2013 1:12:04 PM
     * @param id
     * @return
     */
    public T findById(long id);
    
    /**
     * 删除全部数据
     * @author Thomsen
     * @since Jul 13, 2013 1:15:10 PM
     * @return
     */
    public boolean deleteAll();
    
    /**
     * 根据id删除数据
     * @author Thomsen
     * @since Jul 13, 2013 1:15:24 PM
     * @param id
     * @return
     */
    public boolean deleteById(long id);
    
}
