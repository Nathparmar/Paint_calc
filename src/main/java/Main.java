import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static double totalAmountOfPaintNeeded(double[] heights, double[] widths, double objectHeight, double objectWidth) {
        double totalArea = 0;
        for (int i = 0; i < heights.length; i++) {
            totalArea += heights[i] * widths[i];
        }
        totalArea = totalArea - objectHeight*objectWidth;
        return totalArea;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        double paintPrice = 0;
        while (!validInput) {
            try {
                System.out.println("Please specify the price per tin of paint?");
                paintPrice = scanner.nextDouble();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number or decimal.");
                scanner.next();
            }
        }


        double tinVolume = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.println("How many litres does this tin contain?");
                tinVolume = scanner.nextDouble();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number or decimal.");
                scanner.next();
            }
        }


        double paintCoverage = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.println("What is the coverage per litre of this paint?");
                paintCoverage = scanner.nextDouble();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number or decimal.");
                scanner.next();
            }
        }


        int numberOfWalls = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.println("How many rectangular walls are you painting?");
                numberOfWalls = scanner.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        double[] heights = new double[numberOfWalls];
        double[] widths = new double[numberOfWalls];

        for (int i = 0; i < numberOfWalls; i++) {
            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Can you provide the height of wall " + (i + 1) + " in mm?");
                    heights[i] = scanner.nextDouble();
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number or decimal");
                    scanner.next();
                }
            }

            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Can you provide the width of wall " + (i + 1) + " in mm?");
                    widths[i] = scanner.nextDouble();
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number or decimal.");
                    scanner.next();
                }
            }
        }

        boolean answer = false;
        validInput = false;
        while (!validInput) {
            try {
                System.out.println("Are there any objects in the wall that don't need painting? (e.g window/door) True or False?");
                answer = scanner.nextBoolean();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number or decimal");
                scanner.next();
            }
        }

        double objectHeight = 0.0;
        double objectWidth = 0.0;
        if (answer == true){

            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Can you provide the height of the object?");
                    objectHeight = scanner.nextDouble();
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number or decimal");
                    scanner.next();
                }
            }
            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Can you provide the width of the object?");
                    objectWidth = scanner.nextDouble();
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number or decimal");
                    scanner.next();
                }
            }
        }




//        System.out.println(width);
//        System.out.println(height);
//        System.out.println(numberOfWalls);


        double totalArea = totalAmountOfPaintNeeded(heights, widths, objectHeight, objectWidth);
//        System.out.println(totalArea);

        double numberOfTinsExact = (totalArea / (paintCoverage * tinVolume * 1e6)) ;
//        System.out.println(numberOfTinsExact);

       double numberOfTins = 0;
       if (totalArea > 0){
           numberOfTins = Math.floor(numberOfTinsExact) + 1;
       }


        double totalCost = numberOfTins * paintPrice;

        System.out.println("This means you need " + numberOfTins + " paint tins costing £" + totalCost);
    }
}
