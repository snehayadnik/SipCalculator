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
        val monthlyRate=(rate/100.0)/12.0
        val calculatedAmt =(amount * ((((1+monthlyRate).pow(time))-1)/monthlyRate)*(1+monthlyRate)).toInt()
        _investmentAmount.value = amount*time
        _estimatedAmount.value =  calculatedAmt-(amount*time)
        _calculatedReturns.value = calculatedAmt
    }
}

/*
M = P × ({[1 + i]^n – 1} / i) × (1 + i).

In the above formula –

M is the amount you receive upon maturity.
P is the amount you invest at regular intervals.
n is the number of payments you have made.
i is the periodic rate of interest.
Take for example you want to invest Rs. 1,000 per month for 12 months at a periodic rate of interest of 12%.

then the monthly rate of return will be 12%/12 = 1/100=0.01

Hence, M = 1,000X ({[1 +0.01 ]^{12} – 1} / 0.01) x (1 + 0.01)

which gives Rs 12,809 Rs approximately in a year.*/
