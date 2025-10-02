package view.agentResponsable;

import controller.agent.ResponsableController;
import model.Agent;

import java.util.Scanner;

public class DeletePaymentView {


    private ResponsableController responsableController;
    private Scanner scanner;

    public DeletePaymentView()
    {
        this.responsableController = new ResponsableController();
        this.scanner = new Scanner(System.in);
    }


    public void deletePayment(Agent agent)
    {
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");

        System.out.print("Enter payment id : ");
        int idPayment = scanner.nextInt();
        scanner.nextLine();

        String rs = responsableController.deletePayment(idPayment);


        System.out.println("*************");
        System.out.println("             ");
        System.out.println(rs);
        System.out.println("             ");
        System.out.println("*************");

    }

}
