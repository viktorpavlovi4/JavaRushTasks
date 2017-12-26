package com.javarush.task.task36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;
    private int speed;
    private int maxSpeed;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
        speed = getCarSpeed();
        maxSpeed = getCarMaxSpeed();
    }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }

    public void speedUp(int seconds) {
        if (speed < maxSpeed) {
            speed += (3.5 * seconds);
            setCarSpeed(speed);
        }
        if (speed > maxSpeed) {
            speed = maxSpeed;
            setCarSpeed(speed);
        }
    }

    public void speedDown(int seconds) {
        if (speed > 0) {
            speed -= (12 * seconds);
            setCarSpeed(speed);
        }
        if (speed < 0) {
            speed = 0;
            setCarSpeed(speed);
        }
    }
}