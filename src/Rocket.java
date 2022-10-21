public class Rocket implements SpaceShip{

    int cost; //cost of rocket
    int weight; //weight of rocket
    int maxWeight; //max weight of rocket with cargo
    int currentWeight;
    double chanceLaunch; //Chance of launch explosion
    double chanceLanding; //chance of landing crash


    public boolean launch() {

        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item){
        return (this.currentWeight+ item.weight)<=maxWeight;
    }

    public int carry (Item item){
        this.currentWeight+=item.weight;
        return this.currentWeight;
    }

}
