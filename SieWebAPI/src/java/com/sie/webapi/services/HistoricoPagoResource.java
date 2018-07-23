/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.webapi.services;

import com.sie.bl.HistoricoPagoBL;
import com.sie.dto.HistoricoPago;
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
@Path("historicopago")
public class HistoricoPagoResource {

    HistoricoPagoBL histopa;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HistoricoPagoResource
     */
    public HistoricoPagoResource() {
    }

    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<HistoricoPago> getid(@PathParam("id") Integer id) {
        
        histopa = new HistoricoPagoBL();
        
        return histopa.getHistoricoPago(id);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String create(HistoricoPago hp) {
        
        histopa = new HistoricoPagoBL();
        try {
            
            histopa.insertHistoricoPago(hp);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(HistoricoPagoResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
    

    /**
     * PUT method for updating or creating an instance of PersonaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(HistoricoPago hp) {
        
        histopa = new HistoricoPagoBL();
        
        try {
            
            histopa.updateHistoricoPago(hp);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(HistoricoPagoResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
	
	
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String delete(Integer id){
    
        histopa = new HistoricoPagoBL();
        
        try {
            
            histopa.deleteHistoricoPago(id);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(HistoricoPagoResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    
    }
    
}
