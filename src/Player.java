public class Player {
    /**
     * @Author Ronan & Marcas
     * This is the base Player class.
     * All players have these properties and methods, but special Player types have extended behaviour.
     */
    private String nickname;
    private Wallet wallet;
    private Portfolio portfolio;
    private int position; //position on the board
    private int score;

    public Player(String nickname)
    /**
     * @param nickname represents this player in the console output.
     */
    {
        this.nickname = nickname; //assigns nickname to the player
        this.setScore(0); //zero score
        this.wallet = new Wallet(); //creates an empty wallet
    }
    public boolean setScore(int score)
    /**
     * @param score the new score of the player
     * @return True if the assignment is successful
     * @return False if the assignment is unsuccessful
     */
    {
        if(score >= 0)
        {
            this.score = score;
            return true;
        }
        return false;
    }
    public boolean tackleInitiative(Initiative initiative)
    /**
     * @param initiative The initiative which is to be tackled
     * @return False if the initiative cannot be completed or has already been completed.
     * @return True if it is able to be tackled.
     */
    {
        if(initiative.isCompleted()) //Cannot attempt a completed initiative
        {
            return false;
        }
        if(initiative.getLevel() == PriorityLevel.Low)
        {
            this.setScore(this.score + initiative.getScore());
            initiative.complete(); //Initiative is now completed and there is no need to revisit it
            return true;
        }
        //Medium
        //High
        //these two require turns to pass so in this prototype, they will not be implemented.
        return false;
    }
    public boolean move(int amount, Tile[] map)
    /**
     * @param amount Number of steps to move
     * @param map Used to show the range of tiles from 0 to X. If the movement would bring the user past X, reset to 0 at that stage
     * @return True if the method fires without exception
     */
    {
        for(int i = 0; i < amount; i++)
        {
            if(this.position +1 >= map.length)
            {
                position = 0; //Go from the end of the board to the start of the board
            }
            else
            {
                position++;
            }
        }
        return true;
    }
    public String describe()
    /**
     * @return details about the Player
     */
    {
        String output = "";
        output += "Name: \t\t" + this.nickname + "\n";
        output += "Score: \t\t" + this.score + "\n";
        output += "Square: \t" + this.position + "\n"; //Make map static to get a more descriptive method?
        return output;
    }

    public String getNickname()
    /**
     * @return nickname
     */
    {
        return this.nickname;
    }
    public Wallet getWallet()
    {
        return this.wallet;
    }
}