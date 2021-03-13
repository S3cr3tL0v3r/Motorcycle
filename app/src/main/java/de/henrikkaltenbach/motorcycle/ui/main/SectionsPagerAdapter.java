package de.henrikkaltenbach.motorcycle.ui.main;

import android.content.Context;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.google.android.gms.location.FusedLocationProviderClient;
import de.henrikkaltenbach.motorcycle.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_telemetry, R.string.tab_zero_to_hundred, R.string.title_activity_settings};
    private final Context mContext;
    private final FusedLocationProviderClient flpc;
    private final SensorManager sm;

    public SectionsPagerAdapter(Context context, FragmentManager fm, FusedLocationProviderClient flpc, SensorManager sm) {
        super(fm);
        mContext = context;
        this.flpc = flpc;
        this.sm = sm;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        switch (position) {
            case 0:
                return TelemetryFragment.newInstance(flpc, sm);
            case 1:
                return ZeroToHundredFragment.newInstance(flpc, sm);
            case 2:
                return SettingsFragment.newInstance();
            default:
                return BlankFragment.newInstance();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}