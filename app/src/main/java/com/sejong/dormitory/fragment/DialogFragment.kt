package com.sejong.dormitory.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sejong.dormitory.R
import com.sejong.dormitory.databinding.FragmentDialogBinding

class DialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentDialogBinding
    private var titleListener: TitleUpdateListener? = null
    private var adapterListener: AdapterUpdateListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        titleListener = if (context is TitleUpdateListener) {
            context
        } else {
            null
        }

        adapterListener = if (context is AdapterUpdateListener) {
            context
        } else {
            null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle( // Background -> Transparent.
            STYLE_NORMAL,
            R.style.TransparentBottomSheetDialogFragment
        )

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDialogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvClose.setOnClickListener {
            dismiss()
        }

        binding.tvLife.setOnClickListener {
            titleListener?.onTextUpdate("생활 민원")
            adapterListener?.onLifeAdapterUpdate()
            dismiss()
        }

        binding.tvFacility.setOnClickListener {
            titleListener?.onTextUpdate("시설 민원")
            adapterListener?.onFacilityAdapterUpdate()
            dismiss()
        }
    }

    interface TitleUpdateListener {
        fun onTextUpdate(newText: String)
    }

    interface AdapterUpdateListener {
        fun onFacilityAdapterUpdate()
        fun onLifeAdapterUpdate()
    }
}