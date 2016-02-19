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
package com.anyuan.weboss.api.ws.pda.impl.v2;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.anyuan.weboss.api.ws.pda.IPdaCommonService;

/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Jul 28, 2013 8:18:13 PM
 */
@WebService(targetNamespace="http://pda.ws.thomweboss.anyuan.com/v2")
public class PdaCommonService implements IPdaCommonService {

    private static final String VERSION = "2.0";
    /* (non-Javadoc)
     * @see com.anyuan.weboss.api.ws.pda.IPdaCommonService#login(java.lang.String, java.lang.String)
     */
    @WebMethod()
    public String login(String requestJson, String version) {
        if (VERSION.equals(version)) {
            return "2.0 success";    
        } else {
            return "2.0 error";
        }
    }

}
