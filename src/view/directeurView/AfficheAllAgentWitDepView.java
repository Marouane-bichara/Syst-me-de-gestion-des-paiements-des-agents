package view.directeurView;

import controller.agent.ResponsableController;
import model.Agent;

import java.util.List;
import java.util.Scanner;

public class AfficheAllAgentWitDepView {
    private ResponsableController agentController;
    private Scanner scanner;

    public AfficheAllAgentWitDepView()
    {
        this.agentController = new ResponsableController();
        this.scanner = new Scanner(System.in);
    }


    public void afficheAllagentsWithDep()
    {

        List<Agent> agents = agentController.getallAgentWithDepartements();

        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");

        for (Agent agent : agents){
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
