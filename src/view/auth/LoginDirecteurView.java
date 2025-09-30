package view.auth;

import controller.auth.AuthDirecController;
import model.Agent;
import validationInput.ValidationInput;
import view.directeurView.DirectureView;

import java.util.Scanner;

public class LoginDirecteurView {



    private Scanner scanner;
    private ValidationInput validationInput;
    private AuthDirecController authDirecController;
    private DirectureView responsableView;

    public LoginDirecteurView()
    {
        this.scanner = new Scanner(System.in);
        this.validationInput = new ValidationInput();
        this.authDirecController = new AuthDirecController();
        this.responsableView = new DirectureView();
    }


    public void LoginDirec()
    {
        String email ;
        String password ;
        boolean isTrue = true ;

        while (isTrue)
        {
            System.out.println("****************************************");
            System.out.println("                                        ");
            System.out.println("Gestion d’une Banque Digitale en Java");
            System.out.println("                                        ");
            System.out.println("****************************************");
            System.out.println("                                        ");

            System.out.print("Enter your email : ");
            email = scanner.nextLine();
            System.out.print("Enter your password : ");
            password = scanner.nextLine();

            String resault = validationInput.validationInput(email , password);


            if (resault.equals("Input is valid")) {
                Agent agent = authDirecController.authDirecController(email , password);
                if (agent == null) {
                    System.out.println("***********************************");
                    System.out.println("                                    ");
                    System.out.println("No directer found with these credentials.");
                    System.out.println("                                      ");
                    System.out.println("************************************");
                    System.out.println("                                     ");
                    System.out.println("Please try again.");
                    continue;
                }else {
                    responsableView.responView(agent);
                }
                break;
            } else {
                System.out.println(resault);
                System.out.println("Please try again.");
            }
        }
    }

}
