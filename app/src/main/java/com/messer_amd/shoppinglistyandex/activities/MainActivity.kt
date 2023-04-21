package com.messer_amd.shoppinglistyandex.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.messer_amd.shoppinglistyandex.R
import com.messer_amd.shoppinglistyandex.databinding.ActivityMainBinding
import com.messer_amd.shoppinglistyandex.fragments.FragmentManager
import com.messer_amd.shoppinglistyandex.fragments.ShopListNamesFragment
import com.messer_amd.shoppinglistyandex.settings.SettingsActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var defPref: SharedPreferences
    private var currentMenuItemId = R.id.shop_list
    private var currentTheme = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        defPref = PreferenceManager.getDefaultSharedPreferences(this)
        setTheme(getSelectedTheme())

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        currentTheme = defPref.getString("theme_key", "green").toString()
        FragmentManager.setFragment(ShopListNamesFragment.newInstance(), this)
        setBottomNavListener()
    }

    private fun setBottomNavListener(){
       binding.bNav.setOnItemSelectedListener {
           when(it.itemId){
               R.id.settings -> {
                   startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
               }
               R.id.shop_list -> {
                   FragmentManager.setFragment(ShopListNamesFragment.newInstance(), this)
               }
               R.id.new_item -> {
                   FragmentManager.currentFrag?.onClickNew()
               }
           }
           true
       }
    }
    override fun onResume() {
        super.onResume()
        binding.bNav.selectedItemId = currentMenuItemId
        if (defPref.getString("theme_key", "green") != currentTheme) recreate()
    }
    private fun getSelectedTheme(): Int {
        return if (defPref.getString("theme_key", "green") == "green") {
            R.style.Theme_ShoppingListGreen
        } else {
            R.style.Theme_ShoppingListRed
        }
    }
}