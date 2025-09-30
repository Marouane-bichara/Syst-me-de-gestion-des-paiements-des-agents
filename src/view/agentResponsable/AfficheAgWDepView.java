package view.agentResponsable;

import controller.agent.AgentController;
import model.Agent;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AfficheAgWDepView {


    private AgentController agentController;
    private Scanner scanner;

    public AfficheAgWDepView()
    {
        this.agentController = new AgentController();
        this.scanner = new Scanner(System.in);
    }



    public void affichAgents(Agent respoAgent)
    {

        List<Agent> agents = agentController.getallAgentWithDepartements();

        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");

        String respoDepName = respoAgent.getDepartement().getName().trim().toLowerCase();

        List<Agent> newAgents = agents.stream().filter(a -> a.getDepartement() != null).filter(a -> a.getDepartement().getName().trim().toLowerCase().equals(respoDepName)).collect(Collectors.toList());

        if (newAgents.isEmpty()) {
            System.out.println("There is no Agents in his departement");
            return;
        }

        for (Agent agent : newAgents){
            System.out.println("******************************");
            System.out.println("                               ");
            System.out.println("Agent Id : " + agent.getId());
            System.out.println("Agent Name : " + agent.getPrenom());
            System.out.println("Agent Last Name : " + agent.getNom());
            System.out.println("Agent Email : " + agent.getEmail());
            System.out.println("Agent password : " + agent.getMotDePasse());
            System.out.println("Agent Type : " + agent.getTypeAgent());
            System.out.println("Agent Departement : " + agent.getDepartement().getName());
            System.out.println("                               ");
            System.out.println("******************************");

        }


    }

}
