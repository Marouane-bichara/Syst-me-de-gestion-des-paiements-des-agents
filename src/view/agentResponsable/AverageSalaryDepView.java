package view.agentResponsable;

import controller.agent.ResponsableController;
import model.Agent;

public class AverageSalaryDepView {

    private ResponsableController responsableController;

    public AverageSalaryDepView()
    {
        this.responsableController = new ResponsableController();
    }

    public void avergSalary(Agent agent)
    {
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");

        int idDepartement = agent.getDepartement().getId();
        Double rs = responsableController.getAverageSalaryByDepartment(idDepartement);


        System.out.println("**************************");
        System.out.println("                          ");
        System.out.println(rs);
        System.out.println("                          ");
        System.out.println("***************************");
    }

}
