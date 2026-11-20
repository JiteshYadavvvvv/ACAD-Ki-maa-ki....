
import javax.swing.*;

class RetailPrice extends JFrame {
    JTextField cost, markup;
    JLabel result;

    RetailPrice() {
        setTitle("Retail Price Calculator");
        setLayout(null);

        JLabel l1 = new JLabel("Wholesale Cost:");
        l1.setBounds(30, 30, 120, 30);
        add(l1);

        cost = new JTextField();
        cost.setBounds(160, 30, 120, 30);
        add(cost);

        JLabel l2 = new JLabel("Markup Percentage:");
        l2.setBounds(30, 80, 120, 30);
        add(l2);

        markup = new JTextField();
        markup.setBounds(160, 80, 120, 30);
        add(markup);

        JButton b = new JButton("Calculate");
        b.setBounds(100, 130, 120, 30);
        add(b);

        result = new JLabel("Retail Price:");
        result.setBounds(30, 180, 250, 30);
        add(result);

        b.addActionListener(e -> {
            double c = Double.parseDouble(cost.getText());
            double m = Double.parseDouble(markup.getText());
            double price = c + (c * m / 100);
            result.setText("Retail Price: ₹" + price);
        });

        setSize(350, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RetailPrice();
    }
}
