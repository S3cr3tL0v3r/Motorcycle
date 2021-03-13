package de.henrikkaltenbach.motorcycle.viewmodel;

public class Settings {

    private static Settings instance;
    /**
     * Singleton
     */
    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    private int rate;
    private boolean requestingLocationUpdates;
    private double accelerationThreshold = 4.905;

    public int getRate() {
        return rate;
    }

    public boolean isRequestingLocationUpdates() {
        return requestingLocationUpdates;
    }

    public double getAccelerationThreshold() {
        return accelerationThreshold;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setRequestingLocationUpdates(boolean requestingLocationUpdates) {
        this.requestingLocationUpdates = requestingLocationUpdates;
    }

    public void setAccelerationThreshold(double accelerationThreshold) {
        this.accelerationThreshold = accelerationThreshold;
    }

}
