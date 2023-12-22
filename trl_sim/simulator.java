import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class simulator extends JButton{
    private JFrame frame;
    private JButton startBtn,stopBtn,NGrBtn,NYBtn,NRdBtn,
    EGrBtn,EYBtn,ERdBtn,SGrBtn,SYBtn,SRdBtn,WGrBtn,WYBtn,WRdBtn;

    private int remainingTime = 140;
    private Timer timer;
    private JLabel timesDisplay,sign,imgLabel;
    private JPanel panel,signPanel;
    private ImageIcon image;

    public simulator() {
        frame = new JFrame();
        frame.setTitle("Java Swing".toUpperCase());
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(getLayout());
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);
        //image
        image = new ImageIcon("images/intersection.png");
        imgLabel = new JLabel(image);
        setLabelBounds(imgLabel, 25, 190);
        imgLabel.setBackground(new Color(0, 0, 0, 0));

        //label text
        sign = new JLabel("Traffic Light Simulator System".toUpperCase());
        sign.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 28));
        sign.setForeground(Color.YELLOW);

        //panel for add sign components
        signPanel = new JPanel();
        signPanel.setLayout(new GridBagLayout());
        signPanel.setBackground(Color.GRAY);
        setPanelBounds(signPanel, 100, 10);
        signPanel.add(sign);

        //time display
        timesDisplay = new JLabel(("Remaining Times: "+ remainingTime + " Seconds").toUpperCase());
        timesDisplay.setForeground(Color.ORANGE);
        timesDisplay.setFont(new Font("TIMES NEW ROMAN", Font.BOLD,28));

        //panel for add time display components
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.DARK_GRAY);
        setPanelBounds(panel, 100, 70);
        panel.add(timesDisplay);

        //Northern Lights
        NGrBtn = new JButton();
        NYBtn = new JButton();
        NRdBtn = new JButton();
        setButtonBounds(NGrBtn, 250, 137);
        setButtonBounds(NYBtn, 350, 137);
        setButtonBounds(NRdBtn, 450, 137);

        //Eastern Lights
        EGrBtn = new JButton();
        EYBtn = new JButton();
        ERdBtn = new JButton();
        setButtonBounds(EGrBtn, 635, 200);
        setButtonBounds(EYBtn, 635, 270);
        setButtonBounds(ERdBtn, 635, 340);

        //Southern Lights
        SGrBtn = new JButton();
        SYBtn = new JButton();
        SRdBtn = new JButton();
        setButtonBounds(SGrBtn, 250, 445);
        setButtonBounds(SYBtn, 350, 445);
        setButtonBounds(SRdBtn, 450, 445);

        //Wester Lights
        WGrBtn = new JButton();
        WYBtn = new JButton();
        WRdBtn = new JButton();
        setButtonBounds(WGrBtn, 35, 200);
        setButtonBounds(WYBtn, 35, 270);
        setButtonBounds(WRdBtn, 35, 340);

        //Action Button
        startBtn = new JButton("Start".toUpperCase());
        stopBtn = new JButton("Stop".toUpperCase());
        startBtn.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
        stopBtn.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
        setButtonBounds(startBtn, 650, 440);
        setButtonBounds(stopBtn, 650, 500);

        //timer
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateLights();
            }

        });

        //Start Button Action
        startBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
            
        });

        //Stop Button Action
        stopBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
            
        });
    }
    //display button position function
    private void setButtonBounds(JButton button,int x, int y){
        button.setBounds(x, y, 80, 50);
        frame.add(button);
    }
     //display panel position function
     private void setPanelBounds(JPanel panelB,int x, int y){
        panelB.setBounds(x, y, 600, 50);
        frame.add(panelB);
    }

    //Label position
    private void setLabelBounds(JLabel label,int x, int y){
        label.setBounds(x, y, 700, 250);
        frame.add(label);
    }
    //update lights2
    private void updateLights(){
        if (remainingTime <= 140 && remainingTime >= 110) {
            setLightsColor();
            NGrBtn.setBackground(Color.GREEN);
            SRdBtn.setBackground(Color.RED);
            ERdBtn.setBackground(Color.RED);
            WRdBtn.setBackground(Color.RED);
        } else if (remainingTime <= 110 && remainingTime >= 105) {
            setLightsColor();
            NYBtn.setBackground(Color.YELLOW);
            SRdBtn.setBackground(Color.RED);
            ERdBtn.setBackground(Color.RED);
            WRdBtn.setBackground(Color.RED);
        }else if (remainingTime <= 105 && remainingTime >= 75) {
            setLightsColor();
            EGrBtn.setBackground(Color.GREEN);
            NRdBtn.setBackground(Color.RED);
            SRdBtn.setBackground(Color.RED);
            WRdBtn.setBackground(Color.RED);
        }else if (remainingTime <= 75 && remainingTime >= 70) {
            setLightsColor();
            EYBtn.setBackground(Color.YELLOW);
            NRdBtn.setBackground(Color.RED);
            SRdBtn.setBackground(Color.RED);
            WRdBtn.setBackground(Color.RED);
        }else if (remainingTime <= 70 && remainingTime >= 40) {
            setLightsColor();
            SGrBtn.setBackground(Color.GREEN);
            NRdBtn.setBackground(Color.RED);
            WRdBtn.setBackground(Color.RED);
            ERdBtn.setBackground(Color.RED);
        }else if (remainingTime <= 40 && remainingTime >= 35) {
            setLightsColor();
            SYBtn.setBackground(Color.YELLOW);
            NRdBtn.setBackground(Color.RED);
            WRdBtn.setBackground(Color.RED);
            ERdBtn.setBackground(Color.RED);
        }else if (remainingTime <= 35 && remainingTime >= 5) {
            setLightsColor();
            WGrBtn.setBackground(Color.GREEN);
            NRdBtn.setBackground(Color.RED);
            SRdBtn.setBackground(Color.RED);
            ERdBtn.setBackground(Color.RED);
        }else if (remainingTime <= 5 && remainingTime >= 0) {
            setLightsColor();
            WYBtn.setBackground(Color.YELLOW);
            NRdBtn.setBackground(Color.RED);
            SRdBtn.setBackground(Color.RED);
            ERdBtn.setBackground(Color.RED);
        }
        timesDisplay.setText("Remaining Times: " + remainingTime +" seconds");

        remainingTime--;
        if (remainingTime <= 0) {
            remainingTime = 140;
        }
    }

    //color set
    private void setLightsColor() {
        NGrBtn.setBackground(Color.GRAY);
        NYBtn.setBackground(Color.GRAY);
        NRdBtn.setBackground(Color.GRAY);

        EGrBtn.setBackground(Color.GRAY);
        EYBtn.setBackground(Color.GRAY);
        ERdBtn.setBackground(Color.GRAY);

        SGrBtn.setBackground(Color.GRAY);
        SYBtn.setBackground(Color.GRAY);
        SRdBtn.setBackground(Color.GRAY);

        WGrBtn.setBackground(Color.GRAY);
        WYBtn.setBackground(Color.GRAY);
        WRdBtn.setBackground(Color.GRAY);
    }
}
