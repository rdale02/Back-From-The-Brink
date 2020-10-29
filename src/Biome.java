import java.util.ArrayList;

public class Biome {
    private String name;
    private TileType type;
    private Player owner;
    private ArrayList<Initiative> initiatives;

    public Biome(String name, TileType type)
    {
        this.name = name;
        this.type = type;
        this.owner = null;
        this.initiatives = new ArrayList<>();
    }
    public boolean setOwner(Player p)
    {
        this.owner = p;
        return true;
    }


}
