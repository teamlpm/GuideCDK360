package com.devhwang1312.cdk360

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.devhwang1312.cdk360.ui.MainFragment
import com.solar.file.voicesearch.interfaces.IOnFragmentInteractListener

class MainActivity : AppCompatActivity(), IOnFragmentInteractListener {
    override fun onBackToHome() {
        super.onBackPressed()
    }

    override fun onOpenFragment(fragment: Fragment) {
        openFragment(fragment, true)
    }

    private val mainFragment = MainFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            openFragment(mainFragment, false)
        }
    }

    private fun openFragment(fragment: Fragment, addToBackStack: Boolean) {
        val TAG = fragment.javaClass.simpleName
        val sameTagFragment = supportFragmentManager.findFragmentByTag(TAG)
        if (sameTagFragment != null)
            supportFragmentManager.beginTransaction()
                .remove(sameTagFragment)
                .commit()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, TAG)
        if (addToBackStack) fragmentTransaction.addToBackStack(TAG)
        try {
            fragmentTransaction.commit()
        } catch (ise: IllegalStateException) {
            ise.printStackTrace()
            fragmentTransaction.commitAllowingStateLoss()
        }
    }
}
