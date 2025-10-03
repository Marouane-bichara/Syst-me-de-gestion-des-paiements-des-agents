package view.agentResponsable;

import controller.agent.ResponsableController;
import model.Agent;

import java.util.Scanner;

public class AllPaymentsDepartementView {


    private Scanner scanner;
    private ResponsableController responsableController;

    public AllPaymentsDepartementView()
    {
        this.scanner = new Scanner(System.in);
        this.responsableController = new ResponsableController();
    }
    public void allPaymentsDep(Agent agent)
    {
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");


        int departementId = agent.getDepartement().getId();
        Double rs = responsableController.getTotalPaymentsByDepartment(departementId);
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Your Departement total payments = " + rs);
        System.out.println("                                        ");
        System.out.println("****************************************");

    }
}
