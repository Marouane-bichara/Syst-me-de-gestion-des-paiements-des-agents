package view.directeurView;

import controller.agent.AgentController;
import controller.departement.DepartementController;
import model.Departement;

import java.util.List;
import java.util.Scanner;

public class FillterAgentsByDepView {
    private AgentController agentController;
    private DepartementController departementController;
    private Scanner scanner;

    public FillterAgentsByDepView()
    {
        this.agentController = new AgentController();
        this.departementController = new DepartementController();
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
        System.out.println(departements);
//        for (Departement d : departements)
//        {
//            System.out.println("");
//        }

    }


}
