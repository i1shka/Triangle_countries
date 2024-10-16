import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        входные данные
        Scanner scan = new Scanner(new File("input.txt"));
        double cityX = scan.nextDouble();
        double cityY = scan.nextDouble();
        int kol = scan.nextInt();
        ArrayList<Integer> results = new ArrayList<>();  //создаем ArrayList для сохранения результатов
        double[][] trArr = new double[kol][6];
        for (int i = 0; i < trArr.length; i++) {
            for (int j = 0; j < trArr[i].length; j++) {
                trArr[i][j] = scan.nextDouble();
            }

//        вычисляем площадь страны
            double trArea = Math.round(new Triangle(trArr[i]).area() * 100) / 100.0;

//        создаем новые треугольники с вершиной в точке city
            double areaWithCity = trianglesWithCity(cityX, cityY, trArr[i]);

//        сравниваем площадь страны и суммы площадей треугольников с вершиной в city
            areaComparison(areaWithCity, trArea, results);
        }

//        вывод результатов
        writing(results);
    }

    private static double trianglesWithCity(double cityX, double cityY, double[] trArr) {
        double areaWithCity = 0;
        for (int i = 0; i < 6; i += 2) {
            double[] newTr = trArr.clone();
            newTr[i] = cityX;
            newTr[i + 1] = cityY;
            if (new Triangle(newTr).area() == 0) return 0;    // если площадь нового треугольника 0, возвращаем 0
            areaWithCity += new Triangle(newTr).area();
        }
        areaWithCity = Math.round(areaWithCity * 100) / 100.0;
        return areaWithCity;
    }

    private static void areaComparison(double areaWithCity, double trArea, ArrayList<Integer> results) {
        int s = (areaWithCity == trArea) ? results.size() + 1 : 0;
        results.add(s);
    }

    private static void writing(ArrayList<Integer> results) {
        results.remove((Integer) 0);
        if (results.contains(0)) {
            results.clear();
        }
        try {
            FileWriter writer = new FileWriter("output.txt", false);
            writer.write(Integer.toString(results.size()));
            writer.write("\n");
            writer.write(String.valueOf(results));
            writer.close();
            System.out.println("output.txt created");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
