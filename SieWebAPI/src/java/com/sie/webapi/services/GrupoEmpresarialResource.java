/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.webapi.services;

import com.sie.bl.GrupoEmpresarialBL;
import com.sie.dto.GrupoEmpresarial;
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
@Path("grupoempresarial")
public class GrupoEmpresarialResource {

    GrupoEmpresarialBL grupoe;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GrupoEmpresarialResource
     */
    public GrupoEmpresarialResource() {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<GrupoEmpresarial> getall() {
        
        grupoe = new GrupoEmpresarialBL();
        
        return grupoe.getContrato();
    }
	
	
	@GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<GrupoEmpresarial> getid(@PathParam("id") Integer id) {
        
        grupoe = new GrupoEmpresarialBL();
        
        return grupoe.getContratoNit(id);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String create(GrupoEmpresarial ge) {
        
        grupoe = new GrupoEmpresarialBL();
        try {
            
            grupoe.insertGrupoEmpresarial(ge);
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
    public String update(GrupoEmpresarial ge) {
        
        grupoe = new GrupoEmpresarialBL();
        
        try {
            
            grupoe.updateGrupoEmpresarial(ge);
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
    
        grupoe = new GrupoEmpresarialBL();
        
        try {
            
            grupoe.deleteGrupoEmpresarial(id);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(PersonaResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    
    }
    
}
