/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.webapi.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Brayan A
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.sie.webapi.services.BeneficiarioAfiliadoResource.class);
        resources.add(com.sie.webapi.services.ContratoPlanResource.class);
        resources.add(com.sie.webapi.services.ContratoResource.class);
        resources.add(com.sie.webapi.services.GrupoEmpresarialResource.class);
        resources.add(com.sie.webapi.services.HistoricoPagoResource.class);
        resources.add(com.sie.webapi.services.HistoricoStokeResource.class);
        resources.add(com.sie.webapi.services.InformacionAdicionalResource.class);
        resources.add(com.sie.webapi.services.PagoResource.class);
        resources.add(com.sie.webapi.services.ParentescoResource.class);
        resources.add(com.sie.webapi.services.PersonaResource.class);
        resources.add(com.sie.webapi.services.PersonaRolPersonaResource.class);
        resources.add(com.sie.webapi.services.PlanResource.class);
        resources.add(com.sie.webapi.services.RolPersonaResource.class);
        resources.add(com.sie.webapi.services.RutaResource.class);
        resources.add(com.sie.webapi.services.SedeResource.class);
        resources.add(com.sie.webapi.services.StokeResource.class);
        resources.add(com.sie.webapi.services.TalonarioResource.class);
        resources.add(com.sie.webapi.services.UsuarioResource.class);
    }
    
}
