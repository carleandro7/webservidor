/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.great.controller;

import br.com.great.dao.MecanicasDAO;
import org.json.JSONArray;

/**
 *
 * @author carleandro
 */
public class MecanicaController {
    
    /**
     *
     * @param mecanica_id String
     * @return JSONArray
     */
    public JSONArray getMecania(String mecanica_id){
        System.out.println("Enviando para o GIT");
                return MecanicasDAO.getInstance().getMecania(mecanica_id);
    }
    
}