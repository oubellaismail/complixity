import java.util.Date;

public class Exam {
    private String nom;
    private Date date;

    // Constructor
    public Exam(String nom, Date date) {
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
    public Date getDate() {
        return date;
    }

    // Setter for 'date'
    public void setDate(Date date) {
        this.date = date;
    }
}
