package za.ac.iie.cybermonk

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //declarations
        val tvResults = findViewById<TextView>(R.id.tvResults)
        val btnReview = findViewById<Button>(R.id.btnReview)

        // receiving the info from the last page
        val bundle: Bundle? = intent.extras
        val review =bundle?.getString("review")
        val scores =bundle?.getInt("scores")

        //score allocation logic
        var marks = ""
        if (scores == 0 || scores == 1){
            marks = "0 or 1 out of 6: \n Keep practicing! \nSTAY SAFE ONLINE."
        }else if (scores == 2){
            marks = "2 out of 6: \n Keep practicing! \nSTAY SAFE ONLINE."
        }else if (scores == 3){
            marks = "3 out of 6: \n Keep practicing! \nSTAY SAFE ONLINE."
        }else if (scores == 4){
            marks = "4 out of 6: \n Great job! \nMASTER HACKERS!"
        }else if (scores == 5){
            marks = "5 out of 6: \n Great job! \nMASTER HACKER!"
        }else if (scores == 6){
            marks = "6 out of 6: \n Great job! \nMASTER HACKER!"
        }
        tvResults.text = "$marks"



        //review button
        btnReview.setOnClickListener {
            tvResults.text = "$review"
        }


    }
}