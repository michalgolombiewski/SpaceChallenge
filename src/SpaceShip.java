public interface SpaceShip {

    //indicating if the launch was successful or if the rocket has crashed.
    public boolean launch();

    //indicating if rocket success of landing
    public boolean land ();

    //if the rocket can carry an item or exceed the limit
    public boolean canCarry(Item item);

    //updates the current weight of the rocket.
    public int carry(Item item);
}
