package com.vasialeleka.roomonjava

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var db = Room
            .databaseBuilder(applicationContext, AppDatabase::class.java, "db")
            .allowMainThreadQueries()
            .build()

        for (i in 0..5) {
            var user = User()
            user.name = "" + i
            db.userDao().insert(user)

        }


        var list = db.userDao().allUsers
        var l = " s"
    }
}
