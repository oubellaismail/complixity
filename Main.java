import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Etudiant> etds = new ArrayList<Etudiant>();
        ArrayList<Filiere> filieres = new ArrayList<Filiere>();
        ArrayList<Exam> exams = new ArrayList<Exam>();

        System.out.println("hello bro to our program so please feel free to use it ok ?");

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Ajouter étudiants");
            System.out.println("2. Ajouter filiere");
            System.out.println("3. Ajouter examen");
            System.out.println("4. Display etudiants");
            System.out.println("5. Display filires");
            System.out.println("6. Display exams");
            System.out.println("7. Add notes");
            System.out.println("8. Quitter");
            System.out.print("Votre choix: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addEtudiant(etds, scanner, filieres);
                    break;
                case 2:
                    addFiliere(filieres, scanner);
                    break;
                case 3:
                    addExam(exams, filieres, scanner);
                    break;
                case 4:
                    displayEtudiants(etds);
                    break;
                case 5:
                    displayFilieres(filieres);
                    break;
                case 6:
                    dispalyExams(exams);
                    break;
                case 7:
                    addNotes(filieres, exams, etds, scanner);
                    return;
                case 8:
                    System.out.println("Good bye !");
                    return;
                default:
                    System.out.println("Sorry, unexisted option ...");
                    break;
            }
        }
    }

    public static void addFiliere(ArrayList<Filiere> filieres, Scanner scanner) {

        System.out.print("Please add filiere name : ");
        String name = scanner.next();

        Filiere fil = findFiliere(filieres, name);

        if (fil == null) {
            filieres.add(new Filiere(name));
        } else {
            System.out.println("Filiere already exists ... !");
            return;
        }

    }

    public static Filiere findFiliere(ArrayList<Filiere> filieres, String name) {
        for (Filiere fil : filieres) {
            if (fil.getNom().equalsIgnoreCase(name)) {
                return fil;
            }
        }

        return null;
    }

    public static void displayFilieresFun(ArrayList<Filiere> filieres) {

        for (int i = 0; i < filieres.size(); i++) {
            System.out.println((i + 1) + ". " + filieres.get(i).getNom());
        } 
    }

    public static Filiere checkFiliere(ArrayList<Filiere> filieres, Scanner scanner){
        if (filieres.size() == 0) {
            System.out.println("Try to fill up the filiere list first ...! ");
            addFiliere(filieres, scanner);
        }

        int index; 
        do {
            System.out.println("Choose filiere from this list: ");
            displayFilieresFun(filieres);

            System.out.println();
            index = scanner.nextInt(); 
        } while (index > filieres.size() || index <= 0);

        return filieres.get(index - 1);
    }

    public static void addEtudiant(ArrayList<Etudiant> etds, Scanner scanner, ArrayList<Filiere> filieres) {

        Filiere fil = checkFiliere(filieres, scanner);

        System.out.print("Give nom : ");
        String nom = scanner.next();
        System.out.print("Give prenom : ");
        String prenom = scanner.next();
        System.out.print("Give cne : ");
        String cne = scanner.next();
        Etudiant etd = new Etudiant(nom, prenom, cne);
        etds.add(etd);
        fil.setEtudiant(etd);
    }

    public static void displayEtudiants(ArrayList<Etudiant> etds){
        for(Etudiant etd : etds){
            System.out.println(etds.toString());
        }
    }

    public static void displayFilieres(ArrayList<Filiere> filieres){
        for(Filiere filiere : filieres){
            System.out.println(filiere.toString());
        }
    }

    public static void addExam(ArrayList<Exam> exams, ArrayList<Filiere> filieres, Scanner scanner){
        Filiere fil = checkFiliere(filieres, scanner);
        System.out.print("Exam name : ");
        String name = scanner.next();

        LocalDate date = null;
        
        while (date == null) {
            System.out.print("Date (yyyy-MM-dd): ");
            String dateInput = scanner.next();

            try {
                date = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } 
            catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            }
        }

        Exam exam = new Exam(name, date);
        exams.add(exam);
        fil.setExamen(exam);
    } 
    
    public static void dispalyExams(ArrayList<Exam> exams){
        for(Exam exam : exams){
            System.out.println(exam.toString());
        }
    }

    public static void addNotes(ArrayList<Filiere> filieres, ArrayList<Exam> exams, ArrayList<Etudiant> etds, Scanner scanner){
        
        System.out.print("Provide the number of notes you wanna insert : ");
        int n = scanner.nextInt();

        HashMap <Exam, Double> notes = new HashMap<Exam, Double>();
        int choice;
        Etudiant etudiant = null;
        do{
            etudiant = findEtudiant(etds, scanner);
            System.out.println("the name of student found is : " + etudiant.getNom() + " " + etudiant.getPrenom());
    
            System.out.println("Is this the right student : ");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Your choice : ");
            choice = scanner.nextInt();
        }while(choice == 0);

        for(int i = 0; i < n ; i++){
            Exam exam = checkExam(filieres, exams, scanner);
            
            Filiere filiere = null;
            for(Filiere fil : filieres){
                ArrayList<Exam> filExams = fil.getExamens();
                if (filExams.contains(exam) == true) {
                    filiere = fil;
                }
            }
    
            if(filiere.getEtudiants().contains(etudiant) == false){
                System.out.println("Exam and choosen etudiant don't belong to the same filiere ... !");
                return;
            }
    
            System.out.print("Give note : ");
            Double note = scanner.nextDouble();

            notes.put(exam, note);
    
        }
        
        etudiant.setNotes(notes);

    }

    public static Etudiant findEtudiant(ArrayList<Etudiant> etds, Scanner scanner){
        System.out.print("Give cne : ");
        String name = scanner.next();

        for(Etudiant etd : etds){
            if(etd.getCne().equalsIgnoreCase(name)){
                return etd;
            }
        }
        return null;
    }

    public static Exam checkExam(ArrayList<Filiere> filieres,ArrayList<Exam> exams, Scanner scanner){
        if (exams.size() == 0) {
            System.out.println("Try to fill up the exmas list first ...! ");
            addExam(exams, filieres, scanner);
        }

        int index; 
        do {
            System.out.println("Choose exam from this list: ");
            dispalyExams(exams);

            System.out.println();
            index = scanner.nextInt(); 
        } while (index > filieres.size() || index <= 0);

        return exams.get(index - 1);
    }

    public static void displayExamsFun(ArrayList<Exam> exams) {

        for (int i = 0; i < exams.size(); i++) {
            System.out.println((i + 1) + ". " + exams.get(i).getNom());
        } 
    }

}
