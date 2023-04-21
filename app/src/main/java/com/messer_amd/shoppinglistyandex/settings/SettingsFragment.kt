package com.messer_amd.shoppinglistyandex.settings

import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.messer_amd.shoppinglistyandex.R

class SettingsFragment : PreferenceFragmentCompat() {
    private lateinit var removeAdsPref: Preference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
       setPreferencesFromResource(R.xml.settings_preference, rootKey)
    }
}