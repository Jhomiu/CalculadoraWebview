package com.example.calculadorakt

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var numero1 = 0.0
    var numero2 = 0.0
    var resultFinal = 0.0
    var operador = -1;
    var letras = ""

    var letraMemoria = ""
    var memoria = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

                webview.webChromeClient = object : WebChromeClient() {

                }
                webview.webViewClient = object : WebViewClient() {

                }
                val settings: WebSettings = webview.settings
                settings.javaScriptEnabled = true
                webview.loadUrl("https://google.com")
            }

    }



    fun borrar(v: View){
        resultFinal= 0.0
        numero1=0.0
        numero2=0.0
        cuentas.setText("")
        resultado.setText("")
    }

    fun memory(v: View){
        when (v.id){
            R.id.memBorrar ->{
                letraMemoria = ""
                memoria = 0.0
            }
            R.id.memSumar ->{
                letraMemoria = resultado.text as String
                memoria =  memoria + letraMemoria.toDouble()
                resultFinal = memoria

            }
            R.id.memMostrar ->{
                resultado.setText("" + memoria)
                resultFinal = memoria
            }
        }
    }

    fun clickNumero(v: View){
        when(v.id){
            R.id.cero -> (cuentas.setText("" + cuentas.text + "0")
                    )
            R.id.uno -> (cuentas.setText("" + cuentas.text + "1")
                    )
            R.id.dos -> (cuentas.setText("" + cuentas.text + "2")
                    )
            R.id.tres -> (cuentas.setText("" + cuentas.text + "3")
                    )
            R.id.cuatro -> (cuentas.setText("" + cuentas.text + "4")
                    )
            R.id.cinco -> (cuentas.setText("" + cuentas.text + "5")
                    )
            R.id.seis -> (cuentas.setText("" + cuentas.text + "6")
                    )
            R.id.siete -> (cuentas.setText("" + cuentas.text + "7")
                    )
            R.id.ocho -> (cuentas.setText("" + cuentas.text + "8")
                    )
            R.id.nueve -> (cuentas.setText("" + cuentas.text + "9")
                    )
            R.id.punto -> (cuentas.setText("" + cuentas.text + ".")
                    )
        }

    }

    fun clickOperador(v: View){

        when (v.id){
            R.id.igual ->{
                letras = cuentas.text as String
                if (letras.equals("")){
                    numero2=0.0
                }else{
                    numero2 = letras.toDouble()
                }
                if (operador == -1){

                }
                if (operador == 0){
                    resultFinal = numero1 * numero2
                    resultado.setText("" + resultFinal)
                    operador = -1
                }
                if (operador == 1){
                    resultFinal = numero1 - numero2
                    resultado.setText("" + resultFinal)
                    operador = -1
                }
                if (operador == 2){
                    resultFinal = numero1 + numero2
                    resultado.setText("" + resultFinal)
                    operador = -1
                }
                if (operador == 3){
                    resultFinal = numero1 / numero2
                    resultado.setText("" + resultFinal)
                    operador = -1
                }
                cuentas.setText("")

            }
            R.id.multiplicar -> {
                if (cuentas.text.trim().equals("")) {
                    resultado.setText("" + resultFinal + "*")
                    cuentas.setText("")
                    numero1 = resultFinal
                    operador = 0
                    resultFinal = 0.0
                }else {
                    resultado.setText("" + cuentas.text + " *")
                    letras = cuentas.text as String
                    numero1 = letras.toDouble()

                    cuentas.setText("")
                    operador = 0
                }
            }
            R.id.resta -> {
                if (cuentas.text.trim().equals("")) {
                    resultado.setText("" + resultFinal + "-")
                    cuentas.setText("")
                    numero1 = resultFinal
                    operador = 1
                    resultFinal = 0.0
                } else{
                    resultado.setText("" + cuentas.text + " -")
                    letras = cuentas.text as String
                    numero1 = letras.toDouble()

                    cuentas.setText("")
                    operador = 1
                }
            }
            R.id.suma -> {
                if (cuentas.text.trim().equals("")){
                    resultado.setText("" + resultFinal + "+")
                    cuentas.setText("")
                    numero1 = resultFinal
                    operador = 2
                    resultFinal = 0.0
                }else {
                    resultado.setText("" + cuentas.text + " +")
                    letras = cuentas.text as String
                    numero1 = letras.toDouble()
                    cuentas.setText("")
                    operador = 2
                }

            }
            R.id.dividir -> {
                if (cuentas.text.trim().equals("")) {
                    resultado.setText("" + resultFinal + "/")
                    cuentas.setText("")
                    numero1 = resultFinal
                    operador = 3
                    resultFinal = 0.0
                }else {
                    resultado.setText("" + cuentas.text + " /")
                    letras = cuentas.text as String
                    numero1 = letras.toDouble()

                    cuentas.setText("")
                    operador = 3
                }
            }

        }
    }
}


