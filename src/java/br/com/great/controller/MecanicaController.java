/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.great.controller;

import br.com.great.dao.MecanicasDAO;
import br.com.great.model.Mecanica;
import java.util.ArrayList;
import org.json.JSONArray;

/**
 * Classe responsavel por fazer o controle entre os serviços oferecidos pelo jogos
 * no banco de dados com os eventos relacionados a cada jogo
 * @author carleandro
 */
public class MecanicaController {
    
    /**
    * Método responsável por get em uma Mecanica de uma missao de um jogo do banco de dados
     * @param mecanica_id String
     * @return JSONArray
     */
    public JSONArray getMecania(String mecanica_id){
        System.out.println("Enviando para o GIT");
        return MecanicasDAO.getInstance().getMecania(mecanica_id);
    }
    
    /**
    * Método responsável lista todas as mecanicas de uma missao
     * @param missao_id int
     * @return ArrayList Mecanica
     */
    public ArrayList<Mecanica> getMecaniaMissao(int missao_id){
        System.out.println("Enviando para o GIT");
        return MecanicasDAO.getInstance().getMecaniaMissao(missao_id);
    }
}
