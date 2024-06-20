package com.example.sipcalculator.ui.baseFragment.tabUi

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.sipcalculator.databinding.FragmentSWPBinding
import com.example.sipcalculator.databinding.FragmentStepUpBinding
import com.example.sipcalculator.ui.viewModels.StepUpViewModel
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel


class SWPFragment : Fragment() {
    private lateinit var binding: FragmentSWPBinding
    private lateinit var investment: TextView
    private lateinit var estimated: TextView
    private lateinit var pieChart: PieChart
    private lateinit var inputAmount: EditText
    private lateinit var inputReturnRate: EditText
    private lateinit var inputTime: EditText
    private lateinit var calculateBtn: Button
    private var calculatedAmt: Int = 0
    private var invAmount: Int = 0
    private lateinit var calculatedReturnsText: TextView
    private lateinit var incInv: Button
    private lateinit var decInv: Button
    private var enteredAmt: Int = 0


    private val viewModel: StepUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSWPBinding.inflate(inflater, container, false).apply{
            lifecycleOwner=viewLifecycleOwner
            viewModel=this@SWPFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calculateButtonSWP.setOnClickListener {
            val enteredAmt = binding.editTextAmtSWP.text.toString().toInt()
            val enteredRate = binding.editTextRateSWP.text.toString().toInt()
            val enteredTime = binding.editTextTimeSWP.text.toString().toInt()
            val enteredStepUp = binding.editTextWithdrawlSWP.text.toString().toInt()
            viewModel.calculateStepUp(enteredAmt,enteredRate,enteredTime,enteredStepUp)
        }
        viewModel.investmentAmount.observe(viewLifecycleOwner, Observer{
            binding.invAmtSWP.text=it.toString()
        })
        viewModel.estimatedAmount.observe(viewLifecycleOwner,Observer{
            binding.estAmtSWP.text=it.toString()
        })
        viewModel.calculatedReturns.observe(viewLifecycleOwner,Observer{
            binding.totalInvSWP.text=it.toString()
        })
    }


    private fun setData(estimatedAmount:Int) {
        val investedAmount=viewModel.investmentAmount.value?:0
        binding.SWPPiechart.clearChart()
        binding.SWPPiechart.addPieSlice(
            PieModel(
                "Invested Amount",
                investedAmount.toFloat(),
                Color.parseColor("#FCD828")
            )
        )
        binding.SWPPiechart.addPieSlice(
            PieModel( "Estimated Amount",
                estimatedAmount.toFloat(),
                Color.parseColor("#1A7CC8")

            )
        )
        binding.SWPPiechart.startAnimation()
    }
}
/*
(A × r) / [n × {1 - (1 + r)^(-nt)}]

Where:

A = Initial Investment Amount

R = Expected Rate of Return

n = Number of Annual Withdrawals

t = Investment Tenure (in years)*/
