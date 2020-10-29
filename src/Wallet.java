import java.util.ArrayList;

public class Wallet
{
     /**
      * @param resources Defines what the owner of the wallet can use to purchase tiles and pay tolls.
      *                  Stores both the resource type and quantity of all resources in their possession.
      */
     private ArrayList<Resource> resources;

     public Wallet()//Constructor takes no arguments; a new wallet will always be empty.
     {
          this.resources = new ArrayList<Resource>(); //creation of the empty wallet
     }
     public int getSize()
     {
          return resources.size();
     }
     public ArrayList<Resource> getResources()
     /**
      * @return the resources inside the wallet.
      */
     {
          return this.resources;
     }


     public boolean add(Resource resource)
     /**
      * @return true once the resource has been added into the wallet.
      */
     {
          //Loop through until you get to the resource type
          for(Resource r : this.resources)
          {
               if(r.getResourceType() == resource.getResourceType())
               {
                    r.gain(resource.getQuantity());
                    return true;
               }
          }
          //If that resource type isn't found, add it
          resources.add(resource);
          return true;
     }
     public boolean lose(Resource resource)
     /**
      * @return true if the wallet contains a high enough quantity of the resource to be lost.
      * @return false if the wallet doesn't contain any/enough of the resource.
      */
     {
          //loop through to see if you have that resource
          for(Resource r : this.resources)
          {
               if(r.getResourceType() == resource.getResourceType())
               {
                    if(r.getQuantity() >= resource.getQuantity())
                    {
                         r.lose(resource.getQuantity());
                         if(r.getQuantity() ==0) //if there isn't any of the resource left, remove it from the wallet.
                         {
                              this.resources.remove(r);
                         }
                         return true;
                    }
                    else
                    {
                         return false; //fires if there isn't enough of the resource to be deducted.
                    }
               }
          }
          return false; //fires if there is none of that resource.
     }
     public String show()
     /**
      * @return a concatenation of each resource in the owner's possession, as well as their quantities.
      */
     {
          String output = "RESOURCE \t QUANTITY";
          for(Resource r:this.resources)
          {
               output += "\n" + r.getResourceType().toString().toUpperCase() + "\t" + r.getQuantity();
          }
          return output;
     }


}
