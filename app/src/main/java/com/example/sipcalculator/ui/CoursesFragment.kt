package com.example.sipcalculator.ui

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
    private lateinit var playButton: ImageView
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
            playButton=imageView1
        }
        course.movementMethod = LinkMovementMethod.getInstance()
    }

  /*playButton.setOnClickListener(View.OnClickListener()) {
        override fun onClick(View v) {
            gotoUrl("https://www.youtube.com/watch?v=Jb7MIBgMwgU");
        }
    }
    private fun gotoUrl(s: String) {
        val uri = Uri.parse(s)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }*/

}