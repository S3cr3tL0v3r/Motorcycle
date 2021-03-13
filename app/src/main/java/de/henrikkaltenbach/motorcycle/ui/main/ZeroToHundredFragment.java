package de.henrikkaltenbach.motorcycle.ui.main;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
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
import de.henrikkaltenbach.motorcycle.databinding.FragmentZeroToHundredBinding;
import de.henrikkaltenbach.motorcycle.viewmodel.Telemetry;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ZeroToHundredFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ZeroToHundredFragment extends Fragment implements SensorEventListener {

    private FragmentZeroToHundredBinding binding;
    private Telemetry telemetry;
    private FusedLocationProviderClient locationProviderClient;
    private LocationCallback locationCallback;
    private SensorManager sensorManager;
    private Sensor acceleratorSensor;
    private Sensor accelerationSensor;
    private boolean ready;
    private boolean timingStarted;
    private long elapsedMilliseconds;

    private ZeroToHundredFragment(FusedLocationProviderClient flpc, SensorManager sm) {
        locationProviderClient = flpc;
        sensorManager = sm;
    }

    /**
     * Use this factory method to create a new instance of this fragment.
     *
     * @return A new instance of fragment ZeroToHundredFragment.
     */
    public static ZeroToHundredFragment newInstance(FusedLocationProviderClient flpc, SensorManager sm) {
        return new ZeroToHundredFragment(flpc, sm);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        telemetry = Telemetry.getInstance();
        acceleratorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);  // Todo: Gravity sensor?
        accelerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_zero_to_hundred, container, false);
        binding.setTelemetry(telemetry);
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                for (Location location : locationResult.getLocations()) {
                    if (location.getSpeed() >= 27.78f) {
                        timingStarted = false;
                        ready = false;
                        binding.bReady.getBackground().clearColorFilter();
                        binding.bReady.setAlpha(0.5f);
                        binding.tvTiming.getRootView().setBackgroundColor(Color.rgb(76, 175, 80));
//                        displayTimingFullscreen();
                    }
                    telemetry.setSpeed(location.getSpeed());
                }
            }
        };
        binding.bReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ready) {
                    ready = false;
                    timingStarted = false;
                    binding.bReady.getBackground().clearColorFilter();
                } else {
                    ready = true;
                    telemetry.setTiming(0f);
                    binding.bReady.setAlpha(1f);
                    binding.bReady.getBackground().setColorFilter(new PorterDuffColorFilter(
                            Color.rgb(76, 175, 80), PorterDuff.Mode.MULTIPLY));
                    binding.tvTiming.getRootView().setBackgroundColor(Color.rgb(0, 0, 0));
                }
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