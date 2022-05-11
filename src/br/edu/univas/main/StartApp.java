package br.edu.univas.main;

import br.edu.univas.vo.WorkOnCsvFile;

import java.util.List;
import java.util.Scanner;

public class StartApp {

    public void start(){

        WorkOnCsvFile csv = new WorkOnCsvFile();
        int count = 0;
        while(count == 0){
            Scanner scanner = new Scanner(System.in);
            int option;
            System.out.println("\nChoose one Subject below:\n");
            csv.readCsv();
            option = scanner.nextInt(); scanner.nextLine();
            if(option == 9){
                System.out.println("Exiting...Thank You!!!");
                count++;
            }else{
                String subject = csv.chooseOption(option);
                List<String> rollCall = csv.makingRollCall(scanner);
                csv.saveRollCall(subject, rollCall);
            }
        }

    }
}
