package view.normalAgent;

import controller.normalAgent.NormalAgentController;
import model.Agent;

public class TotalPayments {
    private NormalAgentController normalAgentController;

    public TotalPayments()
    {
        this.normalAgentController = new NormalAgentController();
    }


    public void totalPayments(Agent agent)
    {
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("   ");


        Double rs = normalAgentController.sumPaymentToAgent(agent.getId());


        System.out.println("**********************");
        System.out.println("                      ");
        System.out.println("Total payments : " + rs);
        System.out.println("                      ");
        System.out.println("**********************");

    }
}
