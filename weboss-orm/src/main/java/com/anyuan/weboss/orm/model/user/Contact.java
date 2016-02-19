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

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.anyuan.weboss.orm.model.Model;

/**
 * TODO
 * XmlRootElement need, MessageBodyWriter not found for media type=application/xml, 
 * @author Thomsen
 * @version 1.0
 * @since Jul 6, 2013 8:33:51 PM
 */
@XmlRootElement
public class Contact extends Model {

    /**
     * 电话
     */
    private Phone phone;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 地址
     */
    private Address address;
    
    /**
     * 
     */
    private List<Address> addresses;
    
    public Contact() {
        
    }
    
    /**
     * @param phone
     * @param email
     * @param address
     */
    public Contact(Phone phone, String email, Address address) {
        super();
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
    
    /**
     * @param id
     * @param name
     * @param addresses
     */
    public Contact(Phone phone, String email, List<Address> addresses) {
        super();
        this.phone = phone;
        this.email = email;
        this.addresses = addresses;
    }


    /**
     * @return the phone
     */
    public Phone getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

}
