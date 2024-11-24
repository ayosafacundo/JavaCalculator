import javax.swing.*;
import java.awt.*;
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
    private JPanel ButtonPad;
    private JPanel Numbers;
    private JScrollPane Scrollable;

    private final InternalCalculator internal = new InternalCalculator();
    Calculator() {
        this.setContentPane(this.Background);
        this.setTitle("Calculator");
        this.setResizable(false);
        Calculate.setText("0");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(1920/2-400/2,1080/2-300/2,400,300);
        ActionListener numberAction = e -> {
            internal.input(e.getActionCommand());
            Calculate.setText(internal.toString());
        };
        Num0.addActionListener(numberAction);
        Num0.setMnemonic(KeyEvent.VK_NUMPAD0);
        Num1.addActionListener(numberAction);
        Num1.setMnemonic(KeyEvent.VK_NUMPAD1);
        Num2.addActionListener(numberAction);
        Num2.setMnemonic(KeyEvent.VK_NUMPAD2);
        Num3.addActionListener(numberAction);
        Num3.setMnemonic(KeyEvent.VK_NUMPAD3);
        Num4.addActionListener(numberAction);
        Num4.setMnemonic(KeyEvent.VK_NUMPAD4);
        Num5.addActionListener(numberAction);
        Num5.setMnemonic(KeyEvent.VK_NUMPAD5);
        Num6.addActionListener(numberAction);
        Num6.setMnemonic(KeyEvent.VK_NUMPAD6);
        Num7.addActionListener(numberAction);
        Num7.setMnemonic(KeyEvent.VK_NUMPAD7);
        Num8.addActionListener(numberAction);
        Num8.setMnemonic(KeyEvent.VK_NUMPAD8);
        Num9.addActionListener(numberAction);
        Num9.setMnemonic(KeyEvent.VK_NUMPAD9);
        FuncPlus.addActionListener(numberAction);
        FuncPlus.setMnemonic(KeyEvent.VK_PLUS);
        FuncMinus.addActionListener(numberAction);
        FuncMinus.setMnemonic(KeyEvent.VK_MINUS);
        FuncMultiply.addActionListener(numberAction);
        FuncMultiply.setMnemonic(KeyEvent.VK_MULTIPLY);
        FuncDivide.addActionListener(numberAction);
        FuncDivide.setMnemonic(KeyEvent.VK_DIVIDE);
        DotButton.addActionListener(numberAction);
        DotButton.setMnemonic(KeyEvent.VK_DECIMAL);
        FuncModulo.addActionListener(numberAction);
        FuncModulo.setMnemonic('%');
        ActionListener eraseAction = e -> {
            internal.erase(e.getActionCommand());
            Calculate.setText(internal.toString());
        };
        FuncC.addActionListener(eraseAction);
        FuncC.setMnemonic(KeyEvent.VK_C);
        FuncCE.addActionListener(eraseAction);
        FuncCE.setMnemonic(KeyEvent.VK_DELETE);
        ActionListener totalAction = e -> {
            internal.total();
            Calculate.setText(internal.toString());
        };
        FuncEqual.addActionListener(totalAction);
        FuncEqual.setMnemonic(KeyEvent.VK_ENTER);
        ActionListener getInfo = e -> JOptionPane.showMessageDialog(FuncInfo, "Made By Ayosa Facundo Ezequiel");
        FuncInfo.addActionListener(getInfo);
        FuncInfo.setMnemonic('i');
        Calculate.setVerticalAlignment(SwingConstants.CENTER);
        Calculate.setHorizontalAlignment(SwingConstants.CENTER);
        Numbers.setBackground(new Color(45,45,45));
        Calculate.setFont(new Font("Geist Mono Thin", Font.PLAIN, 20));
        Calculate.setForeground(Color.WHITE);
        Numbers.setBorder(BorderFactory.createLineBorder(new Color(65,65,65), 5));
        ButtonPad.setBackground(new Color(65,65,65));
        Background.setBackground(new Color(65,65,65));
        Scrollable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        this.pack();
    }
}

