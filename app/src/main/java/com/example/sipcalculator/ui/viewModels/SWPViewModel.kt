package com.example.sipcalculator.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.time.times

class SWPViewModel:ViewModel() {
        private val _investmentAmount = MutableLiveData<Int>()
        val investmentAmount: LiveData<Int> = _investmentAmount

        private val _estimatedAmount = MutableLiveData<Int>()
        val estimatedAmount: LiveData<Int> = _estimatedAmount

        private val _calculatedReturns = MutableLiveData<Int>()
        val calculatedReturns: LiveData<Int> = _calculatedReturns

        fun calculateSWP(amount: Int ,rate: Int, time: Int,withdrawl:Int) {
            var futureVal=0.0
            var corpus=amount.toDouble()
            val monthlyRate:Double=((rate/100.0)/12)
            for(i in 1..time){
                val interestEarned=corpus * monthlyRate
                corpus+=interestEarned
                corpus-=withdrawl
                futureVal+=withdrawl.toDouble()

                if(corpus<=0)
                {
                    corpus=0.0
                    break
                }
            }
            val calculatedAmt =corpus
            _investmentAmount.value = amount
            _estimatedAmount.value = futureVal.toInt()
            _calculatedReturns.value = calculatedAmt.toInt()
        }
    }
