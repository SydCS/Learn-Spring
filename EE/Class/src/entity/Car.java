package entity;

public class Car
{
    IEngine engine;

    IBrake brake;

    public Car(IEngine engine, IBrake brake) {
        this.engine = engine;
        this.brake = brake;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", brake=" + brake +
                '}';
    }
}
