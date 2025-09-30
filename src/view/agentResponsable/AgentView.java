package view.agentResponsable;

import model.Agent;
import view.directeurView.AfficheAllAgentWitDepView;
import view.directeurView.FillterAgentsByDepView;

import java.util.Scanner;

public class AgentView {


    private AddAgentView addAgentView;
    private UpdateAgentView updateAgentView;
    private DeleteAgentView deleteAgentView;
    private AfficheAgentView afficheAgentView;
    private AfficheAgWDepView afficheAgWDepView;
    private AfficheAllAgentWitDepView afficheAllAgentWitDepView;
    private FillterAgentsByDepView fillterAgentsByDepView;
    private Scanner scanner;

    public AgentView()
    {
        this.addAgentView = new AddAgentView();
        this.updateAgentView = new UpdateAgentView();
        this.deleteAgentView = new DeleteAgentView();
        this.afficheAgentView = new AfficheAgentView();
        this.afficheAgWDepView = new AfficheAgWDepView();
        this.afficheAllAgentWitDepView = new AfficheAllAgentWitDepView();
        this.fillterAgentsByDepView = new FillterAgentsByDepView();
        this.scanner = new Scanner(System.in);
    }

    public void viewAgent(Agent agent)
    {
        boolean isTrue = true;
        int choice;

        while (isTrue)
        {
            System.out.println("****************************************");
            System.out.println("                                        ");
            System.out.println("Gestion d’une Banque Digitale en Java");
            System.out.println("                                        ");
            System.out.println("****************************************");
            System.out.println("                                        ");
            System.out.println("1. Add Agent.");
            System.out.println("2. Update Agent.");
            System.out.println("3. Delete Agent.");
            System.out.println("4. Affiche Agent.");
            System.out.println("5. Affiche all Agents.");
            System.out.println("6. Exite");
            System.out.print("Enter your choice : ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                     addAgentView.addAgent(agent);
                    System.out.println("*********************");

                    break;
                case 2:
                    updateAgentView.updateAgent(agent);
                    break;
                case 3:
                    deleteAgentView.deleteAgent(agent);
                    break;
                case 4:
                    afficheAgentView.afficheAgent(agent);
                    break;
                case 5:
                    afficheAgWDepView.affichAgents(agent);
                    break;
                case 6:
                    System.exit(0);
            }


        }



    }
}
