import java.io.FileNotFoundException;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Panel extends JFrame implements ActionListener,ItemListener{
    private static final long serialVersionUID = 1L;
    private JPanel SudokuGridPanel , CautionPanel , ChoosePanel, OperationPanel;
    private JButton retract , keep , achievement , hint , begin , lookAnswer ;
    private JComboBox easyQuestion , middleQuestion , hardQuestion;//������
    private ButtonGroup degreeChoose ;
    private JRadioButton easy , middle , hard ;
    static String degree = "easy" ;
    static String num = "1";

    public void newPanel(String dif , String no) throws FileNotFoundException {

        Container showPanel = this.getContentPane();
        showPanel.setLayout(new GridBagLayout());

        //NamePanel
        JPanel NamePanel = new JPanel();
        JLabel name = new JLabel("数独游戏");
        name.setFont(new Font("宋体", Font.PLAIN, 35));
        NamePanel.add(name,BorderLayout.CENTER);
        NamePanel.setBackground(Color.CYAN);
        showPanel.add(NamePanel, new GBC(0,0,2,1).setFill(GBC.NONE).setIpad(610, 10).setWeight(0, 0));

        //AnswerPanel
        JPanel AnswerPanel = new JPanel();
        AnswerPanel.setBackground(Color.pink);
        SudokuGridPanel = new SudokuGrid(dif,no).getPanel();
        showPanel.add(SudokuGridPanel, new GBC(0,1,1,3).setFill(GBC.BOTH).setIpad(400, 400).setWeight(100, 100).setInsets(0,0,0,0));

        //CautionPanel
        CautionPanel = new JPanel();
        JLabel caution = new JLabel("注意：输入数字范围为1-9!");
        caution.setFont(new Font("楷体",Font.BOLD,15));
        CautionPanel.add(caution,BorderLayout.CENTER);
        CautionPanel.setBackground(Color.LIGHT_GRAY);
        showPanel.add(CautionPanel, new GBC(1,1,1,1).setFill(GBC.NONE).setIpad(8, 100).setWeight(4, 4).setInsets(0,0,0,0));

        //ChoosePanel
        String[] questionTab = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
        ChoosePanel = new JPanel();
        easyQuestion = new JComboBox(questionTab);
        middleQuestion = new JComboBox(questionTab);
        hardQuestion = new JComboBox(questionTab);
        easy = new JRadioButton("简单");
        middle = new JRadioButton("中等");
        hard = new JRadioButton("困难");
        begin = new JButton("开始游戏");
        begin.addActionListener(this);
        lookAnswer = new JButton("查看答案");
        lookAnswer.addActionListener(this);
        degreeChoose = new ButtonGroup();
        degreeChoose.add(easy);
        degreeChoose.add(middle);
        degreeChoose.add(hard);
        ChoosePanel.setBackground(Color.pink);
        ChoosePanel.setLayout(new GridLayout(4,2));
        ChoosePanel.add(easy);
        ChoosePanel.add(easyQuestion);
        ChoosePanel.add(middle);
        ChoosePanel.add(middleQuestion);
        ChoosePanel.add(hard);
        ChoosePanel.add(hardQuestion);
        ChoosePanel.add(begin);
        ChoosePanel.add(lookAnswer);
        showPanel.add(ChoosePanel, new GBC(1,2,1,1).setFill(GBC.NONE).setIpad(40, 100).setWeight(0, 0));

        //OperationPanel
        OperationPanel = new JPanel();
        OperationPanel.setBackground(Color.gray);
        retract = new JButton("撤回");
        keep = new JButton("保存");
        achievement = new JButton("成就");
        hint = new JButton("提示");
        OperationPanel.setLayout(new GridLayout(2,2));
        OperationPanel.add(retract);
        OperationPanel.add(keep);
        OperationPanel.add(achievement);
        OperationPanel.add(hint);
        showPanel.add(OperationPanel, new GBC(1,3,1,1).setFill(GBC.NONE).setIpad(90, 150).setWeight(0, 0));

        this.setSize(640,550);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("数独游戏");

    }

    public JPanel setNamePanel(JPanel p) {
        return p ;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        new Panel().newPanel(degree,num);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals("开始游戏")) {
            SudokuGrid.counter = 0;
            if(easy.isSelected()) {
                try {
                    this.setVisible(false);
                    this.degree = "easy" ;
                    switch(easyQuestion.getSelectedIndex()) {
                        case 0 : num = "1"; break;
                        case 1 : num = "2"; break;
                        case 2 : num = "3"; break;
                        case 3 : num = "4"; break;
                        case 4 : num = "5"; break;
                        case 5 : num = "6"; break;
                        case 6 : num = "7"; break;
                        case 7 : num = "8"; break;
                        case 8 : num = "9"; break;
                        case 9 : num = "10"; break;
                        case 10 : num = "11"; break;
                        case 11 : num = "12"; break;
                        case 12 : num = "13"; break;
                        case 13 : num = "14"; break;
                        case 14 : num = "15"; break;
                    }
                    new Panel().newPanel(degree,num);
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            if(middle.isSelected()) {
                try {
                    this.setVisible(false);
                    this.degree = "middle" ;
                    switch(middleQuestion.getSelectedIndex()) {
                        case 0 : num = "1"; break;
                        case 1 : num = "2"; break;
                        case 2 : num = "3"; break;
                        case 3 : num = "4"; break;
                        case 4 : num = "5"; break;
                        case 5 : num = "6"; break;
                        case 6 : num = "7"; break;
                        case 7 : num = "8"; break;
                        case 8 : num = "9"; break;
                        case 9 : num = "10"; break;
                        case 10 : num = "11"; break;
                        case 11 : num = "12"; break;
                        case 12 : num = "13"; break;
                        case 13 : num = "14"; break;
                        case 14 : num = "15"; break;
                    }
                    new Panel().newPanel(degree,num);
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            if(hard.isSelected()) {
                try {
                    this.setVisible(false);
                    this.degree = "hard" ;
                    switch(hardQuestion.getSelectedIndex()) {
                        case 0 : num = "1"; break;
                        case 1 : num = "2"; break;
                        case 2 : num = "3"; break;
                        case 3 : num = "4"; break;
                        case 4 : num = "5"; break;
                        case 5 : num = "6"; break;
                        case 6 : num = "7"; break;
                        case 7 : num = "8"; break;
                        case 8 : num = "9"; break;
                        case 9 : num = "10"; break;
                        case 10 : num = "11"; break;
                        case 11 : num = "12"; break;
                        case 12 : num = "13"; break;
                        case 13 : num = "14"; break;
                        case 14 : num = "15"; break;
                    }
                    new Panel().newPanel(degree,num);
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
    }
}