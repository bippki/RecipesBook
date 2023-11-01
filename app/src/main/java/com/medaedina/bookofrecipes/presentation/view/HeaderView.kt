package com.medaedina.bookofrecipes.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.medaedina.bookofrecipes.R

class HeaderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    LinearLayout(context, attrs, defStyleAttr) {

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        View.inflate(context, R.layout.header_view, this)
        val textViewTitle = findViewById<TextView>(R.id.textView_title)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.HeaderView)
        try { // If attributes not empty
            val title = attributes.getString(R.styleable.HeaderView_title)
            textViewTitle.text = title
        } finally {
            attributes.recycle()
        }
    }
}