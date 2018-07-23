/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dto.GrupoEmpresarial;
import java.util.List;

/**
 *
 * @author Zarhell
 */
public class GrupoEmpresarialBL {

    public List<GrupoEmpresarial> getContrato() {
        GrupoEmpresarialBL testGrupoEmpresarial = new GrupoEmpresarialBL();
        testGrupoEmpresarial.getContrato();
        return null;
    }

    public List<GrupoEmpresarial> getContratoNit(Integer nit) {
        GrupoEmpresarialBL testGrupoEmpresarial = new GrupoEmpresarialBL();
        testGrupoEmpresarial.getContratoNit(nit);
        return null;
    }

    public void insertGrupoEmpresarial(GrupoEmpresarial grupo) {
        GrupoEmpresarialBL testGrupoEmpresarial = new GrupoEmpresarialBL();
        testGrupoEmpresarial.insertGrupoEmpresarial(grupo);
    }

    public void updateGrupoEmpresarial(GrupoEmpresarial grupo) {
        GrupoEmpresarialBL testGrupoEmpresarial = new GrupoEmpresarialBL();
        testGrupoEmpresarial.updateGrupoEmpresarial(grupo);
        
    }

    public void deleteGrupoEmpresarial(Integer grupo) {
        GrupoEmpresarialBL testGrupoEmpresarial = new GrupoEmpresarialBL();
        
        testGrupoEmpresarial.deleteGrupoEmpresarial(grupo);
    }
}
