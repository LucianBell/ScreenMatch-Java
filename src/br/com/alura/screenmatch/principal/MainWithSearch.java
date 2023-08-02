package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.model.Title;
import br.com.alura.screenmatch.model.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        var busca = leitura.nextLine();

        String adress = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=7ef332a9";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(adress))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String json = response.body();

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TitleOmdb meuTituloOmdb = gson.fromJson(json, TitleOmdb.class);
            //System.out.println("Nome do titulo: " + meuTituloOmdb.getName());
            System.out.println(meuTituloOmdb);
            Title meuTitulo = new Title(meuTituloOmdb);
            System.out.println("Titulo já convertido");
            System.out.println(meuTitulo);

            FileWriter escrita = new FileWriter("filmes.txt");
            escrita.write(meuTitulo.toString());
            escrita.close();
        } catch (NumberFormatException e) {
            System.out.println("Error:");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Argument error:");
            System.out.println(e.getMessage());
        } catch (ErroDeConversaoDeAnoException e) {
            System.out.println("Error:");
            System.out.println(e.getMessage());
        }

        System.out.println("O programa finalizou corretamente");
    }
}
