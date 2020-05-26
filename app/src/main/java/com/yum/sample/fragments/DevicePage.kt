package com.yum.sample.fragments

import android.os.Bundle
import android.transition.ChangeBounds
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yum.sample.CustomActivity
import com.yum.sample.R
import kotlinx.android.synthetic.main.device_page.*
import java.io.DataOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import android.widget.Toast
import com.yum.sample.CommandFactory


class DevicePage : Fragment() {

    lateinit var activity: CustomActivity
    var layoutId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layoutId = arguments?.get("button_id") as Int
        activity = context as CustomActivity
        activity.setTitle(layoutId)

        enterTransition = ChangeBounds()
        exitTransition = ChangeBounds()

        return inflater.inflate(R.layout.device_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtons(layoutId)
        enable.setOnClickListener { onClick(true) }
        disable.setOnClickListener { onClick(false) }
    }

    fun setButtons(layoutId: Int) {
        if (layoutId in 1..2) {
            enable.text = "Open"
            disable.text = "Close"
        }
    }

    fun onClick(boo: Boolean) {
        val command = CommandFactory.getCommand(CommandFactory.BUTTON_ID)
        if(command is CommandFactory.TurnCommand){
            command.boo = boo
            command.context = context
            command.id = id
            command.title = activity.gettitle()
        }
        command.execute()
    }
}