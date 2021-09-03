/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import Check.Check_Liste.*;
import static Gestione_File.Lettura.*; 
import java.util.ArrayList;
import Classi.Risultato;


public class GestioneConti extends Risultato {
    public String nomefaaaf = "grandipeni.txt";
 
    public boolean ControlloUser(String nomecontrollato){
        ArrayList<String> letto = new ArrayList();
        
        try{
        
        letto = LeggiBR(nomefaaaf);
        for(int i=0; i<letto.size();i++){
            String ciao = letto.get(i);
            String[] vet = ciao.split(",");
            if(vet[2]==nomecontrollato){
                return true;
            }
        }
        setSuccesso(true);
        }  
        catch(Exception ex){
            System.out.println("hai perso i peni :( ");
            setSuccesso(false);
            setDescrizioneErrore(ex.toString());
            return true;
        }
        return false;
    }
    
}
