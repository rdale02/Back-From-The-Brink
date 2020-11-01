public class Tile {
    /**
     * @author Patrick & Ronan
     * Patrick is responsible for the general structure of this class and its methods, as well as its Class Diagram
     * Ronan is responsible for implementation of validation, as well as integrating the structure into the prototype
     */
    private String name;
    private Resource price;
    private TileType type;
    private Player owner;

    public Tile(String name, Resource price,TileType type) {
        /**
         * @param name represents the name of the tile
         * @param price represents what a player must pay to claim the tile
         * @param type represents the type of the tile
         * @author Patrick
         */
        this.name = name;
        this.price = price;
        this.type = type;
        this.owner = null;
    }

    public String TileInfo(){
        /**
         * @return a concatenated string of information about this tile.
         * @author Patrick
         */
        String output = "";
        output += ("Name: "+ this.getName()+"\n");
        output += ("Price: "+ this.getPrice().getQuantity() + " " + this.getPrice().getResourceType()+ "\n");
        output += ("Type: "+ this.getTileType()+ "\n");
        output += ("Owner: " + this.owner + "\n");
        return output;
    }

    public boolean setOwner(Player player)
    {
        if(this.owner.equals(null))
        {
            this.owner = player;
            return true;
        }
        return false;
    }

    public boolean setName(String name) {
        /**
         * @param name of the biome
         * @return true if the assignment is successful
         * @return false if the assignment is unsuccessful
         */
        if(name.length() > 0)
        {
            this.name= name;
            return true;
        }
        return false;
    }
    public void setPrice(Resource price) {
        if(!price.equals(null))
            this.price = price;
    }
    public void setTileType(TileType type) {
        this.type= type;
    }

    public String getName() {
        return this.name;
    }
    public Resource getPrice() {
        return this.price;
    }
    public TileType getTileType() {
        return this.type;
    }
}
