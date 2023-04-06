package com.messer_amd.shoppinglistyandex.activities

import android.app.Application
import com.messer_amd.shoppinglistyandex.db.MainDataBase

class MainApp: Application() {
    val dataBase by lazy { MainDataBase.getDataBase(this)}
}