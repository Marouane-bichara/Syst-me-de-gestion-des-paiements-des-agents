package view.auth;

import controller.auth.AuthRespoController;
import validationInput.ValidationInput;
import view.agentResponsable.AgentView;

import java.util.Scanner;

public class LoginDirecteurView {



    private Scanner scanner;
    private ValidationInput validationInput;
    private AuthRespoController authRespoController;
    private AgentView agentView;


    public LoginDirecteurView()
    {
        this.scanner = new Scanner(System.in);
        this.authRespoController = new AuthRespoController();
        this.validationInput = new ValidationInput();
        this.agentView = new AgentView();
    }
}
