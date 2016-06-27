package com.jose;

import net.sourceforge.jFuzzyLogic.FIS;
import org.antlr.runtime.RecognitionException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) {
        try {
            FIS fis;

            File arquivo = new File(Main.class.getResource("controlador_marcha.txt").toURI());

            String conteudo = new String(Files.readAllBytes(arquivo.toPath()));
            fis = FIS.createFromString(conteudo, true);

            System.out.println("...\nArquivo carregado com sucesso!\n...\n");

            fis.setVariable("aceleracao_motorista", 40.0);
            fis.setVariable("inclinacao_solo", 1);

            fis.evaluate();

            double velocidadeCarro = fis.getVariable("velocidade_carro").getValue();

            System.out.println("A velocidade do veiculo eh de " + velocidadeCarro + " km/h");
        } catch (URISyntaxException | IOException | RecognitionException e) {
            e.printStackTrace();
        }
    }
}
