package com.example.sipcalculator.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class StepUpViewModel: ViewModel() {
    private val _investmentAmount = MutableLiveData<Int>()
    val investmentAmount: LiveData<Int> = _investmentAmount

    private val _estimatedAmount = MutableLiveData<Int>()
    val estimatedAmount: LiveData<Int> = _estimatedAmount

    private val _calculatedReturns = MutableLiveData<Int>()
    val calculatedReturns: LiveData<Int> = _calculatedReturns

    fun calculateStepUp(amount: Int, rate: Int, time: Int,stepUp:Int) {
        var futureVal=0.0
        var invested=0.0
        val monthlyRate=(rate/100.0)/12.0
        val stepUpRate=stepUp/100.0
        var currentInvestment:Double
        for(i in 1..time){
            currentInvestment=amount * ((1+stepUpRate).pow(i/12))
            futureVal+=currentInvestment * ((1+monthlyRate).pow(time-i))
            invested+=currentInvestment
        }
        val calculatedAmt = futureVal.toInt()
        _investmentAmount.value = invested.toInt()
        _estimatedAmount.value = (calculatedAmt-invested).toInt()
        _calculatedReturns.value = calculatedAmt
    }
}


