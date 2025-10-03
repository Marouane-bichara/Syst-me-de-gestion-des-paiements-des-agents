package view.directeurView;

import controller.deirecture.DirectureController;
import validationInput.ValidationUtils;

import java.util.Scanner;

public class AssignAgentToDepartementView {


    private DirectureController directureController;
    private Scanner scanner;

    public AssignAgentToDepartementView()
    {
        this.scanner = new Scanner(System.in);
        this.directureController = new DirectureController();
    }




    public void assignAgent()
    {

        int choice ;
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("1. Assign an exesting agent.");
        System.out.println("2. Create new responsable.");
        System.out.print("Enter your choice : ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice)
        {
            case 1:
                System.out.print("Enter Agent last name : ");
                String agentLastName = scanner.nextLine();

                System.out.print("Enter agent name : ");
                String agentname = scanner.nextLine();

                System.out.print("Enter departement name : ");
                String departementName = scanner.nextLine();


                String rs = directureController.assignExestingAgentToDepartement(agentname , agentLastName , departementName);

                System.out.println("***************");
                System.out.println("               ");
                System.out.println(rs);
                System.out.println("               ");
                System.out.println("***************");

                break;
            case 2:
                System.out.print("Enter Responsable last name : ");
                String lastNameRes = scanner.nextLine();
                System.out.print("Enter Responsable first name : ");
                String NameRes = scanner.nextLine();

                String emailres;
                while (true)
                {
                    System.out.print("Enter Responsable email : ");
                    emailres = scanner.nextLine();
                    if(ValidationUtils.isValidEmail(emailres))break;
                    System.out.println("Invalid email.");
                }



                String motDePasseRes;

                while (true)
                {
                    System.out.print("Enter Responsable motDePasse : ");
                    motDePasseRes = scanner.nextLine();
                    if(ValidationUtils.isValidPassword(motDePasseRes))break;
                    System.out.println("Invalid password pick another one.");
                }

                String typeAgent = "RESPONSABLE_DEPARTEMENT";
                System.out.print("Enter Responsable Departement : ");
                String departementRespo = scanner.nextLine();
                String Resault  = directureController.addnewRespo(lastNameRes , NameRes , emailres ,motDePasseRes , typeAgent , departementRespo);

                System.out.println("***********");
                System.out.println("           ");
                System.out.println(Resault);
                System.out.println("           ");
                System.out.println("***********");

                break;
        }
    }

}
