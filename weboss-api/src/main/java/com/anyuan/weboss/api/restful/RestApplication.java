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
package com.anyuan.weboss.api.restful;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * TODO
 * jersey 1.x extends Application
 * @author Thomsen
 * @version 1.0
 * @since Mar 5, 2013 10:56:14 PM
 */
//@ApplicationPath("/jersey-ws")
public class RestApplication extends ResourceConfig {
    
//    public Set<Class<?>> getClasses() {
//        final Set<Class<?>> classes = new HashSet<Class<?>>();
//        classes.add(HelloResource.class);
//        
//        classes.add(ContactsResource.class);
//        
//        return classes;
//    }
    
   public RestApplication() {
       packages("com.anyuan.weboss.api.restful");
   }
}
