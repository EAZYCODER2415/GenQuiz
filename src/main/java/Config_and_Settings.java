import java.util.Scanner;

class Config_and_Settings {
    private String name;
    private int level;
    private double exp;
    private int multiplier;
    private int maxEXP;

    public Config_and_Settings(String n) {
        name = n;
        level = 0;
        exp = 0.0;
        multiplier = 1;
        maxEXP = 200;
    }

    public String getACCName() {
        return name;
    }

    public int getLvl() {
        return level;
    }

    public double getExp() {
        return Math.round(exp);
    }

    public double getMaxExp() {
        return maxEXP;
    }

    public void addExp() {
        exp += (Math.random() * 200) * multiplier;
    }

    public void lvlUp() {
        level++;
        exp = maxEXP - exp;
        if (exp < 1) {
            exp = 0;
        }
        multiplier += 0.05;
        maxEXP *= 2;
        Main.clear();
        System.out.print("You have leveled up!! (LEVEL " + level + ") > ");
        Scanner scanner1 = new Scanner(System.in);
        String scanner2 = scanner1.nextLine();
        while (!(scanner2.equals(""))) {
            System.out.print("\n");
            System.out.print("> ");
            scanner2 = scanner1.nextLine();
        }
        if (exp >= maxEXP) {
            lvlUp();
        }
    }
}