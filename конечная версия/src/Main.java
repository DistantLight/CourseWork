import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;


public class Main {

    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();


    static JFrame getFrame(){
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


        menu1.add(new JMenuItem("копировать"));

        menu2.add(new JMenuItem("счётчик слов"));
        menu2.add(new JMenuItem("нумерация строк"));
        menu2.add(new JMenuItem("вывести предложение по номеру"));
        menu2.add(new JMenuItem("замена слова"));
        menu2.add(new JMenuItem("счётчик слов"));
        menu2.add(new JMenuItem("счётчик предложений"));
        menu2.add(new JMenuItem("счётчик одного слова"));

        menu3.add(new JMenuItem("сохранить текущие записи"));


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








        jFrame.revalidate();                                                        //важно
    }
}