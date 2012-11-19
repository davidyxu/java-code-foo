package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LicensePlateCalculator extends JPanel implements ActionListener {
	protected JTextField textField;
	protected JTextArea textArea;
	int N = 0; int L = 0; int maxL = 0; int popSize = 0;
    double licenseSize = 0;
    double remainder = 0;
    String best = "";
    public LicensePlateCalculator() {
    	super(new GridBagLayout());
    	textField = new JTextField(30);
    	textField.addActionListener(this);

    	textArea = new JTextArea(5, 30);
    	textArea.setEditable(false);
    	JScrollPane scrollPane = new JScrollPane(textArea);

    	GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);

        greetings();
    }
    public boolean textCheck(String text) {
    	if (text == null || text.length() == 0)
    		return false;
    	for (int i = 0; i < text.length(); i++) {
    		if (!Character.isDigit(text.charAt(i)))
    			return false;
    	}
    	return true;
    }
    public void updateSize() {
    	licenseSize = Math.pow(10,N) * Math.pow(26,L);
    }
    public void updateBest() {
    	remainder = licenseSize- popSize;
    	best = Integer.toString(N) + " number digits and " + Integer.toString(L) + " alphabet digits. \n There is an excess of "
    		 + Double.toString(remainder) + " possible license plates.\n";
    }
    public String calculate() {
    	N=0; L=0; remainder = 0; updateSize(); maxL=0;
    	while (popSize> licenseSize) {
			L++; maxL++;
			updateSize();
		}
    	N=0; L=0; remainder = 0; updateSize();

    	while (popSize>licenseSize) {
    		N++;
    		updateSize();
    	}
    	updateBest();


    	while(L<maxL) {
    		L++;
    		updateSize();
    		while(licenseSize>=popSize && N>0){
    			N--;
    			updateSize();
    		}
    		if (licenseSize<popSize){
    			N++;
    			updateSize();
    		}
    		if (licenseSize - popSize <= remainder)	updateBest();
    	}
    	return best;
    }

    public void actionPerformed(ActionEvent evt) {
    	String text = textField.getText();
    		if (textCheck(text)){
    			popSize = Integer.parseInt(text);
    			textArea.append(calculate() + "\n");

    		}
    		else textArea.append("Please enter integer numbers only.\n");

   			textField.selectAll();
   			textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    public void greetings() {
    	double test = 56.750001;
    	test = test - test % 1;
    	NumberFormat integerFormat = new DecimalFormat("#");
    	textArea.append("Welcome to the License Plate Calculator.\n");
    	textArea.append("Please enter in a population size to calculate the minimum\nnumber of characters required on the license plate.\n\n");
    }
    private static void runGUI(){
    	JFrame frame = new JFrame("License Plate Calculator");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(new LicensePlateCalculator());

    	frame.pack();
    	frame.setVisible(true);
    }
    public static void main(String[] args) {
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
    		public void run() {
    			runGUI();
    		}
    	});
    }

}