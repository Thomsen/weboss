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

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import com.anyuan.weboss.api.restful.storage.ContactStore;
import com.anyuan.weboss.orm.model.user.Contact;

/**
 * 个人联系人
 * @author Thomsen
 * @version 1.0
 * @since Mar 6, 2013 11:13:05 PM
 */
public class ContactResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String contact;
    
    public ContactResource(UriInfo uriInfo, Request request, String contact) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.contact = contact;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Contact getContact() {
        Contact cont = ContactStore.getStore().get(contact);
        if (cont == null) {
            throw new RuntimeException("no contact");
        }
        return cont;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putContact(JAXBElement<Contact> jaxbContact) {
        Contact c = jaxbContact.getValue();
        return putAndGetResponse(c);
    }
    
    private Response putAndGetResponse(Contact c) {
        Response res;
        if(ContactStore.getStore().containsKey(c.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        ContactStore.getStore().put(c.getStrId(), c);
        return res;
    }
    
    @DELETE
    public void deleteContact() {
        Contact c = ContactStore.getStore().remove(contact);
        if(c==null) {
//          throw new NotFoundException("No such Contact.");            
        }

    }
}
