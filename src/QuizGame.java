import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("\uD83C\uDFAE Welcome to the Java Quiz Game!");
        System.out.println("Answer the following 3 questions:\n");

        // Question 1
        System.out.println("1. What does JVM stand for?");
        System.out.println("a) Java Very Much");
        System.out.println("b) Java Virtual Machine");
        System.out.println("c) Java Visual Mode");
        System.out.println("Your answer: ");
        String answer1 = scanner.nextLine();
        if (answer1.equalsIgnoreCase("b")) score++;

        // Question 2
        System.out.println("\n2. Which data type is used to store true/false?");
        System.out.println("a) int");
        System.out.println("b) String");
        System.out.println("c) boolean");
        System.out.println("Your answer: ");
        String answer2 = scanner.nextLine();
        if (answer2.equalsIgnoreCase("c")) score++;

        // Question 3
        System.out.println("\n1. What symbol is used to end a Java statement?");
        System.out.println("a) .");
        System.out.println("b) ;");
        System.out.println("c) ,");
        System.out.println("Your answer: ");
        String answer3 = scanner.nextLine();
        if (answer3.equalsIgnoreCase("b")) score++;

        System.out.println("\n\uD83C\uDF89 You scored " + score + "/3!");
        scanner.close();
    }
}