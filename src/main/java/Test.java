import java.util.ArrayList;
import java.util.Scanner;

class Test extends Learn {

    public int maxQuestions;
    
    public Test(ArrayList<Flashcard> q, int mq) {
        super(q);
        maxQuestions = mq;
    }

    public int getMaxQuestions() {
        return maxQuestions;
    }

    public void setMaxQuestions(int max) {
        maxQuestions = max;
    }

    public void session(Config_and_Settings account) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Flashcard> questions = new ArrayList<Flashcard>();
        ArrayList<String> scores = new ArrayList<String>();
        resetData();
        boolean Exit = false;
        for (int i = 0; i < getMaxQuestions(); i++) {
            int random = (int) (Math.random() * 2) + 1;
            int random2 = (int) (Math.random() * quiz.size());
            while (random2 == 0 || random2 == quiz.size()) {
                random2 = (int) (Math.random() * quiz.size());
            }
            if (random == 1) {
                // MCQ
                Main.clear();
                int max = quiz.size() - 1;
                System.out.println("Question #" + (i+1));
                System.out.print("\n");
                System.out.println(quiz.get(random2).getFlashcard());
                System.out.print("\n");
                String[] letters = {"A", "B", "C", "D"};
                String correctAnswer = "";
                int number = 0;
                if (quiz.size() >= 4) {
                    number = 4;
                } else {
                    number = quiz.size();
                }
                int RANDOM = (int) (Math.random() * 4);
                int[] answerIndexes = new int[4];
                for (int p = 0; p < 4; p++) {
                    answerIndexes[p] = -1;
                }
                for (int j = 0; j < number; j++) {
                    if (j == RANDOM) {
                        System.out.println("[" + letters[j] + "] " + quiz.get(random2).getAnswer());
                        correctAnswer = letters[j];
                        answerIndexes[j] = random2;
                    } else {
                        int in = (int) (Math.random() * max) + 1;
                        boolean AlreadyExists = false;
                        for (int p = 0; p < 4; p++) {
                            if (answerIndexes[p] == in || in == random2) {
                                AlreadyExists = true;
                                break;
                            }
                        }
                        while (AlreadyExists) {
                            in = (int) (Math.random() * max) + 1;
                            AlreadyExists = false;
                            for (int p = 0; p < 4; p++) {
                                if (answerIndexes[p] == in || in == random2) {
                                    AlreadyExists = true;
                                    break;
                                }
                            }
                        }
                        System.out.println("[" + letters[j] + "] " + quiz.get(in).getAnswer());
                        answerIndexes[j] = in;
                    }
                }
                System.out.println("[>] Back to Menu");
                System.out.print("\n");
                System.out.print("> ");
                String select = scanner.nextLine();
                while (select.equals("")) {
                    System.out.print("\n");
                    System.out.print("> ");
                    select = scanner.nextLine();
                }
                if (select.toUpperCase().equals(correctAnswer)) {
                    addScore(1.0);
                    scores.add("CORRECT");
                } else if (select.equals(">")) {
                    Exit = true;
                    break;
                } else {
                    scores.add("INCORRECT");
                }
                questions.add(quiz.get(random2));
            } else {
                // WQ
                Main.clear();
                System.out.println("Question #" + (i+1));
                System.out.print("\n");
                System.out.println(quiz.get(random2).getFlashcard());
                System.out.print("\n");
                System.out.println("[>] Back to Menu");
                System.out.print("\n");
                System.out.print("> ");
                String select = scanner.nextLine();
                while (select.equals("")) {
                    System.out.print("\n");
                    System.out.print("> ");
                    select = scanner.nextLine();
                }
                if (select.toLowerCase().equals(quiz.get(random2).getAnswer().toLowerCase())) {
                    addScore(1.0);
                    scores.add("CORRECT");
                } else if (select.equals(">")) {
                    Exit = true;
                    break;
                } else {
                    scores.add("INCORRECT");
                }
                questions.add(quiz.get(random2));
            }
        }
        // finish screen
        if (Exit != true) {
            Main.clear();
            System.out.println("====================");
            System.out.println("MARVELOUS WORK!!");
            System.out.println("====================");
            System.out.print("\n");
            int inc = 0;
            for (Flashcard flash: questions) {
                System.out.println("#" + (inc+1) + ": " + flash.getFlashcard() + " - " + flash.getAnswer() + " (" + scores.get(inc) + ")");
                inc++;
            }
            System.out.print("\n");
            System.out.print("Score: " + (int) getScore() + "/" + getMaxQuestions());
            System.out.print("\n");
            System.out.println("[R] Retake Test");
            System.out.println("[B] Back to Menu");
            System.out.print("\n");
            System.out.print("> ");
            String select = scanner.nextLine();
            while (!select.toUpperCase().equals("R") && !select.toUpperCase().equals("B")) {
                System.out.print("\n");
                System.out.print("> ");
                select = scanner.nextLine();
            }
            account.addExp();
            if (account.getExp() >= account.getMaxExp()) {
                account.lvlUp();
            }
            if (select.toUpperCase().equals("R")) {
                Main.clear();
                System.out.print("Choose number of questions (10, 15, 20, or anything to cancel) > ");
                String select2 = scanner.nextLine();
                while (select2.equals("")) {
                    System.out.print("\n");
                    System.out.print("> ");
                    select2 = scanner.nextLine();
                }
                try {
                    if (Integer.valueOf(select2) == 10) {
                        setMaxQuestions(10);
                        session(account);
                    } else if (Integer.valueOf(select2) == 15) {
                        setMaxQuestions(15);
                        session(account);
                    } else if (Integer.valueOf(select2) == 20) {
                        setMaxQuestions(20);
                        session(account);
                    }
                } catch (NumberFormatException e) {
                    System.out.print("go back");
                }
            }
        }
    }
}