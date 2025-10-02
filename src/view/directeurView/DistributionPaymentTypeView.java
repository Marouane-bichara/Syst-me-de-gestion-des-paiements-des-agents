package view.directeurView;

import controller.deirecture.DirectureController;

import java.util.Scanner;

public class DistributionPaymentTypeView {

    private DirectureController directureController;
    private Scanner scanner;

    public DistributionPaymentTypeView()
    {
        this.scanner = new Scanner(System.in);
        this.directureController = new DirectureController();
    }

    public void distributionPaymentType()
    {
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");

        String typePayment;

        while (true)
        {
            System.out.print("Enter type Payment (SALAIRE | BONUS | PRIME | INDEMNITE): ");

            typePayment = scanner.nextLine();

            if(typePayment.equals("SALAIRE") || typePayment.equals("BONUS") || typePayment.equals("PRIME") || typePayment.equals("INDEMNITE")) break;
            System.out.println("Please try again");
        }

        double resault = directureController.calculeBytotal(typePayment);


        System.out.println("******************");
        System.out.println("                  ");
        System.out.println("Resault is : " + resault + "%");
        System.out.println("                  ");
        System.out.println("******************");
    }
}
