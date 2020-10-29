public class Resource {
    /*

     */
    private ResourceType resourceType;
    private double quantity;

    public Resource(ResourceType rt, double qty) //Constructor for a resource
    /**
     * @param rt the type of resource (Money, Time, Awareness etc).
     * @param qty the amount of that resource as a double.
     */
    {
        this.resourceType = rt;
        this.quantity = qty;
    }
    public ResourceType getResourceType()
    {
        return this.resourceType;
    }
    public double getQuantity()
    {
        return this.quantity;
    }
    public boolean gain(double quantity)
    {
        if(quantity > 0)
        {
            this.quantity += quantity;
            return true;
        }
        return false;
    }
    public boolean lose(double quantity)
    {
        if(quantity > 0)
        {
            this.quantity -= quantity;
            return true;
        }
        return false;
    }

}
