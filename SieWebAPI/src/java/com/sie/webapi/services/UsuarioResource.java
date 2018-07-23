/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.webapi.services;

import com.sie.bl.UsuarioBL;
import com.sie.dto.Usuario;
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
@Path("Usuario")
public class UsuarioResource {

    UsuarioBL usuario;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioResource
     */
    public UsuarioResource() {
    }

    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> getall() {
        
        usuario = new UsuarioBL();
        
        return usuario.getUsuario();
    }
    
    @POST
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String create(Usuario u,@PathParam("id") Integer id) {
        
        usuario = new UsuarioBL();
        try {
            
            usuario.insertUsuario(u,id);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(UsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
    

    /**
     * PUT method for updating or creating an instance of PersonaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(Usuario u) {
        
        usuario = new UsuarioBL();
        
        try {
            
            usuario.updatePersonas(u);
            return "exito!";
        } catch (Exception ex) {
            Logger.getLogger(UsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
	
	
//    @DELETE
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public String delete(Integer id){
//    
//        usuario = new UsuarioBL();
//        
//        try {
//            
//            return "exito!";
//        } catch (Exception ex) {
//            Logger.getLogger(UsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
//            return ex.getMessage();
//        }
//    
//    }
    
}
