package com.mgtic.dapm.gatov2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var gameEngine:Board = Board()
    lateinit var boardView:BoardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        boardView = findViewById(R.id.board)
        gameEngine = Board()
        boardView.setGameEngine(gameEngine)
        boardView.setMainActivity(this)
        newGame()
    }

    private fun newGame() {
        gameEngine.newGame()
        boardView.invalidate()
       // Toast.makeText(applicationContext,"Turno de X",Toast.LENGTH_SHORT).show()
    }

    fun gameEnded(c: Char) {
        val msg = if (c == 'T') "Juego Terminado. No hubo ganador" else "Juego Terminado. $c ganó"
        AlertDialog.Builder(this).setTitle("Tic Tac Toe").setMessage(msg).setOnDismissListener { newGame() }.show()
    }
}
