// 6510405814 Sornchai Somsakul

package services;

enum State {
    NO_QUARTER,
    HAS_QUARTER,
    GUMBALL_SOLD,
    OUT_OF_GUMBALLS
}

public class GumballService {
    int inventory;
    State state;

    public GumballService() {
        inventory = 5;
        state = State.NO_QUARTER;
    }

    public void init() {
        greeting();
        getInventory();
        getStatus();
    }

    private void greeting() {
        System.out.println("Mighty Gumball Inc.");
        System.out.println("Java-enabled Standing Gumball Model #2004");
    }

    private void getInventory() {
        System.out.println("Inventory: " + inventory + " gumballs");
    }

    private void getStatus() {
        if (this.state == State.OUT_OF_GUMBALLS) {
            System.out.println("Machine is sold out");
        } else {
            System.out.println("Machine is waiting for quarter\n");
        }
    }

    public void insertQuarter() {
        if (this.state == State.HAS_QUARTER) {
            System.out.println("You can't insert another quarter");
            return;
        }

        if (this.state == State.OUT_OF_GUMBALLS) {
            System.out.println("You can't insert a quarter, the machine is sold out");
            return;
        }

        this.state = State.HAS_QUARTER;
        System.out.println("You inserted a quarter");
    }

    public void rotateCrank() {
        switch (this.state) {
            case State.NO_QUARTER:
                System.out.println("You turned but there's no quarter");
                return;
            case State.HAS_QUARTER:
                this.state = State.GUMBALL_SOLD;
                this.inventory--;
                System.out.println("You turned...");
                System.out.println("A gumball comes rolling out the slot");
                if (this.inventory == 0) {
                    System.out.println("Oops, out of gumballs!");
                    this.state = State.OUT_OF_GUMBALLS;
                } else {
                    this.state = State.NO_QUARTER;
                }
                break;
            case State.OUT_OF_GUMBALLS:
                System.out.println("You turned, but there are no gumballs");
                break;
        }


    }

    public void ejectQuarter() {
        if (this.state == State.HAS_QUARTER) {
            this.state = State.NO_QUARTER;
            System.out.println("Quarter returned");
            return;
        }

        if (this.state == State.NO_QUARTER) {
            System.out.println("You haven't inserted a quarter");
        }
    }
}
