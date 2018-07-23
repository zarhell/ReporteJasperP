/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.webapi.services;

import com.sie.bl.BeneficiarioAfiliadoBL;
import com.sie.dto.BeneficiarioAfiliado;
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
@Path("beneficiarioafiliado")
public class BeneficiarioAfiliadoResource {

    BeneficiarioAfiliadoBL benafi;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BeneficiarioAfiliadoResource
     */
    public BeneficiarioAfiliadoResource() {
    }

        /**
     * Retrieves representation of an instance of com.sie.webapi.services.InformacionAdicionalResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<BeneficiarioAfiliado> getid(@PathParam("id") Integer id) {
        
        benafi = new BeneficiarioAfiliadoBL();
        
        return benafi.getBeneficiarioAfiliado(id);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public String create(BeneficiarioAfiliado ba) {
        
        benafi = new BeneficiarioAfiliadoBL();
        try {
            
            benafi.insertBeneficiarioAfiliado(ba);
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
    public String update(BeneficiarioAfiliado ba) {
        
        benafi = new BeneficiarioAfiliadoBL();
        
        try {
            
            benafi.updateBeneficiarioAfiliado(ba);
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
    
        benafi = new BeneficiarioAfiliadoBL();
        
        try {
            
            benafi.deleteBeneficiarioAfiliado(id);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(PersonaResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    
    }   
    
}
