
public abstract class AbstarctTest {
    int milage;

    AbstarctTest(int milage){
        this.milage = milage;
    }

    public abstract void presseBrack();
    public abstract void presseAcceletaor();

    public int getNumberOfWheels(){
        return milage;
    }
}
