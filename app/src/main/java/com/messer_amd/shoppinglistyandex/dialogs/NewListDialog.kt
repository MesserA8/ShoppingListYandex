package com.messer_amd.shoppinglistyandex.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.messer_amd.shoppinglistyandex.databinding.NewListDialogBinding

object NewListDialog {
    fun showDialog(context: Context, listener: Listener, s: String) {
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        val binding = NewListDialogBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)
        binding.apply {
            bCreate.setOnClickListener {
                val listName = edNewListName.text.toString()
                if (listName.isNotEmpty()) {
                    listener.onClick(listName)
                }
                dialog?.dismiss()
            }
        }
        dialog = builder.create()
        dialog.window?.setBackgroundDrawable(null)
        dialog.show()
    }

    interface Listener {
        fun onClick(name: String) {

        }
    }
}