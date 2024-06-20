package com.example.sipcalculator.ui.baseFragment.tabUi

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.sipcalculator.databinding.FragmentSIPBinding
import com.example.sipcalculator.ui.viewModels.SIPViewModel
import org.eazegraph.lib.models.PieModel

class SIPFragment : Fragment() {
    private lateinit var binding: FragmentSIPBinding
    private val viewModel: SIPViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSIPBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@SIPFragment.viewModel
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calculateSIPButton.setOnClickListener {
            val enteredAmt = binding.editTextAmt.text.toString().toInt()
            val enteredRate = binding.editTextRate.text.toString().toInt()
            val enteredTime = binding.editTextTime.text.toString().toInt()
            viewModel.calculateSIP(enteredAmt, enteredRate, enteredTime)
        }

        viewModel.investmentAmount.observe(viewLifecycleOwner, Observer {
            binding.invAmtVal.text = it.toString()
        })

        viewModel.estimatedAmount.observe(viewLifecycleOwner, Observer {
            binding.estAmtVal.text = it.toString()
            setData(it)
        })

        viewModel.calculatedReturns.observe(viewLifecycleOwner, Observer {
            binding.totalAmtVal.text = it.toString()
        })
    }

    private fun setData(estimatedAmount: Int) {
        val investedAmount = viewModel.investmentAmount.value ?: 0

        binding.sipPieChart.clearChart()
        binding.sipPieChart.addPieSlice(
            PieModel(
                "Invested Amount",
                investedAmount.toFloat(),
                Color.parseColor("#FCD828")
            )
        )
        binding.sipPieChart.addPieSlice(
            PieModel(
                "Estimated Amount",
                estimatedAmount.toFloat(),
                Color.parseColor("#1A7CC8")
            )
        )
        binding.sipPieChart.startAnimation()
    }
}


