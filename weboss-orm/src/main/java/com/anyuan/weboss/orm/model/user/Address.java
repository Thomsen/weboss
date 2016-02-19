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
	
import javax.xml.bind.annotation.XmlRootElement;

import com.anyuan.weboss.orm.model.Model;

/**
 * TODO
 * 
 * @author Thomsen
 * @version 1.0
 * @since Jul 6, 2013 8:44:21 PM
 */
@XmlRootElement
public class Address extends Model {

	/**
	 * 国家
	 */
	private String country;

	/**
	 * 省
	 */
	private String province;

	/**
	 * 城市
	 */
	private String city;

	/**
	 * 街道
	 */
	private String street;

	/**
	 * 邮政编码
	 */
	private String postcode;

	public Address() {

	}

	/**
	 * @param city
	 * @param street
	 */
	public Address(String city, String street) {
		super();
		this.city = city;
		this.street = street;
	}

	/**
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode
	 *            the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
