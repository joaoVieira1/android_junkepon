package br.edu.ifsp.dmo1.pedratesourapapel.view

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.pedratesourapapel.R
import br.edu.ifsp.dmo1.pedratesourapapel.databinding.ActivityBossBinding
import br.edu.ifsp.dmo1.pedratesourapapel.databinding.ActivityMainBinding

class BossActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBossBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBossBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configToolBar()
        configSpinner()
        configListener()
    }

    private fun configToolBar(){
        supportActionBar?.hide()
    }

    private fun configListener() {
        binding.buttonStartBoss.setOnClickListener { startGame() }
    }

    private fun configSpinner(){
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.tipo_jogos)
        )

        binding.spinnerButtlesBoss.adapter = adapter
    }

    private fun startGame() {
        val battles: Int = when (binding.spinnerButtlesBoss.selectedItemPosition) {
            0 -> 1
            1 -> 3
            else -> 5
        }
        val mIntent = Intent(this, BossWarActivity::class.java)

        mIntent.putExtra(Constants.KEY_PLAYER_1,
            binding.edittextPlayer1Boss.text.toString())

        mIntent.putExtra(Constants.KEY_PLAYER_2,
            getString(R.string.boss))

        mIntent.putExtra(Constants.KEY_ROUNDS, battles)

        startActivity(mIntent)
    }

}