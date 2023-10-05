package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.flow.DEFAULT_CONCURRENCY_PROPERTY_NAME

const val REQUEST_NAME = "Message"
const val DEFAULT_TEXT_SIZE = 1
class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value

    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        textSizeSelectorButton.setOnClickListener { TextSize ->
            val launtchIntent = Intent(this@DisplayActivity, TextSizeActivity::class.java)
            launtchIntent.putExtra(REQUEST_NAME, lyricsDisplayTextView.textSize)
            startActivity(launtchIntent)

        }
        val textSize = intent.getFloatExtra(REQUEST_NAME, DEFAULT_TEXT_SIZE.toFloat())
        lyricsDisplayTextView.textSize = textSize

        val message = intent.getStringExtra("message")
        with(findViewById<TextView>(R.id.textSizeSelectorButton)) {
            val transfer = intent.getIntExtra(REQUEST_NAME, DEFAULT_TEXT_SIZE)
            setTextSize(TypedValue.COMPLEX_UNIT_PX, transfer.toFloat())
        }

    }
}