package view.agentResponsable;

import controller.agent.ResponsableController;
import model.Agent;
import model.Payment;
import model.TypePyment;

import java.util.Date;
import java.util.Scanner;

public class UpdatePaymentView {

    private ResponsableController responsableController;
    private Scanner scanner;

    public UpdatePaymentView()
    {
        this.responsableController = new ResponsableController();
        this.scanner = new Scanner(System.in);
    }

    public void updatePayment(Agent agent)
    {
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");

        System.out.print("Enter Payment id : ");
        int payId = scanner.nextInt();
        scanner.nextLine();

        Payment payment = responsableController.getPaymentById(payId);

        if(payment.getAgent().getDepartement().getId() != agent.getDepartement().getId())
        {
            System.out.println("You dont have the right to change this payment");
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
        double amount;

        while (true)
        {
            System.out.print("Enter the amount : ");
            amount= scanner.nextDouble();
            if(amount >= 0) break;
            System.out.println("Please try again");
        }

        System.out.print("Enter motif : ");
        String motif = scanner.nextLine();

        System.out.print("Valide or not 0 for not valid and 1 for valid : ");
        int conditionValide = scanner.nextInt();

        Date date = new Date();

        int id = payment.getId();


        Agent newAg = payment.getAgent();
        Payment newpayment = new Payment(date , id , TypePyment.valueOf(typePayment) , amount , motif , newAg , conditionValide);

        String rss = responsableController.updatePayment(newpayment);

        System.out.println("*************");
        System.out.println("             ");
        System.out.println(rss);
        System.out.println("             ");
        System.out.println("*************");



    }
}
