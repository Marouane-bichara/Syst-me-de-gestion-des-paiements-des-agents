package view.agentResponsable;

import controller.agent.ResponsableController;
import model.Agent;

import java.util.List;
import java.util.Map;

public class GetAgentRankingByTPayView {

    private ResponsableController responsableController;

    public GetAgentRankingByTPayView()
    {
        this.responsableController = new ResponsableController();
    }


    public void getTheAgentsRankingByPayment(Agent agent)
    {
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");

        Map<String, Double> rs =  responsableController.getAgentsRankingByTotalPayments(agent);

        rs.forEach((name, total) -> System.out.println(name + " -> " + total));



    }

}
