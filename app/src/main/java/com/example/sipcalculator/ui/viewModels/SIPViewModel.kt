package com.example.sipcalculator.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class SIPViewModel: ViewModel() {
    private val _investmentAmount = MutableLiveData<Int>()
    val investmentAmount: LiveData<Int> = _investmentAmount

    private val _estimatedAmount = MutableLiveData<Int>()
    val estimatedAmount: LiveData<Int> = _estimatedAmount

    private val _calculatedReturns = MutableLiveData<Int>()
    val calculatedReturns: LiveData<Int> = _calculatedReturns

    fun calculateSIP(amount: Int, rate: Int, time: Int) {
        val calculatedAmt = (amount * ((((rate/100.0).pow(time))-1)/(rate/100.0))*(1+(rate/100.0))).toInt()
        _investmentAmount.value = amount*12
        _estimatedAmount.value =  calculatedAmt - (amount*12)
        _calculatedReturns.value = calculatedAmt
    }
}
