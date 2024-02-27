package br.com.unicuritiba.algoritmos;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        String diretorioInicial = "/Users/viniciusstencel";
        String[] extensoes = {"execucao-aula-teste.exe","execucao-aula.exe","script-aula-teste.bat","script-aula.bat"};

        buscarArquivos(diretorioInicial, extensoes);
    }

    public static void buscarArquivos(String diretorio, String[] extensoes) {
        Queue<File> fila = new LinkedList<>(); //Cria a fila
        fila.add(new File(diretorio));
        int index = 0;			//Váriavel de controle (Parar a execução do código quando encontra o número de arquivos desejados)
        
        
        while (index < extensoes.length) {
            File dir = fila.poll();			// pega o primeiro elemento da fila e armazena na variavel dir para iterar o código
            File[] arquivos = dir.listFiles();

            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    if (arquivo.isDirectory()) {
                        fila.add(arquivo);
                    } else {
                        for (String extensao : extensoes) {
                            if (arquivo.getName().endsWith(extensao)) {
                                System.out.println("Arquivo encontrado: " + arquivo.getAbsolutePath());
                                index++;
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Busca de arquivos concluída.");
    }
}