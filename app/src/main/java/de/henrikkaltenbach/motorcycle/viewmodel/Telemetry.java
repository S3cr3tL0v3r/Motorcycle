package de.henrikkaltenbach.motorcycle.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import de.henrikkaltenbach.motorcycle.BR;

public class Telemetry extends BaseObservable {

    private static Telemetry instance;
    /**
     * Singleton
     */
    public static Telemetry getInstance() {
        if (instance == null) {
            instance = new Telemetry();
        }
        return instance;
    }
    private final Unit unit = Unit.getInstance();

    // Fields

    private double latitude;
    private double longitude;
    private double altitude;
    private double minAltitude = Double.MAX_VALUE;
    private double maxAltitude = Double.MIN_VALUE;
    private float speed;
    private float maxSpeed;
    private float acceleration;
    private float maxAcceleration;
    private float angle;
    private float maxAngle;
    private float ambientTemperature = Float.MIN_VALUE;
    private float minAmbientTemperature = Float.MAX_VALUE;
    private float maxAmbientTemperature = Float.MIN_VALUE;
    private float pressure = Float.MIN_VALUE;
    private float minPressure = Float.MAX_VALUE;
    private float maxPressure = Float.MIN_VALUE;
    private float humidity = Float.MIN_VALUE;
    private float minHumidity = Float.MAX_VALUE;
    private float maxHumidity = Float.MIN_VALUE;
    private float timing;
    private float oilTemperature;
    private float minOilTemperature;
    private float maxOilTemperature;

    private String sensorActivity = "";
    @Bindable
    public String getSensorActivity() {
        return sensorActivity;
    }
    public void temp() {
        sensorActivity += "T";
        notifyPropertyChanged(BR.sensorActivity);
    }
    public void pres() {
        sensorActivity += "P";
        notifyPropertyChanged(BR.sensorActivity);
    }
    public void humi() {
        sensorActivity += "H";
        notifyPropertyChanged(BR.sensorActivity);
    }

    // Bindable getter

    @Bindable
    public double getLatitude() {
        return latitude;
    }

    @Bindable
    public double getLongitude() {
        return longitude;
    }

    @Bindable
    public double getAltitude() {
        return getAltitudeWithUnit(altitude);
    }

    @Bindable
    public double getMinAltitude() {
        return minAltitude;
    }

    @Bindable
    public double getMaxAltitude() {
        return getAltitudeWithUnit(maxAltitude);
    }

    @Bindable
    public float getSpeed() {
        return speed < 2f ? 0f : getSpeedWithUnit(speed);
    }

    @Bindable
    public float getMaxSpeed() {
        return getSpeedWithUnit(maxSpeed);
    }

    @Bindable
    public float getAcceleration() {
        return getAccelerationWithUnit(acceleration);
    }

    @Bindable
    public float getMaxAcceleration() {
        return getAccelerationWithUnit(maxAcceleration);
    }

    @Bindable
    public float getAngle() {
        return getAngleWithUnit(angle);
    }

    @Bindable
    public float getMaxAngle() {
        return getAngleWithUnit(maxAngle);
    }

    @Bindable
    public float getAmbientTemperature() {
        return getTemperatureWithUnit(ambientTemperature);
    }

    @Bindable
    public float getMinAmbientTemperature() {
        return getTemperatureWithUnit(minAmbientTemperature);
    }

    @Bindable
    public float getMaxAmbientTemperature() {
        return getTemperatureWithUnit(maxAmbientTemperature);
    }

    @Bindable
    public float getPressure() {
        return getPressureWithUnit(pressure);
    }

    @Bindable
    public float getMinPressure() {
        return getPressureWithUnit(minPressure);
    }

    @Bindable
    public float getMaxPressure() {
        return getPressureWithUnit(maxPressure);
    }

    @Bindable
    public float getHumidity() {
        return humidity;
    }

    @Bindable
    public float getMinHumidity() {
        return minHumidity;
    }

    @Bindable
    public float getMaxHumidity() {
        return maxHumidity;
    }

    @Bindable
    public float getTiming() {
        return timing;
    }

    @Bindable
    public float getOilTemperature() {
        return getTemperatureWithUnit(oilTemperature);
    }

