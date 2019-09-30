/*
 * Created by JFormDesigner on Mon Mar 13 22:41:29 CET 2017
 */

package org.cave.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Sven Voler
 */
public class GameGui extends JPanel {
	public GameGui() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Sven Voler
		panel1 = new JPanel();
		scrollPane1 = new JScrollPane();
		roomInfoText = new JTextArea();
		label3 = new JLabel();
		label1 = new JLabel();
		label2 = new JLabel();
		navPanel = new JPanel();
		goNorthBtn = new JButton();
		goEastBtn = new JButton();
		goWestBtn = new JButton();
		goSouthBtn = new JButton();
		panel2 = new JPanel();
		backpackPanel = new JPanel();
		scrollPane2 = new JScrollPane();
		backpackList = new JList();
		dropBtn = new JButton();
		thingsPanel = new JPanel();
		scrollPane3 = new JScrollPane();
		thingsList = new JList();
		pickupBtn = new JButton();
		buttonsPanel = new JPanel();
		roomInfoBtn = new JButton();
		examineBtn = new JButton();
		openChestBtn = new JButton();
		helpBtn = new JButton();
		quitBtn = new JButton();

		//======== this ========

		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		//======== panel1 ========
		{
			panel1.setPreferredSize(new Dimension(900, 600));
			panel1.setBorder(new BevelBorder(BevelBorder.LOWERED));
			panel1.setMinimumSize(new Dimension(900, 500));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
			((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
			((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
			((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

			//======== scrollPane1 ========
			{

				//---- roomInfoText ----
				roomInfoText.setRows(10);
				roomInfoText.setColumns(1);
				roomInfoText.setMinimumSize(new Dimension(300, 200));
				roomInfoText.setDoubleBuffered(true);
				roomInfoText.setFont(new Font("Monospaced", Font.PLAIN, 20));
				roomInfoText.setLineWrap(true);
				scrollPane1.setViewportView(roomInfoText);
			}
			panel1.add(scrollPane1, new GridBagConstraints(0, 0, 7, 1, 1.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 10, 0), 0, 0));

			//---- label3 ----
			label3.setText("Navigation");
			label3.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panel1.add(label3, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 10, 10), 0, 0));

			//---- label1 ----
			label1.setText("Your backpack");
			label1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panel1.add(label1, new GridBagConstraints(2, 1, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 10, 10), 0, 0));

			//---- label2 ----
			label2.setText("Things in room");
			label2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panel1.add(label2, new GridBagConstraints(4, 1, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 10, 10), 0, 0));

			//======== navPanel ========
			{
				navPanel.setLayout(new BorderLayout());

				//---- goNorthBtn ----
				goNorthBtn.setText("North");
				goNorthBtn.setMinimumSize(new Dimension(120, 60));
				goNorthBtn.setMaximumSize(new Dimension(120, 60));
				goNorthBtn.setPreferredSize(new Dimension(120, 60));
				goNorthBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
				navPanel.add(goNorthBtn, BorderLayout.NORTH);

				//---- goEastBtn ----
				goEastBtn.setText("East");
				goEastBtn.setMinimumSize(new Dimension(120, 60));
				goEastBtn.setMaximumSize(new Dimension(120, 60));
				goEastBtn.setPreferredSize(new Dimension(120, 60));
				goEastBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
				navPanel.add(goEastBtn, BorderLayout.EAST);

				//---- goWestBtn ----
				goWestBtn.setText("West");
				goWestBtn.setMinimumSize(new Dimension(120, 60));
				goWestBtn.setMaximumSize(new Dimension(120, 60));
				goWestBtn.setPreferredSize(new Dimension(120, 60));
				goWestBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
				navPanel.add(goWestBtn, BorderLayout.WEST);

				//---- goSouthBtn ----
				goSouthBtn.setText("South");
				goSouthBtn.setMinimumSize(new Dimension(120, 60));
				goSouthBtn.setMaximumSize(new Dimension(120, 60));
				goSouthBtn.setPreferredSize(new Dimension(120, 60));
				goSouthBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
				navPanel.add(goSouthBtn, BorderLayout.SOUTH);

				//======== panel2 ========
				{
					panel2.setMinimumSize(new Dimension(60, 60));
					panel2.setLayout(null);
				}
				navPanel.add(panel2, BorderLayout.CENTER);
			}
			panel1.add(navPanel, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 10, 10), 0, 0));

