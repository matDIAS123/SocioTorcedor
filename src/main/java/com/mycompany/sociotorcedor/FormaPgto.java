/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sociotorcedor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author User
 */
public class FormaPgto {
        private Integer id;
    private String descr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
    
    public static List<FormaPgto> buscaFormasPgto() throws Exception {
        DBController db = new DBController();
        ResultSet rset;
        List<FormaPgto> formas = new ArrayList<>();
        
        
        db.conectar();
        rset = db.executeQuery("SELECT * FROM FormaPgto");
            
        try {
            while (rset.next()) {
                FormaPgto f = new FormaPgto();
                f.id = rset.getInt("id");
                f.descr = rset.getString("descr");

                formas.add(f);
            }
        } catch (SQLException ex) {
            throw new Exception("Erro ao percorrer resultados!");
        }
            
        db.desconectar();
                
        return formas;
    }
}
