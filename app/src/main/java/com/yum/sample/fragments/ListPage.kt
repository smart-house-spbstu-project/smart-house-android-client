package com.yum.sample.fragments

import android.os.Bundle
import android.transition.ChangeBounds
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yum.sample.*
import com.yum.sample.presenters.Presenter

class ListPage : Fragment(), CustomView {

    lateinit var activity: CustomActivity
    lateinit var navController: NavController
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val buttonId = arguments?.get("button_id") as Int
        activity = context as CustomActivity
        activity.bindList(buttonId, this)
        activity.setTitle(buttonId)
        enterTransition = ChangeBounds()
        exitTransition = ChangeBounds()
    }

    override fun showList(list: List<Int>) {
        val components = ArrayList<Int>()
        navController = NavHostFragment.findNavController(this)
        components.addAll(list)
        val componentsListAdapter =
            RecyclerListAdapter(components, activity::listItemPressed, navController)

        recyclerView.overScrollMode = View.OVER_SCROLL_ALWAYS
        recyclerView.adapter = componentsListAdapter
        recyclerView.overScrollMode = View.OVER_SCROLL_IF_CONTENT_SCROLLS
    }

    override fun setTitle(title: Int) {
        activity.setTitle(title)
    }

}
