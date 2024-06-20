package com.example.sipcalculator.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class LumpsumViewModel: ViewModel() {
    private val _investmentAmount = MutableLiveData<Int>()
    val investmentAmount: LiveData<Int> = _investmentAmount

    private val _estimatedAmount = MutableLiveData<Int>()
    val estimatedAmount: LiveData<Int> = _estimatedAmount

    private val _calculatedReturns = MutableLiveData<Int>()
    val calculatedReturns: LiveData<Int> = _calculatedReturns

    fun calculateLumpsum(amount: Int, rate: Int, time: Int) {
        val calculatedAmt = (amount * ((1 + (rate / 100.0)).pow(time))).toInt()
        _investmentAmount.value = amount
        _estimatedAmount.value = calculatedAmt- amount
        _calculatedReturns.value = calculatedAmt
    }
}

