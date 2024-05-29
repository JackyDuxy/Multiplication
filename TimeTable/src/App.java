import java.io.*;
import java.util.*;



public class App {
    //generating questions
    public static String questionsGenerator(){
        Random numGenerator = new Random();
        int numA = numGenerator.nextInt(1,20);
        int numB = numGenerator.nextInt(1,20);
        // System.out.println(numA);
        // System.out.println(numB);
        String result = String.valueOf(numA)+"*"+String.valueOf(numB);
        int answer = numA*numB;
        // System.out.println(result);
        return ((result)+"|"+(answer));

}

public static String sync_user_info (){
    String filename = "/Users/jackyduxy/Desktop/Code/Java/TimeTable/src/userScore.txt";
    String line = null;
    String returnString = "";
    try{
         //synch user info with userinfo txt
        FileReader read_info_txt = new FileReader(filename);
        // does the sync user info method need any outside information to preform this said task
        BufferedReader bufferedReader = new BufferedReader(read_info_txt);
        

        // System.out.println("SYNCH USER INFO DEBUG");
        line = bufferedReader.readLine();
        returnString = line;
        // System.out.println(line);

        while(line != null){
            line = bufferedReader.readLine();
        }
        // System.out.println("Data type: " + line.getClass().getName());
        // System.out.println("Data type: " + returnString.getClass().getName());
        bufferedReader.close();
        // System.out.println("return String is right here: "+returnString);
        return returnString;

        }
    catch(FileNotFoundException ex) {
        System.out.println("file not found");
        return "unexpected";
    }
    catch(IOException ex) {
        System.out.println("io exception");
        return "unexpected";
    }
};

// public static int funcAddpoint(){
//     int returnpoint = 0;
//     String myStr = questionsGenerator();
//     String regex = "[|]";
//     String[] myArray = myStr.split(regex);
//     String answer = "";
//     String question = "";
//     int i = 0;
//     for (String s : myArray) {
//         // System.out.println(s);
//         if (i<1){
//             question = s;
//         }
//         else{
//             answer = s;
//         }
//         i++;
//     }
//     System.out.println("answer: "+answer);
//     System.out.println("answer length"+answer.length());
//     for (int x=0;x<answer.length();x++){
//         returnpoint++;
//     }
//     System.out.println("point will be returned"+returnpoint);
//     return 1;
// }

public static void updatetxt(int score){
    String filename = "/Users/jackyduxy/Desktop/Code/Java/TimeTable/src/userScore.txt";
    String newText = String.valueOf(score); // aka score
    String oldtext = sync_user_info();
    // System.out.println(oldtext);
    try{
        
        //synch user info with userinfo txt
        FileWriter write_info_txt = new FileWriter(filename , true);
        // does the sync user info method need any outside information to preform this said task
        BufferedWriter bufferedWriter = new BufferedWriter(write_info_txt);
        bufferedWriter.newLine();
        bufferedWriter.write(newText);

        bufferedWriter.close();
    }
    catch(FileNotFoundException ex) {
        System.out.println("file not found");
    }
    catch(IOException ex) {
        System.out.println("io exception");
    }
}

    public static void main(String[] args) throws Exception {
        int score = Integer.parseInt(sync_user_info());
        while (true) {
            Scanner scanner = new Scanner(System.in);

                String myStr = questionsGenerator();
                String regex = "[|]";
                String[] myArray = myStr.split(regex);
                String answer = "";
                String question = "";
                int i = 0;
                for (String s : myArray) {
                    // System.out.println(s);
                    if (i<1){
                        question = s;
                    }
                    else{
                        answer = s;
                    }
                    i++;
                }
                // System.out.println(answer);
                // System.out.println("answer:"+answer);

                    int returnpoint = 0;
                    // System.out.println("answer: "+answer);
                    // System.out.println("answer length"+answer.length());
                    for (int y=0;y<answer.length();y++){
                        returnpoint++;
                    }
                // System.out.println("point will be returned"+returnpoint);
                System.out.println("Answer following question:"+question+"=?");
                String userAnswer = scanner.nextLine();
                if(userAnswer.equals(answer)){
                    score = score + returnpoint;
                    System.out.println("good job! score + "+returnpoint+"! Press 1 to continue, Press 2 to leave and check score.");
                    String leaveOrStay = scanner.nextLine();
                    if(leaveOrStay.equals("1")){
                        continue;
                    }
                    else if(leaveOrStay.equals("2")){
                        System.out.println("Good bye, your score is "+score);
                        updatetxt(score);
                        break;
                    }
                    else{
                        System.out.println("Not understanable");
                        continue;
                    }
                }else{
                    score--;
                    System.out.println("are you using ur brain?");
                    System.out.println("try harder next time");
                    System.out.println("score - 1! Press 1 to continue, Press 2 to leave and check score.");
                    String leaveOrStay = scanner.nextLine();
                    if(leaveOrStay.equals("1")){
                        continue;
                    }
                    else if(leaveOrStay.equals("2")){
                        System.out.println("Good bye, your score is "+score);
                        updatetxt(score);
                        break;
                    }
                    else{
                        System.out.println("Not understanable");
                        continue;
                    }
                }
        }
    }
}
