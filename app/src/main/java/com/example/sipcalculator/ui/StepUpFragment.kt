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
import com.example.sipcalculator.databinding.FragmentStepUpBinding
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel


class StepUpFragment : Fragment() {
    private lateinit var binding: FragmentStepUpBinding
    private lateinit var investment: TextView
    private lateinit var estimated: TextView
    private lateinit var pieChart: PieChart
    private lateinit var inputAmount: EditText
    private lateinit var inputReturnRate: EditText
    private lateinit var inputTime: EditText
    private lateinit var calculateBtn: Button
    private lateinit var calculatedReturnsText: TextView
    private var calculatedAmt:Int=0
    private var invAmt:Int=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStepUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            investment = invAmtStepUp
            estimated = estAmtStepUp
            pieChart = stepUpPieChart
            inputAmount = editTextAmtStepUp
            inputReturnRate = editTextRateStepUp
            inputTime = editTextTimeStepUp
            calculateBtn = calculateButtonStepUp
            calculatedReturnsText = totalInvStepUp
        }
setData()

        calculateBtn.setOnClickListener {
            val enteredAmt: Int = Integer.parseInt(inputAmount.text.toString())
            val enteredRate: Int = Integer.parseInt(inputReturnRate.text.toString())
            val enteredTime: Int = Integer.parseInt(inputTime.text.toString())
            calculatedAmt = ((enteredAmt * ((((1 + enteredRate) * enteredTime) - 1) / enteredRate) * (1 + enteredRate)).toDouble()).toInt()
           invAmt=enteredAmt*enteredTime
            calculatedReturnsText.text = calculatedAmt.toString()
            setData()
        }

    }



private fun setData() {
    investment.text = invAmt.toString()
    estimated.text = calculatedAmt.toString()


    // Set the data and color to the pie chart
    pieChart.addPieSlice(
        PieModel(
            "Invested Amount",
            Integer.parseInt(investment.text.toString()).toFloat(),
            Color.parseColor("#FCD828"))
    )
    pieChart.addPieSlice(
        PieModel(
            "Estimated Amount",
            Integer.parseInt(estimated.text.toString()).toFloat(),
            Color.parseColor("#1A7CC8"))
    )

    // To animate the pie chart
    pieChart.startAnimation()
}
    }
