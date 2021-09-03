
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
