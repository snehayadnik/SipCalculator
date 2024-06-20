package com.example.sipcalculator.ui.mainUI

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.sipcalculator.R
import com.example.sipcalculator.databinding.FragmentFAQSBinding

class FAQSFragment : Fragment() {
    private lateinit var binding: FragmentFAQSBinding
    private lateinit var arrow: ImageView
    private lateinit var hiddenView: TextView
    private lateinit var cardView: CardView

    private lateinit var arrow2: ImageView
    private lateinit var hiddenView2: TextView
    private lateinit var cardView2: CardView
    private lateinit var arrow3: ImageView
    private lateinit var hiddenView3: TextView
    private lateinit var cardView3: CardView
    private lateinit var arrow4: ImageView
    private lateinit var hiddenView4: TextView
    private lateinit var cardView4: CardView
    private lateinit var arrow5: ImageView
    private lateinit var hiddenView5: TextView
    private lateinit var cardView5: CardView
    private lateinit var arrow6: ImageView
    private lateinit var hiddenView6: TextView
    private lateinit var cardView6: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFAQSBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply{
            arrow=arrowButton
            hiddenView=ans1
            cardView=baseCardview1
            arrow2=arrowButton2
            hiddenView2=ans2
            cardView2=baseCardview2
            arrow3=arrowButton3
            hiddenView3=ans3
            cardView3=baseCardview3
            arrow4=arrowButton4
            hiddenView4=ans4
            cardView4=baseCardview4
            arrow5=arrowButton5
            hiddenView5=ans5
            cardView5=baseCardview5
            arrow6=arrowButton6
            hiddenView6=ans6
            cardView6=baseCardview6}


       arrow.setOnClickListener {
            if (hiddenView.visibility == View.VISIBLE) {
                // The transition of the hiddenView is carried out by the TransitionManager class.
                // Here we use an object of the AutoTransition Class to create a default transition
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                hiddenView.visibility = View.GONE
                arrow.setImageResource(R.drawable.
                caret_down_arrow_south_svgrepo_com)
            } else {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                hiddenView.visibility = View.VISIBLE
                arrow.setImageResource(R.drawable.caret_up_arrow_north_svgrepo_com)
            }
        }
        arrow2.setOnClickListener {
            if (hiddenView2.visibility == View.VISIBLE) {
                // The transition of the hiddenView is carried out by the TransitionManager class.
                // Here we use an object of the AutoTransition Class to create a default transition
                TransitionManager.beginDelayedTransition(cardView2, AutoTransition())
                hiddenView2.visibility = View.GONE
                arrow2.setImageResource(R.drawable.
                caret_down_arrow_south_svgrepo_com)
            } else {
                TransitionManager.beginDelayedTransition(cardView2, AutoTransition())
                hiddenView2.visibility = View.VISIBLE
                arrow2.setImageResource(R.drawable.caret_up_arrow_north_svgrepo_com)
            }
        }
        arrow3.setOnClickListener {
            if (hiddenView3.visibility == View.VISIBLE) {
                // The transition of the hiddenView is carried out by the TransitionManager class.
                // Here we use an object of the AutoTransition Class to create a default transition
                TransitionManager.beginDelayedTransition(cardView3, AutoTransition())
                hiddenView3.visibility = View.GONE
                arrow3.setImageResource(R.drawable.
                caret_down_arrow_south_svgrepo_com)
            } else {
                TransitionManager.beginDelayedTransition(cardView3, AutoTransition())
                hiddenView3.visibility = View.VISIBLE
                arrow3.setImageResource(R.drawable.caret_up_arrow_north_svgrepo_com)
            }
        }
        arrow4.setOnClickListener {
            if (hiddenView4.visibility == View.VISIBLE) {
                // The transition of the hiddenView is carried out by the TransitionManager class.
                // Here we use an object of the AutoTransition Class to create a default transition
                TransitionManager.beginDelayedTransition(cardView4, AutoTransition())
                hiddenView4.visibility = View.GONE
                arrow4.setImageResource(R.drawable.
                caret_down_arrow_south_svgrepo_com)
            } else {
                TransitionManager.beginDelayedTransition(cardView4, AutoTransition())
                hiddenView4.visibility = View.VISIBLE
                arrow4.setImageResource(R.drawable.caret_up_arrow_north_svgrepo_com)
            }
        }
        arrow5.setOnClickListener {
            if (hiddenView5.visibility == View.VISIBLE) {
                // The transition of the hiddenView is carried out by the TransitionManager class.
                // Here we use an object of the AutoTransition Class to create a default transition
                TransitionManager.beginDelayedTransition(cardView5, AutoTransition())
                hiddenView5.visibility = View.GONE
                arrow5.setImageResource(R.drawable.
                caret_down_arrow_south_svgrepo_com)
            } else {
                TransitionManager.beginDelayedTransition(cardView5, AutoTransition())
                hiddenView5.visibility = View.VISIBLE
                arrow5.setImageResource(R.drawable.caret_up_arrow_north_svgrepo_com)
            }
        }
        arrow6.setOnClickListener {
            if (hiddenView6.visibility == View.VISIBLE) {
                // The transition of the hiddenView is carried out by the TransitionManager class.
                // Here we use an object of the AutoTransition Class to create a default transition
                TransitionManager.beginDelayedTransition(cardView6, AutoTransition())
                hiddenView6.visibility = View.GONE
                arrow6.setImageResource(R.drawable.
                caret_down_arrow_south_svgrepo_com)
            } else {
                TransitionManager.beginDelayedTransition(cardView6, AutoTransition())
                hiddenView6.visibility = View.VISIBLE
                arrow6.setImageResource(R.drawable.caret_up_arrow_north_svgrepo_com)
            }
        }
       }
    }

