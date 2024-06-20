import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class ScoreProcessor {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://liveexample.pearsoncmg.com/data/Scores.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            double totalScore = 0;
            int count = 0;

            while ((inputLine = in.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(inputLine);
                while (st.hasMoreTokens()) {
                    String scoreStr = st.nextToken();
                    try {
                        double score = Double.parseDouble(scoreStr);
                        totalScore += score;
                        count++;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Skipping invalid score: " + scoreStr);
                    }
                }
            }
            in.close();
            
            double averageScore = totalScore / count;
            System.out.println("Total Score: " + totalScore);
            System.out.println("Average Score: " + averageScore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
