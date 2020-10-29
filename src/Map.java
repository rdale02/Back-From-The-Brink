import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Map
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int turnCount = 0;
        ArrayList<Player> players = new ArrayList<Player>();
        int numPlayers = 0;
        while(numPlayers < 1 || numPlayers > 8)
        {
            System.out.println("How many players?");
            numPlayers = scan.nextInt();
        }
        for(int i = 1; i < numPlayers+1; i++) //for each player in the game, get their name
        {
            System.out.println("Enter the name of Player " + i);
            String name = "";
            while(name.length() < 2) //add duplicate validation clause
            {
                name = scan.nextLine();
            }
            Player p = new Player(name);
            players.add(p);
        }
        for(Player p : players)
        {
            System.out.println(p.describe());
        }
        Tile[] map = new Tile[40];
        Resource demo = new Resource(ResourceType.Money,0.0);
        Resource sMoney = new Resource(ResourceType.Money, 10.0);
        Resource mMoney = new Resource(ResourceType.Money, 20.0);
        Resource lMoney = new Resource(ResourceType.Money, 30.0);
        Resource sAwareness = new Resource(ResourceType.Awareness, 1.5);
        map[0]= new Tile("Go",mMoney,TileType.Game);
        map[1]= new Tile("Himalayas",demo,TileType.Mountain);
        map[2]= new Tile("Community Chest",demo,TileType.Card);
        map[3]= new Tile("Andes",demo,TileType.Mountain);
        map[4]= new Tile("Awareness Tax",demo,TileType.Tax);
        map[5]= new Tile("Public Transport",demo,TileType.Transport);
        map[6]= new Tile("Kalahari",demo,TileType.Desert);
        map[7]= new Tile("Wildcard",demo,TileType.Card);
        map[8]= new Tile("Namib",demo,TileType.Desert);
        map[9]= new Tile("Sahara",demo,TileType.Desert);
        map[10]= new Tile("Litter Pick",demo,TileType.Game);
        map[11]= new Tile("Manchurian Plain",demo,TileType.Grasslands);
        map[12]= new Tile("Research Tax",demo,TileType.Tax);
        map[13]= new Tile("Kazakh Steppe",demo,TileType.Grasslands);
        map[14]= new Tile("Canadian Prairies",demo,TileType.Grasslands);
        map[15]= new Tile("Public Transport",demo,TileType.Transport);
        map[16]= new Tile("Alaska",demo,TileType.Tundra);
        map[17]= new Tile("Community Chest",demo,TileType.Card);
        map[18]= new Tile("Greenland",demo,TileType.Tundra);
        map[19]= new Tile("Scandinavia",demo,TileType.Tundra);
        map[20]= new Tile("Electric Vehicle Parking",demo,TileType.Game);
        map[21]= new Tile("Amazon",demo,TileType.Rainforest);
        map[22]= new Tile("Wildcard",demo,TileType.Card);
        map[23]= new Tile("Congolian Rainforest",demo,TileType.Rainforest);
        map[24]= new Tile("Daintree Rainforest",demo,TileType.Rainforest);
        map[25]= new Tile("Public Transport",demo,TileType.Transport);
        map[26]= new Tile("Great Barrier Reef",demo,TileType.Coral);
        map[27]= new Tile("Tubbataha", demo, TileType.Coral);
        map[28]= new Tile("Energy Tax",demo, TileType.Tax);
        map[29]= new Tile("Apo Reef",demo,TileType.Coral);
        map[30]= new Tile("GO to Litter Pick", demo,TileType.Game);
        map[31]= new Tile("Kakamega Woodlands",demo,TileType.Woodlands);
        map[32]= new Tile("Pollett's Cove",demo,TileType.Woodlands);
        map[33]= new Tile("Community Chest",demo,TileType.Card);
        map[34]= new Tile("Cathedral Pines",demo,TileType.Woodlands);
        map[35]= new Tile("Public Transport",demo,TileType.Transport);
        map[36]= new Tile("Wildcard",demo,TileType.Card);
        map[37]= new Tile("Serengeti",demo,TileType.Savannah);
        map[38]= new Tile("Money Tax",demo,TileType.Tax);
        map[39]= new Tile("Cerrado",demo,TileType.Savannah);

        for(int i =0;i<39;i++) {
            Tile t= map[i];
            System.out.println(t.TileInfo());
        }
        System.out.println("Enter the number of turns (>5)");
        int turns = 0;
        while(turns < 5)
        {
            turns = scan.nextInt();
        }
        for(int i = 0; i < turns;i++)
        {
            for(Player p : players)
            {
                turn(p,map);
            }
        }


    }
    private static void turn(Player p, Tile[] map)
    {
        Random rnd = new Random();
        int movement = rnd.nextInt(6) + rnd.nextInt(6);
        System.out.print(p.getNickname() + " moves " + movement + " spaces.\n");
        p.move(movement, map);
    }
    public boolean checkBalance(Tile t, Player p)
    {
        for(Resource r : p.getWallet().getResources())
        {
            if(r.equals(t.getPrice().getResourceType()))
            {
                if(r.getQuantity() >= t.getPrice().getQuantity())
                {
                    r.lose(t.getPrice().getQuantity());
                }
            }
        }
        return false;
    }



}

