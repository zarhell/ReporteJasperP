/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.webapi.services;

import com.sie.bl.PersonaBL;
import com.sie.dto.Persona;
import java.sql.SQLException;
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
@Path("persona")
public class PersonaResource {

    PersonaBL personbl;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonaResource
     */
    public PersonaResource() {
    }

    /**
     * Retrieves representation of an instance of com.sie.webapi.services.PersonaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> getall() {

        personbl = new PersonaBL();
                
        return personbl.getPersonas();
    }
    
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Persona> getid(@PathParam("id") Integer id) {
        
        personbl = new PersonaBL();
        
        return personbl.getPersonasIdentificacion(id);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String create(Persona p) {
        
        personbl= new PersonaBL();
        try {
            
            personbl.insertPersonas(p);
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
    public String update(Persona p) {
        
        personbl= new PersonaBL();
        try {
            
            personbl.updatePersonas(p);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(PersonaResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
    
    
    @GET
    @Path("n/{nombre}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Persona> getnombre(@PathParam("nombre") String nom) {
        
        personbl = new PersonaBL();
        
        return personbl.getPersonasNombre(nom);
    }
    
}
