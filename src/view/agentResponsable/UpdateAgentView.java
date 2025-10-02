package view.agentResponsable;

import controller.agent.ResponsableController;
import model.Agent;
import model.TypeAgent;
import validationInput.ValidationUtils;

import java.util.Scanner;

public class UpdateAgentView {


    private ResponsableController agentController;
    private Scanner scanner;



    public UpdateAgentView()
    {
        this.agentController = new ResponsableController();
        this.scanner = new Scanner(System.in);
    }


    public void updateAgent(Agent respoAgent)
    {


        boolean isTrue = true;

        String name;
        String lastName;



        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");

        System.out.println("Search for the Agent First");
        System.out.println("                          ");
        System.out.print("Enter Agent Name : ");

        name = scanner.nextLine();

        System.out.print("Enter Agent LastName : ");

        lastName = scanner.nextLine();

        Agent agent = agentController.getAgentByNameAndLastName(lastName , name);


        if (!agent.getDepartement().getName().equals(respoAgent.getDepartement().getName())) {
            System.out.println("************************");
            System.out.println("                         ");
            System.out.println("You do NOT have the right to update this agent");
            System.out.println("                         ");
            System.out.println("**************************");
            return;
        }



        System.out.println("                                   ");
        System.out.println("************************************");
        System.out.println("                                   ");

        System.out.println("Agent Id : " + agent.getId());
        System.out.println("Agent name : " + agent.getPrenom());
        System.out.println("Agent LastName : " + agent.getNom());
        System.out.println("Agent Email : " + agent.getEmail());
        System.out.println("Agent Password : " + agent.getMotDePasse());
        System.out.println("Agent Type : " + agent.getTypeAgent());
        System.out.println("Agent Departement : " + agent.getDepartement().getName());


        System.out.println("                                   ");
        System.out.println("************************************");
        System.out.println("                                   ");



        System.out.print("Enter new Name : ");
        String newName = scanner.nextLine();
        System.out.print("Enter new Last Name : ");
        String newLastName = scanner.nextLine();
        String newEmail;

        while (true){
            System.out.print("Enter new Email : ");
             newEmail = scanner.nextLine();
            if(ValidationUtils.isValidEmail(newEmail))
            {
                break;
            }
            System.out.println("Invalid email try again");
        }


        String newPassword;

        while(true)
        {
            System.out.print("Enter new Password : ");
            newPassword = scanner.nextLine();

            if(ValidationUtils.isValidPassword(newPassword)) break;
            System.out.println("Invalid password.");
        }


        String newTypeAgent;

        while(true)
        {
            System.out.print("Enter new Agent Type : ");
            newTypeAgent = scanner.nextLine();
            if(ValidationUtils.isValidType(newTypeAgent))break;
            System.out.println("Invalid type , type must be OUVRIER or , STAGIARE");
        }
        TypeAgent newType;

        if(newTypeAgent.equals("STAGIARE"))
        {
            newType = TypeAgent.STAGIARE;
        }else {
            newType = TypeAgent.OUVRIER;
        }


        String resault = agentController.updateAgent( newLastName,  newName,  newEmail, newPassword,  newType.name() ,  respoAgent.getDepartement().getName() ,  agent.getId());
        System.out.println("                                   ");
        System.out.println("************************************");
        System.out.println("                                   ");
        System.out.println(resault);
        System.out.println("                                   ");
        System.out.println("************************************");
        System.out.println("                                   ");

    }


}
