package net.sf.openrocket.montecarloextension;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.Line;

public class MonteCarloLegacy extends JDialog {

	static List<Double> xInMetres = new ArrayList<Double>();
	static List<Double> yInMetres = new ArrayList<Double>();
	private static double xSD;
	private static double ySD;
	private static String filename = System.getProperty("user.home") + "/Desktop/openrocketdatafile.txt";

	private static String stDev = new File("").getAbsolutePath();

	public MonteCarloLegacy() {
		try {
			parseData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Double[] xPoints = new Double[xInMetres.size()];
		xPoints = xInMetres.toArray(xPoints);

		Double[] yPoints = new Double[yInMetres.size()];
		yPoints = yInMetres.toArray(yPoints);

		plot(xPoints, yPoints);
		try {
			String sdFilename = "/src/main/resources/stanDev.txt";
			printToFile(sdFilename, xPoints, yPoints);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Parses data from a text file and stores it into related arrays
	 * 
	 * @throws IOException
	 */
	public static void parseData() throws IOException {
		File data = new File(filename);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(data));

			String line;

			while ((line = reader.readLine()) != null) {
				String[] split = line.split(",");

				double x = Double.parseDouble(split[0]);
				double y = Double.parseDouble(split[1]);

				xInMetres.add(x);
				yInMetres.add(y);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Plotting method. Plots a scatter plot to a JFrame.
	 * 
	 * @param xPoints
	 * @param yPoints
	 */
	public static void plot(Double[] xPoints, Double[] yPoints) {
		Plot2DPanel plot = new Plot2DPanel();
		double[] X = new double[xPoints.length];
		double[] Y = new double[yPoints.length];
		double[] xSdArray = new double[xPoints.length];
		double[] ySdArray = new double[yPoints.length];
		double[] sumX = new double[1];
		double[] sumY = new double[1];
		sumX[0] = 0.0;
		sumY[0] = 0.0;

		// monte carlo plot
		Double maxX = -8.018601452817755;
		Double minX = -8.018601452817755;
		for (int i = 0; i < xPoints.length; i++) {
			Double d = xPoints[i];
			double d2 = d.doubleValue();
			sumX[0] += d2;
			X[i] = d2;
			if (d2 > maxX) {
				maxX = d2;
			}
			if (d2 < minX) {
				minX = d2;
			}
		}
		Double minY = -6.360190554893407E-5;
		Double maxY = -6.360190554893407E-5;
		for (int i = 0; i < yPoints.length; i++) {
			Double d = yPoints[i];
			double d2 = d.doubleValue();
			sumY[0] += d2;
			Y[i] = d2;
			if (d2 < minY) {
				minY = d2;
			}
			if (d2 > maxY) {
				maxY = d2;
			}
		}



		// standard deviation plot
		xSD = calculateSD(X);
		ySD = calculateSD(Y);

		for (int i = 0; i < xPoints.length; i++) {
			Double d = xPoints[i] * xSD;
			double d2 = d.doubleValue();
			xSdArray[i] = d2;
		}
		for (int i = 0; i < yPoints.length; i++) {
			Double d = yPoints[i] * ySD;
			double d2 = d.doubleValue();
			ySdArray[i] = d2;
//			System.out.println("ySD points: "+d+"");
		}

		// calculate mean
		sumX[0] = sumX[0] / X.length;
		sumY[0] = sumY[0] / Y.length;

		System.out.println("Plotting points...");

		plot.addScatterPlot("Simulations", Color.BLUE, X, Y); // monte carlo plot
		plot.addScatterPlot("Mean", Color.RED, sumX, sumY); // mean
		// plot.addScatterPlot("Standard Dev", Color.GREEN, xSdArray, ySdArray); //
		// standard deviation applied plot

		// code for legend
		plot.addLegend("SOUTH");
		Line l = new Line(Color.red, new double[] { minX, minY }, new double[] { maxX, maxY });
		// plot.addPlotable(l);

		JFrame frame = new JFrame("Monte Carlo");
		frame.setSize(500, 500);

		// sets the screen at the centre
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);

		frame.setContentPane(plot);

		// set the screen at the top of the window
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.NORMAL);
		System.out.println("Plotting successfully completed");
	}

	/**
	 * Calculates the standard deviation of the array values.
	 * 
	 * @param numArray
	 * @return standard deviation number
	 */
	public static double calculateSD(double numArray[]) {
		System.out.println("Calculating standard deviation...");
		double sum = 0.0, standardDeviation = 0.0;
		int length = numArray.length;

		for (double num : numArray) {
			sum += num;
		}

		double mean = sum / length;

		for (double num : numArray) {
			standardDeviation += Math.pow(num - mean, 2);
		}

//		System.out.println("Standard deviation");
//		System.out.println(Math.sqrt(standardDeviation / length));
		System.out.println("Calculations finished");
		return Math.sqrt(standardDeviation / length);

	}

	/**
	 * Prints the standard deviation arrays to a csv text file.
	 * 
	 * @param fileName
	 * @param xPoints
	 * @param yPoints
	 * @throws IOException
	 */
	public static void printToFile(String fileName, Double[] xPoints, Double[] yPoints) throws IOException {
		System.out.println("Creating and printing to file...");

		BufferedWriter writer = null;
		stDev = stDev.concat(fileName);
		File f = new File(stDev);
		writer = new BufferedWriter(new FileWriter(f));
		for (int i = 0; i < xPoints.length; i++) {
			Double x = xPoints[i] * xSD;
			Double y = yPoints[i] * ySD;

//        	System.out.println("Printing...");
			writer.append(x + "," + y + "\n");
//			System.out.println(x + "," + y);

		}

		writer.close();
		System.out.println("File printing completed");

	}
}
