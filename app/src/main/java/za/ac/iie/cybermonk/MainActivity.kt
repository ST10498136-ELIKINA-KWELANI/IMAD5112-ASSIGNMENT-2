package za.ac.iie.cybermonk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    // DECLARATIONS
        val tvDescription = findViewById<TextView>(R.id.tvDescription)
        val btnStart = findViewById<Button>(R.id.btnStart)

        tvDescription.text = "Welcome to CyberMonk — your guide to smarter living.\n" +
                "Challenge yourself with flashcards that test real vs fake life hacks.\n" +
                "Sharpen your thinking and discover what actually works."

        // button to the next screen
        btnStart.setOnClickListener {
            val FlashcardQuestionsScreen = Intent(this, FlashCardQuestion::class.java)
            startActivity(FlashcardQuestionsScreen)
        }
    }
}