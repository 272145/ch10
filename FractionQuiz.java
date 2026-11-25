import java.util.Scanner;

public class FractionQuiz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int correct = 0;
        int total = 0;

        System.out.println("Let the Fraction Quiz Begin.");
        System.out.println("Answers should be in lowest terms. Good luck!");

        while (true) {
            Fraction a = new Fraction();
            Fraction b = new Fraction();

            int operation = (int) (Math.random() * 4);
            String symbol;
            Fraction answer;

            if (operation == 0) {
                symbol = "+";
                answer = Fraction.add(a, b);
            } else if (operation == 1) {
                symbol = "-";
                answer = Fraction.subtract(a, b);
            } else if (operation == 2) {
                symbol = "*";
                answer = Fraction.multiply(a, b);
            } else {
                symbol = "/";
                answer = Fraction.divide(a, b);
            }

            System.out.print(a + " " + symbol + " " + b + " = ");
            String response = input.nextLine().trim();

            if (response.equals("quit")) {
                break;
            }

            Fraction userAnswer = new Fraction(response);
            total++;

            if (userAnswer.equals(answer)) {
                correct++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong, the answer was " + answer);
            }
        }

        if (total == 0) {
            System.out.println("You answered no questions.");
        } else {
            Fraction score = new Fraction(correct, total);
            long percent = Math.round(score.toDouble() * 100);

            System.out.println("You answered " + score
                + " correctly, for a score of " + percent + " percent!");
        }

        input.close();
    }
}
