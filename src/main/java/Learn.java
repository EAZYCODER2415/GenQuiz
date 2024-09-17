import java.util.ArrayList;
import java.util.Scanner;

class Learn {
    public double score;
    public int current;
    public ArrayList<Flashcard> quiz;
    public int attempts;

    public Learn(ArrayList<Flashcard> q) {
        score = 0.0;
        current = 1;
        quiz = q;
        attempts = 1;
    }

    public double getScore() {
        return Math.round(score);
    }

    public void addScore(double sc) {
        score += sc;
    }

    public void resetScore() {
        score = 0.0;
    }

    public int getAttempts() {
        return attempts;
    }

    public void addAttempt() {
        attempts++;
    }

    public int currentFlashcard() {
        return current;
    }

    public void addNextFlashcard() {
        current++;
    }

    public void resetFlashcard() {
        current = 1;
    }

    public void resetData() {
        score = 0.0;
        current = 1;
        attempts = 1;
    }

    public void session(Config_and_Settings account) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> wrongQuestions = new ArrayList<Integer>();
        ArrayList<Flashcard> questions = new ArrayList<Flashcard>();
        if (getAttempts() < 3) {
            resetScore();
            boolean Exit = false;
            if (quiz.size()-1 < 7) {
                for (int i = 0; i < quiz.size(); i++) {
                    Main.clear();
                    int max = quiz.size() - 1;
                    System.out.println("Question #" + (i+1));
                    System.out.print("\n");
                    System.out.println(quiz.get(currentFlashcard()).getFlashcard());
                    System.out.print("\n");
                    System.out.println("Score: " + getScore());
                    System.out.print("\n");
                    String[] letters = {"A", "B", "C", "D"};
                    String correctAnswer = "";
                    int number = 0;
                    if (quiz.size() >= 4) {
                        number = 4;
                    } else {
                        number = quiz.size();
                    }
                    int random = (int) (Math.random() * 4);
                    int[] answerIndexes = new int[4];
                    for (int p = 0; p < 4; p++) {
                        answerIndexes[p] = -1;
                    }
                    for (int j = 0; j < number; j++) {
                        if (j == random) {
                            System.out.println("[" + letters[j] + "] " + quiz.get(currentFlashcard()).getAnswer());
                            correctAnswer = letters[j];
                            answerIndexes[j] = currentFlashcard();
                        } else {
                            int in = (int) (Math.random() * max) + 1;
                            boolean AlreadyExists = false;
                            for (int p = 0; p < 4; p++) {
                               if (answerIndexes[p] == in || in == currentFlashcard()) {
                                    AlreadyExists = true;
                                    break;
                                }
                            }
                            while (AlreadyExists) {
                                in = (int) (Math.random() * max) + 1;
                                AlreadyExists = false;
                                for (int p = 0; p < 4; p++) {
                                   if (answerIndexes[p] == in || in == currentFlashcard()) {
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
                        double sc = Math.round(Math.random() * 750.0 + 50.0);
                        addScore(sc);
                        System.out.print("\n");
                        System.out.println("You nailed it! (Correct Answer: " + correctAnswer + " - " + quiz.get(currentFlashcard()).getAnswer() + ")");
                        System.out.println("+" + sc);
                        System.out.print("> ");
                        select = scanner.nextLine();
                        while (!(select.equals(""))) {
                            System.out.print("\n");
                            System.out.print("> ");
                            select = scanner.nextLine();
                        }
                    } else if (select.equals(">")) {
                        Exit = true;
                        break;
                    } else {
                        System.out.print("\n");
                        System.out.println("Oops that's a miss! (Correct Answer: " + correctAnswer + " - " + quiz.get(currentFlashcard()).getAnswer() + ")");
                        System.out.print("> ");
                        select = scanner.nextLine();
                        while (!(select.equals(""))) {
                            System.out.print("\n");
                            System.out.print("> ");
                            select = scanner.nextLine();
                        }
                        wrongQuestions.add(currentFlashcard());
                    }
                    questions.add(quiz.get(currentFlashcard()));
                    addNextFlashcard();
                    if (i == 6) {
                        int len = wrongQuestions.size();
                        int d = 7;
                        int e = i+1;
                        while (wrongQuestions.size() != 0 && d < 7 + len) {
                            len = wrongQuestions.size();
                            Main.clear();
                            max = quiz.size() - 1;
                            System.out.println("Question #" + (e+1) + " (Redemption Question)");
                            System.out.print("\n");
                            System.out.println(quiz.get(wrongQuestions.get((d+1)-8)).getFlashcard());
                            System.out.print("\n");
                            System.out.println("Score: " + getScore());
                            System.out.print("\n");
                            letters = new String[4];
                            for (int a = 0; a < 4; a++) {
                                if (a == 0) {
                                    letters[a] = "A";
                                } else if (a == 1) {
                                    letters[a] = "B";
                                } else if (a == 2) {
                                    letters[a] = "C";
                                } else if (a == 3) {
                                    letters[a] = "D";
                                }
                            }
                            correctAnswer = "";
                            random = (int) (Math.random() * 4);
                            answerIndexes = new int[4];
                            for (int p = 0; p < 4; p++) {
                                answerIndexes[p] = -1;
                            }
                            for (int j = 0; j < 4; j++) {
                                if (j == random) {
                                    System.out.println("[" + letters[j] + "] " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer());
                                    correctAnswer = letters[j];
                                    answerIndexes[j] = wrongQuestions.get((d+1)-8);
                                } else {
                                    int in = (int) (Math.random() * max) + 1;
                                    boolean AlreadyExists = false;
                                    for (int p = 0; p < 4; p++) {
                                       if (answerIndexes[p] == in || in == wrongQuestions.get((d+1)-8)) {
                                            AlreadyExists = true;
                                            break;
                                        }
                                    }
                                    while (AlreadyExists) {
                                        in = (int) (Math.random() * max) + 1;
                                        AlreadyExists = false;
                                        for (int p = 0; p < 4; p++) {
                                           if (answerIndexes[p] == in || in == wrongQuestions.get((d+1)-8)) {
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
                            select = scanner.nextLine();
                            while (select.equals("")) {
                                System.out.print("\n");
                                System.out.print("> ");
                                select = scanner.nextLine();
                            }
                            if (select.toUpperCase().equals(correctAnswer)) {
                                double sc = Math.round(Math.random() * 750.0 + 50.0);
                                addScore(sc);
                                System.out.print("\n");
                                System.out.println("You nailed it! (Correct Answer: " + correctAnswer + " - " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
                                System.out.println("+" + sc);
                                System.out.print("> ");
                                select = scanner.nextLine();
                                while (!(select.equals(""))) {
                                    System.out.print("\n");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                }
                                wrongQuestions.remove((d+1)-8);
                            } else if (select.equals(">")) {
                                Exit = true;
                                break;
                            } else {
                                System.out.print("\n");
                                System.out.println("Oops that's a miss! (Correct Answer: " + correctAnswer + " - " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
                                System.out.print("> ");
                                select = scanner.nextLine();
                                while (!(select.equals(""))) {
                                    System.out.print("\n");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                }
                                d++;
                                if (d >= i+1 + wrongQuestions.size()) {
                                    d = 7;
                                }
                            }
                            e++;
                        }
                        break;
                    }
                    if (currentFlashcard() > (quiz.size() - 1)) {
                        addAttempt();
                        resetFlashcard();
                        if (getAttempts() == 3) {
                            int len = wrongQuestions.size();
                            int d = 7;
                            int e = i+1;
                            while (wrongQuestions.size() != 0 && d < 7 + len) {
                                len = wrongQuestions.size();
                                Main.clear();
                                max = quiz.size() - 1;
                                System.out.println("Question #" + (e+1) + " (Redemption Question)");
                                System.out.print("\n");
                                System.out.println(quiz.get(wrongQuestions.get((d+1)-8)).getFlashcard());
                                System.out.print("\n");
                                System.out.println("Score: " + getScore());
                                System.out.print("\n");
                                letters = new String[4];
                                for (int a = 0; a < 4; a++) {
                                    if (a == 0) {
                                        letters[a] = "A";
                                    } else if (a == 1) {
                                        letters[a] = "B";
                                    } else if (a == 2) {
                                        letters[a] = "C";
                                    } else if (a == 3) {
                                        letters[a] = "D";
                                    }
                                }
                                correctAnswer = "";
                                random = (int) (Math.random() * 4);
                                answerIndexes = new int[4];
                                for (int p = 0; p < 4; p++) {
                                    answerIndexes[p] = -1;
                                }
                                for (int j = 0; j < 4; j++) {
                                    if (j == random) {
                                        System.out.println("[" + letters[j] + "] " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer());
                                        correctAnswer = letters[j];
                                        answerIndexes[j] = wrongQuestions.get((d+1)-8);
                                    } else {
                                        int in = (int) (Math.random() * max) + 1;
                                        boolean AlreadyExists = false;
                                        for (int p = 0; p < 4; p++) {
                                           if (answerIndexes[p] == in || in == wrongQuestions.get((d+1)-8)) {
                                                AlreadyExists = true;
                                                break;
                                            }
                                        }
                                        while (AlreadyExists) {
                                            in = (int) (Math.random() * max) + 1;
                                            AlreadyExists = false;
                                            for (int p = 0; p < 4; p++) {
                                               if (answerIndexes[p] == in || in == wrongQuestions.get((d+1)-8)) {
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
                                select = scanner.nextLine();
                                while (select.equals("")) {
                                    System.out.print("\n");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                }
                                if (select.toUpperCase().equals(correctAnswer)) {
                                    double sc = Math.round(Math.random() * 750.0 + 50.0);
                                    addScore(sc);
                                    System.out.print("\n");
                                    System.out.println("You nailed it! (Correct Answer: " + correctAnswer + " - " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
                                    System.out.println("+" + sc);
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                    while (!(select.equals(""))) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        select = scanner.nextLine();
                                    }
                                    wrongQuestions.remove((d+1)-8);
                                } else if (select.equals(">")) {
                                    Exit = true;
                                    break;
                                } else {
                                    System.out.print("\n");
                                    System.out.println("Oops that's a miss! (Correct Answer: " + correctAnswer + " - " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                    while (!(select.equals(""))) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        select = scanner.nextLine();
                                    }
                                    d++;
                                    if (d >= i+1 + wrongQuestions.size()) {
                                        d = 7;
                                    }
                                }
                                e++;
                            }
                            if (Exit == true) {
                                break;
                            }
                            Main.clear();
                            System.out.println("=========================================");
                            System.out.println("YOU HAVE COMPLETED THE LEARN QUIZ!!");
                            System.out.println("=========================================");
                            System.out.print("\n");
                            int inc = 0;
                            for (Flashcard flash: questions) {
                                System.out.println("#" + (inc+1) + ": " + flash.getFlashcard() + " - " + flash.getAnswer());
                                inc++;
                            }
                            System.out.print("\n");
                            System.out.print("Score: " + getScore());
                            System.out.print("\n");
                            System.out.print("> ");
                            select = scanner.nextLine();
                            while (!(select.equals(""))) {
                                System.out.print("\n");
                                System.out.print("> ");
                                select = scanner.nextLine();
                            }
                            Exit = true;
                            account.addExp();
                            if (account.getExp() >= account.getMaxExp()) {
                                account.lvlUp();
                            }
                            break;
                        }
                    }
                }
            } else {
                for (int i = 0; i < 7; i++) {
                    Main.clear();
                    int max = quiz.size() - 1;
                    System.out.println("Question #" + (i+1));
                    System.out.print("\n");
                    System.out.println(quiz.get(currentFlashcard()).getFlashcard());
                    System.out.print("\n");
                    System.out.println("Score: " + getScore());
                    System.out.print("\n");
                    String[] letters = new String[4];
                    for (int a = 0; a < 4; a++) {
                        if (a == 0) {
                            letters[a] = "A";
                        } else if (a == 1) {
                            letters[a] = "B";
                        } else if (a == 2) {
                            letters[a] = "C";
                        } else if (a == 3) {
                            letters[a] = "D";
                        }
                    }
                    String correctAnswer = "";
                    int random = (int) (Math.random() * 4);
                    int[] answerIndexes = new int[4];
                    for (int p = 0; p < 4; p++) {
                        answerIndexes[p] = -1;
                    }
                    for (int j = 0; j < 4; j++) {
                        if (j == random) {
                            System.out.println("[" + letters[j] + "] " + quiz.get(currentFlashcard()).getAnswer());
                            correctAnswer = letters[j];
                            answerIndexes[j] = currentFlashcard();
                        } else {
                            int in = (int) (Math.random() * max) + 1;
                            boolean AlreadyExists = false;
                            for (int p = 0; p < 4; p++) {
                               if (answerIndexes[p] == in || in == currentFlashcard()) {
                                    AlreadyExists = true;
                                    break;
                                }
                            }
                            while (AlreadyExists) {
                                in = (int) (Math.random() * max) + 1;
                                AlreadyExists = false;
                                for (int p = 0; p < 4; p++) {
                                   if (answerIndexes[p] == in || in == currentFlashcard()) {
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
                        double sc = Math.round(Math.random() * 750.0 + 50.0);
                        addScore(sc);
                        System.out.print("\n");
                        System.out.println("You nailed it! (Correct Answer: " + correctAnswer + " - " + quiz.get(currentFlashcard()).getAnswer() + ")");
                        System.out.println("+" + sc);
                        System.out.print("> ");
                        select = scanner.nextLine();
                        while (!(select.equals(""))) {
                            System.out.print("\n");
                            System.out.print("> ");
                            select = scanner.nextLine();
                        }
                    } else if (select.equals(">")) {
                        Exit = true;
                        break;
                    } else {
                        System.out.print("\n");
                        System.out.println("Oops that's a miss! (Correct Answer: " + correctAnswer + " - " + quiz.get(currentFlashcard()).getAnswer() + ")");
                        System.out.print("> ");
                        select = scanner.nextLine();
                        while (!(select.equals(""))) {
                            System.out.print("\n");
                            System.out.print("> ");
                            select = scanner.nextLine();
                        }
                        wrongQuestions.add(currentFlashcard());
                    }
                    questions.add(quiz.get(currentFlashcard()));
                    addNextFlashcard();
                    if (i == 6) {
                        int len = wrongQuestions.size();
                        int d = i+1;
                        int e = i+1;
                        while (wrongQuestions.size() != 0 && d < 7 + len) {
                            Main.clear();
                            max = quiz.size() - 1;
                            System.out.println("Question #" + (e+1) + " (Redemption Question)");
                            System.out.print("\n");
                            System.out.println(quiz.get(wrongQuestions.get((d+1)-8)).getFlashcard());
                            System.out.print("\n");
                            System.out.println("Score: " + getScore());
                            System.out.print("\n");
                            letters = new String[4];
                            for (int a = 0; a < 4; a++) {
                                if (a == 0) {
                                    letters[a] = "A";
                                } else if (a == 1) {
                                    letters[a] = "B";
                                } else if (a == 2) {
                                    letters[a] = "C";
                                } else if (a == 3) {
                                    letters[a] = "D";
                                }
                            }
                            correctAnswer = "";
                            random = (int) (Math.random() * 4);
                            answerIndexes = new int[4];
                            for (int p = 0; p < 4; p++) {
                                answerIndexes[p] = -1;
                            }
                            for (int j = 0; j < 4; j++) {
                                if (j == random) {
                                    System.out.println("[" + letters[j] + "] " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer());
                                    correctAnswer = letters[j];
                                    answerIndexes[j] = wrongQuestions.get((d+1)-8);
                                } else {
                                    int in = (int) (Math.random() * max) + 1;
                                    boolean AlreadyExists = false;
                                    for (int p = 0; p < 4; p++) {
                                       if (answerIndexes[p] == in || in == wrongQuestions.get((d+1)-8)) {
                                            AlreadyExists = true;
                                            break;
                                        }
                                    }
                                    while (AlreadyExists) {
                                        in = (int) (Math.random() * max) + 1;
                                        AlreadyExists = false;
                                        for (int p = 0; p < 4; p++) {
                                           if (answerIndexes[p] == in || in == wrongQuestions.get((d+1)-8)) {
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
                            select = scanner.nextLine();
                            while (select.equals("")) {
                                System.out.print("\n");
                                System.out.print("> ");
                                select = scanner.nextLine();
                            }
                            if (select.toUpperCase().equals(correctAnswer)) {
                                double sc = Math.round(Math.random() * 750.0 + 50.0);
                                addScore(sc);
                                System.out.print("\n");
                                System.out.println("You nailed it! (Correct Answer: " + correctAnswer + " - " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
                                System.out.println("+" + sc);
                                System.out.print("> ");
                                select = scanner.nextLine();
                                while (!(select.equals(""))) {
                                    System.out.print("\n");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                }
                                wrongQuestions.remove((d+1)-8);
                            } else if (select.equals(">")) {
                                Exit = true;
                                break;
                            } else {
                                System.out.print("\n");
                                System.out.println("Oops that's a miss! (Correct Answer: " + correctAnswer + " - " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
                                System.out.print("> ");
                                select = scanner.nextLine();
                                while (!(select.equals(""))) {
                                    System.out.print("\n");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                }
                                d++;
                                if (d >= 7 + wrongQuestions.size()) {
                                    d = 7;
                                }
                            }
                            e++;
                        }
                        if (wrongQuestions.size() == 0 && currentFlashcard() >= quiz.size() - 1 && getAttempts() != 3) {
                            addAttempt();
                            resetFlashcard();
                        }
                        if (getAttempts() != 3) {
                            break;
                        }
                    }
                    if (getAttempts() == 3) {
                        if (getAttempts() == 3) {
                            int len = wrongQuestions.size();
                            int d = 7;
                            int e = i+1;
                            while (wrongQuestions.size() != 0 && d < 7 + len) {
                                Main.clear();
                                max = quiz.size() - 1;
                                System.out.println("Question #" + (e+1) + " (Redemption Question)");
                                System.out.print("\n");
                                System.out.println(quiz.get(wrongQuestions.get((d+1)-8)).getFlashcard());
                                System.out.print("\n");
                                System.out.println("Score: " + getScore());
                                System.out.print("\n");
                                letters = new String[4];
                                for (int a = 0; a < 4; a++) {
                                    if (a == 0) {
                                        letters[a] = "A";
                                    } else if (a == 1) {
                                        letters[a] = "B";
                                    } else if (a == 2) {
                                        letters[a] = "C";
                                    } else if (a == 3) {
                                        letters[a] = "D";
                                    }
                                }
                                correctAnswer = "";
                                random = (int) (Math.random() * 4);
                                answerIndexes = new int[4];
                                for (int p = 0; p < 4; p++) {
                                    answerIndexes[p] = -1;
                                }
                                for (int j = 0; j < 4; j++) {
                                    if (j == random) {
                                        System.out.println("[" + letters[j] + "] " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer());
                                        correctAnswer = letters[j];
                                        answerIndexes[j] = wrongQuestions.get((d+1)-8);
                                    } else {
                                        int in = (int) (Math.random() * max) + 1;
                                        boolean AlreadyExists = false;
                                        for (int p = 0; p < 4; p++) {
                                           if (answerIndexes[p] == in || in == wrongQuestions.get((d+1)-8)) {
                                                AlreadyExists = true;
                                                break;
                                            }
                                        }
                                        while (AlreadyExists) {
                                            in = (int) (Math.random() * max) + 1;
                                            AlreadyExists = false;
                                            for (int p = 0; p < 4; p++) {
                                               if (answerIndexes[p] == in || in == wrongQuestions.get((d+1)-8)) {
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
                                select = scanner.nextLine();
                                while (select.equals("")) {
                                    System.out.print("\n");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                }
                                if (select.toUpperCase().equals(correctAnswer)) {
                                    double sc = Math.round(Math.random() * 750.0 + 50.0);
                                    addScore(sc);
                                    System.out.print("\n");
                                    System.out.println("You nailed it! (Correct Answer: " + correctAnswer + " - " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
                                    System.out.println("+" + sc);
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                    while (!(select.equals(""))) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        select = scanner.nextLine();
                                    }
                                    wrongQuestions.remove((d+1)-8);
                                } else if (select.equals(">")) {
                                    Exit = true;
                                    break;
                                } else {
                                    System.out.print("\n");
                                    System.out.println("Oops that's a miss! (Correct Answer: " + correctAnswer + " - " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                    while (!(select.equals(""))) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        select = scanner.nextLine();
                                    }
                                    d++;
                                    if (d >= 7 + wrongQuestions.size()) {
                                        d = 7;
                                    }
                                }
                                e++;
                            }
                            if (Exit == true) {
                                break;
                            }
                            Main.clear();
                            System.out.println("=========================================");
                            System.out.println("YOU HAVE COMPLETED THE LEARN QUIZ!!");
                            System.out.println("=========================================");
                            System.out.print("\n");
                            int inc = 0;
                            for (Flashcard flash: questions) {
                                System.out.println("#" + (inc+1) + ": " + flash.getFlashcard() + " - " + flash.getAnswer());
                                inc++;
                            }
                            System.out.print("\n");
                            System.out.print("Score: " + getScore());
                            System.out.print("\n");
                            System.out.print("> ");
                            select = scanner.nextLine();
                            while (!(select.equals(""))) {
                                System.out.print("\n");
                                System.out.print("> ");
                                select = scanner.nextLine();
                            }
                            Exit = true;
                            account.addExp();
                            if (account.getExp() >= account.getMaxExp()) {
                                account.lvlUp();
                            }
                            break;
                        }
                    }
                }
            }
            if (Exit != true) {
                Main.clear();
                System.out.println("====================");
                System.out.println("GREAT JOB!!");
                System.out.println("====================");
                System.out.print("\n");
                int inc = 0;
                for (Flashcard flash: questions) {
                    System.out.println("#" + (inc+1) + ": " + flash.getFlashcard() + " - " + flash.getAnswer());
                    inc++;
                }
                System.out.print("\n");
                System.out.print("Score: " + getScore());
                System.out.print("\n");
                System.out.println("[R] Replay Quiz");
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
                    session(account);
                }
            }
        } else {
            Main.clear();
            System.out.println("=========================================");
            System.out.println("YOU HAVE COMPLETED THE LEARN QUIZ!!");
            System.out.println("=========================================");
            System.out.print("\n");
            System.out.print("Restart the quiz? (Y/N) > ");
            String select = scanner.nextLine();
            while (!(select.toUpperCase().equals("Y")) && !(select.toUpperCase().equals("N"))) {
                System.out.print("\n");
                System.out.print("> ");
                select = scanner.nextLine();
            }
            if (select.toUpperCase().equals("Y")) {
                resetData();
                session(account);
            }
        }    
    }
}