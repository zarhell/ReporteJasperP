/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.webapi.services;

import com.sie.bl.InformacionAdicionalBL;
import com.sie.dto.InformacionAdicional;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Brayan A
 */
@Path("infoaddicional")
public class InformacionAdicionalResource {

    InformacionAdicionalBL infobl;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of InformacionAdicionalResource
     */
    public InformacionAdicionalResource() {
    }

    /**
     * Retrieves representation of an instance of com.sie.webapi.services.InformacionAdicionalResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<InformacionAdicional> getid(@PathParam("id") Integer id) {
        
        infobl = new InformacionAdicionalBL();
        
        return infobl.getinfoadicional(id);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String create(InformacionAdicional ia) {
        
        infobl = new InformacionAdicionalBL();
        try {
            
            infobl.insertinfoadicional(ia);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(PersonaResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
    

    /**
     * PUT method for updating or creating an instance of PersonaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(InformacionAdicional ia) {
        
        infobl = new InformacionAdicionalBL();
        try {
            
            infobl.updateinfoadicional(ia);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(PersonaResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
    
}
