package com.example.sipcalculator.ui.mainUI

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sipcalculator.databinding.FragmentCoursesBinding


class CoursesFragment : Fragment() {
    private lateinit var binding: FragmentCoursesBinding
    private lateinit var course: TextView
    private lateinit var playButton1: ImageView
    private lateinit var playButton2: ImageView
    private lateinit var playButton3: ImageView
    private lateinit var playButton4: ImageView
    private lateinit var playButton5: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoursesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            course = whatIsSIP1
            playButton1=imageView1
            playButton2=imageView2
            playButton3=imageView3
            playButton4=imageView4
            playButton5=imageView5
        }
        course.movementMethod = LinkMovementMethod.getInstance()
        playButton1.setOnClickListener{
            playList("https://www.youtube.com/watch?v=AWoIBW5FnOw")
        }
        playButton2.setOnClickListener{
            playList("https://www.youtube.com/watch?v=C2p7Bf1vNeA")
        }
        playButton3.setOnClickListener{
            playList("https://www.youtube.com/watch?v=x2s0XKLQR1A")
        }
        playButton4.setOnClickListener{
            playList("https://www.youtube.com/watch?v=fbrHqPRwz1s")
        }
        playButton5.setOnClickListener{
            playList("https://www.youtube.com/watch?v=Wy2aEUmf_OE")
        }
    }
    fun playList(url:String){
        val intent = Intent()
        intent.setAction(Intent.ACTION_VIEW)
        intent.addCategory(Intent.CATEGORY_BROWSABLE)
        intent.data=Uri.parse(url)
        startActivity(intent)
    }
}