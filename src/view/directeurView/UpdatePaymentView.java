package view.directeurView;

import controller.deirecture.DirectureController;
import model.Agent;
import model.Payment;
import model.TypePyment;

import java.util.Date;
import java.util.Scanner;

public class UpdatePaymentView {


    private DirectureController directureController;
    private Scanner scanner;

    public UpdatePaymentView()
    {
        this.scanner = new Scanner(System.in);
        this.directureController = new DirectureController();
    }


    public void updatePayment()
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

        Payment payment = directureController.getPaymentById(payId);

        String typePayment;

        while (true)
        {
            System.out.print("Enter type Payment (SALAIRE | BONUS | PRIME | INDEMNITE): ");

            typePayment = scanner.nextLine();

            if(typePayment.equals("SALAIRE") || typePayment.equals("BONUS") || typePayment.equals("PRIME") || typePayment.equals("INDEMNITE")) break;
            System.out.println("Please try again");
        }

        System.out.print("Enter the amount : ");
        double amount = scanner.nextDouble();

        System.out.print("Enter motif : ");
        String motif = scanner.nextLine();

        System.out.print("Valide or not 0 for not valid and 1 for valid : ");
        int conditionValide = scanner.nextInt();

        Date date = new Date();

        int id = payment.getId();

        Agent newAg = payment.getAgent();

        Payment newpayment = new Payment(date , id , TypePyment.valueOf(typePayment) , amount , motif , newAg , conditionValide);


        String rss = directureController.updatePayment(newpayment);

        System.out.println("*************");
        System.out.println("             ");
        System.out.println(rss);
        System.out.println("             ");
        System.out.println("*************");


    }
}
