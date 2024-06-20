package com.example.sipcalculator.ui.baseFragment.tabUi

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.sipcalculator.databinding.FragmentStepUpBinding
import com.example.sipcalculator.ui.viewModels.StepUpViewModel
import org.eazegraph.lib.models.PieModel


class StepUpFragment : Fragment() {
    private lateinit var binding: FragmentStepUpBinding
    private val viewModel:StepUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStepUpBinding.inflate(inflater, container, false).apply{
            lifecycleOwner=viewLifecycleOwner
            viewModel=this@StepUpFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calculateButtonStepUp.setOnClickListener {
            val enteredAmt = binding.editTextAmtStepUp.text.toString().toInt()
            val enteredRate = binding.editTextRateStepUp.text.toString().toInt()
            val enteredTime = binding.editTextTimeStepUp.text.toString().toInt()
            val enteredStepUp = binding.editTextAnnualStepUp.text.toString().toInt()
            viewModel.calculateStepUp(enteredAmt,enteredRate,enteredTime,enteredStepUp)
        }
        viewModel.investmentAmount.observe(viewLifecycleOwner, Observer{
            binding.invAmtStepUp.text=it.toString()
        })
        viewModel.estimatedAmount.observe(viewLifecycleOwner,Observer{
            binding.estAmtStepUp.text=it.toString()
        })
        viewModel.calculatedReturns.observe(viewLifecycleOwner,Observer{
            binding.totalInvStepUp.text=it.toString()
        })
    }


    private fun setData(estimatedAmount:Int) {
        val investedAmount=viewModel.investmentAmount.value?:0
binding.stepUpPieChart.clearChart()
        binding.stepUpPieChart.addPieSlice(
            PieModel(
                "Invested Amount",
                investedAmount.toFloat(),
                Color.parseColor("#FCD828")
                )
            )
        binding.stepUpPieChart.addPieSlice(
            PieModel( "Estimated Amount",
                estimatedAmount.toFloat(),
                Color.parseColor("#1A7CC8")

            )
        )
        binding.stepUpPieChart.startAnimation()
    }
}
