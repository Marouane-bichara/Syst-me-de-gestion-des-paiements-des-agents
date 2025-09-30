package view.directeurView;

import controller.agent.AgentController;
import controller.deirecture.DirectureController;

import java.util.Scanner;

public class CreateDepartementView {

    private DirectureController directureController;
    private Scanner scanner;

    public CreateDepartementView()
    {
        this.directureController = new DirectureController();
        this.scanner = new Scanner(System.in);
    }

    public void addDepartement()
    {

        boolean isTrue = true;
        String name;


            System.out.println("****************************************");
            System.out.println("                                        ");
            System.out.println("Gestion d’une Banque Digitale en Java");
            System.out.println("                                        ");
            System.out.println("****************************************");
            System.out.println("                                        ");

            System.out.print("Enter departement name : ");
            name = scanner.nextLine();

            String resault = directureController.addDepartement(name);
            System.out.println(resault);


    }

}
