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
package com.anyuan.thomweboss.model.user;

import com.anyuan.thomweboss.model.Model;

/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Jul 6, 2013 8:43:25 PM
 */
public class Phone extends Model {
    
    /**
     * 电话号码
     */
    private String number;

    /**
     * 电话类型
     */
    private int phoneType;
    
    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the phoneType
     */
    public int getPhoneType() {
        return phoneType;
    }

    /**
     * @param phoneType the phoneType to set
     */
    public void setPhoneType(int phoneType) {
        this.phoneType = phoneType;
    }

}
