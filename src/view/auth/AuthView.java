package view.auth;

import controller.agent.AgentController;

import java.util.Scanner;

public class AuthView {


    private Scanner scanner;
    private LoginResponsableDepartement loginResponsableDepartement;

    public AuthView()
    {
        this.scanner = new Scanner(System.in);
        this.loginResponsableDepartement = new LoginResponsableDepartement();
    }

    public void authView()
    {

        boolean isTrue = true;
        int choice;



        while (isTrue)
        {
            System.out.println("****************************************");
            System.out.println("                                        ");
            System.out.println("Gestion d’une Banque Digitale en Java");
            System.out.println("                                        ");
            System.out.println("****************************************");
            System.out.println("                                        ");

            System.out.println("1. Login As RESPONSABLE DEPARTEMENT");
            System.out.println("2. Login As DIRECTEUR");
            System.out.println("3. Login As STAGIARE");
            System.out.println("4. Exite.");
            System.out.print("Enter Your Choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    loginResponsableDepartement.LoginRespo();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }


        }


    }
}
