import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuizProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> quizBank = new ArrayList<>();

        while (true) {
            System.out.println("Enter your choice:\n1. Add a question\n2. Start the quiz\n3. Exit");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter the question:");
                    String question = sc.nextLine();
                    System.out.println("Enter option A:");
                    String optionA = sc.nextLine();
                    System.out.println("Enter option B:");
                    String optionB = sc.nextLine();
                    System.out.println("Enter option C:");
                    String optionC = sc.nextLine();
                    System.out.println("Enter the correct answer (A, B, or C):");
                    String answer = sc.nextLine();
                    Question q = new Question(question, optionA, optionB, optionC, answer);
                    quizBank.add(q);
                    System.out.println("Question added successfully!");
                    break;
                case 2:
                    startQuiz(sc, quizBank);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    public static void startQuiz(Scanner sc, List<Question> quizBank) {
        if (quizBank.isEmpty()) {
            System.out.println("Quiz bank is empty. Please add questions first.");
            return;
        }

        List<Integer> selectedIndexes = new ArrayList<>();
        Random random = new Random();
        int numQuestions = quizBank.size();
        int score = 0;

        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(numQuestions);

            while (selectedIndexes.contains(index)) {
                index = random.nextInt(numQuestions);
            }

            selectedIndexes.add(index);
            Question q = quizBank.get(index);
            System.out.println("Question " + (i + 1) + ": " + q.getQuestion());
            System.out.println("A. " + q.getOptionA());
            System.out.println("B. " + q.getOptionB());
            System.out.println("C. " + q.getOptionC());
            System.out.println("Please enter your answer (A, B, or C):");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase(q.getAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("Quiz complete! You scored " + score + " out of 5.");
    }
}