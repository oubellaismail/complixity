import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Etudiant{
    private String nom;
    private String prenom;
    Map<Examen, Double> notes = new HashMap<>();

    public Etudiant(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        notes = new HashMap<Examen, Double>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNote(Examen examen, Double note){
        this.notes.put(examen, note);
    }

    public void setNotes(HashMap<Examen, Double> notes){
        this.notes.putAll(notes);
    }

    @Override
    public String toString(){
        return "nom : " + nom + ", prenom : " + prenom; 
    }
}