package com.devhwang1312.cdk360.utils

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.BounceInterpolator
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import android.content.pm.PackageManager
import android.widget.Toast


object Utils {

    fun getFolder(folder: String): String {
        return Environment.getExternalStorageDirectory().toString() + File.separator + folder + File.separator
    }

    fun openDevOption(context: Context) {
        context.startActivity(
            Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
        )
    }

    fun openSystemSetting(context: Context) {
        context.startActivity(
            Intent(Settings.ACTION_SETTINGS)
        )
    }

    fun animateDialog(viewGroup: ViewGroup) {
        val set = AnimatorSet()
        val animatorX = ObjectAnimator.ofFloat(viewGroup, ViewGroup.SCALE_X, 0.7f, 1f)
        val animatorY = ObjectAnimator.ofFloat(viewGroup, ViewGroup.SCALE_Y, 0.7f, 1f)
        set.playTogether(animatorX, animatorY)
        set.interpolator = BounceInterpolator()
        set.duration = 500
        set.start()
    }

    fun formatDate(date: Long): String {
        val format = SimpleDateFormat("dd/MM/yyyy")
        return format.format(Date(date))
    }

    fun setStatusBarColor(activity: Activity, color: Int, state: StatusBarState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            var newUiVisibility = activity.window.decorView.systemUiVisibility
            if (state === Utils.StatusBarState.Light) {
                //Dark Text to show up on your light status bar
                newUiVisibility = newUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else if (state === Utils.StatusBarState.Dark) {
                //Light Text to show up on your dark status bar
                newUiVisibility = newUiVisibility and (View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR).inv()
            }
            activity.window.decorView.systemUiVisibility = newUiVisibility
            activity.window.statusBarColor = color
        }
    }

    enum class StatusBarState {
        Light,
        Dark
    }

    fun isDevMode(context: Context): Boolean {
        return when {
            Integer.valueOf(Build.VERSION.SDK_INT) >= 17 -> Settings.Secure.getInt(
                context.contentResolver,
                Settings.Global.DEVELOPMENT_SETTINGS_ENABLED,
                0
            ) != 0
            else -> false
        }
    }


    fun openScreenPermission(context: Context) {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        val uri = Uri.fromParts("package", context.packageName, null)
        intent.data = uri
        context.startActivity(intent)
    }

    fun searchGoogle(context: Context, item: String) {
        val url = "https://www.google.com/search?q=$item"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        context.startActivity(i)
    }

    fun searchWikipedia(context: Context, item: String) {
        //https://en.wikipedia.org/w/index.php?search=conmeo
        val url = "https://en.wikipedia.org/w/index.php?search=$item"
        val webpage: Uri = Uri.parse(url)
        val i = Intent(Intent.ACTION_VIEW, webpage)
        i.data = Uri.parse(url)
        if (i.resolveActivity(context.packageManager) != null) {
            context.startActivity(i)
        }
    }

    fun searchYoutube(context:Context,item:String){
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/results?search_query=$item")
        )
        context.startActivity(intent)
    }

    fun searchPlayStore(context:Context,item:String){
        try {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=$item")))
        } catch (ange: android.content.ActivityNotFoundException) {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/search?q=$item")
                )
            )
        }
    }

    fun searchFacebook(context:Context,item:String){
        val pm = context.packageManager
        if(isPackageInstalled("com.facebook.katana",pm)) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(getFacebookPageURL(context, item)))
            context.startActivity(intent)
        }else{
            Toast.makeText(context,"Please install facebook to find it!",Toast.LENGTH_SHORT).show()
        }
    }

    var FACEBOOK_URL = "https://www.facebook.com/search/top/?q="

    //method to get the right URL to use in the intent
    private fun getFacebookPageURL(context: Context,item:String): String {
        val packageManager = context.packageManager
        try {
            val versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode
            return if (versionCode >= 3002850) { //newer versions of fb app
                "fb://facewebmodal/f?href=$FACEBOOK_URL$item"
            } else { //older versions of fb app
                //"fb://page/$FACEBOOK_PAGE_ID"
                "fb://facewebmodal/f?href=$FACEBOOK_URL$item"
            }
        } catch (e: PackageManager.NameNotFoundException) {
            return FACEBOOK_URL //normal web url
        }
    }

    private fun isPackageInstalled(packageName: String, packageManager: PackageManager): Boolean {
        var found = true
        try {
            packageManager.getPackageInfo(packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {

            found = false
        }
        return found
    }
}
