import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class GornerTableCellRenderer implements TableCellRenderer {

    private String requiredValue;

    private boolean coolSearch;

    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JLabel imgLabel = new JLabel();

    private DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();

    {
        formatter.setMaximumFractionDigits(6);
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols curSymbol = formatter.getDecimalFormatSymbols();
        curSymbol.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(curSymbol);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String formattedValue = formatter.format(value);
        double a = Double.parseDouble(formattedValue);

        label.setText(formattedValue);
        panel.add(label);
        ImageIcon icon = new ImageIcon(new ImageIcon(GornerTableCellRenderer.class.getResource("flag.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
        imgLabel.setIcon(icon);


        if (coolSearch && isPalindrome(formattedValue)) panel.setBackground(Color.GREEN);
        else if (requiredValue != null && requiredValue.equals(formattedValue)) panel.add(imgLabel);
        else {
            panel.setBackground(Color.white);
            panel.remove(imgLabel);
        };

        return panel;
    }

    public void setRequiredValue(String requiredValue) {
        this.requiredValue = requiredValue;
    }

    public void setCoolSearch(boolean coolSearch) {
        this.coolSearch = coolSearch;
    }

    public DecimalFormat getFormatter() {
        return formatter;
    }

    private boolean isPalindrome(String value){
        String valueToUse = value;
        if (valueToUse.indexOf('.') != -1) {
            int index = valueToUse.indexOf('.');
            valueToUse = value.substring(0, index) + value.substring(index + 1);
        }
        String reversedValue = new StringBuilder(valueToUse).reverse().toString();

        int num = Integer.parseInt(valueToUse);
        int numRev = Integer.parseInt(reversedValue);
        System.out.println(num);
        System.out.println(numRev);
        if (num == numRev) {
            return true;
        }
        return false;
    }

    public static boolean isPrime(final int i) {
        if (i<=1)
            return false;
        else if (i <=3)
            return true;
        else if (i%2==0 || i %3 ==0)
            return false;
        int n = 5;
        while (n*n <=i){
            if (i % n ==0 || i % (n+2) == 0)
                return false;
            n=n+6;
        }
        return true;
    }
}