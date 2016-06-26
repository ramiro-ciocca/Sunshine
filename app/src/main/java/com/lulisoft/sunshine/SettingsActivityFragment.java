package com.lulisoft.sunshine;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;


public class SettingsActivityFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.pref_general);
        bindPreferenceSummaryToValue(getString(R.string.pref_location_key));
        bindPreferenceSummaryToValue(getString(R.string.pref_units_key));
    }

    private void bindPreferenceSummaryToValue(String key) {
        onSharedPreferenceChanged(PreferenceManager.getDefaultSharedPreferences(getActivity()), key);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference = findPreference(key);
        if(key.equals(getString(R.string.pref_location_key))) {
            String stringValue = sharedPreferences.getString(key, "");
            preference.setSummary(stringValue);
        }
        else if(key.equals(getString(R.string.pref_units_key))) {
            preference.setSummary(((ListPreference) preference).getEntry());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
