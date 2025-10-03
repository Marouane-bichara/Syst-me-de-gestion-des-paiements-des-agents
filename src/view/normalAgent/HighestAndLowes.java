package view.normalAgent;

import controller.normalAgent.NormalAgentController;
import model.Agent;

public class HighestAndLowes {


    private NormalAgentController normalAgentController;

    public HighestAndLowes()
    {
        this.normalAgentController = new NormalAgentController();
    }

    public void highetAndLowestPayment(Agent agent)
    {
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("   ");


        Double highetPayout = normalAgentController.getMaxPayment(agent.getId());
        Double lowestPayout = normalAgentController.LowestPayout(agent.getId());
        System.out.println("****************");
        System.out.println("                ");
        System.out.println("Your highest payout is : " + highetPayout);
        System.out.println("Your lowest payout is : " + lowestPayout);
        System.out.println("                ");
        System.out.println("****************");

    }

}
