/*
Mohamed Sabry
 */

public class Rocket implements SpaceShip{
    int cost;
    int weight;
    int max_weight;
    int current_weight;
    double launch_explosion;
    double land_crash;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return item.weight + this.current_weight <= this.max_weight;
    }

    @Override
    public void carry(Item item) {
        this.current_weight += item.weight;
    }
}
