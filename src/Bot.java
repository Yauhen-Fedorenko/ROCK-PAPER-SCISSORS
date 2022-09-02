import java.util.Random;

public class Bot implements Players{
    private String name;
    private VARIANTS variant;
    private int countVictorys = 0;
    private Random random;

    public Bot(){
        this.name = "Bot";
        random = new Random();
    }
    @Override
    public void setVariants() {
        int x = random.nextInt(3);
        switch (x){
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
