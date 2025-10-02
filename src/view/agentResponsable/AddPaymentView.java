package view.agentResponsable;

import controller.agent.ResponsableController;
import model.Agent;
import model.Payment;
import model.TypePyment;
import service.responsable.ResponsableService;
import usecases.agent.ResponsableUseCase;

import java.util.Date;
import java.util.Scanner;

public class AddPaymentView {


    private Scanner scanner;
    private ResponsableUseCase getAgentUseCase;
    private ResponsableController responsableController;


    public AddPaymentView()
    {
        this.scanner = new Scanner(System.in);
        this.getAgentUseCase = new ResponsableUseCase();
        this.responsableController = new ResponsableController();
    }


    public void addPaymentV(Agent agent)
    {

        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");
//    public Payment(Date datePaiement, int id, TypePyment type, double amount, String motif, Agent agent, int conditionValidee) {

        System.out.print("Enter Agent name : ");
        String name = scanner.nextLine();
        System.out.print("Enter Agent LastName : ");
        String lastName = scanner.nextLine();

        Agent agentt = getAgentUseCase.getAgentByNameAndLastname(lastName , name);

        if(agentt == null)
        {
            System.out.println("****************");
            System.out.println("               ");
            System.out.println("Agent not found");
            System.out.println("               ");
            System.out.println("****************");
            return ;
        }

        if(agentt.getDepartement().getId() != agent.getDepartement().getId())
        {
            System.out.println("This agent is not from your departement");
            return;
        }

        String typePayment;

        while (true)
        {
            System.out.print("Enter type Payment (SALAIRE | BONUS): ");

            typePayment = scanner.nextLine();

            if(typePayment.equals("SALAIRE") || typePayment.equals("BONUS")) break;
            System.out.println("Please try again");
        }

        System.out.print("Enter the amount : ");
        double amount = scanner.nextDouble();

        System.out.print("Enter motif : ");
        String motif = scanner.nextLine();

        System.out.print("Valide or not 0 for not valid and 1 for valid : ");
        int conditionValide = scanner.nextInt();

        Date date = new Date();
        int id = 8;
        Payment payment = new Payment(date , id , TypePyment.valueOf(typePayment) , amount , motif ,agentt , conditionValide);

        String rs = responsableController.addPayment(payment);

        System.out.println("****************");
        System.out.println("               ");
        System.out.println(rs);
        System.out.println("               ");
        System.out.println("****************");





    }

}
