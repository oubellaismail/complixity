import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Etudiant{
    private String nom;
    private String prenom;
    private String cne;
    HashMap<Exam, Double> notes = new HashMap<>();

    public Etudiant(String nom, String prenom, String cne){
        this.nom = nom;
        this.prenom = prenom;
        this.cne = cne;
        notes = new HashMap<Exam, Double>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNote(Exam exam, Double note){
        this.notes.put(exam, note);
    }

    public void setNotes(HashMap<Exam, Double> notes){
        this.notes.putAll(notes);
    }

    @Override
    public String toString() {
        StringBuilder notesString = new StringBuilder();
        for (Map.Entry<Exam, Double> entry : notes.entrySet()) {
            notesString.append(entry.getKey().toString())
                       .append(": ")
                       .append(entry.getValue())
                       .append("\n");
        }
        
        return "Student Details:\n" +
               "Nom: " + nom + "\n" +
               "Prenom: " + prenom + "\n" +
               "CNE: " + cne + "\n" +
               "Notes:\n" + notesString.toString();
    }
}