class Flashcard {
    private String flashcardName;
    private String answer;

    public Flashcard(String fn, String a) {
        flashcardName = fn;
        answer = a;
    }

    public String getFlashcard() {
        return flashcardName;
    }

    public String getAnswer() {
        return answer;
    }

    public void setFlashcard(String fn) {
        flashcardName = fn;
    }

    public void setAnswer(String a) {
        answer = a;
    }
}