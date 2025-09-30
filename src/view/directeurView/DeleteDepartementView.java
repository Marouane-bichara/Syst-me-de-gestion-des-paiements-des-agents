package view.directeurView;

import controller.deirecture.DirectureController;

import java.util.Scanner;

public class DeleteDepartementView {

    private DirectureController directureController;
    private Scanner scanner;

    public DeleteDepartementView()
    {
        this.scanner = new Scanner(System.in);
        this.directureController = new DirectureController();
    }

    public void deleteDepartement()
    {

        String departement;
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("Gestion d’une Banque Digitale en Java");
        System.out.println("                                        ");
        System.out.println("****************************************");
        System.out.println("                                        ");

        System.out.print("Enter Departement name : ");
        departement = scanner.nextLine();

        String resault = directureController.deleteDepartement(departement);
        System.out.println("****************************");
        System.out.println("                            ");
        System.out.println(resault);
        System.out.println("                            ");
        System.out.println("*****************************");
    }
}
