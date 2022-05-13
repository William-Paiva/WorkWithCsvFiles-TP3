package br.edu.univas.main;

import br.edu.univas.vo.WorkOnCsvFile;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class StartApp {

    public void start(){
        File CSV_FILE = new File(System.getenv("CSV_FILE"));
        WorkOnCsvFile csv = new WorkOnCsvFile();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while(count == 0){
            System.out.println("Choose one subject below:\n ");
            csv.readCsv(CSV_FILE);
            int option = scanner.nextInt(); scanner.nextLine();
            if(option == 9){
                System.out.println("Exiting...Thank You!!!");
                count++;
            }else{
                String subject = csv.returnSubject(CSV_FILE, option);
                List<String> rollCall = csv.makingRollCall(scanner);
                csv.saveRollCall(subject, rollCall, CSV_FILE);
            }
        }

    }
}
