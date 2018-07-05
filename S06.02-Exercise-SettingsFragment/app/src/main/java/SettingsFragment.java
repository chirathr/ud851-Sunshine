import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

import com.example.android.sunshine.R;

public class SettingsFragment extends PreferenceFragmentCompat implements
        SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_general);

        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
        PreferenceScreen preferenceScreen = getPreferenceScreen();

        int count = preferenceScreen.getPreferenceCount();

        for (int i = 0; i < count; ++i) {
            Preference preference = preferenceScreen.getPreference(i);
            if (!(preference instanceof CheckBoxPreference)) {
                String value = sharedPreferences.getString(preference.getKey(), "");
                setPreferenceSummary(preference, value);
            }
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Preference preference = findPreference(s);

        if (preference != null) {
            if (!(preference instanceof CheckBoxPreference)) {
                String value = sharedPreferences.getString(preference.getKey(), "");
                preference.setSummary(value);
            }
        }
    }

    private void setPreferenceSummary(Preference preference, Object value) {
        String valueString = (String) value;

        if (preference instanceof ListPreference) {
            ListPreference listPreference = (ListPreference) preference;
            int index = listPreference.findIndexOfValue(valueString);
            if (index >= 0)
                preference.setSummary(listPreference.getEntries()[index]);
        } else if (preference instanceof EditTextPreference) {
            preference.setSummary(valueString);
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
