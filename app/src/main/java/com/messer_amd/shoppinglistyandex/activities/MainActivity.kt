package com.messer_amd.shoppinglistyandex.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.messer_amd.shoppinglistyandex.R
import com.messer_amd.shoppinglistyandex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavListener()
    }

    private fun setBottomNavListener(){
       binding.bNav.setOnItemSelectedListener {
           when(it.itemId){
               R.id.settings -> {
                   Log.d("MyLog", "Settings")
               }
               R.id.shop_list -> {
                   Log.d("MyLog", "List")
               }
               R.id.new_item -> {
                   Log.d("MyLog", "New")
               }
           }
           true
       }
    }
}