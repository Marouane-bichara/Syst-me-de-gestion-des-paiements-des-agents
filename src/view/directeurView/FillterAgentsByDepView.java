package view.directeurView;

import controller.agent.ResponsableController;
import controller.deirecture.DirectureController;
import controller.departement.DepartementController;
import model.Agent;
import model.Departement;

import java.util.List;
import java.util.Scanner;

public class FillterAgentsByDepView {
    private ResponsableController agentController;
    private DepartementController departementController;
    private DirectureController directureController;
    private Scanner scanner;

    public FillterAgentsByDepView()
    {
        this.agentController = new ResponsableController();
        this.departementController = new DepartementController();
        this.directureController = new DirectureController();
        this.scanner = new Scanner(System.in);
    }


    public void filterAgents()
    {
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");

        System.out.println("<<<<< Filter By Departement >>>>>");
        System.out.println("                                  ");

        List<Departement> departements =  departementController.getAlldepartements();
//        System.out.println(departements);
        int num = 1;
        String choice;
        for (Departement d : departements)
        {

            System.out.println(num + ". " + d.getName());
            num++;
        }
        System.out.print("Enter your choice : ");
        choice = scanner.nextLine();

        List<Agent> depAgent = directureController.getAgentsBydepartement(choice);


        for(Agent a : depAgent)
        {
            System.out.println("*********************");
            System.out.println("                     ");
            System.out.println("Agent name : " + a.getPrenom());
            System.out.println("Agent lasname : " + a.getNom());
            System.out.println("Agent email : " + a.getEmail());
            System.out.println("Agent departemetn : " + a.getDepartement().getName());
            System.out.println("                     ");
            System.out.println("*********************");
        }



    }


}
