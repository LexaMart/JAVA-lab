import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {

    private double[] coefficients;
    private float[] coefficientsFloat;

    private double xBeg;
    private double xEnd;
    private double step;

    private float xBegF;
    private float xEndF;
    private float stepF;

    public GornerTableModel(double xBeg, double xEnd, double step, double[] coefficients, float[] coefficientsFloat, float xBegF, float xEndF, float stepF) {
        this.xBeg = xBeg;
        this.xEnd = xEnd;
        this.step = step;
        this.coefficients = coefficients;
        this.coefficientsFloat = coefficientsFloat;
        this.xBegF = xBegF;
        this.xEndF = xEndF;
        this.stepF = stepF;
    }

    @Override
    public int getRowCount() {
        return (int) (Math.ceil((xEnd - xBeg) / step) + 1);
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        double x = xBeg + rowIndex * step;
        double result = 0;
        float xF = xBegF + rowIndex * stepF;
        float resultFloat = 0;

        if (columnIndex == 1 || columnIndex == 3) {
            int i = coefficients.length - 1;
            result = coefficients[i--];
            while (i >= 0) {
                result = result * x + coefficients[i--];
            }
        }

        if (columnIndex == 2 || columnIndex == 3) {
            int i = coefficientsFloat.length - 1;
            resultFloat = coefficientsFloat[i--];
            while (i >= 0) {
                resultFloat = resultFloat * xF + coefficientsFloat[i--];
            }
        }

        switch (columnIndex) {
            case 0: {
                return x;
            }
            case 1: {
                return result;
            }
            case 2: {
                return resultFloat;
            }
            case 3: {
                return Math.abs(result - resultFloat);
            }
            default: {
                return 0;
            }
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: {
                return "Значение X";
            }
            case 1: {
                return "Значение многочлена по схеме Горнера";
            }
            case 2: {
                return "Значение многочлена по схеме Горнера с Float";
            }
            case 3: {
                return "Разница";
            }
            default: {
                return "";
            }
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Double.class;
    }

    public double getXBeg() {
        return xBeg;
    }

    public double getXEnd() {
        return xEnd;
    }

    public double getStep() {
        return step;
    }
}