    @Bindable
    public float getMinOilTemperature() {
        return getTemperatureWithUnit(minOilTemperature);
    }

    @Bindable
    public float getMaxOilTemperature() {
        return getTemperatureWithUnit(maxOilTemperature);
    }

    // UI notifying setter

    public void setLatitude(double latitude) {
        if (this.latitude != latitude) {
            this.latitude = latitude;
            notifyPropertyChanged(BR.latitude);
        }
    }

    public void setLongitude(double longitude) {
        if (this.longitude != longitude) {
            this.longitude = longitude;
            notifyPropertyChanged(BR.longitude);
        }
    }

    public void setAltitude(double altitude) {
        if (this.altitude != altitude) {
            this.altitude = altitude;
            notifyPropertyChanged(BR.altitude);
            if (maxAltitude < altitude) {
                maxAltitude = altitude;
                notifyPropertyChanged(BR.maxAltitude);
            }
            if (minAltitude > altitude) {
                minAltitude = altitude;
                notifyPropertyChanged(BR.minAltitude);
            }
        }
    }

    public void setSpeed(float speed) {
        if (this.speed != speed) {
            this.speed = speed;
            notifyPropertyChanged(BR.speed);
            if (maxSpeed < speed) {
                maxSpeed = speed;
                notifyPropertyChanged(BR.maxSpeed);
            }
        }
    }

    public void setAcceleration(float acceleration) {
        if (this.acceleration != acceleration) {
            this.acceleration = acceleration;
            notifyPropertyChanged(BR.acceleration);
            if (maxAcceleration < acceleration) {
                maxAcceleration = acceleration;
                notifyPropertyChanged(BR.maxAcceleration);
            }
        }
    }

    public void setAngle(float angle) {
        if (this.angle != angle) {
            this.angle = angle;
            notifyPropertyChanged(BR.angle);
            if (maxAngle < angle) {
                maxAngle = angle;
                notifyPropertyChanged(BR.maxAngle);
            }
        }
    }

    public void setAmbientTemperature(float ambientTemperature) {
        if (this.ambientTemperature != ambientTemperature) {
            this.ambientTemperature = ambientTemperature;
            notifyPropertyChanged(BR.ambientTemperature);
            if (maxAmbientTemperature < ambientTemperature) {
                maxAmbientTemperature = ambientTemperature;
                notifyPropertyChanged(BR.maxAmbientTemperature);
            }
            if (minAmbientTemperature > ambientTemperature) {
                minAmbientTemperature = ambientTemperature;
                notifyPropertyChanged(BR.minAmbientTemperature);
            }
        }
    }

    public void setPressure(float pressure) {
        if (this.pressure != pressure) {
            this.pressure = pressure;
            notifyPropertyChanged(BR.pressure);
            if (maxPressure < pressure) {
                maxPressure = pressure;
                notifyPropertyChanged(BR.maxPressure);
            }
            if (minPressure > pressure) {
                minPressure = pressure;
                notifyPropertyChanged(BR.minPressure);
            }
        }
    }

    public void setHumidity(float humidity) {
        if (this.humidity != humidity) {
            this.humidity = humidity;
            notifyPropertyChanged(BR.humidity);
            if (maxHumidity < humidity) {
                maxHumidity = humidity;
                notifyPropertyChanged(BR.maxHumidity);
            }
            if (minHumidity > humidity) {
                minHumidity = humidity;
                notifyPropertyChanged(BR.minHumidity);
            }
        }
    }

    public void setTiming(float timing) {
        if (this.timing != timing) {
            this.timing = timing;
            notifyPropertyChanged(BR.timing);
        }
    }

    public void setOilTemperature(float oilTemperature) {
        if (this.oilTemperature != oilTemperature) {
            this.oilTemperature = oilTemperature;
            notifyPropertyChanged(BR.oilTemperature);
            if (maxOilTemperature < oilTemperature) {
                maxOilTemperature = oilTemperature;
                notifyPropertyChanged(BR.maxOilTemperature);
            }
            if (minOilTemperature > oilTemperature) {
                minOilTemperature = oilTemperature;
                notifyPropertyChanged(BR.minOilTemperature);
            }
        }
    }

    // Utility methods

