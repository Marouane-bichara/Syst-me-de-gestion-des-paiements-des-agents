package view.directeurView;

import controller.deirecture.DirectureController;

import java.util.Scanner;

public class DeletePaymentViewDirec {

    private Scanner scanner;
    private DirectureController directureController;

    public DeletePaymentViewDirec()
    {
        this.directureController = new DirectureController();
        this.scanner = new Scanner(System.in);
    }

    public void deletePayment()
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


        String rs = directureController.deletePayment(idPayment);


        System.out.println("*************");
        System.out.println("             ");
        System.out.println(rs);
        System.out.println("             ");
        System.out.println("*************");

    }

}
