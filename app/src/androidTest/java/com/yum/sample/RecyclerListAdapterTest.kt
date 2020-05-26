package com.yum.sample

import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import org.junit.Test

import org.junit.Assert.*

class RecyclerListAdapterTest {

    val activity = MainActivity()
    val navController = activity.findNavController(R.id.imageView)
    val action: (Int, NavController) -> Unit = { c, n -> }
    val recycle = RecyclerListAdapter(ArrayList(), action, navController)

    @Test
    fun onCreateViewHolder() {
        recycle.onCreateViewHolder(activity.findViewById(R.id.groupButtons), 12)
    }

    @Test
    fun onBindViewHolder() {
        recycle.onBindViewHolder(
            RecyclerListAdapter.ViewHolder(activity.findViewById(R.id.groupButtons)),
            1
        )
    }

    @Test
    fun getItemCount() {
        assertEquals(0, recycle.itemCount)
    }

    @Test
    fun getOnClick() {
        assertEquals(action, recycle.onClick)
    }

    @Test
    fun getNavController() {
        assertEquals(navController, recycle.navController)
    }
}