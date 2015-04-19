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
package com.anyuan.thomweboss.resetful;

import com.anyuan.thomweboss.model.user.Contact;
import com.anyuan.thomweboss.resetful.storage.ContactStore;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * 联系人集合
 * @author Thomsen
 * @version 1.0
 * @since Mar 6, 2013 11:11:59 PM
 */
@Path("/contacts")
public class ContactsResource {
    
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    @GET
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.addAll(ContactStore.getStore().values());
        return contacts;
    }
    
    @Path("{contact}")
    public ContactResource getContact(@PathParam("contact") String contact) {
        return new ContactResource(uriInfo, request, contact);
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newContact(
            @FormParam("id") String id,
            @FormParam("name") String name,
            @Context HttpServletResponse servletResponse) throws IOException {
//                Contact c = new Contact(id,name,new ArrayList<Address>());
                Contact c = new Contact();
                c.setId(Long.valueOf(id));
                c.setEmail(name);
                ContactStore.getStore().put(id, c);
                
                URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
                Response.created(uri).build();
                
//                servletResponse.sendRedirect("../views/user/new_contact.jsp");
                servletResponse.sendRedirect("../rest/contacts");
    }
}
