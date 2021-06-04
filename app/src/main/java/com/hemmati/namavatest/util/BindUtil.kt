package com.hemmati.namavatest.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.hemmati.namavatest.R
import com.squareup.picasso.Picasso


object BindUtil {

    @JvmStatic
    @BindingAdapter("app:loadImage")
    fun loadImage(view: ImageView, imageUrl: String?) {
        Picasso.get().load(imageUrl ?: return).fit()
            .error(R.drawable.ic_baseline_terrain)
            .into(view)
    }
}