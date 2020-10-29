import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Biome> biomes;

    public Portfolio() {
        this.biomes = new ArrayList<>();
    }
    public int getSize()
    {
        return this.biomes.size();
    }
    public boolean add(Biome b, Player player)
    {
        this.biomes.add(b);
        b.setOwner(player);
        return true;
    }
}
