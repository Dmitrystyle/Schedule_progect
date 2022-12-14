package com.example.schedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.*
import com.example.myapplication4.UserAdapter
import com.example.schedule.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    //список из фрагментов
    private val fragList= listOf(
        Fragment1.newInstance(),
        Fragment2.newInstance(),
        Fragment3.newInstance(),
        Fragment4.newInstance(),
        Fragment5.newInstance(),
        Fragment6.newInstance(),
        settings.newInstance()

    )


    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //_____экран опций______
        val fragment_options = Fragment4()
        val fragment: FragmentManager =supportFragmentManager
                fragment.beginTransaction().add(R.id.placeHolder, fragment_options).commit()


        //___рассписание лист_____





        //__________панель внизу_______
        //binding.bNav.selectedItemId=R.id.note
        binding.bNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.note -> {
                    supportFragmentManager.beginTransaction().replace(R.id.placeHolder, fragList[0]).commit()
                    binding.tabLayoutView.visibility= View.VISIBLE
                }

                R.id.settings -> {
                    supportFragmentManager.beginTransaction().replace(R.id.placeHolder, fragList[6]).commit()
                    binding.tabLayoutView.visibility= View.GONE
                }
            }

            true
        }

        //кнопки



        //__________панель в верху_______

        binding.tabLayoutView.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
               supportFragmentManager.beginTransaction().replace(R.id.placeHolder, fragList[tab?.position!!]).commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                supportFragmentManager.beginTransaction().replace(R.id.placeHolder, fragList[0]).commit()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                supportFragmentManager.beginTransaction().replace(R.id.placeHolder, fragList[0]).commit()
            }
        })

    }


}