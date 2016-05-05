package Alarm;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

import java.awt.Color;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import com.javadude.annotation.Default; 



public class AddAlarms extends JFrame implements ActionListener{

	private Mainform parent = null; //parent frame
	int parentNum=-1;// initialize
	private JPanel contentPane;
	private JCheckBox ckbox_onoff;
	private JTextField textField_AlarmName;
	private JTextField textField_MusicPath;
	private JButton btn_ChooseSong;
	private JCheckBox ckbox_Repeat;
	private JPanel panel;
	private JSpinner spinner_H;
	private JSpinner spinner_Day;
	private JSpinner spinner_M;
	private JButton btn_Save;
	private JButton btn_Cancel;
	private JLabel lblTo;
	private JTextField textField_FromCal;
	private JTextField textField_ToCal;
	private JCheckBox ckbox_M;
	private JCheckBox ckbox_Tue;
	private JCheckBox ckbox_W;
	private JCheckBox ckbox_Thu;
	private JCheckBox ckbox_F;
	private JCheckBox ckbox_Sat;
	private JCheckBox ckbox_Sun;
	private JButton btn_CalendarTo;
	private JButton btn_CalendarFrom;
	

	
	public AddAlarms(Mainform parent)
	{
	 new AddAlarms(parent,"","","","","","","",false,false,false,false,false,false,false,false,false,-1); // to initialize
	}
	/**
	 * @wbp.parser.constructor
	 */
	public AddAlarms(final Mainform parent,  String AlarmName,String spinner_H_Check, String spinner_M_Check,  
			String spinner_Day_Check,  String textField_FromCal_Check,  String textField_ToCal_Check,  String textField_MusicPath,
			boolean ckbox_M_Check ,   boolean ckbox_Tue_Check,  boolean ckbox_W_Check,  boolean ckbox_Thu_Check, boolean ckbox_F_Check,
			boolean ckbox_Sat_Check ,  boolean ckbox_Sun_Check ,  boolean ckbox_onoff_Check,  boolean ckbox_Repeat_Check,int ParentNum
			) { // create form... (get Parameter from parent)
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				parent.setVisible(true); // this form close - > parent visible
			}
		});
		
		this.parent = parent; //set parent
		this.parentNum = ParentNum; //set parent number
		setTitle("Set Alarm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 585, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ckbox_onoff = new JCheckBox("On/Off");
		ckbox_onoff.setBounds(36, 35, 161, 29);
		contentPane.add(ckbox_onoff);
		
		textField_AlarmName = new JTextField();
		textField_AlarmName.setBounds(36, 75, 244, 27);
		contentPane.add(textField_AlarmName);
		textField_AlarmName.setColumns(10);
		
		this.textField_MusicPath = new JTextField();
		this.textField_MusicPath.setEditable(false);
		this.textField_MusicPath.setBounds(36, 117, 244, 27);
		contentPane.add(this.textField_MusicPath);
		this.textField_MusicPath.setColumns(10);
		this.textField_MusicPath.setBackground(Color.WHITE);
		
		
		btn_ChooseSong = new JButton("Choose Song");
		btn_ChooseSong.setBounds(297, 116, 188, 29);
		contentPane.add(btn_ChooseSong);
		btn_ChooseSong.addActionListener(this);
		
		ckbox_Repeat = new JCheckBox("Repeat");
		ckbox_Repeat.addChangeListener(new ChangeListener() { //
			public void stateChanged(ChangeEvent arg0) {
				if(ckbox_Repeat.isSelected()) //if ckbox checked
				{
					textField_FromCal.setBackground(Color.WHITE); //change color
					textField_ToCal.setBackground(Color.WHITE);
					
					ckbox_M.setEnabled(true); // enable repeat datas...
					ckbox_Tue.setEnabled(true);
					ckbox_W.setEnabled(true);
					ckbox_Thu.setEnabled(true);
					ckbox_F.setEnabled(true);
					ckbox_Sat.setEnabled(true);
					ckbox_Sun.setEnabled(true);		
				}
				
				else//if not checked
				{
					textField_FromCal.setBackground(Color.LIGHT_GRAY); // unable color...
					textField_ToCal.setBackground(Color.LIGHT_GRAY);
					
					textField_FromCal.setText("");
					textField_ToCal.setText("");
					
					ckbox_M.setEnabled(false);
					ckbox_Tue.setEnabled(false);
					ckbox_W.setEnabled(false);
					ckbox_Thu.setEnabled(false);
					ckbox_F.setEnabled(false);
					ckbox_Sat.setEnabled(false);
					ckbox_Sat.setEnabled(false);
					
					ckbox_M.setSelected(false);
					ckbox_Tue.setSelected(false);
					ckbox_W.setSelected(false);
					ckbox_Thu.setSelected(false);
					ckbox_F.setSelected(false);
					ckbox_Sat.setSelected(false);
					ckbox_Sun.setSelected(false);
				}
			}
		});
		ckbox_Repeat.setBounds(36, 179, 161, 29);
		contentPane.add(ckbox_Repeat);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(36, 219, 493, 107);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblTo = new JLabel("to");
		lblTo.setBounds(242, 15, 38, 21);
		panel.add(lblTo);
		
		textField_FromCal = new JTextField();
		textField_FromCal.setBackground(Color.LIGHT_GRAY);
		textField_FromCal.setEditable(false);
		textField_FromCal.setBounds(17, 12, 128, 27);
		panel.add(textField_FromCal);
		textField_FromCal.setColumns(10);
		
		textField_ToCal = new JTextField();
		textField_ToCal.setBackground(Color.LIGHT_GRAY);
		textField_ToCal.setEditable(false);
		textField_ToCal.setColumns(10);
		textField_ToCal.setBounds(290, 12, 128, 27);
		panel.add(textField_ToCal);
		
		ckbox_M = new JCheckBox("M");
		ckbox_M.setEnabled(false);
		ckbox_M.setBounds(17, 50, 56, 29);
		panel.add(ckbox_M);
		
		ckbox_Tue = new JCheckBox("T");
		ckbox_Tue.setEnabled(false);
		ckbox_Tue.setBounds(82, 50, 56, 29);
		panel.add(ckbox_Tue);
		
		ckbox_W = new JCheckBox("W");
		ckbox_W.setEnabled(false);
		ckbox_W.setBounds(147, 50, 56, 29);
		panel.add(ckbox_W);
		
		ckbox_Thu = new JCheckBox("T");
		ckbox_Thu.setEnabled(false);
		ckbox_Thu.setBounds(212, 50, 56, 29);
		panel.add(ckbox_Thu);
		
		ckbox_F = new JCheckBox("F");
		ckbox_F.setEnabled(false);
		ckbox_F.setBounds(281, 50, 52, 29);
		panel.add(ckbox_F);
		
		ckbox_Sat = new JCheckBox("S");
		ckbox_Sat.setEnabled(false);
		ckbox_Sat.setBounds(346, 50, 56, 29);
		panel.add(ckbox_Sat);
		
		ckbox_Sun = new JCheckBox("S");
		ckbox_Sun.setEnabled(false);
		ckbox_Sun.setBounds(411, 50, 56, 29);
		panel.add(ckbox_Sun);
		
		
		
		btn_CalendarTo = new JButton("ㅁ"); // Calendar btn
		btn_CalendarTo.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
				if(ckbox_Repeat.isSelected()) //repeat checked...
				{
				SwingCalender s1 = new SwingCalender(AddAlarms.this,1); // create new form Calendar, parameter 1 -> toData
				}
				
				else{//not checked...
					JOptionPane.showMessageDialog(null,"If You want to Repeat Calendar , \n please check Repeat!");
				}
				
				 
			}
		});
		btn_CalendarTo.setBounds(151, 11, 52, 29);
		panel.add(btn_CalendarTo);
		
		btn_CalendarFrom = new JButton("ㅁ");
		btn_CalendarFrom.addActionListener(new ActionListener() { // same... upper calender , but this set from data
			public void actionPerformed(ActionEvent e) {
				
				
				if(ckbox_Repeat.isSelected())
				{
				SwingCalender s1 = new SwingCalender(AddAlarms.this,2); // parameter 2 -> fromdata
				}
				
				else{
					JOptionPane.showMessageDialog(null,"please check Repeat!");
				}
			}
		});
		btn_CalendarFrom.setBounds(435, 11, 52, 29);
		panel.add(btn_CalendarFrom);
		
		spinner_H = new JSpinner();
		spinner_H.setModel(new SpinnerNumberModel(0, 0, 11, 1));
		spinner_H.setBounds(297, 74, 48, 28);
		contentPane.add(spinner_H);
		
		spinner_Day = new JSpinner();
		spinner_Day.setModel(new SpinnerListModel(new String[] {"A.M", "P.M"}));
		spinner_Day.setBounds(423, 75, 62, 28);
		contentPane.add(spinner_Day);
		
		spinner_M = new JSpinner();
		spinner_M.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_M.setBounds(362, 75, 48, 28);
		contentPane.add(spinner_M);
		
		btn_Save = new JButton("Save");
		btn_Save.setBounds(36, 341, 125, 29);
		contentPane.add(btn_Save);
		btn_Save.addActionListener(this);
		
		btn_Cancel = new JButton("Cancel");
		btn_Cancel.addActionListener(new ActionListener() {//Cancelbtn... 
			public void actionPerformed(ActionEvent e) {
				parent.setVisible(true); //parent show
				dispose(); // this dipose
			}
		});
		
		
		//initialize form data get parameter from parent
		this.ckbox_onoff.setSelected(ckbox_onoff_Check);
		this.textField_AlarmName.setText(AlarmName);
		this.textField_MusicPath.setText(textField_MusicPath);
		if(spinner_M_Check.equals(""))
		{
			this.spinner_H.setValue(0);
		}
		else
			this.spinner_H.setValue(Integer.parseInt(spinner_H_Check));
		
		if(spinner_M_Check.equals(""))
		{
			this.spinner_M.setValue(0);
		}
		else
			this.spinner_M.setValue(Integer.parseInt(spinner_M_Check));
		
		if(spinner_Day_Check.equals(""))
		{
			this.spinner_Day.setValue("A.M");
		}
		else
			this.spinner_Day.setValue(spinner_Day_Check);
		
		this.ckbox_Repeat.setSelected(ckbox_Repeat_Check);
		this.textField_FromCal.setText(textField_FromCal_Check);
		this.textField_ToCal.setText(textField_ToCal_Check);
		this.ckbox_M.setSelected(ckbox_M_Check);
		this.ckbox_Tue.setSelected(ckbox_Thu_Check);
		this.ckbox_W.setSelected(ckbox_W_Check);
		this.ckbox_Thu.setSelected(ckbox_Thu_Check);
		this.ckbox_F.setSelected(ckbox_F_Check);
		this.ckbox_Sat.setSelected(ckbox_Sat_Check);
		this.ckbox_Sun.setSelected(ckbox_Sun_Check);
		
		btn_Cancel.setBounds(404, 341, 125, 29);
		contentPane.add(btn_Cancel);
		setVisible(true);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource() == btn_ChooseSong) //select mp3 file
		{System.out.print("File Open Clicked \n");
			JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter( "Music(mp3)", "mp3"); // restriction mmp3
			fc.setFileFilter(filter);
			int returnVal = fc.showOpenDialog(this); // dialog
			
			
			if( returnVal == JFileChooser.APPROVE_OPTION) //open data...
			{
				FileReader fr; //to read file path
				try{
				File file = fc.getSelectedFile();
				//Path path = Paths.get(file.getAbsolutePath());
				
				fr= new FileReader(file.getAbsolutePath());
				textField_MusicPath.setText("");
				
				textField_MusicPath.setText(file.getAbsolutePath()); // set Music path
				
				}
				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}				
			}
			
		}//end of file select
		
		if(e.getSource() == btn_Save)//click save btn..
		{
			
			
			System.out.print("Save Button Clicked \n");
			
			
			if(textField_AlarmName.getText().toString().equals("")) //if not input alarm name
			{
				System.out.print("알람제목 없음 \n");
				JOptionPane.showMessageDialog(null,"please input Alarm Name!");
			}
			
			else if(textField_MusicPath.getText().toString().equals(""))//if not input alarm music
			{
				System.out.print("알람음악 없음 \n");
				JOptionPane.showMessageDialog(null,"please Setting Alarm Music!");
			}
			
			else if(ckbox_Repeat.isSelected()) // if checked reapear
			{
			
				 if(textField_FromCal.getText().toString().equals(""))
				{
					System.out.print("알람시작일 없음(no Alarm From date) \n"); // //if not input alarm Start date
					JOptionPane.showMessageDialog(null,"please Alarm Start Day!");
				}
				else if(textField_ToCal.getText().toString().equals(""))
				{
					System.out.print("알람종료일 없음(no Alarm To date) \n"); // if not alarm to date
					JOptionPane.showMessageDialog(null,"please Alarm End Day!");
				}
				else if ((ckbox_M.isSelected() || 
						ckbox_Thu.isSelected() ||
						ckbox_W.isSelected() ||
						ckbox_Thu.isSelected() ||
						ckbox_F.isSelected() ||
						ckbox_Sat.isSelected() ||
						ckbox_Sun.isSelected()) == false)
				{
					JOptionPane.showMessageDialog(null,"please select Alarm  Day!"); ////if not input alarm day
				} else
					try {
						SetMain();// set Data this form -> parent form
					} catch (IOException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
			}
			}

			else // just select alarm time
			{
				try {
					SetMain();// set Data this form -> parent form
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	
		}
	}
	//set and get func
	public void setCalendar_To(String val)
	{
		textField_ToCal.setText(val+"");
		
	}
	
	public void setCalendar_From(String val)
	{
		textField_FromCal.setText(val+"");
	}
	
	public void setTestBox(
			String AlarmName,String spinner_H_Check,String spinner_M_Check,  
			String spinner_Day_Check, String textField_FromCal_Check, String textField_ToCal_Check,String textField_MusicPath,
			boolean  ckbox_M_Check , boolean  ckbox_Tue_Check, boolean ckbox_W_Check,boolean ckbox_Thu_Check ,
			boolean ckbox_F_Check,
			boolean ckbox_Sat_Check , boolean ckbox_Sun_Check , boolean ckbox_onoff_Check, boolean ckbox_Repeat_Check
			)
	{
		
		parent.setTestBox(
				AlarmName,spinner_H_Check,spinner_M_Check,
				spinner_Day_Check,textField_FromCal_Check,textField_ToCal_Check,textField_MusicPath,
				ckbox_M_Check,ckbox_Tue_Check,ckbox_W_Check,
				ckbox_Thu_Check,ckbox_F_Check,ckbox_Sat_Check,ckbox_Sun_Check,ckbox_onoff_Check,ckbox_Repeat_Check
				);
	}
	
    public void getMusicPath()
    {
 	   
    }
    
    //Set Main form(add alarm) From this form datas...
    public void SetMain() throws IOException
    {
    	//variables...
    	String AlarmName;
		String spinner_H_Check;			//Hour
		String spinner_M_Check;			//minute
		String spinner_Day_Check;		//A.M or P.M
		String textField_FromCal_Check;	//from Date
		String textField_ToCal_Check;	//To Date
		String textField_MusicPath;		//music file path.
		boolean ckbox_M_Check;
		boolean ckbox_Tue_Check;
		boolean ckbox_W_Check;
		boolean ckbox_Thu_Check;
		boolean ckbox_F_Check;
		boolean ckbox_Sat_Check;
		boolean ckbox_Sun_Check;
		boolean ckbox_onoff_Check;		//on Or off
		boolean ckbox_Repeat_Check;		//Repeat
		
		
		// set Data ....
		AlarmName= this.textField_AlarmName.getText();	
		spinner_H_Check = spinner_H.getValue().toString();
		spinner_M_Check = spinner_M.getValue().toString();
		spinner_Day_Check = spinner_Day.getValue().toString();
		textField_FromCal_Check = textField_FromCal.getText();
		textField_ToCal_Check = textField_ToCal.getText();
		textField_MusicPath = this.textField_MusicPath.getText();
		ckbox_M_Check = ckbox_M.isSelected();
		ckbox_Tue_Check = ckbox_Tue.isSelected();
		ckbox_W_Check = ckbox_W.isSelected();
		ckbox_Thu_Check = ckbox_Thu.isSelected();
		ckbox_F_Check = ckbox_F.isSelected();
		ckbox_Sat_Check = ckbox_Sat.isSelected();
		ckbox_Sun_Check = ckbox_Sun.isSelected();
		ckbox_onoff_Check = ckbox_onoff.isSelected();
		ckbox_Repeat_Check = ckbox_Repeat.isSelected();
		
		//to print test 
		System.out.println("AlarmName is: " + AlarmName);
		System.out.print("spinner_H_Check:"+spinner_H_Check+"\n");
		System.out.print("spinner_M_Check:"+spinner_M_Check+"\n");
		System.out.print("spinner_Day_Check:"+spinner_Day_Check+"\n");
		System.out.print("textField_FromCal_Check:"+textField_FromCal_Check+"\n");
		System.out.print("textField_ToCal_Check:"+textField_ToCal_Check+"\n");
		
		if(this.parentNum==-1){ //if Initial Create...
		setTestBox(
				AlarmName,spinner_H_Check,spinner_M_Check,
				spinner_Day_Check,textField_FromCal_Check,textField_ToCal_Check,textField_MusicPath,
				ckbox_M_Check,ckbox_Tue_Check,ckbox_W_Check,
				ckbox_Thu_Check,ckbox_F_Check,ckbox_Sat_Check,ckbox_Sun_Check,ckbox_onoff_Check,ckbox_Repeat_Check
				);
		System.out.print("==============parentNum -1 ====================");
		parent.ShowAlamArr();
		parent.setVisible(true);
		//parent.removeAll();
		dispose();
		}
		
		else //adjust alarm
		{
			System.out.print("now editting control num is: "+ this.parentNum+"\n" );
			parent.setAlarmName(parentNum,AlarmName);
			parent.setSpinner_H_Check(parentNum,spinner_H_Check);
			parent.setSpinner_M_Check(parentNum,spinner_M_Check);
			parent.setSpinner_Day_Check(parentNum,spinner_Day_Check);
			parent.setTextField_FromCal_Check(parentNum,textField_FromCal_Check);
			parent.setTextField_ToCal_Check(parentNum,textField_ToCal_Check);
			parent.setTextField_MusicPath(parentNum,textField_MusicPath);
			parent.setCkbox_M_Check(parentNum,ckbox_M_Check);
			parent.setCkbox_Tue_Check(parentNum,ckbox_Tue_Check);
			parent.setCkbox_W_Check(parentNum,ckbox_W_Check);
			parent.setCkbox_Thu_Check(parentNum,ckbox_Thu_Check);
			parent.setCkbox_F_Check(parentNum,ckbox_F_Check);
			parent.setCkbox_Sat_Check(parentNum,ckbox_Sat_Check);
			parent.setCkbox_Sun_Check(parentNum,ckbox_Sun_Check);
			parent.setCkbox_onoff_Check(parentNum,ckbox_onoff_Check);
			parent.setCkbox_Repeat_Check(parentNum,ckbox_Repeat_Check);
	
			parent.clearAlarmArr(this.parentNum); // clear alarm arr
			
			if(spinner_M_Check.length() == 1) 
			{
				spinner_M_Check = "0" + spinner_M_Check;
			}
			parent.setAlarmArr(this.parentNum, spinner_Day_Check+ " "  +spinner_H_Check +":"+ spinner_M_Check+" "+AlarmName+"\n" );
			//Parent show... data 
			if(ckbox_onoff_Check == false) //if on off... -> change color
			{
				parent.setBackcolorAlarmArr(parentNum, Color.LIGHT_GRAY); 
			}
			
			else
			{
				parent.setBackcolorAlarmArr(parentNum, Color.WHITE);
			}
			
			String day2=""; //add Day
			if(ckbox_M_Check)
				day2+="Mon ";
			if(ckbox_Tue_Check)
				day2+="Tue ";
			if(ckbox_W_Check)
				day2+="Wed ";
			if(ckbox_Thu_Check)
				day2+="Thu ";
			if(ckbox_F_Check)
				day2+="Fri ";
			if(ckbox_Sat_Check)
				day2+="Sat ";
			if(ckbox_Sun_Check)
				day2+="Sun";

			parent.setAlarmArr(this.parentNum,day2); //set Alarm
			System.out.print("==============parentNum != -1 ==================== \n");
			System.out.print("==============" +this.parentNum +" ==================== \n");
			parent.ShowAlamArr(); //print test arr
			//parentNum=-1;
			dispose();
		}
    }
    
    
    
}
