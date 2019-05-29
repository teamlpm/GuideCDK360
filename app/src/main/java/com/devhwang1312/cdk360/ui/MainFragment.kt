package com.devhwang1312.cdk360.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devhwang1312.cdk360.Model.CharacterObject
import com.devhwang1312.cdk360.R


class MainFragment: BaseFragment() {
    private var v: View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.fragment_main, container, false)
        }
        return v
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        var a = CharacterObject()
        Log.e("HJVV1312","$a")
    }
}