package com.example.sipcalculator.ui.baseFragment.tabUi

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sipcalculator.databinding.FragmentLumpSumBinding
import com.example.sipcalculator.ui.viewModels.LumpsumViewModel
import org.eazegraph.lib.models.PieModel
import androidx.lifecycle.Observer


class LumpSumFragment : Fragment() {
    private lateinit var binding: FragmentLumpSumBinding
    private val viewModel: LumpsumViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLumpSumBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@LumpSumFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calculateButtonLumpsum.setOnClickListener {
            val enteredAmt = binding.editTextAmtLumpsum.text.toString().toInt()
            val enteredRate = binding.editTextRateLumpsum.text.toString().toInt()
            val enteredTime = binding.editTextTimeLumpsum.text.toString().toInt()
            viewModel.calculateLumpsum(enteredAmt, enteredRate, enteredTime)
        }

        viewModel.investmentAmount.observe(viewLifecycleOwner, Observer {
            binding.invAmtLumpsum.text = it.toString()
        })

        viewModel.estimatedAmount.observe(viewLifecycleOwner, Observer {
            binding.estAmtLumpsum.text = it.toString()
            setData(it)
        })

        viewModel.calculatedReturns.observe(viewLifecycleOwner, Observer {
            binding.totalInvLumpsum.text = it.toString()
        })
    }

    private fun setData(estimatedAmount: Int) {
        val investedAmount = viewModel.investmentAmount.value ?: 0

        binding.lumpSumPiechart.clearChart()
        binding.lumpSumPiechart.addPieSlice(
            PieModel(
                "Invested Amount",
                investedAmount.toFloat(),
                Color.parseColor("#FCD828")
            )
        )
        binding.lumpSumPiechart.addPieSlice(
            PieModel(
                "Estimated Amount",
                estimatedAmount.toFloat(),
                Color.parseColor("#1A7CC8")
            )
        )
        binding.lumpSumPiechart.startAnimation()
    }
}
/*binding.apply {
    investment = invAmtLumpsum
    estimated = estAmtLumpsum
    pieChart = lumpSumPiechart
    inputAmount = editTextAmtLumpsum
    inputReturnRate = editTextRateLumpsum
    inputTime = editTextTimeLumpsum
    calculateBtn = calculateButtonLumpsum
    calculatedReturnsText = totalInvLumpsum
}
setData()

calculateBtn.setOnClickListener {
    val enteredAmt: Int = Integer.parseInt(inputAmount.text.toString())
    val enteredRate: Int = Integer.parseInt(inputReturnRate.text.toString())
    val enteredTime: Int = Integer.parseInt(inputTime.text.toString())
    calculatedAmt = enteredAmt * (1 + (enteredRate / 100)).toDouble().pow(enteredTime.toDouble()).toInt()
    calculatedReturnsText.text = (calculatedAmt-enteredAmt).toString()
    invAmount=enteredAmt
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
}*/

/*You must use the mathematical formula: FV = PV(1+r)^n FV = Future Value PV = Present Value r = Rate of interest
n = Number of years For example, you have invested a lump sum amount of Rs 1,00,000 in a mutual fund scheme for 20 years.
You have the expected rate of return of 10% on the investment. You may calculate the future value of the investment as:
 FV = 1,00,000(1+0.1)^20 FV = Rs 6,72,750. You have invested Rs 1,00,000 which has grown to Rs 6,72,750.
 The wealth gain is Rs 6,72,750 – Rs 1,00,000 = Rs 5,72,750.*/
