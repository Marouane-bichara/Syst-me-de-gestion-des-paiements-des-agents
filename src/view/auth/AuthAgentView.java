package view.auth;

import controller.auth.AuthAgentNormalController;
import controller.auth.AuthDirecController;
import model.Agent;
import validationInput.ValidationInput;
import view.directeurView.DirectureView;
import view.normalAgent.NormalAgentView;

import java.util.Scanner;

public class AuthAgentView {

    private Scanner scanner;
    private ValidationInput validationInput;
    private AuthAgentNormalController authAgentNormalController;
    private NormalAgentView normalAgentView;


    public AuthAgentView()
    {
        this.scanner = new Scanner(System.in);
        this.validationInput = new ValidationInput();
        this.authAgentNormalController = new AuthAgentNormalController();
        this.normalAgentView = new NormalAgentView();
    }

    public void authAgent()
    {

        String email ;
        String password ;
        boolean isTrue = true ;

        while (isTrue){


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
                Agent agent = authAgentNormalController.authAgentNormal(email , password);

                if (agent == null) {
                    System.out.println("***********************************");
                    System.out.println("                                    ");
                    System.out.println("No agent found.");
                    System.out.println("                                      ");
                    System.out.println("************************************");
                    System.out.println("                                     ");
                    System.out.println("Please try again.");
                    continue;
                }else {
                    normalAgentView.noramlAgentView(agent);
                }
                break;
            }else {
                System.out.println(resault);
                System.out.println("Please try again.");
            }
        }
    }
}
