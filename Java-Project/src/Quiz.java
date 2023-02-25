import java.util.*;
public class Quiz {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            List<Question> quizBank = new ArrayList<>();
            boolean running = true;

            while (running) {
                System.out.println("Select an option:");
                System.out.println("1. Add a question");
                System.out.println("2. Start the quiz");
                System.out.println("3. Exit");
                int choice = sc.nextInt();
                sc.nextLine(); // consume the remaining newline character

                switch (choice) {
                    case 1:
                        addQuestion(sc, quizBank);
                        break;
                    case 2:
                        startQuiz(sc, quizBank);
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option selected.");
                        break;
                }
            }

            sc.close();
        }

        public static void addQuestion(Scanner sc, List<Question> quizBank) {
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
            System.out.println("Question added to quiz bank.");
        }

        public static void startQuiz(Scanner sc, List<Question> quizBank) {
            if (quizBank.isEmpty()) {
                System.out.println("Quiz bank is empty. Please add questions first.");
                return;
            }

            List<Integer> selectedIndexes = new ArrayList<>();
            Random random = new Random();
            int numQuestions = quizBank.size();
            int numCorrectAnswers = 0;

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
                    numCorrectAnswers++;
                } else {
                    System.out.println("Incorrect.");
                }
            }

            int score = numCorrectAnswers * 20;
            System.out.println("Quiz complete. You got " + numCorrectAnswers + " out of 5 questions correct.");
            System.out.println("Your score is: " + score + "%");
        }

    }



