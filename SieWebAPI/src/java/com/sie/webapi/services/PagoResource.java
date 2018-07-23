/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.webapi.services;

import com.sie.bl.PagoBL;
import com.sie.dto.Pago;
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
@Path("pago")
public class PagoResource {

    PagoBL pgao;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PagoResource
     */
    public PagoResource() {
    }

    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Pago> getall() {
        
        pgao = new PagoBL();
        
        return pgao.getPago();
    }
	
	
	@GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Pago> getid(@PathParam("id") Integer id) {
        
        pgao = new PagoBL();
        
        return pgao.getPagoContrato(id);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String create(Pago p) {
        
        pgao = new PagoBL();
        try {
            
            pgao.insertPago(p);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(PagoResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
    

    /**
     * PUT method for updating or creating an instance of PersonaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(Pago p) {
        
        pgao = new PagoBL();
        
        try {
            
            pgao.updatePago(p);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(PagoResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
	
	
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String delete(Integer id){
    
        pgao = new PagoBL();
        
        try {
            
            pgao.deletePago(id);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(PagoResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    
    }
    
}
