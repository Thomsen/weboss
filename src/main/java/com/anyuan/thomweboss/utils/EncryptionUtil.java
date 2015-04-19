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
package com.anyuan.thomweboss.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密解密
 * @author Thomsen
 * @version 1.0
 * @since Dec 8, 2012 2:18:21 AM
 */
public class EncryptionUtil {
    
    //=============================MD5===============================//
    
    /**
     * 将字符串编码成md5
     * @author Thomsen
     * @since Dec 8, 2012 12:41:49 PM
     * @param source
     * @return
     */
    public static String encodeMd5(String source) {
        if (source == null) {
            throw new NullPointerException();
        }
        
        StringBuffer result = new StringBuffer();
        
        MessageDigest messageDigest = null;
        byte[] byteArray = null;
        
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(source.getBytes("UTF-8"));
            
            byteArray = messageDigest.digest();
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        for (int i=0; i<byteArray.length; i++) {
           if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
               result.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
           } else {
               result.append(Integer.toHexString(0xFF & byteArray[i])); 
           }
        }
        
//        String r = new String(Base64.encodeBase64(byteArray), "UTF-8");
        
        return result.toString();
    }
    
    /**
     * 将md5码进行解码
     * @author Thomsen
     * @since Dec 8, 2012 1:09:26 PM
     * @param source
     * @return
     */
    public static String decodeMd5(String source) {
        if (source == null) {
            throw new NullPointerException();
        }
        String result = null;
        
        
        return result;
    }
    
    /**
     * 对编码后的md5码进行加密
     * @author Thomsen
     * @since Dec 8, 2012 12:42:59 PM
     * @param source
     * @return
     */
    public static String encryMd5(String source) {
        return convertMd5(source);
    }
    
    /**
     * 将加密后的md5码进行解密
     * @author Thomsen
     * @since Dec 8, 2012 12:43:28 PM
     * @param source
     * @return
     */
    public static String decryMd5(String source) {
        String s = convertMd5(source);
        return convertMd5(s);
    }
    
    /**
     * 加密算法
     * @author Thomsen
     * @since Dec 8, 2012 1:10:03 PM
     * @param source
     * @return
     */
    private static String convertMd5(String source) {
        if (source == null) {
            throw new NullPointerException();  
        }
        
        char[] c = source.toCharArray();
        for (int i=0; i<c.length; i++) {
            c[i] = (char) (c[i] ^ 't');
        }
        
        String result = new String(c);
        
        return result;
    }

}
