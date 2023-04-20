package com.messer_amd.shoppinglistyandex.settings

import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.messer_amd.shoppinglistyandex.R

class SettingsActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {
    private lateinit var defPref: SharedPreferences
    private var listener: SharedPreferences.OnSharedPreferenceChangeListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        defPref = PreferenceManager.getDefaultSharedPreferences(this)
        setTheme(getSelectedTheme())

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        listener = SharedPreferences.OnSharedPreferenceChangeListener { defPref, key ->
            recreate()
        }
        defPref.registerOnSharedPreferenceChangeListener(listener)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.placeHolder, SettingsFragment()).commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }

    private fun getSelectedTheme(): Int {
        return if (defPref.getString("theme_key", "business") == "business") {
            R.style.Theme_ShoppingListBusiness
        } else {
            R.style.Theme_ShoppingListDark
        }
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, string: String) {
        setTheme(getSelectedTheme())
    }
}