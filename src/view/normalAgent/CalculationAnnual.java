package view.normalAgent;

import controller.normalAgent.NormalAgentController;
import model.Agent;

public class CalculationAnnual {

    private NormalAgentController normalAgentController;

    public CalculationAnnual()
    {
        this.normalAgentController = new NormalAgentController();
    }

    public void calculationAnnual(Agent agent)
    {

        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("   ");

        Double rs = normalAgentController.getTotalAnnualSalary(agent.getId());

        System.out.println("Annual payment : " + rs);

    }
}
