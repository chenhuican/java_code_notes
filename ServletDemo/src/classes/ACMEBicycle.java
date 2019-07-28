package classes;

public class ACMEBicycle implements Bicycle {
    int cadence = 0;
    int speed = 0;
    int gear = 1;
    String Ss = "This is String,";
    long creditCardNumber = 1234_5678_9012_2343L;
    
    @Override
    public void changeCadence(int newValue) {
        cadence = newValue;
    }

    @Override
    public void changeGear(int newValue) {
        gear = newValue;

    }

    @Override
    public void speedUp(int increment) {
        speed = speed + increment;

    }

    @Override
    public void applyBrakes(int decrement) {
        speed = speed - decrement;

    }
    
    public void setSs(String s1) {
        this.Ss = this.Ss + s1;
        System.out.println("Ss = " + Ss);
    }
    
    void printStates() {
        System.out.println("cadence = " + cadence +
        " speed: " + speed +
        " gear= " + gear+
        " creditCardNumber: "+ creditCardNumber);
    }

    public static void main(String[] args) {
        ACMEBicycle c1 = new ACMEBicycle();
        c1.setSs("XXXXXXXXXXXXXX");
        c1.printStates();
    }
}
