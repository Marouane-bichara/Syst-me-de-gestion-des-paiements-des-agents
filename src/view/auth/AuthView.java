package view.auth;

import java.util.Scanner;

public class AuthView {


    private Scanner scanner;
    private LoginResponsableDepartement loginResponsableDepartement;
    private LoginDirecteurView loginDirecteurView;
    private AuthAgentView authAgentView;

    public AuthView()
    {
        this.scanner = new Scanner(System.in);
        this.loginResponsableDepartement = new LoginResponsableDepartement();
        this.loginDirecteurView = new LoginDirecteurView();
        this.authAgentView = new AuthAgentView();
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
            System.out.println("3. Login As Agent");
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
                    loginDirecteurView.LoginDirec();
                    break;
                case 3:
                    authAgentView.authAgent();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }


        }


    }
}
