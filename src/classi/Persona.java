package classi;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Persona {
    private int id, idCittaNascita, idSport;
    private String nome, cognome, cf;
    private LocalDate dataNascita;

    public Persona() {
    }

    public Persona(int id, String nome, String cognome, String cf, LocalDate dataNascita, int idCittaNascita, int idSport) {
        this.id = id;
        this.idCittaNascita = idCittaNascita;
        this.idSport = idSport;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.dataNascita = dataNascita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCittaNascita() {
        return idCittaNascita;
    }

    public void setIdCittaNascita(int idCittaNascita) {
        this.idCittaNascita = idCittaNascita;
    }

    public int getIdSport() {
        return idSport;
    }

    public void setIdSport(int idSport) {
        this.idSport = idSport;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }
    
    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }
    
    public String datiPersona()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        String dateString = dataNascita.format(formatter);
        
        return nome + " " + cognome + " " + dateString;
    }
    
}
