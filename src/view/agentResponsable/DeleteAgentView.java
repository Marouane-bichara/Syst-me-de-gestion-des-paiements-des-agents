package view.agentResponsable;

import controller.agent.ResponsableController;
import model.Agent;

import java.util.Scanner;

public class DeleteAgentView {


    private ResponsableController agentController;
    private Scanner scanner;

    public DeleteAgentView()
    {
        this.agentController = new ResponsableController();
        this.scanner = new Scanner(System.in);
    }


    public void deleteAgent(Agent respoAgent)
    {
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");

        System.out.println("Search for the Agent First");
        System.out.println("                          ");
        System.out.print("Enter Agent Name : ");

        String name = scanner.nextLine();

        System.out.print("Enter Agent LastName : ");

        String lastName = scanner.nextLine();

        Agent agent = agentController.getAgentByNameAndLastName(lastName , name);

        if(agent == null)
        {
            System.out.println("************************");
            System.out.println("                         ");
            System.out.println("There is no one by this informations.");
            System.out.println("                         ");
            System.out.println("**************************");
            return;
        }

        if (!agent.getDepartement().getName().equals(respoAgent.getDepartement().getName())) {
            System.out.println("************************");
            System.out.println("                         ");
            System.out.println("You do NOT have the right to Delete this agent");
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

        System.out.print("Enter Agent Id : ");
        int agentId = scanner.nextInt();
        scanner.nextLine();

        String resault = agentController.deleteAgentById(agentId);


        System.out.println("                      ");
        System.out.println("***********************");
        System.out.println(resault);
        System.out.println("***********************");
        System.out.println("                        ");

    }

}
