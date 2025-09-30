package view.auth;

import controller.auth.AuthRespoController;
import model.Agent;
import validationInput.ValidationInput;
import view.agentResponsable.AgentView;

import java.util.Scanner;

public class LoginResponsableDepartement {



    private Scanner scanner;
    private ValidationInput validationInput;
    private AuthRespoController authRespoController;
    private AgentView agentView;


    public LoginResponsableDepartement()
    {
        this.scanner = new Scanner(System.in);
        this.authRespoController = new AuthRespoController();
        this.validationInput = new ValidationInput();
        this.agentView = new AgentView();
    }


    public void LoginRespo()
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
                Agent agent = authRespoController.authRespController(email , password);
                if (agent == null) {
                    System.out.println("***********************************");
                    System.out.println("                                    ");
                    System.out.println("No agent found with these credentials.");
                    System.out.println("                                      ");
                    System.out.println("************************************");
                    System.out.println("                                     ");
                    System.out.println("Please try again.");
                    continue;
                }else {
                    agentView.viewAgent(agent);
                }
                break;
            } else {
                System.out.println(resault);
                System.out.println("Please try again.");
            }


        }
    }


}
