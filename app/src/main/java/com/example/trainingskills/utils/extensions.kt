package com.example.trainingskills.utils

import android.app.AlertDialog
import androidx.fragment.app.Fragment

fun Fragment.showDialog(title: String, message: String) {
    AlertDialog.Builder(requireContext())
        .setTitle(title)
        .setMessage(message)
        .create()
        .show()
}