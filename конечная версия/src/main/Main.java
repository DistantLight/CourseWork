package main;

import menu1.*;
import menu2.*;
import menu3.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;


public class Main {

    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();


    static JFrame getFrame(){                           //ф-ия настройки экрана приложения
        JFrame jFrame = new JFrame() {};

        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        jFrame.setSize(dimension);


        return jFrame;
    }


    public static void main(String[] args) throws Exception {


        JTextArea jTextArea = new JTextArea(80,80);
        jPanel.add(jTextArea);


        JMenuBar jMenuBar = new JMenuBar();

        JMenu menu1 = new JMenu("файл");
        JMenu menu2 = new JMenu("функции");
        JMenu menu3 = new JMenu("сохранить");
        jMenuBar.add(menu1);
        jMenuBar.add(menu2);
        jMenuBar.add(menu3);


        jFrame.setJMenuBar(jMenuBar);


        jFrame.add(jPanel);
        menu1.add(new JMenuItem("открыть")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(jFrame);

                try{
                    File file = jFileChooser.getSelectedFile();
                    Scanner scanner = new Scanner(file);
                    String w;
                    while (scanner.hasNext()){
                        w = scanner.nextLine();
                        jTextArea.append(w + "\n");
                    }
                } catch (Exception exception){}
            }
        });

        menu1.add(new JMenuItem("создать")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String str = JOptionPane.showInputDialog(jFrame, "введите адрес директории для файла");
                    String name = JOptionPane.showInputDialog(jFrame, "введите название файла");
                    File file = new File(str, name);
                    file.createNewFile();
                }catch (Exception exception){}
            }
        });




        menu1.add(new JMenuItem("копировать")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser1 = new JFileChooser();
                JFileChooser jFileChooser2 = new JFileChooser();

                jFileChooser1.setDialogTitle("Выберите файл, который нужно скопировать");
                jFileChooser2.setDialogTitle("Выберите файл, в который будет записан текст");

                jFileChooser1.showOpenDialog(jFrame);
                jFileChooser2.showOpenDialog(jFrame);


                try{
                   File file1 =  jFileChooser1.getSelectedFile();
                   File file2 = jFileChooser2.getSelectedFile();

                   if (file1.exists()&&file2.exists()){
                       CreateCopyFile createCopyFile = new CreateCopyFile();
                       createCopyFile.CopyFile(file1, file2);
                   }
                }catch (Exception exception){}
            }
        });

        menu1.add(new JMenuItem("удалить")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(jFrame);

                try {
                    File file = jFileChooser.getSelectedFile();
                    file.delete();
                }catch (Exception exception){}
            }
        });


        menu2.add(new JMenuItem("нумерация строк")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(jFrame);

                try {
                    File file = jFileChooser.getSelectedFile();
                    LineNumbering ln = new LineNumbering();
                    ln.NumberOfString(file);
                } catch (Exception exception){}
            }
        });

        menu2.add(new JMenuItem("счётчик слов")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(jFrame);

                try {
                    File file = jFileChooser.getSelectedFile();
                    if (file.exists()){
                        CountingWords countingWords = new CountingWords();
                        JOptionPane.showMessageDialog(jFrame,countingWords.CounterWords(file));
                    }
                }catch (Exception exception){}
            }
        });

        menu2.add(new JMenuItem("вывести предложение по номеру")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(jFrame);

                try {
                    File file = jFileChooser.getSelectedFile();
                    int var = Integer.parseInt(JOptionPane.showInputDialog(jFrame, "введите номер предложения"));
                    if (file.exists()){
                        OutputSentence outputSentence = new OutputSentence();
                        JOptionPane.showMessageDialog(jFrame,outputSentence.DisplaySentence(file,var-1));
                    }
                }catch (Exception exception){}
            }
        });

        menu2.add(new JMenuItem("замена слова")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(jFrame);

                try {
                    File file = jFileChooser.getSelectedFile();
                    if (file.exists()) {
                        WordReplacement wr = new WordReplacement();
                        String str1 = JOptionPane.showInputDialog(jFrame, "введите cлово, которое нужно найти");
                        String str2 = JOptionPane.showInputDialog(jFrame, "введите слово для замены");
                        wr.ChangeWords(file,str1,str2);
                    }
                }catch (Exception exception){}
            }
        });

        menu2.add(new JMenuItem("счётчик слова")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(jFrame);

                try{
                    File file = jFileChooser.getSelectedFile();
                    if(file.exists()){
                        CountingWord countingWord = new CountingWord();
                        String str = JOptionPane.showInputDialog(jFrame, "введите cлово, которое нужно посчитать");
                        JOptionPane.showMessageDialog(jFrame,countingWord.CounterWord(file,str));
                    }
                }catch (Exception exception){}
            }
        });

        menu2.add(new JMenuItem("счётчик предложений")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(jFrame);

                try{
                    File file = jFileChooser.getSelectedFile();
                    if(file.exists()){
                        CountingSentences cs = new CountingSentences();
                        JOptionPane.showMessageDialog(jFrame,cs.CounterSentences(file));
                    }
                }catch (Exception exception){}
            }
        });
        

        menu3.add(new JMenuItem("сохранить текущие записи")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setDialogTitle("выберите текстовый файл для сохранения введенного текста");
                jFileChooser.showOpenDialog(jFrame);

                try {
                    File file = jFileChooser.getSelectedFile();
                    if (file.exists()) {
                        SavingText savingText = new SavingText(file);
                        savingText.SaveFile(jTextArea);
                        JOptionPane.showMessageDialog(jFrame,"всё прошло успешно" );
                    }
                }catch (Exception exception){}
            }
        });




        jFrame.revalidate();                                                        //важно
    }
}
