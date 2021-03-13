package de.henrikkaltenbach.motorcycle.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import de.henrikkaltenbach.motorcycle.BR;

public class Unit extends BaseObservable {

    private static Unit instance;

    // Fields

    private String altitude = "";
    private String speed = "";
    private String acceleration = "";
    private String angle = "";
    private String temperature = "";
    private String pressure = "";

    /**
     * Singleton
     */
    public static Unit getInstance() {
        if (instance == null) {
            instance = new Unit();
        }
        return instance;
    }

    // Bindable getter

    @Bindable
    public String getAltitude() {
        return altitude;
    }

    @Bindable
    public String getSpeed() {
        return speed;
    }

    @Bindable
    public String getAcceleration() {
        return acceleration;
    }

    @Bindable
    public String getAngle() {
        return angle;
    }

    @Bindable
    public String getTemperature() {
        return temperature;
    }

    @Bindable
    public String getPressure() {
        return pressure;
    }

    // UI notifying setter

    public void setAltitude(String altitude) {
        if (!this.altitude.equals(altitude)) {
            this.altitude = altitude;
            notifyPropertyChanged(BR.altitude);
        }
    }

    public void setSpeed(String speed) {
        if (!this.speed.equals(speed)) {
            this.speed = speed;
            notifyPropertyChanged(BR.speed);
        }
    }

    public void setAcceleration(String acceleration) {
        if (!this.acceleration.equals(acceleration)) {
            this.acceleration = acceleration;
            notifyPropertyChanged(BR.acceleration);
        }
    }

    public void setAngle(String angle) {
        if (!this.angle.equals(angle)) {
            this.angle = angle;
            notifyPropertyChanged(BR.angle);
        }
    }

    public void setTemperature(String temperature) {
        if (!this.temperature.equals(temperature)) {
            this.temperature = temperature;
            notifyPropertyChanged(BR.temperature);
        }
    }

    public void setPressure(String pressure) {
        if (!this.pressure.equals(pressure)) {
            this.pressure = pressure;
            notifyPropertyChanged(BR.pressure);
        }
    }

}
