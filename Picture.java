package fourpeople.socute.outfitpal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Picture extends JFrame {
    private JButton maleButton, femaleButton;

    public Picture() {
        super("OutfitPAL");
        setLayout(new BorderLayout());

        // 創建 JPanel 以容納照片
        JPanel panel = new JPanel(new FlowLayout());
        add(panel, BorderLayout.CENTER);

        ImageIcon girlIcon = new ImageIcon(getClass().getResource("girl.png"));
        Image girlImage = girlIcon.getImage();
        Image resizedGirlImage = girlImage.getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        ImageIcon resizedGirlIcon = new ImageIcon(resizedGirlImage);
        JLabel girlLabel = new JLabel(resizedGirlIcon);
        panel.add(girlLabel);

        ImageIcon boyIcon = new ImageIcon(getClass().getResource("boy.png"));
        Image boyImage = boyIcon.getImage();
        Image resizedBoyImage = boyImage.getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        ImageIcon resizedBoyIcon = new ImageIcon(resizedBoyImage);
        JLabel boyLabel = new JLabel(resizedBoyIcon);
        panel.add(boyLabel);

        // 創建 JPanel 以容納按鈕
        JPanel buttonPanel = new JPanel(new FlowLayout());
        add(buttonPanel, BorderLayout.NORTH);

        JLabel promptLabel = new JLabel("請選擇您要搭配的性別:\n");
        buttonPanel.add(promptLabel);

        // 添加女生按钮
        femaleButton = new JButton("女生");
        femaleButton.setBounds(100, 100, 100, 30);

        femaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "您選擇了女性");
                ComboBoxFrame comboBoxFrame = new ComboBoxFrame("Woman"); // 传递性别信息
                // ComboBoxFrame comboBoxFrame = new ComboBoxFrame();
                comboBoxFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                comboBoxFrame.setSize(400, 300);
                comboBoxFrame.setVisible(true);
            }
        });

        buttonPanel.add(femaleButton); // 添加按钮到面板

        // 添加男生按钮
        maleButton = new JButton("男生");
        maleButton.setBounds(100, 100, 100, 30);
        maleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "您選擇了男性");
                ComboBoxFrame comboBoxFrame = new ComboBoxFrame("Man"); // 传递性别信息
                // ComboBoxFrame comboBoxFrame = new ComboBoxFrame();
                comboBoxFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                comboBoxFrame.setSize(400, 300);
                comboBoxFrame.setVisible(true);
            }
        });
        buttonPanel.add(maleButton); // 添加按钮到面板

    }
}
