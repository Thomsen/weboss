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
package com.anyuan.weboss.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Dec 10, 2012 10:11:03 PM
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends GenericException {

    /**
     * 
     */
    private static final long serialVersionUID = -7033986345622524231L;

    
    private Long resId;
    
    public ResourceNotFoundException(Long resId) {
        this.resId = resId;
    }
    
    public Long getResId() {
        return resId;
    }
}
