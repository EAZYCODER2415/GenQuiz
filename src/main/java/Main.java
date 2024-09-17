import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void clear() {
        /**
        * Code Source URL: https://www.javatpoint.com/how-to-clear-screen-in-java
        * Author: Javatpoint
        * Line Numbers: 2
        * Reason for inclusion: Method to clear screen in Java (like the Python replit.clear() function);
        * Explanation of code: \033[H\033[2J is an ASCII code in which \033 means ESC, following a control sequence indicator (CSI) which moves the cursor to the top-left corner (\033[H) and clear everything starting from there (\033[2J). The flush command resets the position of the cursor back to the top-left corner of the screen.
        */
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static String title() {
        return "  ______                        ______             __           " + "\n" + " /      \\                      /      \\           |  \\          " + "\n" + "|  $$$$$$\\  ______   _______  |  $$$$$$\\ __    __  \\$$ ________ " + "\n" + "| $$ __\\$$ /      \\ |       \\ | $$  | $$|  \\  |  \\|  \\|        \\" + "\n" + "| $$|    \\|  $$$$$$\\| $$$$$$$\\| $$  | $$| $$  | $$| $$ \\$$$$$$$$" + "\n" + "| $$ \\$$$$| $$    $$| $$  | $$| $$ _| $$| $$  | $$| $$  /    $$ " + "\n" + "| $$__| $$| $$$$$$$$| $$  | $$| $$/ \\ $$| $$__/ $$| $$ /  $$$$_ " + "\n" + " \\$$    $$ \\$$     \\| $$  | $$ \\$$ $$ $$ \\$$    $$| $$|  $$    \\" + "\n" + "  \\$$$$$$   \\$$$$$$$ \\$$   \\$$  \\$$$$$$\\  \\$$$$$$  \\$$ \\$$$$$$$$" + "\n" + "                                    \\$$$                        ";
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i < 5; i++) {
            clear();
            System.out.println(title());
            System.out.print("\n");
            System.out.print("Loading");
            Thread.sleep(500);
            clear();
            System.out.println(title());
            System.out.print("\n");
            System.out.print("Loading.");
            Thread.sleep(500);
            clear();
            System.out.println(title());
            System.out.print("\n");
            System.out.print("Loading..");
            Thread.sleep(500);
            clear();
            System.out.println(title());
            System.out.print("\n");
            System.out.print("Loading...");
            Thread.sleep(500);
        }
        clear();
        Thread.sleep(1000); 
        System.out.println("Welcome to GENQUIZ!");
        Thread.sleep(750);
        System.out.println("A superb study review app, guaranteed to help you ace your hunt of academical prowess!!");
        Thread.sleep(3000);
        System.out.println("Create your account to get started!");
        System.out.print("What is your name: ");
        Scanner nameInput = new Scanner(System.in);
        String ni = nameInput.nextLine();
        Config_and_Settings config = new Config_and_Settings(ni);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            clear();
            System.out.println("GenQuiz");
            System.out.print("\n");
            System.out.println(config.getACCName() + ": Level " + config.getLvl() + " (" + config.getExp() + "/" + config.getMaxExp() + ")");
            System.out.print("\n");
            System.out.println("[1] New Quiz");
            System.out.println("[2] Open Quiz");
            System.out.println("[E] Log Out");
            System.out.print("\n");
            System.out.print("> ");
            String select = scanner.nextLine();
            while (select.equals("")) {
                System.out.print("> ");
                select = scanner.nextLine();
            }
            clear();
            if (select.equals("1")) {
                System.out.print("Quiz Name: ");
                String name = scanner.nextLine();
                while (name.equals("")) {
                    System.out.print("\n");
                    System.out.print("Quiz Name: ");
                    name = scanner.nextLine();
                }
                System.out.print("\n");
                System.out.print("Description: ");
                String desc = scanner.nextLine();
                while (desc.equals("")) {
                    System.out.print("\n");
                    System.out.print("Description: ");
                    desc = scanner.nextLine();
                }
                System.out.print("\n");
                System.out.print("Flashcard #1: ");
                String flashcard = scanner.nextLine();
                while (flashcard.equals("")) {
                    System.out.print("\n");
                    System.out.print("Flashcard #1: ");
                    flashcard = scanner.nextLine();
                }
                System.out.print("\n");
                System.out.print("Answer: ");
                String answer = scanner.nextLine();
                while (answer.equals("")) {
                    System.out.print("\n");
                    System.out.print("Answer : ");
                    answer = scanner.nextLine();
                }
                boolean Done = false;
                int count = 1;
                ArrayList<Flashcard> array = new ArrayList<Flashcard>();
                array.add(new Flashcard(name, desc));
                array.add(new Flashcard(flashcard, answer));
                while (!Done) {
                    System.out.print("\n");
                    System.out.println("If you are done with the quiz, type 'done' anywhere to finish. Or cancel to discard your quiz draft.");
                    System.out.print("Flashcard #" + (count + 1) + ": ");
                    flashcard = scanner.nextLine();
                    while (flashcard.equals("")) {
                        System.out.print("\n");
                        System.out.print("Flashcard #" + (count + 1) + ": ");
                        flashcard = scanner.nextLine();
                    }
                    if (flashcard.toLowerCase().equals("done")) {
                        Quizzes.addNewQuiz(array);
                        break;
                    } else if (flashcard.toLowerCase().equals("cancel")) {
                        break;
                    }
                    System.out.print("\n");
                    System.out.print("Answer: ");
                    answer = scanner.nextLine();
                    if (answer.toLowerCase().equals("done")) {
                        Quizzes.addNewQuiz(array);
                        break;
                    } else if (answer.toLowerCase().equals("cancel")) {
                        break;
                    }
                    count++;
                    array.add(new Flashcard(flashcard, answer));
                }
            } else if (select.equals("2")) {
                if (Quizzes.quizzies.size() < 1) {
                    System.out.println("You currently have no quizzes.");
                    System.out.print("\n");
                    System.out.print("Press [ENTER] to go back > ");
                    select = scanner.nextLine();
                    while (!(select.equals(""))) {
                        System.out.print("\n");
                        System.out.print("Press [ENTER] to go back > ");
                        select = scanner.nextLine();
                    }
                } else {
                    System.out.println("You currently have " + Quizzes.getListSize() + " quizzes.");
                    System.out.print("\n");
                    int Count = 0;
                    for (int i = 0; i < Quizzes.getListSize(); i++) {
                        Count = i+1;
                        System.out.print("[" + Count + "] " + Quizzes.getQuizName(i) + ": " + Quizzes.getQuizLength(i) + " flashcards");
                        System.out.print("\n");
                    }
                    Count++;
                    System.out.print("[" + Count + "] " + "Back");
                    System.out.print("\n");
                    System.out.print("> ");
                    select = scanner.nextLine();
                    while (select.equals("")) {
                        System.out.print("> ");
                        select = scanner.nextLine();
                    }
                    if (Integer.valueOf(select) <= Quizzes.getListSize()) {
                        int InDex = Integer.valueOf(select) - 1;
                        String NAME = Quizzes.getQuizName(InDex);
                        String DESC = Quizzes.getQuiz(InDex).get(0).getAnswer();
                        int count = 1;
                        boolean SideFlip = false;
                        Learn learn = new Learn(Quizzes.quizzies.get(InDex));
                        Learn write = new Write(Quizzes.quizzies.get(InDex), false);
                        while (true) {
                            clear();
                            NAME = Quizzes.getQuizName(InDex);
                            DESC = Quizzes.getQuiz(InDex).get(0).getAnswer();
                            System.out.println(NAME);
                            System.out.print("\n");
                            System.out.println(DESC);
                            System.out.print("\n");
                            System.out.println(count + "/" + Quizzes.getQuizLength(InDex) + " flashcards");
                            System.out.print("\n");
                            if (SideFlip == false) {
                                System.out.print("+");
                                for (int t = 0; t < Quizzes.getQuiz(InDex).get(count).getFlashcard().length() + 2; t++) {
                                    System.out.print("-");
                                }
                                System.out.print("+");
                                System.out.print("\n");
                                for (int i = 0; i < 2; i++) {
                                    System.out.print("|");
                                    for (int t = 0; t < Quizzes.getQuiz(InDex).get(count).getFlashcard().length() + 2; t++) {
                                        System.out.print(" ");
                                    }
                                    System.out.print("|");
                                    System.out.print("\n");
                                }
                                System.out.println("|" + " " + Quizzes.getQuiz(InDex).get(count).getFlashcard() + " " + "|");
                                for (int i = 0; i < 2; i++) {
                                    System.out.print("|");
                                    for (int t = 0; t < Quizzes.getQuiz(InDex).get(count).getFlashcard().length() + 2; t++) {
                                        System.out.print(" ");
                                    }
                                    System.out.print("|");
                                    System.out.print("\n");
                                }
                                System.out.print("+");
                                for (int t = 0; t < Quizzes.getQuiz(InDex).get(count).getFlashcard().length() + 2; t++) {
                                    System.out.print("-");
                                }
                                System.out.print("+");
                            } else if (SideFlip == true) {
                                System.out.print("+");
                                for (int t = 0; t < Quizzes.getQuiz(InDex).get(count).getAnswer().length() + 2; t++) {
                                    System.out.print("-");
                                }
                                System.out.print("+");
                                System.out.print("\n");
                                for (int i = 0; i < 2; i++) {
                                    System.out.print("|");
                                    for (int t = 0; t < Quizzes.getQuiz(InDex).get(count).getAnswer().length() + 2; t++) {
                                        System.out.print(" ");
                                    }
                                    System.out.print("|");
                                    System.out.print("\n");
                                }
                                System.out.println("|" + " " + Quizzes.getQuiz(InDex).get(count).getAnswer() + " " + "|");
                                for (int i = 0; i < 2; i++) {
                                    System.out.print("|");
                                    for (int t = 0; t < Quizzes.getQuiz(InDex).get(count).getAnswer().length() + 2; t++) {
                                        System.out.print(" ");
                                    }
                                    System.out.print("|");
                                    System.out.print("\n");
                                }
                                System.out.print("+");
                                for (int t = 0; t < Quizzes.getQuiz(InDex).get(count).getAnswer().length() + 2; t++) {
                                    System.out.print("-");
                                }
                                System.out.print("+");
                            }
                            System.out.println("\n");
                            System.out.println("[F] Flip Flashcard");
                            System.out.println("[<] Prev | [>] Next");
                            System.out.println("[E] Edit Quiz");
                            System.out.println("[B] Back to Main Menu");
                            System.out.print("\n");
                            System.out.println("MINI-GAMES");
                            System.out.println("[L] Learn");
                            System.out.println("[T] Test");
                            System.out.println("[W] Write");
                            System.out.print("\n");
                            System.out.print("> ");
                            select = scanner.nextLine();
                            while (select.equals("")) {
                                System.out.print("> ");
                                select = scanner.nextLine();
                            }
                            clear();
                            if (select.toUpperCase().equals("B")) {
                                System.out.println("Are you sure? Your data will be lost once you leave this screen. (Y/N)");
                                System.out.print("\n");
                                System.out.print("> ");
                                select = scanner.nextLine();
                                while (select.equals("") || (!(select.toUpperCase().equals("Y")) && !(select.toUpperCase().equals("N")))) {
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                }
                                if (select.toUpperCase().equals("Y")) {
                                    break;
                                }
                            } else if (select.toUpperCase().equals("F")) {
                                if (SideFlip == false) {
                                    SideFlip = true;
                                } else {
                                    SideFlip = false;
                                }
                            } else if (select.equals("<")) {
                                if (count - 1 < 1) {
                                    count = Quizzes.getQuizLength(InDex);
                                } else {
                                    count--;
                                }
                                SideFlip = false;
                            } else if (select.equals(">")) {
                                if (count + 1 > Quizzes.getQuizLength(InDex)) {
                                    count = 1;
                                } else {
                                    count++;
                                }
                                SideFlip = false;
                            } else if (select.toUpperCase().equals("E")) {
                                System.out.println("[0] Add Flashcard");
                                System.out.println("[1] Edit Flashcard");
                                System.out.println("[2] Edit Answer");
                                System.out.println("[3] Delete Flashcard");
                                System.out.println("[4] Edit Name");
                                System.out.println("[5] Edit Description");
                                System.out.println("[6] Delete Quiz");
                                System.out.print("> ");
                                select = scanner.nextLine();
                                while (select.equals("") || Integer.valueOf(select) < 0 || Integer.valueOf(select) > 6) {
                                    System.out.print("\n");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                }
                                System.out.print("\n");
                                if (Integer.valueOf(select) == 1) {
                                    System.out.print("Select a flashcard number: ");
                                    String number = scanner.nextLine();
                                    while (Integer.valueOf(number).equals("") || Integer.valueOf(number) < 1 || Integer.valueOf(number) > Quizzes.getQuizLength(InDex)) {
                                        number = scanner.nextLine();
                                    }
                                    System.out.print("\n");
                                    System.out.print("Type in the new flashcard: ");
                                    String name = scanner.nextLine();
                                    while (name.equals("")) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        name = scanner.nextLine();
                                    }
                                    Quizzes.getQuiz(InDex).get(Integer.valueOf(number)).setFlashcard(name);
                                    System.out.print("\n");
                                    System.out.print("Done!");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                    while (!(select.equals(""))) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        select = scanner.nextLine();
                                    }
                                } else if (Integer.valueOf(select) == 2) {
                                    System.out.print("Select a flashcard number: ");
                                    String number = scanner.nextLine();
                                    while (Integer.valueOf(number).equals("") || Integer.valueOf(number) < 1 || Integer.valueOf(number) > Quizzes.getQuizLength(InDex)) {
                                        number = scanner.nextLine();
                                    }
                                    System.out.print("\n");
                                    System.out.print("Type in the new answer: ");
                                    String ans = scanner.nextLine();
                                    while (ans.equals("")) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        ans = scanner.nextLine();
                                    }
                                    Quizzes.getQuiz(InDex).get(Integer.valueOf(number)).setAnswer(ans);
                                    System.out.print("\n");
                                    System.out.print("Done!");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                    while (!(select.equals(""))) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        select = scanner.nextLine();
                                    }
                                } else if (Integer.valueOf(select) == 3) {
                                    System.out.print("Select a flashcard number: ");
                                    String number = scanner.nextLine();
                                    while (Integer.valueOf(number).equals("") || Integer.valueOf(number) < 1 || Integer.valueOf(number) > Quizzes.getQuizLength(InDex)) {
                                        number = scanner.nextLine();
                                    }
                                    System.out.print("\n");
                                    Quizzes.removeFlashcard(Quizzes.getQuiz(InDex), Integer.valueOf(number));
                                    System.out.print("Done!");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                    while (!(select.equals(""))) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        select = scanner.nextLine();
                                    }
                                    if (Quizzes.getQuizLength(InDex) == 0) {
                                        Quizzes.removeQuiz(Quizzes.getQuiz(InDex));
                                        break;
                                    }
                                } else if (Integer.valueOf(select) == 0) {
                                    System.out.println("Type 'cancel' to discard your draft if desirable.");
                                    System.out.print("Flashcard #" + (Quizzes.getQuizLength(InDex) + 1) + ": ");
                                    String Flashcard = scanner.nextLine();
                                    while (Flashcard.equals("")) {
                                        System.out.print("\n");
                                        System.out.print("Flashcard #" + (Quizzes.getQuizLength(InDex) + 1) + ": ");
                                        Flashcard = scanner.nextLine();
                                    }
                                    if (!Flashcard.toLowerCase().equals("cancel")) {
                                        System.out.print("\n");
                                        System.out.print("Answer: ");
                                        String Answer = scanner.nextLine();
                                        while (Answer.equals("")) {
                                            System.out.print("\n");
                                            System.out.print("Answer: ");
                                            Answer = scanner.nextLine();
                                        }
                                        if (!(Answer.toLowerCase().equals("cancel"))) {
                                            Quizzes.addNewFlashcard(InDex, new Flashcard(Flashcard, Answer));
                                            System.out.print("\n");
                                            System.out.print("Done!");
                                            System.out.print("> ");
                                            select = scanner.nextLine();
                                            while (!(select.equals(""))) {
                                                System.out.print("\n");
                                                System.out.print("> ");
                                                select = scanner.nextLine();
                                            }
                                        }
                                    }
                                } else if (Integer.valueOf(select) == 4) {
                                    System.out.print("Type in the new name: ");
                                    String ans = scanner.nextLine();
                                    while (ans.equals("")) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        ans = scanner.nextLine();
                                    }
                                    Quizzes.getQuiz(InDex).set(0, new Flashcard(ans, Quizzes.getQuiz(InDex).get(0).getAnswer()));
                                    System.out.print("\n");
                                    System.out.print("Done!");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                    while (!(select.equals(""))) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        select = scanner.nextLine();
                                    }
                                } else if (Integer.valueOf(select) == 5) {
                                    System.out.print("Type in the new desc: ");
                                    String ans = scanner.nextLine();
                                    while (ans.equals("")) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        ans = scanner.nextLine();
                                    }
                                    Quizzes.getQuiz(InDex).get(0).setAnswer(ans);
                                    System.out.print("\n");
                                    System.out.print("Done!");
                                    System.out.print("> ");
                                    select = scanner.nextLine();
                                    while (!(select.equals(""))) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        select = scanner.nextLine();
                                    }
                                } else if (Integer.valueOf(select) == 6) {
                                    System.out.print("Are you sure? (Y/N) > ");
                                    String ans = scanner.nextLine();
                                    while (ans.equals("")) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        ans = scanner.nextLine();
                                    }
                                    if (ans.toUpperCase().equals("Y")) {
                                        Quizzes.removeQuiz(Quizzes.getQuiz(InDex));
                                        System.out.print("\n");
                                        System.out.print("Done!");
                                        System.out.print("> ");
                                        select = scanner.nextLine();
                                        while (!(select.equals(""))) {
                                            System.out.print("\n");
                                            System.out.print("> ");
                                            select = scanner.nextLine();
                                        }
                                        break;
                                    }
                                }
                            } else if (select.toUpperCase().equals("L")) {
                                if (Quizzes.getQuizLength(InDex) == 1) {
                                    Main.clear();
                                    System.out.print("Your quiz has only one flashcard. Create another flashcard. > ");
                                    select = scanner.nextLine();
                                    while (!(select.equals(""))) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        select = scanner.nextLine();
                                    }
                                } else {
                                    learn.session(config);
                                }
                            } else if (select.toUpperCase().equals("T")) {
                                if (Quizzes.getQuizLength(InDex) == 1) {
                                    Main.clear();
                                    System.out.print("Your quiz has only one flashcard. Create another flashcard. > ");
                                    select = scanner.nextLine();
                                    while (!(select.equals(""))) {
                                        System.out.print("\n");
                                        System.out.print("> ");
                                        select = scanner.nextLine();
                                    }
                                } else {
                                    if (Quizzes.getQuizLength(InDex) == 1) {
                                        Main.clear();
                                        System.out.print("Your quiz has only one flashcard. Create another flashcard. > ");
                                        select = scanner.nextLine();
                                        while (!(select.equals(""))) {
                                            System.out.print("\n");
                                            System.out.print("> ");
                                            select = scanner.nextLine();
                                        }
                                    } else {
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
                                                Learn test = new Test(Quizzes.quizzies.get(InDex), 10);
                                                test.session(config);
                                            } else if (Integer.valueOf(select2) == 15) {
                                                Learn test = new Test(Quizzes.quizzies.get(InDex), 15);
                                                test.session(config);
                                            } else if (Integer.valueOf(select2) == 20) {
                                                Learn test = new Test(Quizzes.quizzies.get(InDex), 20);
                                                test.session(config);
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.print("go back");
                                        }
                                    }
                                }
                            } else if (select.toUpperCase().equals("W")) {
                                write.session(config);
                            }
                        }
                    }
                }
            } else if (select.toUpperCase().equals("E")) {
                System.out.print("Are you sure? (Y/N) > ");
                String ans = scanner.nextLine();
                while (ans.equals("")) {
                    System.out.print("\n");
                    System.out.print("> ");
                    ans = scanner.nextLine();
                }
                if (ans.toUpperCase().equals("Y")) {
                    Main.clear();
                    scanner.close();
                    System.out.println("BYE!!");
                    break;
                }
            }
        }
    }
}