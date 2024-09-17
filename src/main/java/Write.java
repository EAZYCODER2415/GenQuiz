import java.util.ArrayList;
import java.util.Scanner;

class Write extends Learn {

    public boolean hardOrNot;
    
    public Write(ArrayList<Flashcard> q, boolean hon) {
        super(q);
        hardOrNot = hon;
    }

    public boolean getDifficulty() {
        return hardOrNot;
    }

    public void setDifficulty(boolean bool) {
        hardOrNot = bool;
    }

    public void session(Config_and_Settings account) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> wrongQuestions = new ArrayList<Integer>();
        ArrayList<Flashcard> questions = new ArrayList<Flashcard>();
        if (super.getAttempts() < 3) {
            super.resetScore();
            boolean Exit = false;
            if (quiz.size()-1 < 7) {
                for (int i = 0; i < quiz.size(); i++) {
                    Main.clear();
                    System.out.println("Question #" + (i+1));
                    System.out.print("\n");
                    System.out.println(quiz.get(super.currentFlashcard()).getFlashcard());
                    System.out.print("\n");
                    System.out.println("Score: " + super.getScore());
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
                    if (select.toLowerCase().equals(quiz.get(super.currentFlashcard()).getAnswer().toLowerCase())) {
                        double sc = Math.round(Math.random() * 750.0 + 50.0);
                        super.addScore(sc);
                        System.out.print("\n");
                        System.out.println("You nailed it! (Correct Answer: " +  quiz.get(super.currentFlashcard()).getAnswer() + ")");
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
                        System.out.println("Oops that's a miss! (Correct Answer: " + quiz.get(super.currentFlashcard()).getAnswer() + ")");
                        System.out.print("> ");
                        select = scanner.nextLine();
                        while (!(select.equals(""))) {
                            System.out.print("\n");
                            System.out.print("> ");
                            select = scanner.nextLine();
                        }
                        wrongQuestions.add(super.currentFlashcard());
                    }
                    questions.add(quiz.get(super.currentFlashcard()));
                    super.addNextFlashcard();
                    if (i == 6) {
                        int len = wrongQuestions.size();
                        int d = 7;
                        int e = i+1;
                        while (wrongQuestions.size() != 0 && d < 7 + len) {
                            len = wrongQuestions.size();
                            Main.clear();
                            System.out.println("Question #" + (e+1) + " (Redemption Question)");
                            System.out.print("\n");
                            System.out.println(quiz.get(wrongQuestions.get((d+1)-8)).getFlashcard());
                            System.out.print("\n");
                            System.out.println("Score: " + getScore());
                            System.out.print("\n");
                            System.out.println("[>] Back to Menu");
                            System.out.print("\n");
                            System.out.print("> ");
                            select = scanner.nextLine();
                            while (select.equals("")) {
                                System.out.print("\n");
                                System.out.print("> ");
                                select = scanner.nextLine();
                            }
                            if (select.toLowerCase().equals(quiz.get(wrongQuestions.get((d+1)-8)).getAnswer().toLowerCase())) {
                                double sc = Math.round(Math.random() * 750.0 + 50.0);
                                super.addScore(sc);
                                System.out.print("\n");
                                System.out.println("You nailed it! (Correct Answer: " +  quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
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
                                System.out.println("Oops that's a miss! (Correct Answer: " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
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
                    if (super.currentFlashcard() > (quiz.size() - 1)) {
                        super.addAttempt();
                        super.resetFlashcard();
                        if (super.getAttempts() == 3) {
                            int len = wrongQuestions.size();
                            int d = 7;
                            int e = i+1;
                            while (wrongQuestions.size() != 0 && d < 7 + len) {
                                len = wrongQuestions.size();
                                Main.clear();
                                System.out.println("Question #" + (e+1) + " (Redemption Question)");
                                System.out.print("\n");
                                System.out.println(quiz.get(wrongQuestions.get((d+1)-8)).getFlashcard());
                                System.out.print("\n");
                                System.out.println("Score: " + getScore());
                                System.out.print("\n");
                                System.out.println("[>] Back to Menu");
                                System.out.print("\n");
                                System.out.print("> ");
                                select = scanner.nextLine();
                                while (select.equals("")) {
                                    System.out.print("\n");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                }
                                if (select.toLowerCase().equals(quiz.get(wrongQuestions.get((d+1)-8)).getAnswer().toLowerCase())) {
                                    double sc = Math.round(Math.random() * 750.0 + 50.0);
                                    super.addScore(sc);
                                    System.out.print("\n");
                                    System.out.println("You nailed it! (Correct Answer: " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
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
                                    System.out.println("Oops that's a miss! (Correct Answer: " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
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
                            System.out.println("YOU HAVE COMPLETED THE WRITE QUIZ!!");
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
                    System.out.println("Question #" + (i+1));
                    System.out.print("\n");
                    System.out.println(quiz.get(super.currentFlashcard()).getFlashcard());
                    System.out.print("\n");
                    System.out.println("Score: " + getScore());
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
                    if (select.toLowerCase().equals(quiz.get(super.currentFlashcard()).getAnswer().toLowerCase())) {
                        double sc = Math.round(Math.random() * 750.0 + 50.0);
                        super.addScore(sc);
                        System.out.print("\n");
                        System.out.println("You nailed it! (Correct Answer: " + quiz.get(super.currentFlashcard()).getAnswer() + ")");
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
                        System.out.println("Oops that's a miss! (Correct Answer: " + quiz.get(super.currentFlashcard()).getAnswer() + ")");
                        System.out.print("> ");
                        select = scanner.nextLine();
                        while (!(select.equals(""))) {
                            System.out.print("\n");
                            System.out.print("> ");
                            select = scanner.nextLine();
                        }
                        wrongQuestions.add(super.currentFlashcard());
                    }
                    questions.add(quiz.get(super.currentFlashcard()));
                    super.addNextFlashcard();
                    if (i == 6) {
                        int len = wrongQuestions.size();
                        int d = 7;
                        int e = i+1;
                        while (wrongQuestions.size() != 0 && d < 7 + len) {
                            Main.clear();
                            System.out.println("Question #" + (e+1) + " (Redemption Question)");
                            System.out.print("\n");
                            System.out.println(quiz.get(wrongQuestions.get((d+1)-8)).getFlashcard());
                            System.out.print("\n");
                            System.out.println("Score: " + getScore());
                            System.out.print("\n");
                            System.out.println("[>] Back to Menu");
                            System.out.print("\n");
                            System.out.print("> ");
                            select = scanner.nextLine();
                            while (select.equals("")) {
                                System.out.print("\n");
                                System.out.print("> ");
                                select = scanner.nextLine();
                            }
                            if (select.toLowerCase().equals(quiz.get(wrongQuestions.get((d+1)-8)).getAnswer().toLowerCase())) {
                                double sc = Math.round(Math.random() * 750.0 + 50.0);
                                super.addScore(sc);
                                System.out.print("\n");
                                System.out.println("You nailed it! (Correct Answer: " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
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
                                System.out.println("Oops that's a miss! (Correct Answer: " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
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
                    if (super.getAttempts() == 3) {
                        if (super.getAttempts() == 3) {
                            int len = wrongQuestions.size();
                            int d = 7;
                            int e = i+1;
                            while (wrongQuestions.size() != 0 && d < 7 + len) {
                                Main.clear();
                                System.out.println("Question #" + (e+1) + " (Redemption Question)");
                                System.out.print("\n");
                                System.out.println(quiz.get(wrongQuestions.get((d+1)-8)).getFlashcard());
                                System.out.print("\n");
                                System.out.println("Score: " + getScore());
                                System.out.print("\n");
                                System.out.println("[>] Back to Menu");
                                System.out.print("\n");
                                System.out.print("> ");
                                select = scanner.nextLine();
                                while (select.equals("")) {
                                    System.out.print("\n");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                }
                                if (select.toLowerCase().equals(quiz.get(wrongQuestions.get((d+1)-8)).getAnswer().toLowerCase())) {
                                    double sc = Math.round(Math.random() * 750.0 + 50.0);
                                    super.addScore(sc);
                                    System.out.print("\n");
                                    System.out.println("You nailed it! (Correct Answer: " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
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
                                    System.out.println("Oops that's a miss! (Correct Answer: " + quiz.get(wrongQuestions.get((d+1)-8)).getAnswer() + ")");
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
                            System.out.println("YOU HAVE COMPLETED THE WRITE QUIZ!!");
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
            System.out.println("YOU HAVE COMPLETED THE WRITE QUIZ!!");
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
                super.resetData();
                session(account);
            }
        }    
    }
}