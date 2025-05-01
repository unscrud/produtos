package dev.unscrud;

import com.opencsv.bean.CsvToBeanBuilder;
import dev.unscrud.model.Produto;
import dev.unscrud.service.TraduzirProdutoService;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    InputStream is = Main.class.getClassLoader().getResourceAsStream("products.csv");
    if (is == null) {
      throw new FileNotFoundException("Arquivo 'products.csv' não encontrado no classpath.");
    }
    InputStreamReader reader = new InputStreamReader(is);

    List<Produto> produtos = new CsvToBeanBuilder(reader).withType(Produto.class).build().parse();

    produtos.forEach(System.out::println);

    TraduzirProdutoService tradutorService = new TraduzirProdutoService();

    produtos.stream()
            .peek(tradutorService::traduzir)
            .forEach(System.out::println);
  }
}