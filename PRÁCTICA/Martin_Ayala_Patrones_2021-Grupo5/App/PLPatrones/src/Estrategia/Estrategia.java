/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrategia;

import Modelos.Jugador;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface Estrategia {
    
    public void ordena(List<Jugador> jugadores);
}
