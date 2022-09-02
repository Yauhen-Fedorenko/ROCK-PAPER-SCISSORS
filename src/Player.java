import java.util.Scanner;

public class Player implements Players {

    private String name;
    private VARIANTS variant;
    private int countVictorys = 0;
    private Scanner scanner;


    public Player(Scanner scanner){
        this.scanner = scanner;
        System.out.print("Give your name player: ");
        this.name = scanner.nextLine();
    }
    @Override
    public void setVariants(){
        System.out.println("Choice your combination, where \n0 - ROCK;\n1 - PAPER\n2 - " +
                "SCISSORS");
        System.out.print("Your combination, "+name+", is : ");
        byte combinationNumber =-5;
        while (true){
            if (scanner.hasNextByte(3)) {
                combinationNumber = scanner.nextByte();
                scanner.nextLine();
                if (combinationNumber<=2&&combinationNumber>=0)
                    break; else printInformation();}
            else printInformation();
        }
        switch (combinationNumber){
            case(0):
                variant = VARIANTS.ROCK;
                break;
            case(1):
                variant = VARIANTS.PAPER;
                break;
            case(2):
                variant = VARIANTS.SCISSORS;
                break;
            default:
                throw new RuntimeException();
        }
    }
    private void printInformation(){
        System.out.println("Please, give me number from zero to two,");
        System.out.print("Your combination, "+name+", is : ");
        scanner.nextLine();
    }

    @Override
    public VARIANTS getVariants() {
        return this.variant;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addVictory() {
        this.countVictorys++;
    }

    @Override
    public int getVictory() {
        return this.countVictorys;
    }
}
