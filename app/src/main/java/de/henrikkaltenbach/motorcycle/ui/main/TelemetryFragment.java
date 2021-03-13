package de.henrikkaltenbach.motorcycle.ui.main;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import de.henrikkaltenbach.motorcycle.R;
import de.henrikkaltenbach.motorcycle.databinding.FragmentTelemetryBinding;
import de.henrikkaltenbach.motorcycle.viewmodel.Telemetry;
import de.henrikkaltenbach.motorcycle.viewmodel.Unit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TelemetryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TelemetryFragment extends Fragment implements SensorEventListener {

    private FragmentTelemetryBinding binding;
    private Telemetry telemetry;
    private FusedLocationProviderClient locationProviderClient;
    private LocationCallback locationCallback;
    private SensorManager sensorManager;
    private Sensor gravitySensor;
    private Sensor linearAccelerationSensor;
    private Sensor temperatureSensor;
    private Sensor pressureSensor;
    private Sensor humiditySensor;

    private TelemetryFragment(FusedLocationProviderClient flpc, SensorManager sm) {
        locationProviderClient = flpc;
        sensorManager = sm;
    }

    /**
     * Use this factory method to create a new instance of this fragment.
     *
     * @return A new instance of fragment TelemetryFragment.
     */
    public static TelemetryFragment newInstance(FusedLocationProviderClient flpc, SensorManager sm) {
        return new TelemetryFragment(flpc, sm);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        telemetry = Telemetry.getInstance();
        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        linearAccelerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        humiditySensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_telemetry, container, false);
        binding.setTelemetry(telemetry);
        binding.setUnit(Unit.getInstance());
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                for (Location location : locationResult.getLocations()) {
                    telemetry.setLatitude(location.getLatitude());
                    telemetry.setLongitude(location.getLongitude());
                    telemetry.setAltitude(location.getAltitude());
                    telemetry.setSpeed(location.getSpeed());
                }
            }
        };
        binding.bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telemetry.reset();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}