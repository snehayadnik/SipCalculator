package com.example.sipcalculator.ui.mainUI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sipcalculator.R
import com.example.sipcalculator.databinding.ActivityMainBinding
import com.example.sipcalculator.ui.baseFragment.CalculatorFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firstFragment: CalculatorFragment
    private lateinit var secondFragment : CoursesFragment
    private lateinit var thirdFragment: FAQSFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
         firstFragment = CalculatorFragment()
        secondFragment = CoursesFragment()
         thirdFragment = FAQSFragment()

        setCurrentFragment(firstFragment)

        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.Calculator -> setCurrentFragment(firstFragment)
                R.id.Courses -> setCurrentFragment(secondFragment)
                R.id.FAQS -> setCurrentFragment(thirdFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            addToBackStack(null)
            commit()
        }
    }
}