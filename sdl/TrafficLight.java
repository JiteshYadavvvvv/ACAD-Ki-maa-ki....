
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TrafficLight extends JFrame implements ActionListener
{
    JRadioButton red, yellow, green;
    ButtonGroup bg;
    SignalPanel signal;

    TrafficLight()
    {
        setTitle("Traffic Light System");
        setLayout(new BorderLayout(10, 10));

        red = new JRadioButton("Red");
        yellow = new JRadioButton("Yellow");
        green = new JRadioButton("Green");

        bg = new ButtonGroup();
        bg.add(red);
        bg.add(yellow);
        bg.add(green);

        JPanel buttons = new JPanel();
        buttons.add(red);
        buttons.add(yellow);
        buttons.add(green);

        add(buttons, BorderLayout.NORTH);

        signal = new SignalPanel();
        signal.setPreferredSize(new Dimension(300, 400));
        signal.setBackground(Color.WHITE);

        add(signal, BorderLayout.CENTER);

        red.addActionListener(this);
        yellow.addActionListener(this);
        green.addActionListener(this);

        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == red)
            signal.setLight(1);

        else if(e.getSource() == yellow)
            signal.setLight(2);

        else if(e.getSource() == green)
            signal.setLight(3);
    }

    class SignalPanel extends JPanel
    {
        int light = 0;

        void setLight(int n)
        {
            light = n;
            repaint();
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            g.setColor(Color.BLACK);
            g.fillRoundRect(100, 30, 100, 300, 30, 30);

            if(light == 1)
                g.setColor(Color.RED);
            else
                g.setColor(Color.GRAY);

            g.fillOval(120, 50, 60, 60);

            if(light == 2)
                g.setColor(Color.YELLOW);
            else
                g.setColor(Color.GRAY);

            g.fillOval(120, 140, 60, 60);

            if(light == 3)
                g.setColor(Color.GREEN);
            else
                g.setColor(Color.GRAY);

            g.fillOval(120, 230, 60, 60);
        }
    }

    public static void main(String args[])
    {
        new TrafficLight();
    }
}
