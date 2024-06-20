package com.example.sipcalculator.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class SWPViewModel:ViewModel() {
        private val _investmentAmount = MutableLiveData<Int>()
        val investmentAmount: LiveData<Int> = _investmentAmount

        private val _estimatedAmount = MutableLiveData<Int>()
        val estimatedAmount: LiveData<Int> = _estimatedAmount

        private val _calculatedReturns = MutableLiveData<Int>()
        val calculatedReturns: LiveData<Int> = _calculatedReturns

        fun calculateSWP(amount: Int, rate: Int, time: Int,withdrawl:Int) {
            var futureVal: Double
            val ratePercent=rate/100
            var principal=amount
            futureVal=principal* (1 + ratePercent).toDouble().pow(time.toDouble()) -withdrawl*((1 + ratePercent).toDouble()
                .pow(time.toDouble() - 1))/ratePercent
            val calculatedAmt = futureVal.toInt()
            _investmentAmount.value = principal
            _estimatedAmount.value = calculatedAmt
            _calculatedReturns.value = 0
        }
    }
