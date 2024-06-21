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
            val ratePercent=(rate/100.0)/12.0
            /*var a= amount* ((1+ratePercent).pow(time))
            var b= withdrawl * (((((1+ratePercent).pow(time))-1))/ratePercent)*/
            futureVal= amount * (1 + ratePercent).pow(time) -
                    withdrawl * ((1 + ratePercent).pow(time) - 1) / ratePercent

            val calculatedAmt = futureVal.toInt()
            _investmentAmount.value = amount
            _estimatedAmount.value = calculatedAmt
            _calculatedReturns.value = calculatedAmt-amount
        }
    }
