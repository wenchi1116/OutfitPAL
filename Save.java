package fourpeople.socute.outfitpal;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Save {
    private JLabel imageLabel; // Assuming you have an imageLabel variable
    private String gender;
    private String selectedCategory;
    private String selectItem;
    private String selectedColor;
    private int i = 0;

    public Save(String gender, String selectedCategory, String selectItem, String selectedColor) {
        this.gender = gender;
        this.selectedCategory = selectedCategory;
        this.selectItem = selectItem;
        this.selectedColor = selectedColor;
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("OutfitPAL"); // Create a new JFrame
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JButton saveButton = new JButton("儲存圖片");
        JLabel label1 = new JLabel("    如果你喜歡這套穿搭，那你一定要");
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS)); // Set BoxLayout for horizontal alignment
        panel1.add(label1);
        // panel1.add(Box.createHorizontalGlue()); // Add horizontal glue to align
        // components to the right
        panel1.add(saveButton);
        panel1.add(Box.createHorizontalStrut(10));
        Clothes clothes = new Clothes(gender, selectedCategory, selectItem, selectedColor);
        Wear wear = new Wear();
        try {
            wear.WearCrawler(clothes);
        } catch (Exception ee) {
            // 處理例外
            ee.printStackTrace();
        }
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // try {
                String[] imageurl = new String[5];
                imageurl = wear.getimageUrl();
                ImageDownload imagedownload = new ImageDownload(imageurl[i]);
                imagedownload.downloadImage();
                JOptionPane.showMessageDialog(null, "圖片儲存成功");
                // } catch (IOException ee) {
                // ee.printStackTrace();
                // JOptionPane.showMessageDialog(null, "圖片未儲存成功");
                // }

            }
        });
        JButton changeButton = new JButton("再換一套");
        JLabel label2 = new JLabel("    如果你不滿意這套穿搭，那就");
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS)); // Set BoxLayout for horizontal alignment
        panel2.add(label2);
        // panel2.add(Box.createHorizontalGlue()); // Add horizontal glue to align
        // components to the right
        panel2.add(changeButton);
        panel2.add(Box.createHorizontalStrut(10));

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i == 4) {
                    JOptionPane.showMessageDialog(null, "到底要換幾套?????");
                }
                String[] imageurl = new String[5];
                imageurl = wear.getimageUrl();
                ShowImage clothesimage = new ShowImage(imageurl[++i]);
                clothesimage.ShowClothesImage();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel1);
        frame.add(panel2);
        frame.setResizable(false);
        frame.pack();
        frame.setSize(350, 150);
        frame.setVisible(true);
    }
}