import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Day1 {
    //rotation of a safe
    static StringBuilder sb = new StringBuilder();
    static BufferedReader input;

    static {
        try {
            input = new BufferedReader(new FileReader("src/day1.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static int number = 50;
    static int count_of_zero = 0;
    static LinkedList<Integer> size_of_safe = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input.mark(0);
        for(int i = 0; i < 100; i++){
            size_of_safe.add(i);
        }

        while(input.ready()){
            String route = input.readLine();
            String side = route.substring(0,1);
            int distance = Integer.parseInt(route.substring(1));
            int indeksCykliczny = distance%100;
            if(side.contains("R")){
                indeksCykliczny = (number + distance) % 100;
                number = size_of_safe.get(indeksCykliczny);

            }else {
                indeksCykliczny = ((number - distance) % 100 + 100) %100;
                number = size_of_safe.get(indeksCykliczny);
            }
            if (number==0){
                count_of_zero++;
            }
        }
        System.out.println(count_of_zero);
    }

}
