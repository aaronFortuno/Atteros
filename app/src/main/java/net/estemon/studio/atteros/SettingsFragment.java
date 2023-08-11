package net.estemon.studio.atteros;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);

        final EditTextPreference fragments = findPreference("fragments");
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());

        fragments.setSummary("How many fragments is divided an asteroid (" + pref.getString("fragments", "?") + ")");
        fragments.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                int value;
                try {
                    value = Integer.parseInt((String) newValue);
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Has to be a number", Toast.LENGTH_SHORT).show();
                    return false;
                }
                if (value >= 0 && value <= 9) {
                    fragments.setSummary("How many fragments is divided an asteroid (" + value + ")");
                    return true;
                } else {
                    Toast.makeText(getActivity(), "Max fragment number is 9", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });
    }
}
