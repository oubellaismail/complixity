import java.util.ArrayList;

public class Filiere {
    private String nom;
    private ArrayList<Etudiant> etudiants;
    private ArrayList<Exam> examens;


    public Filiere(String nom) {
        this.nom = nom;
        this.etudiants = new ArrayList<>();  
        this.examens = new ArrayList<>(); 
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }


    //add etudiant
    public void setEtudiant(Etudiant etudiant){
        this.etudiants.add(etudiant);
    }

    //add list of etudiants
    public void setEtudiants(ArrayList<Etudiant> etds){
        this.etudiants.addAll(etds);
    }

    

    public ArrayList<Exam> getExamens() {
        return examens;
    }

    public void setExamen(Exam Examens){
        this.examens.add(Examens);
    }

    //add list of Examenss
    public void setExamens(ArrayList<Exam> etds){
        this.examens.addAll(etds);
    }

    @Override
    public String toString(){
        String etdsString = "";
        for(Etudiant etd : etudiants){
            etdsString += etd.toString() + "\n";
        }

        String examsString = "";
        for(Exam exam : examens){
            examsString += exam.toString() + "\n";
        }

        return "nom filiere : " + nom + "\nEtudiants : " + etdsString + "\nExams : " + examsString;
    }
}