package com.example.sipcalculator.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.sipcalculator.databinding.FragmentSWPBinding
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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSWPBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            investment = invAmtSWP
            estimated = estAmtSWP
            pieChart = SWPPiechart
            inputAmount = editTextAmtSWP
            inputReturnRate = editTextRateSWP
            inputTime = editTextTimeSWP
            calculateBtn = calculateButtonSWP
            calculatedReturnsText = totalInvSWP

        }

setData()
        calculateBtn.setOnClickListener {
            enteredAmt = Integer.parseInt(inputAmount.text.toString())
            val enteredRate: Int = Integer.parseInt(inputReturnRate.text.toString())
            val enteredTime: Int = Integer.parseInt(inputTime.text.toString())
            calculatedAmt =
                ((enteredAmt * ((((1 + enteredRate) * enteredTime) - 1) / enteredRate) * (1 + enteredRate)).toDouble()).toInt()
            invAmount = enteredAmt * enteredTime
            val totalInv = invAmount + calculatedAmt
            calculatedReturnsText.text = totalInv.toString()
            setData()
        }
    }


    private fun setData() {
        investment.text = invAmount.toString()
        estimated.text = calculatedAmt.toString()


        // Set the data and color to the pie chart
        pieChart.addPieSlice(
            PieModel(
                "Invested Amount",
                Integer.parseInt(investment.text.toString()).toFloat(),
                Color.parseColor("#FCD828")
            )
        )
        pieChart.addPieSlice(
            PieModel(
                "Estimated Amount",
                Integer.parseInt(estimated.text.toString()).toFloat(),
                Color.parseColor("#1A7CC8")
            )
        )

        // To animate the pie chart
        pieChart.startAnimation()
    }
}
/*
(A × r) / [n × {1 - (1 + r)^(-nt)}]

Where:

A = Initial Investment Amount

R = Expected Rate of Return

n = Number of Annual Withdrawals

t = Investment Tenure (in years)*/
