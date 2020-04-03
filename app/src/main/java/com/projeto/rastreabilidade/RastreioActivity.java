package com.projeto.rastreabilidade;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.projeto.rastreabilidade.contracts.Inicializacao;
import com.projeto.rastreabilidade.contracts.Insercao;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class RastreioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rastreio);

        Intent intent = getIntent();
        final int idProd = intent.getIntExtra("idProd", 0);

        TextView txProd = findViewById(R.id.txProd);
        TextView txShowResult = findViewById(R.id.txRastreio);

        Web3j web3j = Web3j.build(new HttpService("http://192.168.100.7:8545/"));  // defaults to http://localhost:8545/

        Credentials credentials = Credentials.create("BA89EEA172D4A6907DC5A8B7932C5A34F179814AABC57537F35E7F6171F980EB", "0x8C316905E99Eb9e996D45BEDd5b7581D7f850DDA");

        ContractGasProvider contractGasProvider = new DefaultGasProvider();

        TransactionManager transactionManager = new RawTransactionManager(web3j, credentials);

        Inicializacao contratoInicializacao = Inicializacao.load("0xD3Ef9C18Ee6376005B8F99eAD23AC2053165906f", web3j, transactionManager, contractGasProvider);

        Insercao contratoInsercao = Insercao.load("0x0f3C439cae3cbcD69a2729BCF4b71D89846A431F", web3j, transactionManager, contractGasProvider);

        Tuple5<List<String>, List<String>, List<String>, List<String>, List<String>> retorno = null;

        BigInteger quant = null;
        try {
            quant = contratoInicializacao.quantidadeUsuarios().send();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int v = idProd % 10;
        if(v == 0) v = 10;

        String resultado= "";
        try {
            retorno = contratoInsercao.rastreioProd(String.valueOf(idProd), BigInteger.valueOf(v)).send();
            System.out.println("HEY "+retorno.component1().get(1));
            for(int i = 1; i <= v; i++) {
                if(retorno.component1().get(1).equals("")) break;
                resultado = resultado.concat("Hash das Informações: " + retorno.component1().get(i) + "\n" +
                       "Dia: " + retorno.component2().get(i) + "\n" +
                       "Horário: " + retorno.component3().get(i) + "\n"+
                       "Local: " + retorno.component4().get(i) + "\n" +
                       "Endereço Sensor: " + retorno.component5().get(i) + "\n\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(resultado.equals("")) {
            String titulo = "Código Inválido";
            txProd.setText(titulo);

            txShowResult.setVisibility(View.GONE);
        } else {
            String titulo = "Produto " + idProd;
            txProd.setText(titulo);

            txShowResult.setText(resultado);
        }

    }
}
