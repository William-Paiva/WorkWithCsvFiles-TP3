package br.edu.univas.vo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class WorkOnCsvFile {

    public void readCsv(File CSV_FILE){

        Scanner readFile = null;
        try{
            readFile = new Scanner(CSV_FILE);
            while(readFile.hasNextLine()){
                String line = readFile.nextLine();
                String[] splitStrings = line.split(",");
                for (int i = 0, j = 1; i < splitStrings.length; i++, j++){
                    System.out.println(j +". " + splitStrings[i]);
                }
            }
            System.out.println("\n9. Exit");
        }catch(IOException e){
            System.out.println("File not found!!!");
        }
    }

    public static String returnSubject(File CSV_FILE, int option){

        Scanner readFile = null;
        try{
            readFile = new Scanner(CSV_FILE);
            while(readFile.hasNextLine()){
                String line = readFile.nextLine();
                String[] splitStrings = line.split(",");
                return splitStrings[option - 1];
            }
        }catch(IOException e){
            System.out.println("File not found!!!");
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

    public static void saveRollCall(String subject, List<String> names, File CSV_FILE){

        Date date = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("_dd_MM_yyyy");
        String fileCsvName = CSV_FILE.getName();
        String path = CSV_FILE.getPath();
        path = path.replaceAll(fileCsvName, "");
        String formatDate = simpleDate.format(date);
        String fileName = path + subject.toLowerCase() + formatDate + ".txt";

        try(BufferedWriter saveRollCall = new BufferedWriter(new FileWriter(fileName))){
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

