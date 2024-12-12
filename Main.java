import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Etudiant> etds = new ArrayList<Etudiant>();
        ArrayList<Filiere> filieres = new ArrayList<Filiere>();
        ArrayList<Examen> examens = new ArrayList<Examen>();

        System.out.println("hello bro to our program so please feel free to use it ok ?");

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Ajouter étudiants");
            System.out.println("2. Ajouter filiere");
            System.out.println("3. Ajouter examen");
            System.out.println("4. Display etudiants");
            System.out.println("5. Display filires");
            System.out.println("6. Quitter");
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
                    System.out.println("fix");
                    break;
                case 4:
                    displayEtudiants(etds);
                    break;
                case 5:
                    displayFilieres(filieres);
                    break;
                case 6:
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

    public static void addEtudiant(ArrayList<Etudiant> etds, Scanner scanner, ArrayList<Filiere> filieres) {

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

        Filiere fil = filieres.get(index - 1);

        System.out.print("Give nom : ");
        String nom = scanner.next();
        System.out.print("Give prenom : ");
        String prenom = scanner.next();
        Etudiant etd = new Etudiant(nom, prenom);
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

}
