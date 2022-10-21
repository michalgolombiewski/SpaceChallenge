/*specification of U1 rocket*/
public class U1 extends Rocket{


    public U1 (){
        cost=100; //millions
        weight=10000;
        maxWeight=18000;
        chanceLanding=0.0;
        chanceLaunch=0.0;
        currentWeight=weight;
    }

    @Override
    public boolean launch() {
        double random =Math.random()*0.1;
        chanceLaunch=0.05*(( (double)currentWeight-weight) / (maxWeight-weight));
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
        chanceLanding=0.01* (( (double)currentWeight- weight)/(maxWeight-weight));
        //System.out.println("Landing: "+chanceLaunch+"<="+random);
        if (chanceLaunch<=random) {
            return true;
        }
        else {
            return false;
        }
    }
}


