package view.directeurView;

import controller.deirecture.DirectureController;

public class TotalAgentsAndDepartemensSecondView {


    private DirectureController directureController;

    public TotalAgentsAndDepartemensSecondView()
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

        int agentsTotal = directureController.countAgents();
        int departementsTotal = directureController.countDepartements();


        System.out.println("Total departements : " + departementsTotal);
        System.out.println("Total agents : " + agentsTotal);


    }
}
