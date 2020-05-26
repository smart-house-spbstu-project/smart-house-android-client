package com.yum.sample.fragments

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Transition
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.yum.sample.*
import com.yum.sample.components.MenuButton
import kotlinx.android.synthetic.main.fragment_main_menu.*
import kotlinx.android.synthetic.main.fragment_main_menu.view.*

class MainMenu : Fragment(), MenuView {

    lateinit var activity: CustomActivity
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentlayout = inflater.inflate(R.layout.fragment_main_menu, container, false)
        navController = NavHostFragment.findNavController(this)
        activity = context as CustomActivity
        val clickListener = CustomOnClickListener(activity, this)

        fragmentlayout.variables.setOnClickListener(clickListener)
        fragmentlayout.components.setOnClickListener(clickListener)
        fragmentlayout.textStyles.setOnClickListener(clickListener)
        fragmentlayout.colors.setOnClickListener(clickListener)
        fragmentlayout.modules.setOnClickListener(clickListener)
        fragmentlayout.templates.setOnClickListener(clickListener)
        enterTransition = ChangeBounds()
        exitTransition = ChangeBounds()

        return fragmentlayout
    }

    override fun navigate(v: View?) {
        val button = v as MenuButton
        activity.navigate(navController, button.id, button.model?.id ?: 0)
    }

    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        super.onViewCreated(v, savedInstanceState)
        activity.bindTiles(this)
    }

    override fun showList(list: List<MenuItem>) {
        variables.bind(list[0])
        textStyles.bind(list[1])
        colors.bind(list[2])
        components.bind(list[3])
        modules.bind(list[4])
        templates.bind(list[5])
    }

    class CustomOnClickListener(val activity: CustomActivity, val menuView: MenuView) : View.OnClickListener {
        override fun onClick(v: View?) {
            activity.tilePressed(v, menuView)
        }
    }
}
