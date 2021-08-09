/*
Mohamed Sabry
 */

public class U2 extends Rocket{
    U2(){
        cost = 120;
        weight = 18000;
        max_weight = 29000;
        current_weight = weight;
        launch_explosion = 0;
        land_crash = 0;
    }
    /*
        methods to calculate the corresponding chance of exploding (launch and land fails).
    */
    public boolean launch(){
        int rand_number = (int) (Math.random() * 100 + 1);
        this.launch_explosion = 4.0 * (current_weight - weight) / (max_weight - weight);
        return this.launch_explosion <= rand_number;
    }
    public boolean land(){
        int rand_number = (int) (Math.random() * 100 + 1);
        this.land_crash = 8.0 * (current_weight - weight) / (max_weight - weight);
        return this.land_crash <= rand_number;
    }
}

