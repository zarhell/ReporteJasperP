/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.webapi.services;

import com.sie.bl.ContratoPlanBL;
import com.sie.dto.ContratoPlan;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Brayan A
 */
@Path("contratoplan")
public class ContratoPlanResource {

    ContratoPlanBL contrapl;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ContratoPlanResource
     */
    public ContratoPlanResource() {
    }

    
	
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<ContratoPlan> getall() {
        
        contrapl = new ContratoPlanBL();
        
        //return contrapl.getBeneficiarioAfiliado();
        return null;//tmp
    }
	
	
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<ContratoPlan> getid(@PathParam("id") Integer id) {
        
        contrapl = new ContratoPlanBL();
        
        //return contrapl.getBeneficiarioAfiliado(id);
        return null;//tmp
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String create(ContratoPlan cp) {
        
        contrapl = new ContratoPlanBL();
        try {
            
            //contrapl.insertBeneficiarioAfiliado(cp);
            
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
    public String update(ContratoPlan cp) {
        
        contrapl = new ContratoPlanBL();
        
        try {
            
            //contrapl.updateBeneficiarioAfiliado(cp);
            
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(PersonaResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
	
	
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String delete(Integer id){
    
        contrapl = new ContratoPlanBL();
        
        try {
            
            //contrapl.deleteBeneficiarioAfiliado(id);
            
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(PersonaResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    
    }
}
