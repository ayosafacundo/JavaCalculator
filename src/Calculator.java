import javax.swing.*;
import java.awt.event.*;
public class Calculator extends JFrame{
    private JPanel Background;
    private JButton Num7;
    private JButton Num8;
    private JButton Num9;
    private JButton FuncMinus;
    private JButton Num4;
    private JButton Num5;
    private JButton Num6;
    private JButton Num1;
    private JButton Num2;
    private JButton Num3;
    private JButton FuncC;
    private JButton FuncPlus;
    private JButton FuncEqual;
    private JButton Num0;
    private JButton FuncMultiply;
    private JButton FuncDivide;
    private JButton DotButton;
    private JButton FuncModulo;
    private JButton FuncCE;
    private JButton FuncInfo;
    private JLabel Calculate;

    private final InternalCalculator internal = new InternalCalculator();
    Calculator() {
        this.setContentPane(this.Background);
        this.setTitle("Calculator");
        Calculate.setText("_");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(1920/2-400/2,1080/2-300/2,400,300);
        ActionListener numberAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internal.input(e.getActionCommand());
                Calculate.setText(internal.toString());
            }
        };
        Num7.addActionListener(numberAction);
        Num8.addActionListener(numberAction);
        Num9.addActionListener(numberAction);
        Num4.addActionListener(numberAction);
        Num5.addActionListener(numberAction);
        Num6.addActionListener(numberAction);
        Num1.addActionListener(numberAction);
        Num2.addActionListener(numberAction);
        Num3.addActionListener(numberAction);
        Num0.addActionListener(numberAction);
        FuncPlus.addActionListener(numberAction);
        FuncMinus.addActionListener(numberAction);
        FuncMultiply.addActionListener(numberAction);
        FuncDivide.addActionListener(numberAction);
        DotButton.addActionListener(numberAction);
        FuncModulo.addActionListener(numberAction);
        ActionListener eraseAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internal.erase(e.getActionCommand());
                Calculate.setText(internal.toString());
            }
        };
        FuncC.addActionListener(eraseAction);
        FuncCE.addActionListener(eraseAction);
        ActionListener totalAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internal.total();
                Calculate.setText(internal.toString());
            }
        };
        FuncEqual.addActionListener(totalAction);
        ActionListener getInfo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FuncInfo, "Made By Ayosa Facundo Ezequiel");
            }
        };
        FuncInfo.addActionListener(getInfo);
    }

}
