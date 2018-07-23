/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.webapi.services;

import com.sie.bl.PersonaRolPersonaBL;
import com.sie.dto.PersonaRolPersona;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Brayan A
 */
@Path("personarolpersona")
public class PersonaRolPersonaResource {

    PersonaRolPersonaBL personrol;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonaRolPersonaResource
     */
    public PersonaRolPersonaResource() {
    }

    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<PersonaRolPersona> getall() {
        
        personrol = new PersonaRolPersonaBL();
        
        return personrol.getRolPersona();
    }
	

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String create(PersonaRolPersona perol) {
        
        personrol = new PersonaRolPersonaBL();
        try {
            
            personrol.insertRolPersona(perol);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(PersonaRolPersonaResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
    

    /**
     * PUT method for updating or creating an instance of PersonaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(PersonaRolPersona perol) {
        
        personrol = new PersonaRolPersonaBL();
        
        try {
            
            personrol.updateRolPersona(perol);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(PersonaRolPersonaResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
	
	
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String delete(Integer id){
    
        personrol = new PersonaRolPersonaBL();
        
        try {
            
            personrol.deleteRolPersona(id);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(PersonaRolPersonaResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    
    }
    
}
