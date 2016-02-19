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
package com.anyuan.weboss.orm.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.anyuan.weboss.orm.model.Model;

/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Jul 6, 2013 8:00:45 PM
 */
@Entity
@Table(name="t_user")
public class User extends Model {

    /**
     * 用户名
     */
    @Column(name="f_username")
    private String username;
    
    /**
     * 昵称
     */
    @Column(name="f_nickname")
    private String nickname;
    
    /**
     * 登录名
     */
    @Column(name="f_loginname", insertable=true, updatable=false)
    private String loginname;
    
    /**
     * 密码
     */
    @Column(name="f_password")
    private String password;
    
    /**
     * 出生日期
     */
    @Column(name="f_birthday")
    private java.sql.Date birthday;
    
    /**
     * 性别
     */
    @Column(name="f_gender")
    private String gender;
    
    /**
     * 创建日期
     */
    @Column(name="f_createtime")
    private java.sql.Timestamp createtime;
    
    /**
     * 登录日期
     */
    @Column(name="f_logintime")
    private java.sql.Timestamp logintime;
    
    /**
     * 描述
     */
    @Column(name="f_description")
    private String description;
    
    /**
     * 联系方式
     */
    private Contact contact;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the loginname
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * @param loginname the loginname to set
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the birthday
     */
    public java.sql.Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the createtime
     */
    public java.sql.Timestamp getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime the createtime to set
     */
    public void setCreatetime(java.sql.Timestamp createtime) {
        this.createtime = createtime;
    }

    /**
     * @return the logintime
     */
    public java.sql.Timestamp getLogintime() {
        return logintime;
    }

    /**
     * @param logintime the logintime to set
     */
    public void setLogintime(java.sql.Timestamp logintime) {
        this.logintime = logintime;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
