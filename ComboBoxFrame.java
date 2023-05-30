package fourpeople.socute.outfitpal;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.IOException;

public class ComboBoxFrame extends JFrame {
   private final JComboBox<String> comboBox1;
   private final JComboBox<String> comboBox2;
   private final JComboBox<String> comboBox3;
   private final JComboBox<String> comboBox4;
   private final JComboBox<String> comboBox5;

   private static final String[] options1 = { "請選擇種類", "上衣", "褲子", "連衣裙", "外套" };
   private static final String[] options2 = { "請選擇上衣", "T恤", "襯衫", "針織衫", "細肩帶背心", "坦克背心" };
   private static final String[] options3 = { "請選擇褲子", "牛仔褲", "休閒長褲", "休閒短褲" };
   private static final String[] options4 = { "請選擇連衣裙", "裙子", "牛仔裙" };
   private static final String[] options5 = { "請選擇外套", "休閒西裝", "牛仔外套", "短外套", "運動外套", "毛呢大衣" };

   private static final String[] options6 = { "請選擇顏色", "白色系", "黑色系", "灰色系", "棕色系", "米色系", "綠色系", "藍色系", "紫色系", "黃色系",
         "粉色系", "紅色系", "橘色系", "銀色系", "金色系" };
   private static final String[] options7 = { "請選擇您要搭配的季節", "春天", "夏天", "秋天", "冬天" };

   private String gender; // 新增的成员变量

   public ComboBoxFrame(String gender) {
      super("OutfitPAL");
      setLayout(new FlowLayout());

      this.gender = gender; // 初始化性别信息

      comboBox1 = new JComboBox<>(options1);
      comboBox2 = new JComboBox<>(options2);
      comboBox3 = new JComboBox<>(options3);
      comboBox4 = new JComboBox<>(options4);
      comboBox5 = new JComboBox<>(options5);

      comboBox2.setEnabled(false); // 初始狀態下禁用第二個下拉式選單
      comboBox3.setEnabled(false);
      comboBox4.setEnabled(false);
      comboBox5.setEnabled(false);

      comboBox1.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
               String selectedItem = (String) comboBox1.getSelectedItem();
               comboBox2.setEnabled(selectedItem.equals("上衣"));
               comboBox3.setEnabled(selectedItem.equals("褲子"));
               comboBox4.setEnabled(selectedItem.equals("連衣裙"));
               comboBox5.setEnabled(selectedItem.equals("外套"));
            }
         }
      });

      add(comboBox1);
      add(comboBox2);
      add(comboBox3);
      add(comboBox4);
      add(comboBox5);

      JButton button = new JButton("To Be Continue");
      button.addActionListener(new ActionListener() { // 按下 "To Be Continue" 按鈕時彈出具有兩個下拉式選單的新視窗
         @Override
         public void actionPerformed(ActionEvent e) {
            if (comboBox1.getSelectedItem() == options1[0]) {
               JOptionPane.showMessageDialog(null, "您尚未選擇要搭配的種類", "警告", JOptionPane.WARNING_MESSAGE);
            } else if (comboBox1.getSelectedItem() == options1[1] && comboBox2.getSelectedItem() == options2[0]) {
               JOptionPane.showMessageDialog(null, "您尚未選擇要搭配的上衣單品", "警告", JOptionPane.WARNING_MESSAGE);
            } else if (comboBox1.getSelectedItem() == options1[2] && comboBox3.getSelectedItem() == options3[0]) {
               JOptionPane.showMessageDialog(null, "您尚未選擇要搭配的褲子單品", "警告", JOptionPane.WARNING_MESSAGE);
            } else if (comboBox1.getSelectedItem() == options1[3] && comboBox4.getSelectedItem() == options4[0]) {
               JOptionPane.showMessageDialog(null, "您尚未選擇要搭配的連身裙單品", "警告", JOptionPane.WARNING_MESSAGE);
            } else if (comboBox1.getSelectedItem() == options1[4] && comboBox5.getSelectedItem() == options5[0]) {
               JOptionPane.showMessageDialog(null, "您尚未選擇要搭配的外套單品", "警告", JOptionPane.WARNING_MESSAGE);
            } else {
               JFrame newFrame = new JFrame("OutfitPAL");
               newFrame.setLayout(new FlowLayout());

               JComboBox<String> comboBox6 = new JComboBox<>(options6);
               JComboBox<String> comboBox7 = new JComboBox<>(options7);
               newFrame.add(comboBox6);
               newFrame.add(comboBox7);

               JButton confirmButton = new JButton("確定");
               confirmButton.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     String selectItem = null;
                     String selectedCategory = (String) comboBox1.getSelectedItem();
                     String selectedTop = (String) comboBox2.getSelectedItem();
                     String selectedPants = (String) comboBox3.getSelectedItem();
                     String selectedDress = (String) comboBox4.getSelectedItem();
                     String selectedCoat = (String) comboBox5.getSelectedItem();
                     String selectedColor = (String) comboBox6.getSelectedItem();
                     String selectedSeason = (String) comboBox7.getSelectedItem();

                     if (selectedTop != "請選擇上衣") {
                        selectItem = selectedTop;
                     } else if (selectedPants != "請選擇褲子") {
                        selectItem = selectedPants;
                     } else if (selectedDress != "請選擇連衣裙") {
                        selectItem = selectedDress;
                     } else if (selectedCoat != "請選擇外套") {
                        selectItem = selectedCoat;
                     }

                     String output = "選擇的種類：" + selectedCategory + "\n";

                     output += "選擇的物品：" + selectItem + "\n";

                     output += "選擇的顏色：" + selectedColor + "\n";
                     output += "選擇的季節：" + selectedSeason + "\n";
                     output += "選擇的性別：" + gender; // 添加性别信息
                     Clothes clothes = new Clothes(gender, selectedCategory, selectItem, selectedColor);
                     Wear wear = new Wear();
                     try {
                        wear.WearCrawler(clothes);
                     } catch (Exception ee) {
                        // 處理例外
                        ee.printStackTrace();
                     }
                     String[] imageurl = new String[5];
                     imageurl = wear.getimageUrl();
                     ShowImage clothesimage = new ShowImage(imageurl[0]);
                     clothesimage.ShowClothesImage();
                     Save save = new Save(gender, selectedCategory, selectItem, selectedColor);
                     save.createAndShowGUI();
                     newFrame.add(confirmButton);
                     JOptionPane.showMessageDialog(null, output, "選擇", JOptionPane.INFORMATION_MESSAGE);

                     newFrame.dispose(); // 關閉窗口
                  }
               });
               newFrame.add(confirmButton);
               newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               newFrame.setSize(400, 300);
               newFrame.setVisible(true);
            }
         }
      });

      add(button);
   }
}
