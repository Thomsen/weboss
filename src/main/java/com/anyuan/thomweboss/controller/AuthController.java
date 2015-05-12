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
package com.anyuan.thomweboss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO
 * @author Thomsen
 * @version 1.0
 * @since Dec 8, 2012 5:32:32 PM
 */
@Controller
@RequestMapping(value="/auth")
public class AuthController {
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(ModelMap modelMap) {
        modelMap.put("login", "login ext");
        return "/index"; // 该返回值没有作用，并不能在url上指定，
                              // 如果RequestMapping中没有value值，则以类RequestMapping的value值为默认访问url
        // 放回值还是有作用的，会在spring mvc的配置文件中的prefix找到该目录以suffix为后缀的文件
        // 所以value只是指定url的访问路径，而return则是返回访问路径对应的文件
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login() {
        return "welcome";
    }


}
