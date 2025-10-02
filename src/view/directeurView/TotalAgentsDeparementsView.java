package view.directeurView;

import controller.agent.ResponsableController;
import controller.deirecture.DirectureController;

import java.util.Map;

public class TotalAgentsDeparementsView {

    private DirectureController directureController;

    public TotalAgentsDeparementsView()
    {
        this.directureController = new DirectureController();
    }

    public void totalAgentsAndDepartements()
    {
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");

        Map<String , Integer> resault = directureController.getAllDepartementsWithTotal();

        for (String i : resault.keySet())
        {
            System.out.println("Name departement : " + i + "" + "Number total : " + resault.get(i));
        }
    }

}
