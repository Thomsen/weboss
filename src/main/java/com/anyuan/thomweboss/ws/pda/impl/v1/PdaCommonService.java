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
package com.anyuan.thomweboss.ws.pda.impl.v1;

import com.anyuan.thomweboss.ws.pda.IPdaCommonService;

import javax.jws.WebService;

/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Jul 28, 2013 8:17:40 PM
 */
@WebService(targetNamespace="http://pda.ws.thomweboss.anyuan.com/v1")
public class PdaCommonService implements IPdaCommonService {

    private static final String VERSION = "1.0";
    
    /* (non-Javadoc)
     * @see com.anyuan.thomweboss.ws.pda.IPdaCommonService#login(java.lang.String, java.lang.String)
     */
    @Override
    public String login(String requestJson, String version) {

        if (VERSION.equals(version)) {
            return "1.0 success";    
        } else {
            return "1.0 error";
        }
        
    }

}
