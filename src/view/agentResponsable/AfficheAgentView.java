package view.agentResponsable;

import controller.agent.AgentController;
import model.Agent;

import java.util.Scanner;

public class AfficheAgentView {
    private AgentController agentController;
    private Scanner scanner;

    public AfficheAgentView()
    {
        this.agentController = new AgentController();
        this.scanner = new Scanner(System.in);
    }

    public void afficheAgent(Agent respoAgent)
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
            System.out.println("There is no agent with this informations.");
            System.out.println("                         ");
            System.out.println("**************************");
            return;
        }

        if (!agent.getDepartement().getName().equals(respoAgent.getDepartement().getName())) {
            System.out.println("************************");
            System.out.println("                         ");
            System.out.println("You do NOT have the right to see this agent");
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
    }

}
