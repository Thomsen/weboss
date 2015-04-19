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
package com.anyuan.thomweboss.resetful.storage;

import com.anyuan.thomweboss.model.user.Address;
import com.anyuan.thomweboss.model.user.Contact;
import com.anyuan.thomweboss.model.user.Phone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Mar 6, 2013 11:52:56 PM
 */
public class ContactStore {

    private static Map<String, Contact> store;
    
    private static ContactStore instance = null;
    
    private ContactStore() {
        store = new HashMap<String, Contact>();
        initOneContact();
    }

    public static Map<String, Contact> getStore() {
        if (instance == null) {
            instance = new ContactStore();
        }
        return store;
    }
    
    /**
     * TODO
     * @author Thomsen
     * @since Mar 6, 2013 11:59:09 PM
     */
    private void initOneContact() {
//        Address[] addrs = {
//                new Address("Nanjing", "thomsen"),
//                new Address("Shanghai", "chenyujia")
//        };
//        
//        Contact cHuang = new Contact("hhuwtian", "208", Arrays.asList(addrs));
        Phone phone = new Phone();
        phone.setNumber("111222");
        String email = "aa@abc.com";
        Address address = new Address();
        address.setCity("Nanjing");
        Contact cHuang = new Contact(phone, email, address);
        
        store.put(cHuang.getStrId(), cHuang);
    }
    
}
