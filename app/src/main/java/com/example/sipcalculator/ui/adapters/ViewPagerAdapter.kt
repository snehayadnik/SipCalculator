package com.example.sipcalculator.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sipcalculator.ui.baseFragment.tabUi.LumpSumFragment
import com.example.sipcalculator.ui.baseFragment.tabUi.SIPFragment
import com.example.sipcalculator.ui.baseFragment.tabUi.SWPFragment
import com.example.sipcalculator.ui.baseFragment.tabUi.StepUpFragment

class ViewPagerAdapter (
fragmentManager:FragmentManager,
    lifecycle:Lifecycle
):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SIPFragment()
            1 -> StepUpFragment()
            2 -> LumpSumFragment()
            3 -> SWPFragment()
            else -> SIPFragment()
        }
    }
}
