/*specification of U2 rocket*/
public class U2 extends Rocket{
    public U2 (){
        cost=120; //millions
        weight=18000;
        maxWeight=29000;
        chanceLanding=0.0;
        chanceLaunch=0.0;
        currentWeight=weight;
    }

    @Override
    public boolean launch() {
        double random =Math.random()*0.1;
        chanceLaunch=0.04*(( (double)currentWeight-weight) / (maxWeight-weight));
        //System.out.println("Launch: "+chanceLaunch+"<="+random);
        if (chanceLaunch<=random) {
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean land() {
        double random =Math.random()*0.1;
        chanceLanding=0.08* (( (double)currentWeight- weight)/(maxWeight-weight));
        //System.out.println("Landing: "+chanceLaunch+"<="+random);
        if (chanceLaunch<=random) {
            return true;
        }
        else {
            return false;
        }
    }
}
