package view.normalAgent;

import model.Agent;

import java.util.Scanner;

public class NormalAgentView {


    private Scanner scanner;
    private CalculationAnnual calculationAnnual;
    private HighestAndLowes highestAndLowes;
    private GetAllPersonnelInfo getAllPersonnelInfo;
    private TotalPayments totalPayments;

    public NormalAgentView()
    {
        this.scanner = new Scanner(System.in);
        this.calculationAnnual = new CalculationAnnual();
        this.highestAndLowes = new HighestAndLowes();
        this.getAllPersonnelInfo = new GetAllPersonnelInfo();
        this.totalPayments = new TotalPayments();
    }

    public void noramlAgentView(Agent agent)
    {
        boolean isTrue = true;
        int choice ;

        while (isTrue) {


            System.out.println("****************************************");
            System.out.println("                                        ");
            System.out.println("Gestion d’une Banque Digitale en Java");
            System.out.println("                                        ");
            System.out.println("****************************************");
            System.out.println("   ");

            System.out.println("1. Calculation of total annual salary.");
            System.out.println("2. Displaying the highest and lowest payout.");
            System.out.println("3. See all of my personal information and departement.");
            System.out.println("4. I want to calculate my total payments.");
            System.out.println("5. Exite.");
            System.out.print("Enter you choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice)
            {
                case 1:
                    calculationAnnual.calculationAnnual(agent);
                    break;
                case 2:
                    highestAndLowes.highetAndLowestPayment(agent);
                    break;
                case 3:
                    getAllPersonnelInfo.getAllpersonellInfo(agent);
                    break;
                case 4:
                    totalPayments.totalPayments(agent);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
