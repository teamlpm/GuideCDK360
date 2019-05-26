package com.devhwang1312.cdk360.ui

import android.content.Context
import android.support.v4.app.Fragment
import com.solar.file.voicesearch.interfaces.IOnBackListener
import com.solar.file.voicesearch.interfaces.IOnFragmentInteractListener


/**
 *  Created by AMBE on 10/4/2019 at 8:46 AM.
 */
abstract class BaseFragment : Fragment() {
    protected var listenerI: IOnFragmentInteractListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is IOnFragmentInteractListener) {
            listenerI = context
        }

    }

    override fun onDetach() {
        super.onDetach()
        listenerI = null
    }

    open inner class BaseHandler : IOnBackListener {
        override fun onBack() {
            listenerI?.onBackToHome()
        }

    }

}