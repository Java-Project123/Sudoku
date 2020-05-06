import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
public class SudokuGrid extends JFrame implements ActionListener,ItemListener{
    private JPanel[] pnlGame;
    private JTextField[][][] txtGame;
    private JPanel p ;
    String num;
    String difficulty;
    File file ;
    static int counter = 0 ;
    char s ;
    public SudokuGrid(String dif , String no) throws FileNotFoundException {
        this.difficulty = dif ;
        this.num = no ;
        pnlGame = new JPanel[9];
        txtGame = new JTextField[9][3][3];
        p = new JPanel();
        gridInit();
    }

    public void gridInit() throws FileNotFoundException {

        p.setLayout(new GridLayout(3,3));
        for(int i = 0 ; i < 9 ; i ++) {
            pnlGame[i] = new JPanel();
            pnlGame[i].setBorder(BorderFactory.createLineBorder(Color.orange));
            pnlGame[i].setLayout(new GridLayout(3,3));
            p.add(pnlGame[i]);
        }
        for (int z = 0; z < 9; z++) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    txtGame[z][x][y] = new JTextField();
                    int eachSquare = z;
                    int row = x;
                    int column = y;
                    txtGame[z][x][y].addKeyListener(new KeyListener() {
                        public void keyPressed(KeyEvent e) {
                        }

                        @Override
                        public void keyReleased(KeyEvent arg0) {
                            // TODO Auto-generated method stub
                        }

                        @Override
                        public void keyTyped(KeyEvent arg0) {
                            //撤回
                            s = arg0.getKeyChar();
                            if(s == '') {
                                counter -- ;
                            }
                            // 输入符合 1~9
                            else if(isSingleNumber(s)) {
                                counter ++ ;
                                //System.out.println("输入的数据为： " + s);
                                if(!isValid(eachSquare,row,column,s,txtGame)) {
                                    JOptionPane.showMessageDialog(null,"答案错误!");
                                    counter --;
                                }
                            }
                            // 不在 1~9
                            else if(!Character.isDigit(s) || !isSingleNumber(s))
                                JOptionPane.showMessageDialog(null,"非法输入");
                            try {
                                if(counter >= 81 && answerIsRight()) {
                                    JOptionPane.showMessageDialog(null,"游戏结束，恭喜！");
                                }
                                else if(counter >= 81 && !answerIsRight()){
                                    JOptionPane.showMessageDialog(null,"游戏结束，再接再厉！");
                                }
                            } catch (HeadlessException | FileNotFoundException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    });

                    txtGame[z][x][y].setBorder(BorderFactory.createEtchedBorder());
                    txtGame[z][x][y].setFont(new Font("Dialog", Font.ITALIC, 20));// Set size and font
                    txtGame[z][x][y].setHorizontalAlignment(JTextField.CENTER);// set position
                    pnlGame[z].add(txtGame[z][x][y]);
                }
            }
        }
        file = new File("question" + File.separator + difficulty + File.separator + num + ".txt");
        Scanner sc = new Scanner(file);
        int count = 0 ;
        for(int x1 = 0 ; x1 < 3 ; x1 ++) {
            for(int x2 = 0 ; x2 < 3 ; x2 ++) {
                for(int x3 = 0 ; x3 < 3 ; x3 ++) {
                    for(int x4 = 0 ; x4 < 3 ; x4 ++) {
                        int contaner = sc.nextInt();
                        if(contaner == 0) {
                            txtGame[count + x3][x2][x4].setText("");
                        }
                        else {
                            txtGame[count + x3][x2][x4].setText(contaner + "");
                            txtGame[count + x3][x2][x4].setEditable(false);
                            counter ++ ;
                        }
                    }
                }
            }
            count = count + 3 ;
        }
    }

    public JPanel getPanel() {
        return this.p;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    //判断输入是否在 1~9 之间
    public boolean isSingleNumber(char ch) {
        return ch <= '9' && ch >= '1';
    }

    public static boolean isValid(int z1 , int x1, int y1, char s, JTextField[][][] grid){
        // check whether num is unique in i 's row
        // 先判断输入的是哪个大宫格的
        if(z1 == 0 || z1 == 3 || z1 == 6){
            for(int z = z1; z < z1 + 2; z ++){
                for(int y = 0; y < 3; y ++){
                    String near = grid[z][x1][y].getText();
                    if(z == z1){
                        if(y != y1 && !near.equals("")){
                            char n = near.charAt(0);
                            if(n == s)
                                return false;
                        }
                    }else if(!near.equals("")){
                        char n = near.charAt(0);
                        if(n == s)
                            return false;
                    }
                }
            }
        }else if(z1 == 1 || z1 == 4 || z1 == 7){
            for(int z = z1-1; z < z1 + 1; z ++){
                for(int y = 0; y < 3; y ++){
                    String near = grid[z][x1][y].getText();
                    if(z == z1){
                        if(y != y1 && !near.equals("")){
                            char n = near.charAt(0);
                            if(n == s)
                                return false;
                        }
                    }else if(!near.equals("")){
                        char n = near.charAt(0);
                        if(n == s)
                            return false;
                    }
                }
            }
        }else{
            for(int z = z1; z > z1-2; z --){
                for(int y = 0; y < 3; y ++){
                    String near = grid[z][x1][y].getText();
                    if(z == z1){
                        if(y != y1 && !near.equals("")){
                            char n = near.charAt(0);
                            if(n == s)
                                return false;
                        }
                    }else if(!near.equals("")){
                        char n = near.charAt(0);
                        if(n == s)
                            return false;
                    }
                }
            }
        }
        // check whether num is unique in j's column
        if(z1 == 0 || z1 == 1 || z1 == 2){
            for(int z = z1; z < z1 + 6; z += 3){
                for(int x = 0; x < 3; x ++){
                    String near = grid[z][x][y1].getText();
                    if(z == z1){
                        if(x != x1 && !near.equals("")){
                            char n = near.charAt(0);
                            if(n == s)
                                return false;
                        }
                    }else if(!near.equals("")){
                        char n = near.charAt(0);
                        if(n == s)
                            return false;
                    }
                }
            }
        }else if(z1 == 3 || z1 == 4 || z1 == 5){
            for(int z = z1-3; z <z1+3; z += 3){
                for(int x = 0; x < 3; x ++){
                    String near = grid[z][x][y1].getText();
                    if(z == z1){
                        if(x != x1 && !near.equals("")){
                            char n = near.charAt(0);
                            if(n == s)
                                return false;
                        }
                    }else if(!near.equals("")){
                        char n = near.charAt(0);
                        if(n == s)
                            return false;
                    }
                }
            }
        }else{
            for(int z = z1; z > z1-6; z -= 3){
                for(int x = 0; x < 3; x ++){
                    String near = grid[z][x][y1].getText();
                    if(z == z1){
                        if(x != x1 && !near.equals("")){
                            char n = near.charAt(0);
                            if(n == s)
                                return false;
                        }
                    }else if(!near.equals("")){
                        char n = near.charAt(0);
                        if(n == s)
                            return false;
                    }
                }
            }
        }
        //check whether grid[i][j] is unique in the 3-by-3 box
        for(int x = 0; x < 2; x ++){
            for(int y = 0; y < 3; y ++){
                String near = grid[z1][x][y].getText();
                if(x != x1 && y != y1){
                    if(!near.equals("")){
                        char n = near.charAt(0);
                        if(n == s)
                            return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean answerIsRight() throws FileNotFoundException {
        String[] in = new String[81];
        for(int x= 0 ; x < 81 ; x ++) {
            in[x] = "0";
        }
        String[] ans = new String[81];
        int count = 0 ;
        int index = 0;
        for(int x1 = 0 ; x1 < 3 ; x1 ++) {
            for(int x2 = 0 ; x2 < 3 ; x2 ++) {
                for(int x3 = 0 ; x3 < 3 ; x3 ++) {
                    for(int x4 = 0 ; x4 < 3 ; x4 ++) {
                        in[index] = txtGame[count + x3][x2][x4].getText();
                        index ++ ;
                    }
                }
            }
            count = count + 3 ;
        }
        for(int x = 0 ; x < 81 ; x ++) {
            if(in[x].contentEquals("")) {
                char[] cha = new char[]{s};
                in[x] = new String(cha) ;
            }
        }
        index = 0 ;
        File file2 = new File("answer" + File.separator + difficulty + File.separator + num + ".txt");
        Scanner sc1 = new Scanner(file2);
        for(int x = 0 ;x < 81 ; x ++) {
            ans[x] = sc1.next();
        }
        for(int x = 0 ;x < 81 ; x ++) {
            if(!ans[x].contentEquals(in[x])) {
                return false ;
            }
        }

        return true ;
    }
}