			//======== backpackPanel ========
			{
				backpackPanel.setLayout(new GridLayout(2, 0));

				//======== scrollPane2 ========
				{

					//---- backpackList ----
					backpackList.setMinimumSize(new Dimension(47, 166));
					backpackList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					backpackList.setFont(new Font("Tahoma", Font.PLAIN, 20));
					scrollPane2.setViewportView(backpackList);
				}
				backpackPanel.add(scrollPane2);

				//---- dropBtn ----
				dropBtn.setText("Drop");
				dropBtn.setPreferredSize(new Dimension(150, 30));
				dropBtn.setMinimumSize(new Dimension(150, 30));
				dropBtn.setMaximumSize(new Dimension(250, 30));
				dropBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
				backpackPanel.add(dropBtn);
			}
			panel1.add(backpackPanel, new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 10, 10), 0, 0));

			//======== thingsPanel ========
			{
				thingsPanel.setLayout(new GridLayout(2, 0));

				//======== scrollPane3 ========
				{

					//---- thingsList ----
					thingsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					thingsList.setFont(new Font("Tahoma", Font.PLAIN, 20));
					scrollPane3.setViewportView(thingsList);
				}
				thingsPanel.add(scrollPane3);

				//---- pickupBtn ----
				pickupBtn.setText("Pickup");
				pickupBtn.setPreferredSize(new Dimension(150, 30));
				pickupBtn.setMinimumSize(new Dimension(150, 30));
				pickupBtn.setMaximumSize(new Dimension(250, 30));
				pickupBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
				thingsPanel.add(pickupBtn);
			}
			panel1.add(thingsPanel, new GridBagConstraints(4, 2, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 10, 10), 0, 0));

			//======== buttonsPanel ========
			{
				buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

				//---- roomInfoBtn ----
				roomInfoBtn.setText("Room info");
				roomInfoBtn.setMaximumSize(null);
				roomInfoBtn.setMinimumSize(null);
				roomInfoBtn.setPreferredSize(new Dimension(200, 60));
				roomInfoBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
				buttonsPanel.add(roomInfoBtn);

				//---- examineBtn ----
				examineBtn.setText("Examine room");
				examineBtn.setPreferredSize(new Dimension(200, 60));
				examineBtn.setMinimumSize(null);
				examineBtn.setMaximumSize(null);
				examineBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
				buttonsPanel.add(examineBtn);

				//---- openChestBtn ----
				openChestBtn.setText("Open chest");
				openChestBtn.setPreferredSize(new Dimension(200, 60));
				openChestBtn.setMinimumSize(null);
				openChestBtn.setMaximumSize(null);
				openChestBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
				openChestBtn.setEnabled(false);
				buttonsPanel.add(openChestBtn);

				//---- helpBtn ----
				helpBtn.setText("Help");
				helpBtn.setPreferredSize(new Dimension(120, 60));
				helpBtn.setMinimumSize(new Dimension(120, 60));
				helpBtn.setMaximumSize(new Dimension(120, 60));
				helpBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
				buttonsPanel.add(helpBtn);

				//---- quitBtn ----
				quitBtn.setText("Quit");
				quitBtn.setPreferredSize(new Dimension(120, 60));
				quitBtn.setMinimumSize(new Dimension(120, 60));
				quitBtn.setMaximumSize(new Dimension(120, 60));
				quitBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
				buttonsPanel.add(quitBtn);
			}
			panel1.add(buttonsPanel, new GridBagConstraints(0, 4, 7, 1, 4.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 0, 10, 0), 0, 0));
		}
		add(panel1);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Sven Voler
	private JPanel panel1;
	private JScrollPane scrollPane1;
	public JTextArea roomInfoText;
	private JLabel label3;
	private JLabel label1;
	private JLabel label2;
	private JPanel navPanel;
	public JButton goNorthBtn;
	public JButton goEastBtn;
	public JButton goWestBtn;
	public JButton goSouthBtn;
	private JPanel panel2;
	private JPanel backpackPanel;
	private JScrollPane scrollPane2;
	public JList backpackList;
	public JButton dropBtn;
	private JPanel thingsPanel;
	private JScrollPane scrollPane3;
	public JList thingsList;
	public JButton pickupBtn;
	private JPanel buttonsPanel;
	public JButton roomInfoBtn;
	public JButton examineBtn;
	public JButton openChestBtn;
	public JButton helpBtn;
	public JButton quitBtn;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
