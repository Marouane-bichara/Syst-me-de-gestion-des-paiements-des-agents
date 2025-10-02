package view.directeurView;

import controller.deirecture.DirectureController;
import model.Agent;
import model.Payment;
import model.TypePyment;

import java.util.Date;
import java.util.Scanner;

public class AddPaymentDirView {

    private DirectureController directureController;
    private Scanner scanner;

    public AddPaymentDirView ()
    {
        this.directureController = new DirectureController();
        this.scanner = new Scanner(System.in);
    }

    public void addPayment()
    {
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");

        System.out.print("Enter Responsable name : ");

        String direcName = scanner.nextLine();

        System.out.print("Enter Responsable lastname : ");

        String dirLastName = scanner.nextLine();

        Agent agent = directureController.getAgentByNameAndLastName(dirLastName , direcName);
        System.out.println(agent.getTypeAgent().name());


        if(agent == null)
        {
            System.out.println("********************");
            System.out.println("                    ");
            System.out.println("Responsable not found");
            System.out.println("                    ");
            System.out.println("********************");
            return;
        }

        if(agent.getTypeAgent().equals("RESPONSABLE_DEPARTEMENT"))
        {
            System.out.println("********************");
            System.out.println("                    ");
            System.out.println("Agent is not an Responsable.");
            System.out.println("                    ");
            System.out.println("********************");
            return;
        }

//        SALAIRE,
//        PRIME,
//        BONUS,
//        INDEMNITE

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
        int id = 8;
        Payment payment = new Payment(date , id , TypePyment.valueOf(typePayment) , amount , motif ,agent , conditionValide);

        String rs = directureController.addPaymentToDirecture(payment);

        System.out.println("****************");
        System.out.println("               ");
        System.out.println(rs);
        System.out.println("               ");
        System.out.println("****************");
    }




}
