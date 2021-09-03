package logica;
import Classi.Risultato;
import static Gestione_File.Scrittura.*;
import static Gestione_File.Lettura.*;
import classi.Persona;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestionePersona extends Risultato {

    String nomeFile = "persone.txt";    
    String sep = ",";
    
    /**
     * Inserimento di una nuova persona
     * @param p la nuova persona da inserire nel file
     */
    public void inserisciPersona(Persona p)
    {
        try
        {
            GestioneId g = new GestioneId();
            int newId = g.getIdPersona();
            p.setId(newId);
            
            String dati = PreparaDati(p);
            Scrittura(dati, nomeFile, true);
            
            // extends Risultato permette di accedere direttamente ai metodi pubblici della classe Risultato
            setSuccesso(true);
        }
        catch (Exception ex)
        {
            setSuccesso(false);
            setDescrizioneErrore(ex.toString());
        }
    }        
    
    /**
     * Modifica deii dati di una persona data la sua posizione
     * @param posPersona la posizione della persona di cui modificare i dati
     * @param p la nuova persona per che aggiorna i dati alla posizione posPersona
     */
    public void modificaPersona(int posPersona, Persona p)
    {
        try
        {
            // preparo la stringa che sostituirà quella esistente nel file alla posizione posPersona
            String dati = PreparaDati(p);
            ModificaRiga(nomeFile, posPersona, dati);
            setSuccesso(true);
        }
        catch (Exception ex)
        {
            setSuccesso(false);
            setDescrizioneErrore(ex.toString());
        }
    }

    /**
     * Eliminazione di una persona data la sua posizione
     * @param posPersona la posizione della persona da eliminare
     */
    public void eliminaPersona(int posPersona)
    {
        // richiamo la funzione Elimina della libreria
        try
        {
            EliminaRiga(nomeFile, posPersona);
            setSuccesso(true);
        }
        catch (Exception ex)
        {
            setSuccesso(false);
            setDescrizioneErrore(ex.toString());
        }
    }
    
    /**
     * Restituisce una lista di oggetti di tipo Persona leggendoli da un file
     * @return la lista di oggetti di tipo Persona
     */
    public ArrayList<Persona> elencoPersona()
    {
        ArrayList<Persona> lista = new ArrayList<Persona>();
        File f = new File(nomeFile);
        if(!f.exists()) 
        {
            setSuccesso(true);
            return lista;
        }

        try
        {
            ArrayList<String> listaStr = LeggiBR(nomeFile);

            for (int i=0; i<listaStr.size(); i++)
            {
                String[] vettRiga = listaStr.get(i).split(sep, -1);
                
                Persona p = new Persona();
                p.setId(Integer.parseInt(vettRiga[0]));
                p.setNome(vettRiga[1]);
                p.setCognome(vettRiga[2]);
                p.setCf(vettRiga[3]);
                String[] vettData = vettRiga[4].split("-");
                p.setDataNascita(LocalDate.of(Integer.parseInt(vettData[0]),Integer.parseInt(vettData[1]),Integer.parseInt(vettData[2])));
                                
                lista.add(p);
            }
            setSuccesso(true);
            return lista;
        }
        catch (Exception ex)
        {
            setSuccesso(false);
            setDescrizioneErrore(ex.toString());
            return new ArrayList<Persona>();
        }
    }      
    
    /**
     * Restituisce un oggetto di tipo Persona leggendolo da una riga di un file data la posizione
     * @param posPersona la posizione della persona nel file
     * @return l'oggetto di tipo Persona ricercato int id, String nome, String cognome, String cf, LocalDate dataNascita, int idCittaNascita
     */
    public Persona caricaPersona(int posPersona)
    {
        Persona p = new Persona();
        File f = new File(nomeFile);
        if(!f.exists()) 
        {
            setSuccesso(true);
            return p;
        }
        
        try
        {
            String strPos = LeggiRigaPos(nomeFile, posPersona);
            String[] vettRiga = strPos.split(sep, -1);
            
            p.setId(Integer.parseInt(vettRiga[0]));
            p.setNome(vettRiga[1]);
            p.setCognome(vettRiga[2]);
            p.setCf(vettRiga[3]);
            String[] vettData = vettRiga[4].split("-");
            p.setDataNascita(LocalDate.of(Integer.parseInt(vettData[0]),Integer.parseInt(vettData[1]),Integer.parseInt(vettData[2])));
                
            setSuccesso(true);
            return p;
        }
        catch (Exception ex)
        {
            setSuccesso(false);
            setDescrizioneErrore(ex.toString());
            return new Persona();
        }
    }
    
    /**
     * Prepara la stringa contenente i dati della Città da essere inseriti nel file
     * @param p l'oggetto di tipo Città
     * @param sep il carattere separatore
     * @return la stringa contenente i dati della persona separati dal separatore sep
     */
    private String PreparaDati(Persona p)
    {              
        String dati = String.valueOf(p.getId()) + sep + p.getNome() + sep + p.getCognome()
                 + sep + p.getCf() + sep + p.getDataNascita().toString();
        return dati;
    }
}
