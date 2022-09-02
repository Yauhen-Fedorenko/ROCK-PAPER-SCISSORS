import java.util.Scanner;

public class RockPaperScissors {

    private static int countGames = 0;
    public static boolean haveDesire = true;

    public void whoIsWinner(Players player, Players bot){
        if (player.getVariants().equals(bot.getVariants())) {
            System.out.println("Tie");
            countGames++;
            return;
        }
        if ((player.getVariants().equals(VARIANTS.PAPER)&&bot.getVariants().equals(VARIANTS.ROCK))||
                (player.getVariants().equals(VARIANTS.ROCK)&&bot.getVariants().equals(VARIANTS.SCISSORS))||
                (player.getVariants().equals(VARIANTS.SCISSORS)&&bot.getVariants().equals(VARIANTS.PAPER)))
        {
            System.out.println("Named player wins: "+player.getName()+", computer used combination - "+bot.getVariants());
            countGames++;
            player.addVictory();
        } else {
            System.out.println("Named player wins: "+bot.getName()+", he used combination - "+bot.getVariants());
            countGames++;
            bot.addVictory();
        }
    }

    private void setHaveDesire(Scanner scanner){
        System.out.println("Do you want to play again?");
        String answer = new String("");
        while (true){
            System.out.print("Please, say me yes or not (y/n): ");
            answer = scanner.nextLine();
            if (answer.isEmpty()||(!answer.contains("n")&&!answer.contains("y"))) continue; else break;
        }
        if (answer.contains("n")) haveDesire = false;
    }
    private void printStatGames(Players player, Players bot) {
        int wins = player.getVictory();
        int losses = bot.getVictory();
        int ties = countGames - wins - losses;
        double percentageWon = wins*1.0/countGames;
        System.out.println("_________________________________________________________________________");
        System.out.printf("|  %6s  |  %6s  |  %6s  |  %12s  |  %14s  |\n",
                "œŒ¡≈ƒ¿", "œŒ–¿∆≈Õ»≈", "Õ»◊‹ﬂ", "¬—≈√Œ »√–", "œ–Œ÷≈Õ“ œŒ¡≈ƒ");
        System.out.println("_________________________________________________________________________");
        System.out.printf("|  %6d  |  %9d  |  %6d  |  %12d  |  %13.2f%%  |\n",
                wins, losses, ties, countGames, percentageWon * 100);
        System.out.println("_________________________________________________________________________");
    }
    public void startGame(){
        System.out.println("Welcome to the GAME ROCK, PAPER and SCISSORS!!!");
        Scanner scanner = new Scanner(System.in);
        Players player = new Player(scanner);
        Players bot = new Bot();
        do{
            bot.setVariants();
            player.setVariants();
            whoIsWinner(player, bot);
            setHaveDesire(scanner);
        }while (haveDesire);
        printStatGames(player, bot);
    }
}
