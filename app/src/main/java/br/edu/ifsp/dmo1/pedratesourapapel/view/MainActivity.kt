package br.edu.ifsp.dmo1.pedratesourapapel.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.pedratesourapapel.R
import br.edu.ifsp.dmo1.pedratesourapapel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configToolBar()
        configSpinner()
        configListener()
    }

    private fun configToolBar(){
        supportActionBar?.hide()
    }

    private fun configListener() {
        binding.buttonStart.setOnClickListener { startGame() }
        binding.buttonPlayWithBoss.setOnClickListener{startGameWithBoss()}
    }

    private fun configSpinner(){
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.tipo_jogos)
        )

        binding.spinnerButtles.adapter = adapter
    }

    private fun startGame() {
        val battles: Int = when (binding.spinnerButtles.selectedItemPosition) {
            0 -> 1
            1 -> 3
            else -> 5
        }
        val mIntent = Intent(this, WarActivity::class.java)

        mIntent.putExtra(Constants.KEY_PLAYER_1,
            binding.edittextPlayer1.text.toString())

        mIntent.putExtra(Constants.KEY_PLAYER_2,
            binding.edittextPlayer2.text.toString())

        mIntent.putExtra(Constants.KEY_ROUNDS, battles)

        startActivity(mIntent)

    }

    private fun startGameWithBoss(){
        val mIntent = Intent(this, BossActivity::class.java)

        startActivity(mIntent)
    }

}
