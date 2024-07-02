/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package group6quizgame;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Group6quizgame {

    // Questions
    static String q1 = "What is the powerhouse of the cell?";
    static String q2 = "What does \"www\" stand for?";
    static String q3 = "Who painted Mona Lisa?";
    static String q4 = "Who created Facebook?";
    static String q5 = "Who is the first person who stepped on the moon?";
    static String q6 = "What is the largest mammal on Earth?";
    static String q7 = "What is the gravitational acceleration of Earth?";
    static String q8 = "What is the largest planet in the Solar System?";
    static String q9 = "What is the capital of the Philippines?";
    static String q10 = "Who killed Goliath?";
    
    // Array for questions
    static String[] qquiz = {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};

    // Correct answers
    static String a1 = "Mitochondria";
    static String a2 = "World Wide Web";
    static String a3 = "Leonardo Da Vinci";
    static String a4 = "Mark Zuckerberg";
    static String a5 = "Neil Armstrong";
    static String a6 = "Blue whale";
    static String a7 = "9.81 m/s²";
    static String a8 = "Jupiter";
    static String a9 = "Manila";
    static String a10 = "David";

    // Array for correct answers
    static String[] oquiz = {a1, a2, a3, a4, a5, a6, a7, a8, a9, a10};

    // Wrong answers
    static String w1 = "Photosynthesis";
    static String w2 = "Web Wide World";
    static String w3 = "Leonardo DiCaprio";
    static String w4 = "Mark Villar";
    static String w5 = "Neil Armless";
    static String w6 = "Elephant";
    static String w7 = "9.81m/s";
    static String w8 = "Uranus";
    static String w9 = "Cubao";
    static String w10 = "Saul";

    // Array for wrong answers
    static String[] wquiz = {w1, w2, w3, w4, w5, w6, w7, w8, w9, w10};

    // Variables to store score, random number, and previous random number
    static int score = 0;
    static int num = 0;
    static int prev;

    public static void main(String[] args) {

        Frame quizgame = new Frame();
        quizgame.setSize(325, 300);
        quizgame.setLocationRelativeTo(null); // Center the frame
        quizgame.setResizable(false);
        quizgame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Center align with gaps
        quizgame.setBackground(new Color(173, 216, 230)); // Light blue background color

        Panel head = new Panel();
        head.setBackground(new Color(135, 206, 250)); // Light sky blue panel color
        Label htitle = new Label("QUIZ GAME!");
        htitle.setForeground(Color.WHITE); // White text color
        head.add(htitle);

        Panel start = new Panel();
        start.setBackground(new Color(173, 216, 230)); // Light blue panel color
        Button sbtn = new Button("PLAY");
        start.add(sbtn);

        Panel game = new Panel();
        game.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column for q, ch1, ch2
        game.setBackground(new Color(173, 216, 230)); // Light blue panel color
        Label q = new Label();
        q.setPreferredSize(new Dimension(275, 25));
        q.setForeground(Color.BLACK); // Black text color
        Button ch1 = new Button();
        Button ch2 = new Button();
        game.add(q);
        game.add(ch1);
        game.add(ch2);
        game.setVisible(false);

        Panel pscr = new Panel();
        pscr.setBackground(new Color(173, 216, 230)); // Light blue panel color
        Label scr = new Label("Score: " + Integer.toString(score) + "/5");
        scr.setForeground(Color.BLACK); // Black text color
        pscr.add(scr);
        pscr.setVisible(false);

        Panel endscrn = new Panel();
        endscrn.setBackground(new Color(173, 216, 230)); // Light blue panel color
        Label praise = new Label("Congratulations! You Won!");
        praise.setForeground(Color.BLACK); // Black text color
        endscrn.add(praise);
        endscrn.setVisible(false);

        Random rand = new Random();
        num = rand.nextInt(10);

        quizgame.add(head);
        quizgame.add(start);
        quizgame.add(game);
        quizgame.add(pscr);
        quizgame.add(endscrn);

        // Play button
        sbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Randomizer
                int rndm = rand.nextInt(2);
                if (rndm == 0) {
                    q.setText(qquiz[num]);
                    ch1.setLabel(oquiz[num]);
                    ch2.setLabel(wquiz[num]);
                } else if (rndm == 1) {
                    q.setText(qquiz[num]);
                    ch1.setLabel(wquiz[num]);
                    ch2.setLabel(oquiz[num]);
                }

                game.setVisible(true);
                score = 0;
                scr.setText("Score: " + Integer.toString(score) + "/5");
                pscr.setVisible(true);
                endscrn.setVisible(false);
                quizgame.revalidate();

            }
        });

        // Option 1
        ch1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ans = ch1.getLabel();

                // Compare option with answer
                if (ans.equals(oquiz[num])) {
                    score++;
                    scr.setText("Score: " + Integer.toString(score) + "/5");
                } else {
                    score--;
                    scr.setText("Score: " + Integer.toString(score) + "/5");
                }

                // Makes sure that the same question is not asked twice in a row
                do {
                    num = rand.nextInt(10);
                } while (num == prev);

                prev = num;

                // Randomizer
                int rndm = rand.nextInt(2);
                if (rndm == 0) {
                    q.setText(qquiz[num]);
                    ch1.setLabel(oquiz[num]);
                    ch2.setLabel(wquiz[num]);
                } else if (rndm == 1) {
                    q.setText(qquiz[num]);
                    ch1.setLabel(wquiz[num]);
                    ch2.setLabel(oquiz[num]);
                }

                if (score == 5) {
                    game.setVisible(false);
                    endscrn.setVisible(true);
                    quizgame.revalidate();
                }

            }
        });

        ch2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ans = ch2.getLabel();

                //Compare option with answer
                if (ans.equals(oquiz[num])) {
                    score++;
                    scr.setText("Score: " + Integer.toString(score) + "/5");
                } else {
                    score--;
                    scr.setText("Score: " + Integer.toString(score) + "/5");
                }

                // Makes sure that the same question is not asked twice in a row
                do {
                    num = rand.nextInt(10);
                } while (num == prev);

                prev = num;

                // Randomizer
                int rndm = rand.nextInt(2);
                if (rndm == 0) {
                    q.setText(qquiz[num]);
                    ch1.setLabel(oquiz[num]);
                    ch2.setLabel(wquiz[num]);
                } else if (rndm == 1) {
                    q.setText(qquiz[num]);
                    ch1.setLabel(wquiz[num]);
                    ch2.setLabel(oquiz[num]);
                }

                if (score == 5) {
                    game.setVisible(false);
                    endscrn.setVisible(true);
                    quizgame.revalidate();
                }

            }
        });

        quizgame.setVisible(true);

        // Close window
        quizgame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                System.exit(0);

            }
        });
    }
}