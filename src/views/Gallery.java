package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gallery extends JFrame {
    private ImageIcon myImage1 = new ImageIcon(Gallery.class.getResource("/images/img-1.jpg"));
    private ImageIcon myImage2 = new ImageIcon(Gallery.class.getResource("/images/img-2.jpg"));
    private ImageIcon myImage3 = new ImageIcon(Gallery.class.getResource("/images/img-3.jpg"));
    private ImageIcon myImage4 = new ImageIcon(Gallery.class.getResource("/images/img-4.jpg"));
    
    JPanel content = new JPanel();
    private ImageIcon[] myImages = new ImageIcon[4];
    private int curImageIndex=0;

    public Gallery () {
    	setTitle("Image Gallery");
    	getContentPane().setBackground(new Color(25, 65, 25));
            content.setPreferredSize(new Dimension(0, 0));
            content.setMinimumSize(new Dimension(0, 0));
            content.setMaximumSize(new Dimension(0, 0));
            content.setBounds(25, 105, 734, 350);
            JLabel imageContent = new JLabel (myImage1);
            imageContent.setAlignmentX(Component.CENTER_ALIGNMENT);
            myImages[0]=myImage1;
            myImages[1]=myImage2;
            myImages[2]=myImage3;
            myImages[3]=myImage4;
            getContentPane().setLayout(null);
            
            JPanel header = new JPanel();
            header.setBounds(0, 0, 784, 80);
            header.setBackground(new Color(25, 75, 25));
            getContentPane().add(header);
            header.setLayout(null);
            
            JLabel title = new JLabel("Image Gallery");
            title.setForeground(new Color(255, 255, 255));
            title.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 32));
            title.setBounds(25, 0, 185, 80);
            header.add(title);
            
            JLabel settings = new JLabel("");
            settings.setHorizontalAlignment(SwingConstants.CENTER);
            settings.setIcon(new ImageIcon(Gallery.class.getResource("/images/settings_1.png")));
            settings.setBounds(724, 0, 60, 80);
            header.add(settings);
            
            JLabel views = new JLabel("");
            views.setIcon(new ImageIcon(Gallery.class.getResource("/images/list_1.png")));
            views.setHorizontalAlignment(SwingConstants.CENTER);
            views.setBounds(664, 0, 60, 80);
            header.add(views);

            getContentPane().add(content);
            content.setLayout(new BorderLayout(0, 0));
            content.add(imageContent);

            JButton PreviousButton_1 = new JButton ("");
            PreviousButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            PreviousButton_1.setIcon(new ImageIcon(Gallery.class.getResource("/images/arrow-left.png")));
            PreviousButton_1.setFocusPainted(false);
            PreviousButton_1.setDefaultCapable(false);
            PreviousButton_1.setContentAreaFilled(false);
            PreviousButton_1.setBorderPainted(false);
            JButton NextButton_1 = new JButton ("");
            NextButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            NextButton_1.setIcon(new ImageIcon(Gallery.class.getResource("/images/arrow-right.png")));
            NextButton_1.setFocusPainted(false);
            NextButton_1.setDefaultCapable(false);
            NextButton_1.setContentAreaFilled(false);
            NextButton_1.setBorderPainted(false);
            NextButton_1.setBackground(new Color(25, 75, 25));

            JPanel menu = new JPanel();
            menu.setBounds(149, 481, 490, 80);
            menu.setLayout(new GridLayout(1,2));
            menu.setBackground(new Color(25, 75, 25));
            menu.add(PreviousButton_1);
            
            JLabel hr = new JLabel("");
            hr.setHorizontalAlignment(SwingConstants.CENTER);
            hr.setIcon(new ImageIcon(Gallery.class.getResource("/images/hr.png")));
            menu.add(hr);
            
            JLabel shareFacebook = new JLabel("");
            shareFacebook.setHorizontalAlignment(SwingConstants.CENTER);
            shareFacebook.setIcon(new ImageIcon(Gallery.class.getResource("/images/fb2.png")));
            menu.add(shareFacebook);
            
            JLabel hr_1 = new JLabel("");
            hr_1.setHorizontalAlignment(SwingConstants.CENTER);
            hr_1.setIcon(new ImageIcon(Gallery.class.getResource("/images/hr.png")));
            menu.add(hr_1);
            
            JLabel shareGooglePlus = new JLabel("");
            shareGooglePlus.setIcon(new ImageIcon(Gallery.class.getResource("/images/google.png")));
            shareGooglePlus.setHorizontalAlignment(SwingConstants.CENTER);
            menu.add(shareGooglePlus);
            
            JLabel hr_2 = new JLabel("");
            hr_2.setHorizontalAlignment(SwingConstants.CENTER);
            hr_2.setIcon(new ImageIcon(Gallery.class.getResource("/images/hr.png")));
            menu.add(hr_2);
            menu.add(NextButton_1);

            getContentPane().add(menu);
            
            JPanel footer = new JPanel();
            footer.setBackground(new Color(25, 75, 25));
            footer.setBounds(0, 481, 784, 80);
            getContentPane().add(footer);

            //register listener
            PreviousButtonListener PreviousButton = new PreviousButtonListener ();
            NextButtonListener NextButton = new NextButtonListener ();

            //add listeners to corresponding components 
            PreviousButton_1.addActionListener(PreviousButton);
            NextButton_1.addActionListener(NextButton);

        }

    public static void main (String [] args) {
    	Gallery frame = new Gallery();
            frame.setSize(800,600);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
    }

    class PreviousButtonListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
                if(curImageIndex>0 && curImageIndex <= 3) {   
                		content.remove(0);
                        curImageIndex=curImageIndex-1;
                        ImageIcon TheImage= myImages[curImageIndex];
                        content.add(new JLabel (TheImage));
                        content.validate();
                        content.repaint(); 
                    }else {   
                        content.remove(0);
                        content.add(new JLabel (myImage1));
                        curImageIndex=0;
                        content.validate();
                        content.repaint();
                    }
            }
    }

    class NextButtonListener implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		if(curImageIndex>=0 && curImageIndex < 3) {   
    				content.remove(0);
                    curImageIndex = curImageIndex + 1;
                    ImageIcon TheImage= myImages[curImageIndex];
                    content.add(new JLabel (TheImage));
                    content.validate();
                    content.repaint(); 
            }else {   
                    content.remove(0);
                    content.add(new JLabel (myImage4));
                    curImageIndex=3;
                    content.validate();
                    content.repaint();
            }
        }
    }
}