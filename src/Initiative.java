/*
Initiative - Represents a
 */

/*
As soon as you acquire a priority square, other players must give you a contribution if they land on it.
However,before you can ‘tackle’or address a priority within an action areas,
you must manage/’be in charge of’ the whole action area (you decide what ‘custodianship’ -i.e. managing, being in charge of –means!).
As the person in charge of the whole action area,
you can tackle a priority on your turn even if you are not positioned on the particular priority square.
Decide what ‘tackling a priority’ means, what it represents,
and how much it costs in your game;
others might have to make an increased contribution if they land on a priority square and the priority is already being addressed.  (Again, you decide the nature and the significance of the transactions between players.)Three steps in addressing a priorityare  needed  before  you  can take(and  pay  for,  or  otherwise ‘resource’) a‘major step’ (again  you  decide  what  this represents and what it costs).Not only is there a cost associated with tackling a priority within an action area: the more steps the person in charge has taken to tackle the priority, the more other players have to offer if they land on that priority square.
 */
public class Initiative {
    /**
     * @author Ronan
     */
    private String name; //the name of the initiative
    private TileType area; //the tile that the initiative is tied to
    private int turnsLive; //the number of turns which have passed since the initiative was activated
    private int turnsToComplete;
    private boolean completed;
    private Resource cost; //the resource type and quantity required to start up the initiative
    private Resource output; //what is yielded when the initiative is complete
    private PriorityLevel level; //the priority of the initiative
    private int score;

    public Initiative(String name, TileType area, int turnsToComplete, Resource cost, Resource output, PriorityLevel level)
    {
        this.name = name;
        this.area = area;
        this.turnsLive = 0;
        this.cost = cost;
        this.level = level;
        if (level == PriorityLevel.Low) {
            this.turnsToComplete = 0; //ensures that the correct timescale for Low Priority is set
        } else {
            this.turnsToComplete = turnsToComplete;
        }

    }

    public boolean setCost(Resource cost)
    /**
     * @param cost The new cost of tackling this priority. Mainly used with Player Types that affect the cost of initiatives.
     * @return true if the new cost is the same type, but different quantity as the current cost.
     * @return false if the above condition isn't met.
     */
    {
        if(cost != this.cost && cost.getResourceType() == this.cost.getResourceType())
        {
            this.cost = cost;
            return true;
        }
        return false;
    }
    public PriorityLevel getLevel()
    /**
     * @return the Priority Level of this initiative
     */
    {
        return this.level;
    }
    public int getScore()
    /**
     * @return the number of points that this initiative is worth
     */
    {
        return this.score;
    }
    public boolean isCompleted()
    /**
     * @return True if the task has already been completed
     */
    {
        return this.completed;
    }
    public void complete() //not a setter because once it is completed, it can't be changed to not completed.
    {
        this.completed = true;
    }


}
