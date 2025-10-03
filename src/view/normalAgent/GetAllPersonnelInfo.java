package view.normalAgent;

import controller.normalAgent.NormalAgentController;
import model.Agent;

import java.util.List;

public class GetAllPersonnelInfo {

    private NormalAgentController normalAgentController;

    public GetAllPersonnelInfo()
    {
        this.normalAgentController = new NormalAgentController();
    }


    public void getAllpersonellInfo(Agent agent)
    {
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("   ");

        Agent agentInfo = normalAgentController.getinfoPerso(agent.getPrenom() , agent.getNom());
        List<Double> allPayments = normalAgentController.getAgentPaymentByAgentId(agent.getId());

        System.out.println("***********************");
        System.out.println("                       ");

        System.out.println("name : " + agentInfo.getPrenom());
        System.out.println("Last name : " + agentInfo.getNom());
        System.out.println("Type : " + agentInfo.getTypeAgent());
        System.out.println("Departement : " + agentInfo.getDepartement().getName());
        System.out.println("Email : " + agentInfo.getEmail());
        System.out.println("Password : " + agentInfo.getMotDePasse());

        System.out.println("           ");

        System.out.println("************************");

        System.out.println("          ");

        int i = 1;
        for (Double d : allPayments)
        {
            System.out.println("Payment" +i + " : " + d);
            i++;
        }

        System.out.println("                       ");
        System.out.println("***********************");

    }

}
