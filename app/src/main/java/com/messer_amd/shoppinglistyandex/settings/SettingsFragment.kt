package com.messer_amd.shoppinglistyandex.settings

import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.messer_amd.shoppinglistyandex.R

class SettingsFragment : PreferenceFragmentCompat() {
    private lateinit var removeAdsPref: Preference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
       setPreferencesFromResource(R.xml.settings_preference, rootKey)
       // init()
    }

//    private fun init(){
//        bManager = BillingManager(activity as AppCompatActivity)
//        removeAdsPref = findPreference("remove_ads_key")!!
//        removeAdsPref.setOnPreferenceClickListener {
//            bManager.startConnection()
//            true
//        }
//    }

//    override fun onDestroy() {
//        bManager.closeConnection()
//        super.onDestroy()
//    }
}