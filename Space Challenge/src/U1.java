/*
Mohamed Sabry
 */

public class U1 extends Rocket{
    U1(){
        cost = 100;
        weight = 10000;
        max_weight = 18000;
        current_weight = weight;
        launch_explosion = 0;
        land_crash = 0;
    }
    public boolean launch(){
        int rand_number = (int) (Math.random() * 100 + 1);
        this.launch_explosion = 1.0 * (current_weight - weight) / (max_weight - weight);
        return this.launch_explosion <= rand_number;
    }
    public boolean land(){
        int rand_number = (int) (Math.random() * 100 + 1);
        this.land_crash = 5.0 * (current_weight - weight) / (max_weight - weight);
        return this.land_crash <= rand_number;
    }
}

