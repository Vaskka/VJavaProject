/*
javac com/vaskka/learn/grammar/thread/thread.java
java com/vaskka/learn/grammar/thread/ThreadDome1
*/
package com.vaskka.learn.grammar.thread;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ThreadDome1 extends JFrame {

	JLabel countUpLabel   = new JLabel("Count Up!");
	JLabel countDownLabel = new JLabel("Count Down!");

	//implement multithread
	class CountUpThread extends Thread {
		public void run() {
			int count = 0;
			while (true) {
				try {
					sleep(1);
				}
				catch (InterruptedException e) {
				}

				if (count == 1000000) {
					count = 0;
				}
				countUpLabel.setText(Integer.toString(count++));
			}
		}
	} 

	//implement multithread
	class CountDownThread extends Thread {
		public void run() {
			int count = 1000000;
			while (true) {
				try {
					sleep(1);
				}
				catch (InterruptedException e) {
				} 

				if (count == 0) {
					count = 1000000;
				}
				countDownLabel.setText(Integer.toString(count--));

			}
		}
	}

	public ThreadDome1(String title) {
		super(title);
		init();
	}

	private void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new FlowLayout());
		this.add(countUpLabel);
		this.add(countDownLabel);
		this.pack();
		this.setVisible(true);

		(new CountUpThread()).start();
		(new CountDownThread()).start();
	}

	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		ThreadDome1 frame = new ThreadDome1("Thread Demo one");
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				constructGUI();
			}
		});

	}
}

