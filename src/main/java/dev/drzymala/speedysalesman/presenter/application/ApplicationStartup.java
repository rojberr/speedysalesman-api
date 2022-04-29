package dev.drzymala.speedysalesman.presenter.application;

import dev.drzymala.speedysalesman.algorithm.domain.city.City;
import dev.drzymala.speedysalesman.pathfinder.application.port.SpeedyServiceUseCase;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Slf4j
@Component
@AllArgsConstructor
public class ApplicationStartup implements CommandLineRunner {

    SpeedyServiceUseCase speedyService;

    @Override
    public void run(String... args) {

        if (!promptConsoleUse()) return;
        generateFile();
    }

    private boolean promptConsoleUse() {

        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.printf("\n\nDo you want to use the console? yes / no \n");
            String yesOrNo = reader.nextLine();
            if ("no".equalsIgnoreCase(yesOrNo)) return false;
            if ("yes".equalsIgnoreCase(yesOrNo)) return true;
        }
    }

    @SneakyThrows
    private void generateFile() {

        Scanner reader = new Scanner(System.in);
        System.out.println("\n How big file would you like to generate? ");
        int size = reader.nextInt();

        List<City> list = speedyService.generate(size);

        Writer writer = new Writer();
        writer.write(list);
    }
}


//    private void scanFile() {
//
//        Scanner reader = new Scanner(System.in);
//        System.out.println("\n Which file would you like to scan?");
//        String filename = reader.nextLine();
////        FileReader fileReader = new FileReader();
////        fileReader.readFile(filename);
//        try {
//            Path path = Path.of(filename);
//            String input = Files.readString(path);
//            FindPathResponse result = speedyService.findPath(input);
//            result.toString();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//
//
//    FILE READER
//
//	package dev.drzymala.speedysalesman.fileoperators;
//
//            import java.io.File;
//            import java.io.FileNotFoundException;
//            import java.util.Scanner;
//
//public class FileReader {
//
//    public String readFile(String filename) {
//        String output = "";
//        try {
//            File myObj = new File(filename);
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                System.out.println(data);
//                output = output + data;
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//        return output;
//    }
//}
//
//
//	WRITER
//
//            package dev.drzymala.speedysalesman.fileoperators;
//
//            import java.io.BufferedWriter;
//            import java.io.FileWriter;
//            import java.io.IOException;
//
//public class Writer {
//
//    public void write(String input)
//            throws IOException {
//
//        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
//        writer.write(input);
//        writer.close();
//    }
//}
