import java.util.ArrayList;
import java.util.Scanner;

class Quizzes {
    public static ArrayList<ArrayList<Flashcard>> quizzies = new ArrayList<ArrayList<Flashcard>>();

    public Quizzes(ArrayList<Flashcard> quiz) {
        Quizzes.quizzies.add(quiz);
    }

    public static void addNewQuiz(ArrayList<Flashcard> quiz) {
        Quizzes.quizzies.add(quiz);
        Main.clear();
        System.out.print("Your new quiz has been successfully added! > ");
        Scanner scanner1 = new Scanner(System.in);
        String scanner2 = scanner1.nextLine();
        while (!(scanner2.equals(""))) {
            System.out.print("\n");
            System.out.print("> ");
            scanner2 = scanner1.nextLine();
        }
    }

    public static int getListSize() {
        return Quizzes.quizzies.size();
    }

    public static String getQuizName(int index) {
        ArrayList<Flashcard> quiz = Quizzes.quizzies.get(index);
        Flashcard flashcard = quiz.get(0);
        return flashcard.getFlashcard();
    }

    public static ArrayList<Flashcard> getQuiz(int index) {
        ArrayList<Flashcard> quiz = Quizzes.quizzies.get(index);
        return quiz;
    }

    public static int getQuizLength(int index) {
        ArrayList<Flashcard> firstLayer = Quizzes.quizzies.get(index);
        return firstLayer.size() - 1;
    }

    public static void removeFlashcard(ArrayList<Flashcard> quiz, int index) {
        if (Quizzes.quizzies.contains(quiz) && index > 0 && index < quiz.size()) {
            quiz.remove(index);
        }
        if (quiz.size() == 0) {
            removeQuiz(quiz);
        }
    }

    public static void addNewFlashcard(int INDEX, Flashcard flashcard) {
        getQuiz(INDEX).add(flashcard);
    }

    public static void removeQuiz(ArrayList<Flashcard> quiz) {
        Quizzes.quizzies.remove(quiz);
    }
}