import java.time.LocalDate;

public class Exam {
    private String nom;
    private LocalDate date;

    // Constructor
    public Exam(String nom, LocalDate date) {
        this.nom = nom;
        this.date = date;
    }

    // Getter for 'nom'
    public String getNom() {
        return nom;
    }

    // Setter for 'nom'
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter for 'date'
    public LocalDate getDate() {
        return date;
    }

    // Setter for 'date'
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return "name : " + nom + ", date : " + date; 
    }
}