    public void reset() {
        minAltitude = altitude;
        maxAltitude = altitude;
        maxSpeed = speed;
        maxAcceleration = acceleration;
        maxAngle = angle;
        minAmbientTemperature = ambientTemperature;
        maxAmbientTemperature = ambientTemperature;
        minPressure = pressure;
        maxPressure = pressure;
        minHumidity = humidity;
        maxHumidity = humidity;
        minOilTemperature = oilTemperature;
        maxOilTemperature = oilTemperature;
        notifyPropertyChanged(BR.minAltitude);
        notifyPropertyChanged(BR.maxAltitude);
        notifyPropertyChanged(BR.maxSpeed);
        notifyPropertyChanged(BR.maxAcceleration);
        notifyPropertyChanged(BR.maxAngle);
        notifyPropertyChanged(BR.minAmbientTemperature);
        notifyPropertyChanged(BR.maxAmbientTemperature);
        notifyPropertyChanged(BR.minPressure);
        notifyPropertyChanged(BR.maxPressure);
        notifyPropertyChanged(BR.minHumidity);
        notifyPropertyChanged(BR.maxHumidity);
        notifyPropertyChanged(BR.minOilTemperature);
        notifyPropertyChanged(BR.maxOilTemperature);
    }

    public void updateSpeed() {
        notifyPropertyChanged(BR.speed);
        notifyPropertyChanged(BR.maxSpeed);
    }

    public void updateAcceleration() {
        notifyPropertyChanged(BR.acceleration);
        notifyPropertyChanged(BR.maxAcceleration);
    }

    public void updateAngle() {
        notifyPropertyChanged(BR.angle);
        notifyPropertyChanged(BR.maxAngle);
    }

    public void updateAltitude() {
        notifyPropertyChanged(BR.altitude);
        notifyPropertyChanged(BR.maxAltitude);
        notifyPropertyChanged(BR.minAltitude);
    }

    public void updateTemperature() {
        notifyPropertyChanged(BR.ambientTemperature);
        notifyPropertyChanged(BR.maxAmbientTemperature);
        notifyPropertyChanged(BR.minAmbientTemperature);
        notifyPropertyChanged(BR.oilTemperature);
        notifyPropertyChanged(BR.maxOilTemperature);
        notifyPropertyChanged(BR.minOilTemperature);
    }

    public void updatePressure() {
        notifyPropertyChanged(BR.pressure);
        notifyPropertyChanged(BR.maxPressure);
        notifyPropertyChanged(BR.minPressure);
    }

    private double getAltitudeWithUnit(double altitude) {
        switch (unit.getAltitude()) {
            case "m":
                return altitude;
            case "ft":
                return altitude * 3.28084f;
            default:
                return Double.NaN;
        }
    }

    private float getSpeedWithUnit(float speed) {
        switch (unit.getSpeed()) {
            case "m/s":
                return speed;
            case "km/h":
                return speed * 3.6f;
            case "mph":
                return speed * 2.236936f;
            default:
                return Float.NaN;
        }
    }

    private float getAccelerationWithUnit(float acceleration) {
        switch (unit.getAcceleration()) {
            case "m/s²":
            case "ᵐ⁄ₛ₂":
                return acceleration;
            case "g":
                return (float) (acceleration / 9.81);
            default:
                return Float.NaN;
        }
    }

    private float getAngleWithUnit(float angle) {
        switch (unit.getAngle()) {
            case "rad":
                return angle;
            case "°":
                return angle * 180f / (float) Math.PI;
            default:
                return Float.NaN;
        }
    }

    private float getTemperatureWithUnit(float temperature) {
        switch (unit.getTemperature()) {
            case "K":
                return temperature + 273.15f;
            case "°C":
                return temperature;
            case "°F":
                return temperature * 1.8f + 32f;
            default:
                return Float.NaN;
        }
    }

    private float getPressureWithUnit(float pressure) {
        switch (unit.getPressure()) {
            case "Pa":
                return pressure * 100f;
            case "bar":
                return pressure * 0.001f;
            case "hPa":
            case "mbar":
                return pressure;
            case "psi":
                return pressure * 0.01450377f;
            default:
                return Float.NaN;
        }
    }
}
