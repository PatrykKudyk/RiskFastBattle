package com.example.riskfastbattle

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.riskfastbattle.fragments.MainMenuFragment

class MainActivity : AppCompatActivity(),
    MainMenuFragment.OnFragmentInteractionListener {
    lateinit var mainMenuFragment: MainMenuFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainMenuFragment = MainMenuFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.enter_bottom_to_top, R.anim.exit_top_to_bottom,
                R.anim.enter_top_to_bottom, R.anim.exit_bottom_to_top
            )
            .add(R.id.frame_layout, mainMenuFragment)
            .commit()
    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}