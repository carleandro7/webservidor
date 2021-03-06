/*
 * Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.great.helpful;

/**
 * Constants used on GCM service communication.
 */
public final class Constants {

   /**
   * Chave da API do Google GCM
   */
   public static final String API_KEY = "AIzaSyCmu6aVxeFh6ZQ_u1J7DXg_fndmeXGP83g";
   
   public static final int JOGO_NEWJOGO = 1;
   public static final int JOGO_LISTAGRUPOS = 2;
   public static final int JOGO_LISTAEXECUTANDO = 3;
   
   public static final int GRUPO_INSERIRPARTICIPANTE = 1;
   public static final int GRUPO_LISTAARQUIVOS = 2;
   public static final int GRUPO_MECANICAATUAL = 3;
   public static final int GRUPO_SETSTATUSMECANICA = 4;
   public static final int JOGADOR_SETLOCALIZACAO = 5;
   public static final int JOGADOR_ENVIARLOCALIZACAO = 6;
 
  private Constants() {
    throw new UnsupportedOperationException();
  }

}
