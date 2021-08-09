/*
    Mohamed Sabry.
*/

import java.util.*;
import java.io.*;
public class movie_game {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("movies.txt");
        Scanner in = new Scanner(System.in);
        String movie = pick_random_movie(f);

        String dash = movieNameDashed(movie);
        System.out.println("You are guessing:" + dash);

        int wrong = 0;
        int dash_length = movie.replaceAll(" ", "").length();
        boolean win = false;

        while (true){
            // if the player guessed 10 times wrong then GAME OVER.
            if(wrong == 10){
                break;
            }
            System.out.printf("You have guessed (%d) wrong letters:\n", wrong);
            System.out.print("Guess a letter:");
            String c = in.next();
            boolean found = false;

            for (int i = 0; i < movie.length(); i++){
                if(movie.charAt(i) == c.charAt(0)){
                    dash = dash.substring(0, i) + c.charAt(0) + dash.substring(i+1);
                    dash_length--;
                    found = true;
                }
            }
            if (!found){
                wrong++;
            }
            if(dash_length == 0){
                win = true;
                System.out.println("YOU WIN!");
                System.out.println("You have guessed '" + movie + "' correctly.");
                break;
            }
            System.out.println("You are guessing:" + dash);
        }
        if(!win){
            System.out.println("Game Over! .... You Lose.");
        }
    }
    /*
        this movie pick a random movie by generate a random number then access the movie in
        this random index then return it.
     */
    public static String pick_random_movie(File f) throws FileNotFoundException{
        Scanner in = new Scanner(f);
        String res = "";
        int rand = (int) (Math.random() * 25);
        while (rand >= 0){
            res = in.nextLine();
            rand--;
        }
        return res;
    }
    // method takes the movie name and then return it dashed.
    public static String movieNameDashed(String movie){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < movie.length(); i++){
            res.append('_');
        }
        return res.toString();
    }

}
