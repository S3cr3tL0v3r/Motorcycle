package de.henrikkaltenbach.motorcycle.ui.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceFragmentCompat;
import de.henrikkaltenbach.motorcycle.R;
import de.henrikkaltenbach.motorcycle.viewmodel.Settings;
import de.henrikkaltenbach.motorcycle.viewmodel.Telemetry;
import de.henrikkaltenbach.motorcycle.viewmodel.Unit;

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    private SettingsFragment() {
        // Required empty public (?) constructor
    }

    /**
     * Use this factory method to create a new instance of this fragment.
     *
     * @return A new instance of fragment SettingsFragment.
     */
    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        // Todo: adjust TextViews on change; value decimal points and unit font size.
        switch (key) {
            case "speed":
                Unit.getInstance().setSpeed(sharedPreferences.getString(key, "km/h"));
                Telemetry.getInstance().updateSpeed();
                return;
            case "acceleration":
                Unit.getInstance().setAcceleration(sharedPreferences.getString(key, "g"));
                Telemetry.getInstance().updateAcceleration();
                return;
            case "angle":
                Unit.getInstance().setAngle(sharedPreferences.getString(key, "°"));
                Telemetry.getInstance().updateAngle();
                return;
            case "altitude":
                Unit.getInstance().setAltitude(sharedPreferences.getString(key, "m"));
                Telemetry.getInstance().updateAltitude();
                return;
            case "temperature":
                Unit.getInstance().setTemperature(sharedPreferences.getString(key, "°C"));
                Telemetry.getInstance().updateTemperature();
                return;
            case "pressure":
                Unit.getInstance().setPressure(sharedPreferences.getString(key, "hPa"));
                Telemetry.getInstance().updatePressure();
                return;
            case "updates":
                Settings.getInstance().setRequestingLocationUpdates(sharedPreferences.getBoolean(key, true));
                return;
            case "rate":
                Settings.getInstance().setRate(Integer.parseInt(sharedPreferences.getString(key, "1")));
                return;
            case "theme":
                AppCompatDelegate.setDefaultNightMode(Integer.parseInt(sharedPreferences.getString(key, "2")));
                return;
            default:
        }
    }
}