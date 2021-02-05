package br.com.cmendes.pingpongx

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PlayerActivity : AppCompatActivity() {

    companion object{
        val KEY_EXTRA_PLAYER_ONE = "PLAYER1"
        val KEY_EXTRA_PLAYER_TWO = "PLAYER2"
        val REQUEST_CODE_GAME = 1
    }

    private lateinit var  etPlayer1: EditText
    private lateinit var  etPlayer2: EditText
    private lateinit var  btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        setUpView()
        btnStart.setOnClickListener{
            val nextScreen = Intent(this, MainActivity::class.java)

            //Passando os parametros via intent para próxima tela
            nextScreen.putExtra(KEY_EXTRA_PLAYER_ONE, etPlayer1.text.toString())
            nextScreen.putExtra(KEY_EXTRA_PLAYER_TWO, etPlayer2.text.toString())

            //startActivity(nextScreen)
            startActivityForResult(nextScreen,REQUEST_CODE_GAME)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            REQUEST_CODE_GAME-> {
                if(resultCode == Activity.RESULT_OK){
                    clearFields()
                }
            }
        }
    }

    fun clearFields(){
        etPlayer1.setText("")
        etPlayer2.setText("")
    }
    private fun setUpView() {
        etPlayer1 = findViewById(R.id.etPlayer1)
        etPlayer2 = findViewById(R.id.etPlayer2)

        btnStart = findViewById(R.id.btnStart)
    }
}