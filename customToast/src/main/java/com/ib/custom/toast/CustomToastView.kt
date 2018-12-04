package com.ib.custom.toast

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

/**
 * Custom Toast With All Possible Customisations.
 * check commented class CustomToastJava for java code.
 */
@Suppress("Unused")
class CustomToastView(context: Context?) : Toast(context) {


    /**
     * Companion object to make all the methods  static
     * @JvmStatic is added to all methods to call the methods directly with class name from java classes
     * Types are declared as const to avoid getter method.
     * see this for details:-https://medium.com/@dbottillo/kotlin-and-static-not-as-easy-as-java-5f9b5b89b683
     */
    companion object build {
        /**
         * Types of Toast message
         */
        const val WARNING = 1

        const val ERROR = 2

        const val SUCCESS = 3

        const val INFO = 4

        const val DEFAULT = 5

        /**
         *
         * @param context context to initialise toast.
         * @param duration duration of toast.
         * @param message message to show to user.
         * @param layoutId id of custom layout.
         * @return toast inflated with custom layout.
         */
        @JvmStatic
        fun makeText(context: Context, duration: Int, message: String, layoutId: Int): Toast {
            val toast = Toast(context)
            toast.duration = duration
            var customLayout: View? = null
            val isEmpty = TextUtils.isEmpty(message)

            try {
                customLayout = LayoutInflater.from(context).inflate(layoutId, null, false)
                val tvMessage:TextView? = customLayout.findViewById(R.id.toastMessage)
                if (!isEmpty) tvMessage!!.text = message
            } catch (e: Exception) {
                if (e is NullPointerException) {
                    Log.e("INFLATION_ERROR", "Please Provide correct layout id or please change you custom layout textview id to @+id/toastMessage")
                } else {
                    e.printStackTrace()
                }
            }


            toast.view = customLayout
            return toast
        }


        /**
         *
         * @param context context to initialise toast.
         * @param duration duration of toast.
         * @param layoutId id of custom layout.
         * @return toast inflated with custom layout.
         */
        @JvmStatic
        fun showCustomToast(context: Context,duration: Int,layoutId: Int):Toast{
            val toast = Toast(context)
            toast.view =  LayoutInflater.from(context).inflate(layoutId,null,false)
            return toast
        }

        /**
         *
         * @param context context to initialise toast
         * @param duration duration of toast
         * @param type type toast
         * @param message message to show to user
         * @return toast with icons.
         */
        @JvmStatic
        fun makeText(context: Context, duration: Int, type: Int, message: String?): Toast {
            val toast = Toast(context)
            toast.duration = duration

            val customLayout = LayoutInflater.from(context).inflate(R.layout.custom_toast, null, false)
            val llToastBg: LinearLayout = customLayout.findViewById(R.id.llToastBackground)
            val imgType: ImageView = customLayout.findViewById(R.id.imgType)
            val tvMessage: TextView = customLayout.findViewById(R.id.toastMessage)
            val isEmpty = TextUtils.isEmpty(message)

            if (!isEmpty) tvMessage.text = message


            val bgShape: GradientDrawable = llToastBg.background as GradientDrawable

            if (type == SUCCESS) {

                bgShape.setColor(ContextCompat.getColor(context,R.color.success))
                tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
                imgType.visibility = View.VISIBLE
                imgType.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_success))

                if (isEmpty)
                    tvMessage.text = context.getString(R.string.success_message)


            } else if (type == ERROR) {

                bgShape.setColor(ContextCompat.getColor(context,R.color.error))
                tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
                imgType.visibility = View.VISIBLE
                imgType.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_error))

                if (isEmpty)
                    tvMessage.text = context.getString(R.string.error_message)

            } else if (type == WARNING) {

                bgShape.setColor(ContextCompat.getColor(context,R.color.warning))
                tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
                imgType.visibility = View.VISIBLE
                imgType.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_warning))

                if (isEmpty)
                    tvMessage.text = context.getString(R.string.warning_message)

            } else if (type == INFO) {

                bgShape.setColor(ContextCompat.getColor(context,R.color.information))
                tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
                imgType.visibility = View.VISIBLE
                imgType.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_info))

                if (isEmpty)
                    tvMessage.text = context.getString(R.string.information_message)


            } else if (type == DEFAULT) {

                bgShape.setColor(ContextCompat.getColor(context,R.color.black))
                tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
                imgType.visibility = View.GONE

                if (isEmpty)
                    tvMessage.text = context.getString(R.string.default_message)
            }

            toast.view = customLayout
            return toast
        }

        /**
         *
         * @param context context to initialise toast.
         * @param message message to show to user.
         * @return default toast with out icons.
         */
        @JvmStatic
        fun makeDefaultToast(context: Context, message: String): Toast {
            val toast = Toast(context)
            toast.duration = Toast.LENGTH_SHORT

            val customLayout = LayoutInflater.from(context).inflate(R.layout.custom_toast, null as ViewGroup?, false)
            val llToastBg: LinearLayout = customLayout.findViewById(R.id.llToastBackground)
            val imgType: ImageView = customLayout.findViewById(R.id.imgType)
            imgType.visibility = View.GONE
            val tvMessage: TextView = customLayout.findViewById(R.id.toastMessage)
            val bgShape: GradientDrawable = llToastBg.background as GradientDrawable
            tvMessage.text = message

            bgShape.setColor(ContextCompat.getColor(context,R.color.black))
            tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
            imgType.visibility = View.GONE

            toast.view = customLayout
            return toast
        }

        /**
         *
         * @param context  context to initialise toast.
         * @param message message to show to user.
         * @param shouldShowIcon should icon be displayed.
         * @return success toast object.
         */
        @JvmStatic
        fun makeSuccessToast(context: Context, message: String, shouldShowIcon: Int): Toast {
            val toast = Toast(context)
            toast.duration = Toast.LENGTH_SHORT

            val customLayout = LayoutInflater.from(context).inflate(R.layout.custom_toast, null as ViewGroup?, false)
            val llToastBg: LinearLayout = customLayout.findViewById(R.id.llToastBackground)
            val imgType: ImageView = customLayout.findViewById(R.id.imgType)
            val tvMessage: TextView = customLayout.findViewById(R.id.toastMessage)
            val bgShape = llToastBg.background as GradientDrawable
            tvMessage.text = message

            bgShape.setColor(ContextCompat.getColor(context,R.color.success))
            tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
            imgType.visibility = shouldShowIcon
            imgType.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_success))

            toast.view = customLayout

            return toast
        }


        /**
         *
         * @param context context to initialise toast
         * @param message message to show to user
         * @param shouldShowIcon should icon be displayed.
         * @return error toast object.
         */
        @JvmStatic
        fun makeErrorToast(context: Context, message: String, shouldShowIcon: Int): Toast {
            val toast = Toast(context)
            toast.duration = Toast.LENGTH_SHORT

            val customLayout = LayoutInflater.from(context).inflate(R.layout.custom_toast, null as ViewGroup?, false)
            val llToastBg: LinearLayout = customLayout.findViewById(R.id.llToastBackground)
            val imgType: ImageView = customLayout.findViewById(R.id.imgType)
            val tvMessage: TextView = customLayout.findViewById(R.id.toastMessage)
            val bgShape: GradientDrawable = llToastBg.background as GradientDrawable
            tvMessage.text = message

            bgShape.setColor(ContextCompat.getColor(context,R.color.error))
            tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
            imgType.visibility = shouldShowIcon
            imgType.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_error))

            toast.view = customLayout
            return toast
        }

        /**
         *
         * @param context context to initialise toast
         * @param message message to show to user
         * @param shouldShowIcon should icon be displayed.
         * @return warning toast object.
         */
        @JvmStatic
        fun makeWarningToast(context: Context, message: String, shouldShowIcon: Int): Toast {
            val toast = Toast(context)
            toast.duration = Toast.LENGTH_SHORT

            val customLayout = LayoutInflater.from(context).inflate(R.layout.custom_toast, null as ViewGroup?, false)
            val llToastBg: LinearLayout = customLayout.findViewById(R.id.llToastBackground)
            val imgType: ImageView = customLayout.findViewById(R.id.imgType)
            imgType.visibility = shouldShowIcon
            val tvMessage: TextView = customLayout.findViewById(R.id.toastMessage)
            val bgShape: GradientDrawable = llToastBg.background as GradientDrawable
            tvMessage.text = message


            bgShape.setColor(ContextCompat.getColor(context,R.color.warning))
            tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
            imgType.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_warning))

            toast.view = customLayout
            return toast
        }

        /**
         *
         * @param context context to initialise toast.
         * @param message message to show to user.
         * @param shouldShowIcon should icon be displayed.
         * @return infomation toast object.
         */
        @JvmStatic
        fun makeInfoToast(context: Context, message: String, shouldShowIcon: Int): Toast {
            val toast = Toast(context)
            toast.duration = Toast.LENGTH_SHORT

            val customLayout = LayoutInflater.from(context).inflate(R.layout.custom_toast, null as ViewGroup?, false)
            val llToastBg: LinearLayout = customLayout.findViewById(R.id.llToastBackground)
            val imgType: ImageView = customLayout.findViewById(R.id.imgType)
            imgType.visibility = shouldShowIcon
            val tvMessage: TextView = customLayout.findViewById(R.id.toastMessage)
            val bgShape: GradientDrawable = llToastBg.background as GradientDrawable
            tvMessage.text = message

            bgShape.setColor(ContextCompat.getColor(context,R.color.information))
            tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
            imgType.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_info))

            toast.view = customLayout
            return toast
        }

        /**
         *
         * @param context  context to initialise toast.
         * @param duration duration of toast
         * @param type type toast
         * @param message message to show to user.
         * @param shouldShowIcon should icon be displayed.
         * @return custom toast object with user specified customisations.
         */
        @JvmStatic
        fun makeText(context: Context, duration: Int, type: Int, message: String?, shouldShowIcon: Boolean): Toast {
            val toast = Toast(context)
            toast.duration = duration

            val customLayout = LayoutInflater.from(context).inflate(R.layout.custom_toast, null as ViewGroup?, false)
            val llToastBg = customLayout.findViewById<LinearLayout>(R.id.llToastBackground)
            val imgType = customLayout.findViewById<ImageView>(R.id.imgType)
            val tvMessage = customLayout.findViewById<TextView>(R.id.toastMessage)
            val isEmpty = TextUtils.isEmpty(message)

            if (!isEmpty)
                tvMessage.text = message
            val bgShape = llToastBg.background as GradientDrawable

            val visibility = if (shouldShowIcon) View.VISIBLE else View.GONE

            if (type == SUCCESS) {

                bgShape.setColor(ContextCompat.getColor(context,R.color.success))
                tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
                imgType.visibility = visibility
                imgType.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_success))

                if (isEmpty)
                    tvMessage.text = context.getString(R.string.success_message)


            } else if (type == ERROR) {

                bgShape.setColor(ContextCompat.getColor(context,R.color.error))
                tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
                imgType.visibility = visibility
                imgType.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_error))

                if (isEmpty)
                    tvMessage.text = context.getString(R.string.error_message)

            } else if (type == WARNING) {

                bgShape.setColor(ContextCompat.getColor(context,R.color.warning))
                tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
                imgType.visibility = visibility
                imgType.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_warning))

                if (isEmpty)
                    tvMessage.text = context.getString(R.string.warning_message)

            } else if (type == INFO) {

                bgShape.setColor(ContextCompat.getColor(context,R.color.information))
                tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
                imgType.visibility = visibility
                imgType.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_info))

                if (isEmpty)
                    tvMessage.text = context.getString(R.string.information_message)


            } else if (type == DEFAULT) {

                bgShape.setColor(ContextCompat.getColor(context,R.color.black))
                tvMessage.setTextColor(ContextCompat.getColor(context,R.color.white))
                imgType.visibility = View.GONE

                if (isEmpty)
                    tvMessage.text = context.getString(R.string.default_message)

            }

            toast.view = customLayout
            return toast
        }
    }


}