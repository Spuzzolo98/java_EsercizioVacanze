/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Classi.Risultato;
import classi.Persona;
import java.util.ArrayList;


/**
 *
 * @author pietro
 */
public class FunzioniPersona extends Risultato {

    String nomeFile = "persone.txt";    
    String sep = ",";

    /**
     * Cerca la posizione del cf all'interno del file contenente i dati
     * @param cf il cf da ricercare
     * @return la posizione della persona con codice fiscale passato se esiste, altrimenti -1
     */
    public int posizionePersonaByCF(String cf)
    {
        GestionePersona g = new GestionePersona();
        ArrayList<Persona> lista = g.elencoPersona();
        
        if (g.isSuccesso())
        {
            int pos=-1;        
            for (int i=0; i<lista.size(); i++)
            {
                if (lista.get(i).getCf().equalsIgnoreCase(cf)) pos = i;
            }        
            setSuccesso(true);
            return pos;
        }
        else
        {
            setSuccesso(false);
            setDescrizioneErrore(g.getDescrizioneErrore());
            return -1;
        }
    }    
}
