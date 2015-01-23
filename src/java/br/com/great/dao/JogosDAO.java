/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.great.dao;

import br.com.great.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 *
 * @author carleandro
 */
public class JogosDAO extends ConnectionFactory{
    
    private static JogosDAO instance;
                /**
	 * 
	 * Método responsável por criar uma instancia da classe JogosDAO (Singleton)
	 *
	 * @return static
	 * @author Carleandro Noleto
	 * @since 27/11/2014
	 * @version 1.0
	 */
	public static JogosDAO getInstance(){
		if(instance == null)
			instance = new JogosDAO();
		return instance;
	}
	
	/**
	 * 
	 * Método responsável por listar todos os jogos do banco
	 *
	 * @return JSONArray
	 * @author Carleandro Noleto
	 * @since 27/11/2014
	 * @version 1.0
	 */
	public JSONArray listarTodos(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONArray jogos = null;
		Connection conexao = criarConexao();
		try {
                        jogos= new JSONArray();
                        pstmt = conexao.prepareStatement("select * from jogos order by id");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				JSONObject jogo = new JSONObject();
                                jogo.put("id",rs.getInt("id"));
                                jogo.put("nome",rs.getString("nome"));
                                jogo.put("icone",rs.getString("icone"));
                                jogo.put("longitude",rs.getString("longitude"));
                                jogo.put("latitude",rs.getString("latitude"));
				jogos.put(jogo);
			}
			
		} catch (SQLException | JSONException e) {
			System.out.println("Erro ao listar todos os jogos: " + e.getMessage());
                } finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return jogos;
	}
        /**
	 * Método responsável por listar todos os jogos perto de um local com distancia definida
         *
         * @param latitude String
         * @param longitude String
         * @param distancia String
	 * @return JSONArray
	 * @author Carleandro Noleto
	 * @since 27/11/2014
	 * @version 1.0
	 */
        public JSONArray getJogos(String latitude, String longitude, String distancia){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONArray jogos = null;
		Connection conexao = criarConexao();
		try {
                        jogos= new JSONArray();
                        //distancia em KM
                        String sql = 
                                "SELECT  ((3956 * 2 * ASIN(SQRT(POWER(SIN((abs("+latitude+") - abs(dest.latitude)) *  "
                                + " pi()/180 / 2),2) + COS(abs("+latitude+") * pi()/180 ) * COS(abs(dest.latitude) * pi()/180) "
                                + "* POWER(SIN((abs("+longitude+") - abs(dest.longitude)) * 	pi()/180 / 2), 2)))) * 1.609344) as "
                                + "distancia, nome, id, icone FROM jogos dest having distancia < "+distancia+" ORDER BY distancia limit 100";
                        pstmt = conexao.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				JSONObject jogo = new JSONObject();
                                jogo.put("id",rs.getInt("id"));
                                jogo.put("nome",rs.getString("nome"));
                                jogo.put("icone",rs.getString("icone"));
				jogos.put(jogo);
			}
			
		} catch (SQLException | JSONException e) {
			System.out.println("Erro ao listar todos os jogos em uma distancia em KM: " + e.getMessage());
                } finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return jogos;
	}
        
    /**
     * @param idJogo String
     * @return JSONArray
     */
    public JSONArray getDadosIniciais(String idJogo){
		JSONArray jogos = null;
		try {
                        jogos= new JSONArray();
                        
                        jogos.put(new GruposDAO().getTodos(idJogo));                        
                        jogos.put(new MissoesDAO().getTodos(idJogo));
                        jogos.put(new MecanicasDAO().getTodos(idJogo));
                } catch (Exception e) {
			System.out.println("Erro ao listar todos os dados iniciais do jogo: " + e.getMessage());
                }
                
		return jogos;
    }
        
}