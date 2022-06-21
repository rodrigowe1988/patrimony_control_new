package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import application.entities.Investment;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("0.00");

        List<Investment> list = new ArrayList<>();

        String path = "../teste_de_saida_investimentos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String itemCsv = br.readLine();
            while (itemCsv != null) {

                String[] fields = itemCsv.split(",");
                Date date = format.parse(fields[0]);
                double price = Double.parseDouble(fields[1]);

                list.add(new Investment(date, price));

                itemCsv = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        Double firstValue = list.get(0).getCash();
        Double penultimate = list.get(list.size() - 2).getCash();
        Double lastValue = list.get(list.size() - 1).getCash();

        System.out.println("Variação desde o início:  " + df.format(((lastValue * 100 / firstValue) / 100 - 1) * 100));
        System.out.println("Variação das duas últimas " + df.format(((lastValue * 100 / penultimate) / 100 - 1) * 100));
    }
}