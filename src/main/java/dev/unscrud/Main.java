package dev.unscrud;

import com.opencsv.bean.CsvToBeanBuilder;
import dev.unscrud.model.Produto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    List<Produto> produtos = new CsvToBeanBuilder(new FileReader("src/main/resources/products.csv"))
            .withType(Produto.class).build().parse();

    produtos.forEach(System.out::println);
  }
}