/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dao.PlanDAO;
import com.sie.dto.Plan;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zarhell
 */
public class PlanBL {

    public List<Plan> getPlan() {
        try {
            PlanDAO testPlan = new PlanDAO();
            testPlan.getPlan();
            
        } catch (SQLException ex) {
            Logger.getLogger(PlanBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    

    public void insertPlan(Plan pl) {
        try {
            PlanDAO testPlan = new PlanDAO();
            testPlan.insertPlan(pl);
        } catch (SQLException ex) {
            Logger.getLogger(PlanBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePlan(Plan pl) {
        try {
            PlanDAO testPlan = new PlanDAO();
            testPlan.updatePlan(pl);
        } catch (SQLException ex) {
            Logger.getLogger(PlanBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void deletePlan(Integer id) {
        try {
            PlanDAO testPlan = new PlanDAO();
            testPlan.deletePlan(id);
        } catch (SQLException ex) {
            Logger.getLogger(PlanBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
