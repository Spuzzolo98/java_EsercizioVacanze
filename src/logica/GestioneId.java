
package logica;

import java.util.ArrayList;
import Classi.Risultato;
import static Gestione_File.Scrittura.*;
import static Gestione_File.Lettura.*;

public class GestioneId extends Risultato {
    
    String nomeFileId = "fileId.txt";
    
    private void aggiornaFileId(String idPersona, String idCitta, String idSport) throws Exception
    {
        Scrittura(idPersona, nomeFileId, false);
        Scrittura(idCitta, nomeFileId, true);
        Scrittura(idSport, nomeFileId, true);
    }
    
    public int getIdCitta()
    {
        try
        {
            ArrayList<String> listaStr = LeggiBR(nomeFileId);
            String idPersoneStr = listaStr.get(0);
            String idCittaStr = listaStr.get(1);
            String idSportStr = listaStr.get(2);

            int idCitta = Integer.parseInt(idCittaStr) + 1;
            
            aggiornaFileId(idPersoneStr, String.valueOf(idCitta), idSportStr); 
            
            return idCitta;
        }
        catch (Exception ex)
        {
            setSuccesso(false);
            setDescrizioneErrore(ex.toString());
            return 0;
        }
    }

    public int getIdSport()
    {
        try
        {
            ArrayList<String> listaStr = LeggiBR(nomeFileId);
            String idPersoneStr = listaStr.get(0);
            String idCittaStr = listaStr.get(1);
            String idSportStr = listaStr.get(2);

            int idSport = Integer.parseInt(idSportStr) + 1;
            
            aggiornaFileId(idPersoneStr, idCittaStr, String.valueOf(idSport)); 
            
            return idSport;
        }
        catch (Exception ex)
        {
            setSuccesso(false);
            setDescrizioneErrore(ex.toString());
            return 0;
        }
    }
    
    public int getIdPersona()
    {
        try
        {
            ArrayList<String> listaStr = LeggiBR(nomeFileId);
            String idPersoneStr = listaStr.get(0);
            String idCittaStr = listaStr.get(1);
            String idSportStr = listaStr.get(2);

            int idPersona = Integer.parseInt(idPersoneStr) + 1;
            
            aggiornaFileId(String.valueOf(idPersona), idCittaStr, idSportStr); 
            
            return idPersona;
        }
        catch (Exception ex)
        {
            setSuccesso(false);
            setDescrizioneErrore(ex.toString());
            return 0;
        }
    }
}
