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
        val monthlyRate=rate/12
        var currentSIPAmount=amount
        for(i in 1..time){
            futureVal+=currentSIPAmount* ((1 + monthlyRate / 100.0).pow(time - i))
            if(i%12==0)
            {
                currentSIPAmount*=1+(stepUp/100)
            }
        }
        val calculatedAmt = futureVal.toInt()
        _investmentAmount.value = currentSIPAmount
        _estimatedAmount.value = calculatedAmt
        _calculatedReturns.value = 0
    }
}
