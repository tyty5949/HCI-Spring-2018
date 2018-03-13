/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ou.cs.hci.stages;

import edu.ou.cs.hci.resources.Resources;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author StoryTellr
 */
public class ScenarioFrame {
    
    public static ArrayList<String> scenTitles;
    public static ArrayList<String> scenDescriptions;
    
    private static JFrame frame;
    
    public static void makeScenarioFrame()
    {
        scenTitles = Resources.getLines("scenarios/titles.txt");
        scenDescriptions = Resources.getLines("scenarios/descriptions.txt");
        
        frame = new JFrame("Scenarios");
        
        JList scenTitleList = new JList();
        if (!scenTitles.isEmpty()) {
            scenTitleList.setListData(scenTitles.toArray());
        }
        scenTitleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JTextArea scenSummary = new JTextArea(30, 50);
        if (!scenDescriptions.isEmpty()) {
            scenSummary.setText(scenDescriptions.get(0));
        }
        scenSummary.setEditable(false);
        scenSummary.setLineWrap(true);
        scenSummary.setWrapStyleWord(true);
        
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(new JLabel("List of Titles"), BorderLayout.PAGE_START);
        leftPanel.add(scenTitleList, BorderLayout.CENTER);
        
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(new JLabel("Scenario Description"), BorderLayout.PAGE_START);
        rightPanel.add(scenSummary, BorderLayout.CENTER);
        
        //put the entire thing all together and display it
	frame.setBounds(1200, 50, 700, 400);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(leftPanel);
        frame.getContentPane().add(rightPanel);
        frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        scenTitleList.clearSelection();
        scenSummary.setRows(15);
        
	frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
		System.exit(0);
            }
	});
        
        scenTitleList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int index = scenTitleList.getSelectedIndex();
                scenSummary.setText(scenDescriptions.get(index));
            }
        });
    }
}
