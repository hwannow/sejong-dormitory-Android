package com.sejong.dormitory.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sejong.dormitory.databinding.FragmentDayBinding

class DayFragment : Fragment() {
    private lateinit var binding:FragmentDayBinding

    companion object {
        private const val ARG_TITLE = "arg_title"
        private const val ARG_CONTENT = "arg_content"

        fun newInstance(title: String, content: String): DayFragment {
            val fragment = DayFragment()
            val bundle = Bundle()
            bundle.putString(ARG_TITLE, title)
            bundle.putString(ARG_CONTENT, content)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDayBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString(ARG_TITLE) ?: "Title"
        val content = arguments?.getString(ARG_CONTENT) ?: "Content"

        binding.tvDay.text = title
        binding.tvBreakfast.text = content
    }
}