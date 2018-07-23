/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.webapi.services;

import com.sie.bl.HistoricoStokeBL;
import com.sie.dto.HistoricoStoke;
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
@Path("historicostoke")
public class HistoricoStokeResource {

    HistoricoStokeBL histoke;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HistoricoStokeResource
     */
    public HistoricoStokeResource() {
    }

    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<HistoricoStoke> getall() {
        
        histoke = new HistoricoStokeBL();
        
        return histoke.getHistoricoStoke();
    }
	

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String create(HistoricoStoke hst) {
        
        histoke = new HistoricoStokeBL();
        try {
            
            histoke.insertHistoricoStoke(hst);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(HistoricoStokeResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
    

    /**
     * PUT method for updating or creating an instance of PersonaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(HistoricoStoke hst) {
        
        histoke = new HistoricoStokeBL();
        
        try {
            
            histoke.updateHistoricoStoke(hst);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(HistoricoStokeResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
	
	
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String delete(Integer id){
    
        histoke = new HistoricoStokeBL();
        
        try {
            
            histoke.deleteHistoricoStoke(id);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(HistoricoStokeResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    
    }
    
}
