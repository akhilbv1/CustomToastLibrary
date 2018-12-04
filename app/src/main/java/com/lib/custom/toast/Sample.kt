package com.lib.custom.toast

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.ib.custom.toast.CustomToastView

/*
 * Check commented SampleToastActivity for java code
 */
class Sample :AppCompatActivity(), View.OnClickListener {

    private lateinit var btDefault:Button

    private lateinit var btnError:Button

    private lateinit var btnWarning:Button

    private lateinit var btnInfo:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_toast)
        initialiseViews()
    }

    private fun initialiseViews(){
        btDefault = findViewById(R.id.btnDefault)
        btDefault.setOnClickListener(this)

        btnError = findViewById(R.id.btnError)
        btnError.setOnClickListener(this)

        btnWarning = findViewById(R.id.btnWarning)
        btnWarning.setOnClickListener(this)

        btnInfo = findViewById(R.id.btnInfo)
        btnInfo.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.btnDefault -> CustomToastView.makeText(this@Sample,Toast.LENGTH_SHORT,"Toast is working",R.layout.toast).show()

            R.id.btnSuccess -> CustomToastView.makeText(this@Sample,Toast.LENGTH_SHORT,CustomToastView.SUCCESS,"Toast is working",false).show()

            R.id.btnError   -> CustomToastView.makeText(this@Sample,Toast.LENGTH_SHORT,CustomToastView.ERROR,"Username is not valid",false).show()

            R.id.btnWarning -> CustomToastView.makeText(this@Sample,Toast.LENGTH_SHORT,CustomToastView.WARNING,"Out of Memory",false).show()

            R.id.btnInfo    -> CustomToastView.makeText(this@Sample, Toast.LENGTH_SHORT,CustomToastView.INFO,"password should be atleast 6 characters long",false).show()
        }
    }

}