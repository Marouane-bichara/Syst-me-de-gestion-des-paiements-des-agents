package view.agentResponsable;

import controller.agent.ResponsableController;
import model.Agent;
import model.TypeAgent;
import validationInput.ValidationUtils;

import java.util.Scanner;

public class AddAgentView {

    private ResponsableController agentController;
    private Scanner scanner;

    public AddAgentView() {
        this.agentController = new ResponsableController();
        this.scanner = new Scanner(System.in);
    }

    public void addAgent(Agent responsable) {


        System.out.println("****************************************");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("****************************************");

        System.out.print("Enter Agent last name: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Enter Agent first name: ");
        String lastName = scanner.nextLine().trim();
        String email;
        while(true){
            System.out.print("Enter Agent email: ");
            email = scanner.nextLine().trim();
            if (ValidationUtils.isValidEmail(email)) break;
            System.out.println("Email may be invalid try again pls.");
        }

        String password;
        while(true)
        {
            System.out.print("Enter Agent password: ");
            password = scanner.nextLine().trim();
            if (ValidationUtils.isValidPassword(password)) break;
            System.out.println("Password may be too short.");
        }




        System.out.print("Enter Agent type (OUVRIER | STAGIARE): ");
        String typeInput = scanner.nextLine().trim().toUpperCase();
        if (!ValidationUtils.isValidType(typeInput)) {
            System.out.println("Invalid type it will be an OUVRIER by default.");
            typeInput = "OUVRIER";
        }
        TypeAgent type;
        if (typeInput.equals("STAGIARE")) {
            type = TypeAgent.STAGIARE;
        } else {
            type = TypeAgent.OUVRIER;
        }

        String deptName = responsable.getDepartement().getName();

        String result = agentController.addAgent(firstName, lastName, email, password, type.name(), deptName, responsable.getId());
        System.out.println(result);
    }
}
