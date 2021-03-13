package de.henrikkaltenbach.motorcycle;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.SensorManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.tabs.TabLayout;
import de.henrikkaltenbach.motorcycle.databinding.ActivityMainBinding;
import de.henrikkaltenbach.motorcycle.ui.main.SectionsPagerAdapter;
import de.henrikkaltenbach.motorcycle.viewmodel.Settings;
import de.henrikkaltenbach.motorcycle.viewmodel.Unit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        FusedLocationProviderClient flpc = LocationServices.getFusedLocationProviderClient(this);
        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        SectionsPagerAdapter sectionsPagerAdapter =
                new SectionsPagerAdapter(this, getSupportFragmentManager(), flpc, sm);
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final Unit unit = Unit.getInstance();
        unit.setSpeed(preferences.getString("speed", "km/h"));
        unit.setAcceleration(preferences.getString("acceleration", "g"));
        unit.setAngle(preferences.getString("angle", "°"));
        unit.setAltitude(preferences.getString("altitude", "m"));
        unit.setTemperature(preferences.getString("temperature", "°C"));
        unit.setPressure(preferences.getString("pressure", "hPa"));
        Settings.getInstance().setRequestingLocationUpdates(preferences.getBoolean("updates", false));
        Settings.getInstance().setRate(Integer.parseInt(preferences.getString("rate", "1")));
    }
}