package za.ac.iie.cybermonk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlashCardQuestion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flash_card_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    //declarations
        val tvFlashcards = findViewById<TextView>(R.id.tvFlashcards)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val tvAnswers = findViewById<TextView>(R.id.tvAnswers)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnCheckScore = findViewById<Button>(R.id.btnCheckScore)

        // arrays declarations
        val flashcards = arrayOf<String>(
            "Charging your phone overnight will damage the battery.",
            "More signal0 bars mean faster internet speed.",
            "Incognito mode makes you completely anonymous online.",
            "Lowering screen brightness helps save battery.",
            "Using a password manager improves your online security.",
            "Turning on two-factor authentication (2FA) makes your accounts more secure."
        )
        val answers = arrayOf<Boolean>(false, false, false,true,true,true)
        val explanations = arrayOf<String>(
            "False! Modern smartphones stop charging once they reach 100%. While keeping it plugged in all night isn’t perfect long-term, it doesn’t immediately damage your battery.",
            "False! Signal bars show connection strength, not speed. Your internet speed also depends on network congestion, bandwidth, and your service provider.",
            "False! Incognito mode only hides your browsing history from your device. Websites, internet providers, and trackers can still see your activity.",
            "True! The screen is one of the biggest battery consumers. Reducing brightness or using auto-brightness can significantly extend battery life.",
            "True! Password managers help create and store strong, unique passwords, reducing the risk of hacking due to weak or reused passwords.",
            "True! 2FA adds an extra layer of protection by requiring a second verification step, making it much harder for attackers to access your accounts.",
        )

        // while loop for review description
        var reviewText = ""
        var counter = 0 // outside controller
        while (counter < flashcards.count()) {
            reviewText += "Q${counter + 1}: ${flashcards[counter]}\n"
            reviewText += "${explanations[counter]}\n\n"
            counter++ // inside controller
        }
        /*IIE, 2026. Intoduction to Mobile Application and Development
        (Version 2.0) [Source code].
        Available at:
        <https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BCA5A47EE-F107-44AD-AB60-6E296E0B3EAE%7D&file=IMAD5112MM.docx&action=default&mobileredirect=true>
        [Accessed 21 April 2026].
         */

        // the quiz logic
        var currentIndex = 0 // index initialization
        var score = 0 //score initialization

        //question 1
        tvFlashcards.text = flashcards[currentIndex]

        //question 1 logic
        btnTrue.setOnClickListener {
            if(tvFlashcards.text.toString() == flashcards[currentIndex]){
                if (answers[currentIndex] == true){
                    tvAnswers.text = "Correct! \nThats a real time-saver!"
                    score ++
                } else if (answers[currentIndex] == false){
                    tvAnswers.text = "Wrong! \nThats just an urban myth."
                }
            }}
        btnFalse.setOnClickListener {
            if(tvFlashcards.text.toString() == flashcards[currentIndex]){
                if (answers[currentIndex] == true){
                    tvAnswers.text = "Wrong! \nThats just an urban myth."
                } else if (answers[currentIndex] == false){
                    tvAnswers.text = "Correct! \nThats a real time-saver!"
                    score ++ //score counter
                }
            }}

        //question 2 and 3 logic
        btnNext.setOnClickListener {
            currentIndex++ //the current index incremetion.
            tvFlashcards.text = flashcards[currentIndex]

            // same logic as for question 1
            btnTrue.setOnClickListener {
                if(tvFlashcards.text.toString() == flashcards[currentIndex]){
                    if (answers[currentIndex] == true){
                        tvAnswers.text = "Correct! \nThats a real time-saver!"
                        score ++
                    } else if (answers[currentIndex] == false){
                        tvAnswers.text = "Wrong! \nThats just an urban myth."
                    }
                }}
            btnFalse.setOnClickListener {
                if(tvFlashcards.text.toString() == flashcards[currentIndex]){
                    if (answers[currentIndex] == true){
                        tvAnswers.text = "Wrong! \nThats just an urban myth."
                    } else if (answers[currentIndex] == false){
                        tvAnswers.text = "Correct! \nThats a real time-saver!"
                        score ++
                    } }}
        }

        //NEXT PAGE BUTTON
        btnCheckScore.setOnClickListener {
            val ScreenScore = Intent(this, Score::class.java)
            ScreenScore.putExtra("review", reviewText)
            ScreenScore.putExtra("scores", score)
            startActivity(ScreenScore)
        }


    }
}