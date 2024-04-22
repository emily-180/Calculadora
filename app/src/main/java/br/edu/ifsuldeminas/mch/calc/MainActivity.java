package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ifsuldeminas.mch.calc";
    private TextView textViewResultado;
    private TextView textViewUltimaExpressao;
    private String expressaoNumerica = "";
    private boolean fimDaConta = false;
    private Double resultado = 0.0;
    
    private Button buttonUm, buttonDois, buttonTres, buttonQuatro, buttonCinco,
            buttonSeis, buttonSete, buttonOito, buttonNove, buttonZero;
    private Button buttonVirgula, buttonSoma, buttonSubtracao, buttonIgual, buttonReset,
            buttonPorcentagem, buttonMultiplicacao, buttonDivisao,  buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonZero = findViewById(R.id.buttonZeroID);
        buttonUm = findViewById(R.id.buttonUmID);
        buttonDois = findViewById(R.id.buttonDoisID);
        buttonTres = findViewById(R.id.buttonTresID);
        buttonQuatro = findViewById(R.id.buttonQuatroID);
        buttonCinco = findViewById(R.id.buttonCincoID);
        buttonSeis = findViewById(R.id.buttonSeisID);
        buttonSete = findViewById(R.id.buttonSeteID);
        buttonOito = findViewById(R.id.buttonOitoID);
        buttonNove = findViewById(R.id.buttonNoveID);
        buttonVirgula = findViewById(R.id.buttonVirgulaID);
        buttonSoma = findViewById(R.id.buttonSomaID);
        buttonSubtracao = findViewById(R.id.buttonSubtracaoID);
        buttonPorcentagem = findViewById(R.id.buttonPorcentoID);
        buttonMultiplicacao = findViewById(R.id.buttonMultiplicacaoID);
        buttonDivisao = findViewById(R.id.buttonDivisaoID);
        buttonReset = findViewById(R.id.buttonResetID);
        buttonDelete = findViewById(R.id.buttonDeleteID);
        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

        //numeros
        buttonUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("1");
            }
        });

        buttonDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("2");
            }
        });

        buttonTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("3");
            }
        });

        buttonQuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("4");
            }
        });

        buttonCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("5");
            }
        });

        buttonSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("6");
            }
        });

        buttonSete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("7");
            }
        });

        buttonOito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("8");
            }
        });

        buttonNove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("9");
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("0");
            }
        });

        //operadores
        buttonSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimDaConta = false;
                expressaoNumerica = textViewUltimaExpressao.getText().toString();
                if (!expressaoNumerica.isEmpty()) {
                    char ultimoCaractere = expressaoNumerica.charAt(expressaoNumerica.length() - 1);
                    if (!isOperador(ultimoCaractere)) { //caso seja numero coloca mais
                        textViewUltimaExpressao.setText(expressaoNumerica + "+");
                    } else { // caso ja tinha digitado operador, troca para +
                        textViewUltimaExpressao.setText(expressaoNumerica.substring(0, expressaoNumerica.length() - 1) + "+");
                    }
                }
            }
        });

        buttonSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimDaConta = false;
                expressaoNumerica = textViewUltimaExpressao.getText().toString();
                if (expressaoNumerica.isEmpty()) {
                    textViewUltimaExpressao.setText("-");
                } else {
                    char ultimoCaractere = expressaoNumerica.charAt(expressaoNumerica.length() - 1);
                    if (ultimoCaractere != '-') {
                        textViewUltimaExpressao.append("-");
                    }
                }
            }
        });

        buttonMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimDaConta = false;
                expressaoNumerica = textViewUltimaExpressao.getText().toString();
                if (!expressaoNumerica.isEmpty()) {
                    char ultimoCaractere = expressaoNumerica.charAt(expressaoNumerica.length() - 1);
                    if (!isOperador(ultimoCaractere)) {
                        textViewUltimaExpressao.setText(expressaoNumerica + "*");
                    } else {
                        textViewUltimaExpressao.setText(expressaoNumerica.substring(0, expressaoNumerica.length() - 1) + "*");
                    }
                }
            }
        });

        buttonDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimDaConta = false;
                expressaoNumerica = textViewUltimaExpressao.getText().toString();
                if (!expressaoNumerica.isEmpty()) {
                    char ultimoCaractere = expressaoNumerica.charAt(expressaoNumerica.length() - 1);
                    if (!isOperador(ultimoCaractere)) {
                        textViewUltimaExpressao.setText(expressaoNumerica + "/");
                    } else {
                        textViewUltimaExpressao.setText(expressaoNumerica.substring(0, expressaoNumerica.length() - 1) + "/");
                    }
                }
            }
        });

        buttonPorcentagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimDaConta = false;
                expressaoNumerica = textViewUltimaExpressao.getText().toString();
                if (!expressaoNumerica.isEmpty()) {
                    char ultimoCaractere = expressaoNumerica.charAt(expressaoNumerica.length() - 1);
                    if (!isOperador(ultimoCaractere)) {
                        textViewUltimaExpressao.setText(expressaoNumerica + "%");
                    } else {
                        textViewUltimaExpressao.setText(expressaoNumerica.substring(0, expressaoNumerica.length() - 1) + "%");
                    }
                }
            }
        });

        buttonVirgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimDaConta = false;
                expressaoNumerica = textViewUltimaExpressao.getText().toString();
                if (!expressaoNumerica.isEmpty() && Character.isDigit(expressaoNumerica.charAt(expressaoNumerica.length() - 1))) {
                    String[] numeros = expressaoNumerica.split("[+\\-*/]");
                    String ultimoNumero = numeros[numeros.length - 1];
                    if (!ultimoNumero.contains(".")) {
                        textViewUltimaExpressao.append(".");
                    }
                }
            }
        });

        //botao para resetar
        buttonReset = findViewById(R.id.buttonResetID);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimDaConta = false;
                textViewUltimaExpressao.setText("");
                textViewResultado.setText("");
                resultado = 0.0;
                textViewResultado.setText("0.0");
            }
        });

        //botao para apagar  por caracter
        buttonDelete = findViewById(R.id.buttonDeleteID);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimDaConta = false;
                resultado = 0.0;
                expressaoNumerica = textViewUltimaExpressao.getText().toString();
                if (expressaoNumerica.length() > 0) {
                    expressaoNumerica = expressaoNumerica.substring(0, expressaoNumerica.length() - 1);
                    textViewUltimaExpressao.setText(expressaoNumerica);
                }
            }
        });

        //botão para calcular resultado
        buttonIgual = findViewById(R.id.buttonIgualID);
        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculable avaliadorExpressao = null;
                fimDaConta = true;
                try {
                    String expressao = textViewUltimaExpressao.getText().toString();
                    if(isUltimoCaractereOperador(expressao)){
                        expressao = expressao.substring(0, expressao.length() - 1);
                        expressaoNumerica = expressao.substring(0, expressao.length() - 1);
                    }
                    avaliadorExpressao = new ExpressionBuilder(expressao).build();
                    resultado = avaliadorExpressao.calculate();
                    textViewResultado.setText(String.format("%.8s", resultado.toString()));
                } catch (Exception e) {
                    Log.e(TAG, getResources().getString(R.string.menssagem_erro) + expressaoNumerica, e);

                    textViewResultado.setText(getResources().getString(R.string.menssagem_erro));
                }
            }
        });

    }
    private boolean isUltimoCaractereOperador(String expressao) {
        String ultimoCaractere = expressao.substring(expressao.length() - 1);
        return ultimoCaractere.equals("+") || ultimoCaractere.equals("-") || ultimoCaractere.equals("*") || ultimoCaractere.equals("/") || ultimoCaractere.equals("%");
    }

    private boolean isOperador(char caractere) {
        return caractere == '+' || caractere == '-' || caractere == '*' || caractere == '/';
    }

}