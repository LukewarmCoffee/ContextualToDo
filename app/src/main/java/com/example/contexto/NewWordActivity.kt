package com.example.contexto

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewWordActivity : AppCompatActivity() {

    private lateinit var editTitleView: EditText
    private lateinit var editContextView: EditText
    private lateinit var editTimeExpectedView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        editTitleView = findViewById(R.id.edit_title)
        editContextView = findViewById(R.id.edit_context)
        editTimeExpectedView = findViewById(R.id.edit_time_expected)


        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener{
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editTitleView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val title = editTitleView.text.toString()
                val context = editContextView.text.toString()
                val timeExpected = editTimeExpectedView.text.toString()
                replyIntent.putExtra(EXTRA_TITLE, title)
                replyIntent.putExtra(EXTRA_CONTEXT, context)
                replyIntent.putExtra(EXTRA_TIME, timeExpected)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_TITLE = "com.example.android.wordlistsql.TITLE"
        const val EXTRA_CONTEXT = "com.example.android.wordlistsql.CONTEXT"
        const val EXTRA_TIME = "com.example.android.wordlistsql.TIME"

    }
}
