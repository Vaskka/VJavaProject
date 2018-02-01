/*
javac com/vaskka/tool/counter/counter.java
java com/vaskka/tool/counter/Counter
*/

package com.vaskka.tool.counter;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Counter extends JFrame {
	
	JLabel  counterLabel  = new JLabel("Counter");
	JButton startButton   = new JButton("Start");
	JButton stopButton    = new JButton("Stop");
	JButton restartButton = new JButton("Restart");

	CounterThread thread = null;
	boolean stopped = true;
	float second = 0.000f;
	int minuate = 0;
	int hour = 0;

	class CounterThread extends Thread {
		public void run() {
			while (!stopped) {
				try{
					sleep(1);
				}
				catch (InterruptedException e) {
				}

				if (second == 60) {
					second = 0;
					minuate += 1;
				}
				if (minuate == 60) {
					minuate = 0;
					hour += 1;
				}
				second += 0.001;

				counterLabel.setText(Integer.toString(hour) + " " +
									 Integer.toString(minuate) + "' " +
									 Float.toString(second) + "\"");
			}

		}
	}

	public Counter(String title) {
		super(title);
		init();
	}

	private void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new FlowLayout());
		this.setSize(300, 300);
		this.stopButton.setEnabled(false);
		//the start action
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Counter.this.startButton.setEnabled(false);
				Counter.this.stopButton.setEnabled(true);
				Counter.this.restartButton.setEnabled(false);
				startThread();
			}
		});
		//the stop action
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Counter.this.startButton.setEnabled(true);
				Counter.this.stopButton.setEnabled(false);
				Counter.this.restartButton.setEnabled(true);
				stopThread();
			}
		});
		//the restart action
		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartThread();
			}
		});
		this.getContentPane().add(counterLabel);
		this.getContentPane().add(startButton);
		this.getContentPane().add(stopButton);
		this.getContentPane().add(restartButton);
		this.pack();
		this.setVisible(true);
	}

	public synchronized void startThread() {
		stopped = false;
		thread = new CounterThread();
		thread.start();
	}

	public synchronized void stopThread() {
		stopped = true;
	}

	public synchronized void restartThread() {
		second  = 0.000f;
		minuate = 0;
		hour    = 0;
		counterLabel.setText(Integer.toString(hour) + " " +
								 Integer.toString(minuate) + "' " +
								 Float.toString(second) + "\"");
	}

	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		Counter frame = new Counter("Counter");
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				constructGUI();
			}
		});
	}
}
