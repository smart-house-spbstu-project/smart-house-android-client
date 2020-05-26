package com.yum.sample.components

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.menu_button.view.*
import android.util.TypedValue
import androidx.core.content.ContextCompat
import com.yum.sample.MenuItem
import com.yum.sample.R


class MenuButton @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    var model: MenuItem? = null

    init {
        if(context != null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(R.layout.menu_button, this, true)
            attrs?.setAttrs()
        }
    }

    private fun AttributeSet.setAttrs() {
        context.theme.obtainStyledAttributes(
            this,
            R.styleable.MenuButton,
            0,
            0
        ).apply {
            button_text.text = getString(R.styleable.MenuButton_text) ?: "Menu Button"
            val active = getBoolean(R.styleable.MenuButton_active, false)
            isEnabled = active
            recycle()
        }
    }

    fun bind(value: MenuItem){
        model = value
        if(context != null) {
            button_text.text = context.getString(value.title)
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT)
                imageView.setBackgroundResource(value.content)
            else
                imageView.setImageDrawable(ContextCompat.getDrawable(context, value.content))
        }
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        button_text.isEnabled = enabled
        imageView.isEnabled = enabled
    }
}