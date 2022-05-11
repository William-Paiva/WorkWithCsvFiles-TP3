package br.edu.univas.vo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class WorkOnCsvFile {

    public static void readCsv(){

        File CSV_FILE = new File("C:\\CSV\\Subjects.csv");
        Scanner scanner = null;
        try{
            scanner = new Scanner(CSV_FILE);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] splitStrings = line.split(",");
                for (int i = 0; i < 5;  i++){
                    System.out.println(splitStrings[i]);
                }
            }
        }catch(IOException e){
            System.out.println("File not found!!!");
        }
    }

    public static String chooseOption(int option){

        if(option == 1){
            return "History";
        }else if(option == 2){
            return "Portuguese";
        }else if(option == 3){
            return "English";
        }
        return null;
    }

    public static List<String> makingRollCall(Scanner scanner) {

        List<String> names = new ArrayList<>();
        int option = 1;
        System.out.println("Enter the students name: ");
        names.add(scanner.nextLine());
        do{
            System.out.println("Do you wanna add more names?");
            System.out.println("1. Yes\n2. No");
            option = scanner.nextInt(); scanner.nextLine();
            if(option == 1){
                System.out.println("Enter the students name: ");
                names.add(scanner.nextLine());
            }else{
                System.out.println("Ok! The End!");
                option++;
            }
        }while(option == 1);

        return names;
    }

    public static void saveRollCall(String subject, List<String> names){

        Date date = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("_dd_MM_yyyy");
        String formatDate = simpleDate.format(date);
        String fileName = subject.toLowerCase() + formatDate + ".csv";

        try(BufferedWriter saveRollCall = new BufferedWriter(
                new FileWriter("C:\\CSV\\"+ fileName))){

            for(int i=0; i<names.size(); i++){
                saveRollCall.write(names.get(i));
                saveRollCall.newLine();
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
