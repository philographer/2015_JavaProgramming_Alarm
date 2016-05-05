package Alarm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;










//import javax.print.DocFlavor.URL;
import javax.print.attribute.standard.DateTimeAtProcessing;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Dialog.ModalExclusionType;
import java.awt.LayoutManager2;
import java.awt.Window.Type;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.SwingConstants;

import javazoom.jl.player.Player;












import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JSpinner;
import javax.swing.UIManager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;

//import sun.text.normalizer.IntTrie;
//import Alarm.setTimeFrame.*;

public class Mainform extends JFrame {
	
	
	private Timer timer = new Timer(); //Initial Alarm
	private Timer timer2;			//New Form Alarm
	private TimerTask task2;		//task
	MusicThread m1 = new MusicThread();			//Music Thread
	private javax.swing.Timer countDownTimer; // CountDown Timer
	private Timer timer3;  // StopWatch Timer
	private boolean AlarmForm = false; // AlarmForm is Availabe
	int AlarmNum=0;
 	private long startTime;   // Start time of stopwatch. (measured in milliseconds.)
	private boolean running;  // True when the stopwatch is running.
	
	String pathVariable = null;					//to Music Path
	//////////////////Setting Variables(To Save)///////////////////////////////
	String[] AlarmName = new String[5];			//Alarm Name
	String[] spinner_H_Check = new String[5];	//Alarm Hour
	String[] spinner_M_Check = new String[5];	//Alarm Minute
	String[] spinner_Day_Check = new String[5];	//Alarm pm,am
	String[] textField_FromCal_Check = new String[5];	//Calendar From
	String[] textField_ToCal_Check = new String[5];		//Calendar To
	String[] textField_MusicPath = new String[5];		//To save MusicPath
	boolean[] ckbox_M_Check = new boolean[5];			//Alarm Monday
	boolean[] ckbox_Tue_Check = new boolean[5];			//Alarm Tue
	boolean[] ckbox_W_Check = new boolean[5];			//Alarm Wed
	boolean[] ckbox_Thu_Check = new boolean[5];			//Alarm Thu
	boolean[] ckbox_F_Check = new boolean[5];			//Alarm Fri
	boolean[] ckbox_Sat_Check = new boolean[5];			//Alarm Sat
	boolean[] ckbox_Sun_Check = new boolean[5];			//Alarm Sun
	boolean[] ckbox_onoff_Check = new boolean[5];		///Alarm On Off
	boolean[] ckbox_Repeat_Check = new boolean[5];		//Repeat
	//////////////////StopWatchVariables//////////////////////
	boolean flag;	// false : timer Stop
	 int ms = 0;  	//TimeVal...
	 int s = 0;
	 int m = 0;
	 int h = 0;
	 long start;	//Start Time
	 long end;		//end Time
	 String Msecond="";	//To convert Stirng...
	 String Second="";
	 String Minute="";
	 String Hour="";
	 String output="";
	//////////////////StopWatchVariable//////////////////////
	 
	 
	int syear = 0;  //year
	int smonth = 0;	//month
	int sday = 0;	//day
	int shour = 0;	//hour
	int sminute=0;	//minute
	int ssecond=0;	//second
	boolean model24=false; //24 Model(23:00:00) , 12 Model( A.M 11:00:00)
	boolean ampm=false;		//am or pm
	
	////////////////////////////////////////////
	//	Alarm Component  
	private JButton[] btn_Delete = new JButton[5];
	private JButton[] btn_Edit = new JButton[5];
	private JTextArea[] textField_AlarmArr = new JTextArea[5];
	
	/////////////////////////////////////////////
	//component
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_clock;
	private static JLabel lbl_Time;
	private static JLabel lbl_Date;
	private JButton btn_Change;
	private JPanel panel_Alarms;
	private JButton btn_Add;
	private boolean timerCancle=false;
	private boolean timerCancle2=false;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton button;
	private JPanel panel_inner0;
	private JButton btn_edit0;
	private JButton btn_delete0;
	private JTextField textField_Alarm0;
	private JTextField textField_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField textField_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JTextField newField;
	private JPanel panel_StopWatch;
	private JTextField textFiled_StopWatch;
	private JButton Btn_StartWatch;
	private JButton btn_stopWatch;
	private JPanel panel_CountDown;
	private JTextField textField_CoutdownS;
	private JTextField textField_CoutdownH;
	private JTextField textField_CoutdownM;
	private JButton Btn_CountDownStart;
	private JLabel label;
	private JLabel label_1;
	private JButton Btn_CountDownStop;
	private JScrollPane panel_Jscroll;
	//////////////////////////////////////
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { //Look and feel
		try {
			  UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel"); //Change Look and Feel
			  JFrame.setDefaultLookAndFeelDecorated(true);
	    }  
		
		catch (Exception e)
	    { }

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainform frame = new Mainform();
					frame.setVisible(true); //visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Mainform() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			System.out.println("Program Closing...");
			try {
				SaveData();	//To do save Alarm Data
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("Program Running");
				
				try {
					File f = new File("C:/AlarmSetting.txt");
					 if (f.isFile()) { //if File Exist
						 LoadData();//To Load Data
							for(int i = 0; i< 5; i++) // Alarm Num is maxium 5. so Load 5 Alarm. 
								if(!AlarmName[i].equals("null")) // if no null
									setTestBox(AlarmName[i], spinner_H_Check[i], spinner_M_Check[i], spinner_Day_Check[i], textField_FromCal_Check[i], textField_ToCal_Check[i], textField_MusicPath[i], ckbox_M_Check[i], ckbox_Tue_Check[i], ckbox_W_Check[i], ckbox_Thu_Check[i], ckbox_F_Check[i], ckbox_Sat_Check[i], ckbox_Sun_Check[i], ckbox_onoff_Check[i], ckbox_Repeat_Check[i]);
					    }
					    else {
					      
					    }
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		initTimeVal(0,0,0,0,0,0,false,false); //initialLize TimeValue
		setTitle("Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(240, 248, 255));
		tabbedPane.setBounds(5, 4, 612, 331);
		contentPane.add(tabbedPane);
		panel_clock = new JPanel();
		panel_clock.setBackground(new Color(240, 255, 255));
		tabbedPane.addTab("Clock", null, panel_clock, null);
		panel_clock.setLayout(null);
		lbl_Time = new JLabel("Time");
		lbl_Time.setFont(new Font("굴림", Font.PLAIN, 27));
		lbl_Time.setBounds(237, 95, 204, 37);
		panel_clock.add(lbl_Time);
		lbl_Date = new JLabel("Date");
		lbl_Date.setBounds(247, 147, 249, 21);
		panel_clock.add(lbl_Date);
		btn_Change = new JButton("ChanegeDate and time");
		btn_Change.setBackground(new Color(240, 255, 240));
		btn_Change.addActionListener(new ActionListener() {// Change Date And Time
			public void actionPerformed(ActionEvent arg0) {
				
					if(task2 != null)
					{
						task2.cancel(); // Cancel Task
					}
					new setTimeFrame(Mainform.this); // New frame, parameter thisform
					setUnvisibleMain(); //unvisible
			}
		});
		btn_Change.setBounds(202, 200, 215, 58);
		panel_clock.add(btn_Change);
		panel_Alarms = new JPanel();
		panel_Alarms.setBackground(new Color(240, 248, 255));
		tabbedPane.addTab("Alarms", null, panel_Alarms, null);
		panel_Alarms.setLayout(null);
		btn_Add = new JButton("AlarmAdd");
		btn_Add.setBackground(new Color(240, 255, 240));
		btn_Add.setBounds(214, 229, 167, 39);
		panel_Alarms.add(btn_Add);
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	//Add Alarm
				if(AlarmNum>4)
				{
					JOptionPane.showMessageDialog(null, "Maximum Alarm Num is 5"); //Show Dialog
				}
				else
				{System.out.print("New1");
				setUnvisibleMain(); 
				new AddAlarms(Mainform.this);//New form To add Alarm
				
				}
			}
		});
		panel_inner0 = new JPanel();
		panel_inner0.setBackground(SystemColor.controlHighlight);
		panel_inner0.setBounds(0, 0, 596, 255);
		//panel_Alarms.add(panel_inner0);//고침
		GridBagLayout gbl_panel_inner0 = new GridBagLayout(); //GridBag Layout.
		gbl_panel_inner0.columnWidths = new int[]{517, 0, 0};
		gbl_panel_inner0.rowHeights = new int[]{16, 3, 0, 0, 0};
		gbl_panel_inner0.columnWeights = new double[]{};
		gbl_panel_inner0.rowWeights = new double[]{};
		panel_inner0.setLayout(gbl_panel_inner0);
		panel_Jscroll = new JScrollPane(panel_inner0);
		panel_Jscroll.setBounds(0, 0, 607, 214);
		panel_Alarms.add(panel_Jscroll);
		panel_StopWatch = new JPanel();
		panel_StopWatch.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("StopWatch", null, panel_StopWatch, null);
		panel_StopWatch.setLayout(null);
		textFiled_StopWatch = new JTextField();
		textFiled_StopWatch.setBackground(new Color(255, 245, 238));
		textFiled_StopWatch.setEditable(false);
		textFiled_StopWatch.setBounds(117, 116, 156, 27);
		panel_StopWatch.add(textFiled_StopWatch);
		textFiled_StopWatch.setColumns(10);
		Btn_StartWatch = new JButton("Start");
		Btn_StartWatch.setBackground(new Color(240, 255, 240));
		Btn_StartWatch.addActionListener(new ActionListener() { //Start StopSwatch
			public void actionPerformed(ActionEvent e) {
				   if (!flag) { 
				    start = System.currentTimeMillis();
				    flag = true;
				    counter c = new counter();	
				    c.start();
				   }  	  
			}
		});
		
		Btn_StartWatch.setBounds(301, 115, 125, 29);
		panel_StopWatch.add(Btn_StartWatch);
		btn_stopWatch = new JButton("Stop");
		btn_stopWatch.setBackground(new Color(240, 255, 240));
		btn_stopWatch.addActionListener(new ActionListener() { //Stop Stopwatch
			public void actionPerformed(ActionEvent e) {
					if(flag== false)
						textFiled_StopWatch.setText("0:0:0:0");
				
				   flag = false;
				   if(timer3 != null)
				   timer3.cancel();
				  //textFiled_StopWatch.setText("00:00:00:00");
			}
		});
		btn_stopWatch.setBounds(437, 115, 125, 29);
		panel_StopWatch.add(btn_stopWatch);
		panel_CountDown = new JPanel();
		panel_CountDown.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Count Down", null, panel_CountDown, null);
		panel_CountDown.setLayout(null);
		textField_CoutdownS = new JTextField();
		textField_CoutdownS.setForeground(new Color(0, 0, 0));
		textField_CoutdownS.setBackground(new Color(255, 245, 238));
		textField_CoutdownS.setBounds(286, 114, 61, 27);
		panel_CountDown.add(textField_CoutdownS);
		textField_CoutdownS.setColumns(10);
		textField_CoutdownH = new JTextField();
		textField_CoutdownH.setForeground(new Color(0, 0, 0));
		textField_CoutdownH.setBackground(new Color(255, 245, 238));
		textField_CoutdownH.setBounds(109, 114, 61, 27);
		panel_CountDown.add(textField_CoutdownH);
		textField_CoutdownH.setColumns(10);
		textField_CoutdownM = new JTextField();
		textField_CoutdownM.setForeground(new Color(0, 0, 0));
		textField_CoutdownM.setBackground(new Color(255, 245, 238));
		textField_CoutdownM.setBounds(201, 114, 61, 27);
		panel_CountDown.add(textField_CoutdownM);
		textField_CoutdownM.setColumns(10);
		Btn_CountDownStart = new JButton("Start");
		Btn_CountDownStart.setBackground(new Color(240, 255, 240));
		Btn_CountDownStart.addActionListener(new ActionListener() { // Start CountDown
			public void actionPerformed(ActionEvent e) {
				
				if(textField_CoutdownH.getText().equals("")) //initialize textField 00 : 00 : 00
				{
					textField_CoutdownH.setText("00");
				}
				
				if(textField_CoutdownM.getText().equals(""))
				{
					textField_CoutdownM.setText("00");
				}
				
				if(textField_CoutdownS.getText().equals(""))
				{
					textField_CoutdownS.setText("00");
				}
				
				if(Integer.parseInt(textField_CoutdownH.getText())<0 || //To show under60...
						Integer.parseInt(textField_CoutdownH.getText())>60)
					textField_CoutdownH.setText("00");
				
				if(Integer.parseInt(textField_CoutdownM.getText())<0 ||
						Integer.parseInt(textField_CoutdownM.getText())>60)
					textField_CoutdownM.setText("00");
				
				if(Integer.parseInt(textField_CoutdownS.getText())<0 ||
						Integer.parseInt(textField_CoutdownS.getText())>60)
					textField_CoutdownS.setText("00");
					countDownTimer = new javax.swing.Timer(1000, new ActionListener() {
					
					int hour = Integer.parseInt(textField_CoutdownH.getText()); //time Value
					int minute = Integer.parseInt(textField_CoutdownM.getText());
					int second = Integer.parseInt(textField_CoutdownS.getText());
					int totalsecond = (hour * 60 * 60) + (minute * 60) + second; // To get Total Second 
					
					@Override
					public void actionPerformed(ActionEvent arg0) { //count Down
						// TODO Auto-generated method stub;	
						if(totalsecond != 0)
						{
						totalsecond--;
						hour = totalsecond / 3600;
						minute = totalsecond / 60 % 60;
						second = totalsecond %  60;
						
						if(hour < 10)							// 0 -> 00, 6 - > 06
						
							textField_CoutdownH.setText("0"+hour);
						else
							textField_CoutdownH.setText(hour+"");
						
						if(minute < 10)
							
							textField_CoutdownM.setText("0"+minute);
						else
							textField_CoutdownM.setText(minute+"");
						
						if(second < 10)
							
							textField_CoutdownS.setText("0"+second);
						else
							textField_CoutdownS.setText(second+"");
						}	
					}
				});
				countDownTimer.start();
			}
		});
		Btn_CountDownStart.setBounds(377, 113, 88, 29);
		panel_CountDown.add(Btn_CountDownStart);
		label = new JLabel(":");
		label.setBounds(180, 117, 20, 21);
		panel_CountDown.add(label);
		label_1 = new JLabel(":");
		label_1.setBounds(267, 117, 20, 21);
		panel_CountDown.add(label_1);
		Btn_CountDownStop = new JButton("Stop");
		Btn_CountDownStop.setBackground(new Color(240, 255, 240));
		Btn_CountDownStop.addActionListener(new ActionListener() { //Stop Count Down
			public void actionPerformed(ActionEvent e) {
				if(countDownTimer != null)							//InitialIze 00 : 00 : 00
				{
				textField_CoutdownH.setText("00");
				textField_CoutdownM.setText("00");
				textField_CoutdownS.setText("00");
				countDownTimer.stop();
				}
			}
		});
		Btn_CountDownStop.setBounds(482, 113, 74, 29);
		panel_CountDown.add(Btn_CountDownStop);
		
		if(syear == 0 && smonth == 0 && sday == 0) // First Run...
		{
		
		TimerTask task = new TimerTask() {
			public void run() {
				if(timerCancle == false)
				{
				Date now = new Date();//to get Now Time
				String nowString = now.toString();
				nowString.trim();
				String[] nowString2 = nowString.split(" ");
				String day = nowString2[0];//day
				String month = nowString2[1];//month
				String date = nowString2[2];  //date
				String time = nowString2[3]; //now Time
				String country = nowString2[4]; //country
				String year = nowString2[5]; //year
				lbl_Time.setText(time); // set Lable Time
				lbl_Date.setText(day + "," + month+"," + date +"," + year);// set lable Date 
				Alarming();
				}
				
				else// timerCancle == true
					timer.cancel();
			}
		};
		timer.schedule(task, 100,1000); //Start timer
		setVisible(true);
		}
		
	}
	
	public void setTestBox // set Alarm
	(
	String AlarmName,String spinner_H_Check,String spinner_M_Check,  
	String spinner_Day_Check, String textField_FromCal_Check, String textField_ToCal_Check, String textField_MusicPath,
	boolean  ckbox_M_Check , boolean  ckbox_Tue_Check, boolean ckbox_W_Check, boolean ckbox_Thu_Check,boolean ckbox_F_Check,
	boolean ckbox_Sat_Check , boolean ckbox_Sun_Check , boolean ckbox_onoff_Check, boolean ckbox_Repeat_Check
	)//Alarm Parameters (AddAlarms form)
	{
		//initialize val
		this.AlarmName[AlarmNum] = AlarmName;
		this.spinner_H_Check[AlarmNum] = spinner_H_Check;
		this.spinner_M_Check[AlarmNum] = spinner_M_Check;
		this.spinner_Day_Check[AlarmNum] = spinner_Day_Check;
		this.textField_FromCal_Check[AlarmNum] = textField_FromCal_Check;
		this.textField_ToCal_Check[AlarmNum] = textField_ToCal_Check;
		this.textField_MusicPath[AlarmNum] = textField_MusicPath;
		this.ckbox_M_Check[AlarmNum] = ckbox_M_Check;
		this.ckbox_Tue_Check[AlarmNum] = ckbox_Tue_Check;
		this.ckbox_W_Check[AlarmNum] = ckbox_W_Check;
		this.ckbox_Thu_Check[AlarmNum] = ckbox_Thu_Check;
		this.ckbox_F_Check[AlarmNum] = ckbox_F_Check;
		this.ckbox_Sat_Check[AlarmNum] = ckbox_Sat_Check;
		this.ckbox_Sun_Check[AlarmNum] = ckbox_Sun_Check;
		this.ckbox_onoff_Check[AlarmNum] = ckbox_onoff_Check;
		this.ckbox_Repeat_Check[AlarmNum] = ckbox_Repeat_Check;
		//////////////////////////////////////////////////////////////////////////////////////////////////////////추가한부분
		if(panel_inner0 == null)
		{
		panel_inner0 = new JPanel();
		panel_inner0.setBounds(0, 0, 1048, 432);
		panel_Alarms.add(panel_inner0);
		System.out.println("newform"+AlarmNum);
		GridBagLayout gbl_panel_inner0 = new GridBagLayout();
		gbl_panel_inner0.columnWidths = new int[]{868, 0, 0};
		gbl_panel_inner0.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_inner0.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_inner0.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_inner0.setLayout(gbl_panel_inner0);
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		//GUI component dynamic allocation ..
		String day2="";
		if(spinner_M_Check.length() == 1) // one digit -> 10 digit (ex 0 ~ 9 input => 00 ~ 09 로 바꿔줌)
		{
			spinner_M_Check = "0" + spinner_M_Check;
		}
		textField_AlarmArr[AlarmNum] = new JTextArea();
		textField_AlarmArr[AlarmNum].setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridheight = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 0;
		//gbc_textField_1.gridy = 0 + (2*AlarmNum);
		gbc_textField_1.gridy=GridBagConstraints.RELATIVE;
		panel_inner0.add(textField_AlarmArr[AlarmNum],gbc_textField_1);
		textField_AlarmArr[AlarmNum].setColumns(10);
		textField_AlarmArr[AlarmNum].append(spinner_Day_Check+ " "  +spinner_H_Check +":"+ spinner_M_Check+" "+AlarmName+"\n"); //set Alarm view
		if(ckbox_onoff_Check == false) // if alarm off 
		{
			textField_AlarmArr[AlarmNum].setBackground(Color.LIGHT_GRAY); // change color
		}
		//to show alarm day
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
		
		textField_AlarmArr[AlarmNum].append(day2);
		btn_Edit[AlarmNum] = new JButton("Edit");//Edit Alarm button
		btn_Edit[AlarmNum].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = 0;
				
				for(int i = 0; i < panel_inner0.getComponentCount(); i++)
				{
					
					if(e.getSource().equals(panel_inner0.getComponent(i))) // to get 1,2,3,4,5 Alarm Edit
					{
		
															//3으로 나눠서 몫에 1 더함
						i = i/3 + 1;                            //1,2,3,4 ,5 , 6 , 7
						System.out.print("i Num is:"+i+"\n");//1,4,7,10,13,16,19
						
						
						new AddAlarms(Mainform.this, getAlarmName(i-1),getSpinner_H_Check(i-1),getSpinner_M_Check(i-1),getSpinner_Day_Check(i-1),
								getTextField_FromCal_Check(i-1),getTextField_ToCal_Check(i-1),getTextField_MusicPath(i-1),
								getCkbox_M_Check(i-1),getCkbox_Thu_Check(i-1),getCkbox_W_Check(i-1),getCkbox_Thu_Check(i-1),
								getCkbox_F_Check(i-1),getCkbox_Sat_Check(i-1),getCkbox_Sun_Check(i-1),getCkbox_onoff_Check(i-1),
								getCkbox_Repeat_Check(i-1),i-1); //create New form -> AddAlarms form
						
						ShowAlamArr();
						break;

					}
				}
				//edit 누를시 생성자로 변수 전달 
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridheight = 1;
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		//gbc_btnNewButton_1.gridy = 0 + (2*AlarmNum);
		gbc_btnNewButton_1.gridy=GridBagConstraints.RELATIVE;
		panel_inner0.add(btn_Edit[AlarmNum], gbc_btnNewButton_1);
		btn_Delete[AlarmNum] = new JButton("delete");
		btn_Delete[AlarmNum].addActionListener(new ActionListener() { //Delete Button
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int index = 0;
				int totalTableNum = panel_inner0.getComponentCount()/3;//Total Alarm number
				
				for(int i = 0; i < panel_inner0.getComponentCount(); i++)
				{
					//System.out.print(e.getSource().equals(panel_inner0.getComponent(i)));
					
					
					if(e.getSource().equals(panel_inner0.getComponent(i)))//get This component
					{
						
						//System.out.printf("Delete : %d th Table \n",i/3 + 1);
						//System.out.printf("totalComponent:%d ", totalTableNum);
						int initNum = i/3 + 1; //push data  in front of
						
						for(int i2 = initNum; i2<totalTableNum; i2++)//dele data and Push data in front of array
						{//push data
							
							
							setAlarmName(i2-1,getAlarmName(i2));
							setSpinner_H_Check(i2-1,getSpinner_H_Check(i2));
							setSpinner_M_Check(i2-1,getSpinner_M_Check(i2));
							setSpinner_Day_Check(i2-1,getSpinner_Day_Check(i2));
							setTextField_FromCal_Check(i2-1,getTextField_FromCal_Check(i2));
							setTextField_ToCal_Check(i2-1,getTextField_ToCal_Check(i2));
							setTextField_MusicPath(i2-1,getTextField_MusicPath(i2));
							setCkbox_M_Check(i2-1,getCkbox_M_Check(i2));
							setCkbox_Tue_Check(i2-1,getCkbox_Tue_Check(i2));
							setCkbox_W_Check(i2-1,getCkbox_W_Check(i2));
							setCkbox_Thu_Check(i2-1,getCkbox_Thu_Check(i2));
							setCkbox_F_Check(i2-1,getCkbox_F_Check(i2));
							setCkbox_Sat_Check(i2-1,getCkbox_Sat_Check(i2));
							setCkbox_Sun_Check(i2-1,getCkbox_Sun_Check(i2));
							setCkbox_onoff_Check(i2-1,getCkbox_onoff_Check(i2));
							setCkbox_Repeat_Check(i2-1,getCkbox_Repeat_Check(i2));
							
							btn_Delete[i2-1] = btn_Delete[i2];
							btn_Edit [i2-1] = btn_Edit[i2];
							textField_AlarmArr [i2-1] =textField_AlarmArr[i2];
						}
						//Delete Data
						setAlarmName(totalTableNum-1,"");
						setSpinner_H_Check(totalTableNum-1,"");
						setSpinner_M_Check(totalTableNum-1,"");
						setSpinner_Day_Check(totalTableNum-1,"");
						setTextField_FromCal_Check(totalTableNum-1,"");
						setTextField_ToCal_Check(totalTableNum-1,"");
						setTextField_MusicPath(totalTableNum-1,"");
						setCkbox_M_Check(totalTableNum-1,false);
						setCkbox_Tue_Check(totalTableNum-1,false);
						setCkbox_W_Check(totalTableNum-1,false);
						setCkbox_Thu_Check(totalTableNum-1,false);
						setCkbox_F_Check(totalTableNum-1,false);
						setCkbox_Sat_Check(totalTableNum-1,false);
						setCkbox_Sun_Check(totalTableNum-1,false);
						setCkbox_onoff_Check(totalTableNum-1,false);
						setCkbox_Repeat_Check(totalTableNum-1,false);
						btn_Delete[totalTableNum-1] =null;
						btn_Edit [totalTableNum-1] = null;
						textField_AlarmArr [totalTableNum-1] = null;
						AlarmNum--;
						panel_inner0.remove(i);
						panel_inner0.remove(i-1);
						panel_inner0.remove(i-2);
						Mainform.this.repaint();		
					}
				}
				ShowAlamArr();
				System.out.print("Total alarm num is:" + AlarmNum);
			}
		});
		
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridheight = 1;
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 1;
		//gbc_btnNewButton_2.gridy = 1 + (2*AlarmNum);
		gbc_btnNewButton_2.gridy=GridBagConstraints.RELATIVE;
		panel_inner0.add(btn_Delete[AlarmNum], gbc_btnNewButton_2);
		Mainform.this.repaint();//repaint mainform
		AlarmNum ++;//total alarmnum  ++
		System.out.println("now alarmnum is" + AlarmNum);
		
	}
	
	public void initButton()// to initialize Alarm delete,edit btn
	{
		for(int i =0; i<10 ; i++)
		{
			btn_Delete[i].setText("Delete");
			btn_Edit[i].setText("Edit");
		}
	}
	
	public void setvisibleMain() //visible main
	{
		Mainform.this.setVisible(true);
	}
	
	public void setUnvisibleMain()//unvisible main
	{
		Mainform.this.setVisible(false);
	}
	
	public void setTimerCancel() // timer cancel
	{
		timerCancle=true;
		timer.cancel();
		
	}
	
	public void musicStart() // music start that music path
	{
		try
		{
		m1.start();
		}
		catch(Exception e)
		{
			m1 = new MusicThread(); //create new music thread
			m1.start();
		}
	}
	
	public void musicStop() // stop music 
	{
		m1.stop();
	}
	
	public void mainDispose() //main dipose
	{
		this.dispose();
	}
	
	public void printTest() //to test...
	{
		System.out.println("testPrint");
	}
	
	public void setAlarmArr(int i,String Parameter) // setAlarm
	{
		textField_AlarmArr[i].append(Parameter);
	}
	
	public void clearAlarmArr(int i) // to clear alarm text
	{
		textField_AlarmArr[i].setText("");
	}
	
	public void setBackcolorAlarmArr(int i,Color cr) // change background color (on off)
	{
		textField_AlarmArr[i].setBackground(cr);
	}
	
	public class MusicThread extends Thread  // Music Thread
	{
		 public void run() {
			 try {
					FileInputStream fis = new FileInputStream(pathVariable); // pathVariable is variable value each alarm
					Player playMp3 = new Player(fis);//mp3 type
					playMp3.play();
				} catch (Exception e) {
					System.out.println(e);
				}
		  }
	}
	
	public void ShowAlamArr() // to test... show all alarm array
	{
		for(int x=0; x<5; x++)
		{
			
			System.out.print("Array of data \n");
			System.out.print("=============================================== \n");
			System.out.println(getAlarmName(x));
			System.out.println(getSpinner_H_Check(x));
			System.out.println(getSpinner_M_Check(x));
			System.out.println(getSpinner_Day_Check(x));
			System.out.println(getTextField_FromCal_Check(x));
			System.out.println(getTextField_ToCal_Check(x));
			System.out.println(getTextField_MusicPath(x));
			System.out.println(getCkbox_M_Check(x));
			System.out.println(getCkbox_Thu_Check(x));
			System.out.println(getCkbox_W_Check(x));
			System.out.println(getCkbox_Thu_Check(x));
			System.out.println(getCkbox_F_Check(x));
			System.out.println(getCkbox_Sat_Check(x));
			System.out.println(getCkbox_Sun_Check(x));
			System.out.println(getCkbox_onoff_Check(x));
			System.out.println(getCkbox_Repeat_Check(x));
			System.out.print("=============================================== \n");
		}
		System.out.print("==================End Of Data============================= \n");
		System.out.println("Now Total Alarm is:" + AlarmNum);
	}
	
	public void Alarming() // if alarm time, alarming
	{
		for(int i = 0; i < 5 ; i++)//total alarm 5
		if(spinner_Day_Check[i] != null && spinner_Day_Check[i] !="" &&  // not null , not ""
		spinner_H_Check[i] != null &&spinner_H_Check[i] !=""&&
		spinner_M_Check[i] != null && spinner_M_Check[i] != "")
		{
		String AlarmTime="";//AlarmTime
		String AlarmH=""; //Alarm Hour
		String AlarmM = spinner_M_Check[i]; //Alarm Minute
		
		if(AlarmM.length() == 1)// 1 digit -> 10 digit (ex 0 ~ 9 input=> 00 ~ 09 로 바꿔줌)
			AlarmM = "0" + spinner_M_Check[i];
		
		if(lbl_Time.getText().contains("A.M") || lbl_Time.getText().contains("P.M")) //12hour(ex A.M ~~)
		{
			String[] temps = new String [2]; // 
			temps= lbl_Time.getText().split(" ");
			if(temps[0].equals(spinner_Day_Check[i])) //if same a.m or p.m
			{
				AlarmH = spinner_H_Check[i];
				AlarmH = String.valueOf(Integer.parseInt(spinner_H_Check[i])); 
				AlarmTime = AlarmH + ":" + AlarmM+":00"; // XX:YY:00
			}
			
			else
				break;
			
		}
		else //24 hour( 23 : 00 : 00)
		{
			if(spinner_Day_Check[i].equals("P.M")) //Spinner Always A.M  or P.M 
			{
					AlarmH = spinner_H_Check[i];
					AlarmH = String.valueOf((Integer.parseInt(spinner_H_Check[i]) + 12)); //pm이면 +12 해서 24시간단위
					AlarmTime = AlarmH + ":" + AlarmM+":00"; // XX:YY:00
					
					
			}
			else //A.M
			{
				AlarmH = spinner_H_Check[i];
				if(AlarmH.length() == 1)
					AlarmH = "0" + spinner_H_Check[i];
				AlarmTime = AlarmH + ":" + AlarmM+":00";
			}
		}
		//System.out.println("Alarm" +i+"th is" +AlarmTime); 알람시간 표시 
		///////////////////////////////////////////////////
		
		
		//////////////////////////////////////////////////////////////////////
		if(ckbox_onoff_Check[i] == true && lbl_Time.getText().equals(AlarmTime) || //24hour model
				ckbox_onoff_Check[i] == true && lbl_Time.getText().equals("A.M " + AlarmTime)||//12hour model(A.M, P.M)
				ckbox_onoff_Check[i] == true && lbl_Time.getText().equals("P.M "+AlarmTime)
				) //12시간 pm
			//알람 시간이 메인라벨의 시간과 같아지면
		{
			if(ckbox_Repeat_Check[i]==true) //if repeated setting true
			{
				 
				String AlarmDay="";// Alarm Alarming day
				if(ckbox_M_Check[i]==true) // to create alarmday... add day
				{
					AlarmDay += "Mon";
				}
				
				if(ckbox_Tue_Check [i]==true)
				{
					AlarmDay += "Thu";
				}
				
				if(ckbox_W_Check[i]==true)
				{
					AlarmDay += "Wed";
				}
				
				if(ckbox_Thu_Check[i]==true)
				{
					AlarmDay += "Thu";
				}
				
				if(ckbox_F_Check[i]==true)
				{
					AlarmDay += "Fri";
				}
				
				if(ckbox_Sat_Check[i]==true)
				{
					AlarmDay += "Sat";
				}
				
				if(ckbox_Sun_Check[i]==true)
				{
					AlarmDay += "Sun";
				}
				//alarm is alarming when from FromDate to ToDate
				Calendar AlarmDate = Calendar.getInstance(); //now
				String[] MainLabel = new String[4]; //
				MainLabel = lbl_Date.getText().split(",");
				AlarmDate.set(Integer.parseInt(MainLabel[3]), convertMonth(MainLabel[1]) ,Integer.parseInt(MainLabel[2]) ); // alarming dae
				// (year, month, date)
				Calendar from = Calendar.getInstance();
				String[] tempFrom=new String[3];
				String temp1=textField_FromCal_Check[i];
				tempFrom = temp1.split("-");
				from.set(Integer.parseInt(tempFrom[0]), Integer.parseInt(tempFrom[1]), Integer.parseInt(tempFrom[2]));//alarm from date (year, month, date)
				from.set(Calendar.HOUR,0);
				from.set(Calendar.MINUTE,0);
				from.set(Calendar.SECOND, 0);
				
				Calendar to = Calendar.getInstance();
				String[] tempTo=new String[3];
				String temp2=textField_ToCal_Check[i];
				tempTo = temp2.split("-");
				to.set(Integer.parseInt(tempTo[0]), Integer.parseInt(tempTo[1]), Integer.parseInt(tempTo[2]));// alarm to date(year, month, date)
				to.set(Calendar.HOUR,23);
				to.set(Calendar.MINUTE,59);
				to.set(Calendar.SECOND, 59);
				
				System.out.println(AlarmDate.getTime());
				System.out.println(from.getTime());
				System.out.println(to.getTime());
				
				if(AlarmDay.contains(MainLabel[0].toString())) // if Alarming day
						{
							if(
									(from.before(AlarmDate) || from.getTime().equals(AlarmDate.getTime())) //alarm time 
									&&
									(to.after(AlarmDate) || to.getTime().equals(AlarmDate.getTime()))//from To
									)
										{
										setMusicPath(textField_MusicPath[i]);//set Music path that alarm's
										musicStart();//Alarm Alamring!
										new Alarm(Mainform.this);//create new form
										}
							else
							{
								
							}// if not alarm day - > do nothing
						}
			}	
				else //not repeat  but alarmTime come
				{
					setMusicPath(textField_MusicPath[i]);
					musicStart();//alarming!
					new Alarm(Mainform.this);
				}
				
		}//alarm same mainTime lable if end		

		} //end of Alarm if end
		
	}//end of alarming func
	

	public void initAlarm() //initialize alarm data
	{
		for(int i = 0; i < 5 ; i++)
		{
		this.AlarmName[i] = null;
		this.spinner_H_Check[i] = null;
		this.spinner_M_Check[i] = null;
		this.spinner_Day_Check[i] = null;
		this.textField_FromCal_Check[i] = null;
		this.textField_ToCal_Check[i] = null;
		this.textField_MusicPath[i] = null;
		
		this.ckbox_M_Check[i] = false;
		this.ckbox_Tue_Check[i] = false;
		this.ckbox_W_Check[i] = false;
		this.ckbox_Thu_Check[i] = false;
		this.ckbox_F_Check[i] = false;
		this.ckbox_Sat_Check[i] = false;
		this.ckbox_Sun_Check[i] = false;
		this.ckbox_onoff_Check[i] = false;
		this.ckbox_Repeat_Check[i] = false;
		
		btn_Delete[i] =null;
		btn_Edit [i] = null;
		textField_AlarmArr [i] = null;
	}
	panel_inner0.removeAll();
	this.AlarmNum=0;
	}
	
	public void initTimeVal(int year, int month, int day, int hour , int minute, int second , boolean model24, boolean ampm) //initialize time value
	{
		this.setSyear(year);
		this.setSday(day);
		this.setSmonth(month);
		this.setShour(hour);
		this.setSminute(minute);
		this.setSsecond(second);
		this.setModel24(model24);
		this.setAmpm(ampm);
	}
	
	public void newTimeSet() // convert 1,2,3,4,...12 -> int january,februrary...
	{
		final Calendar n = Calendar.getInstance();
		n.set(this.syear, this.smonth, this.sday, this.shour, this.sminute, this.ssecond);
		
		final Calendar calendar2  = Calendar.getInstance();
		int ConvertedMonth=0;
		switch (this.smonth){
	    case 1:
	    	ConvertedMonth = Calendar.JANUARY;
	        break;
	    case 2:
	    	ConvertedMonth = Calendar.FEBRUARY;
	        break;
	    case 3:
	    	ConvertedMonth = Calendar.MARCH;
	        break;
	    case 4:
	    	ConvertedMonth = Calendar.APRIL;
	        break;
	    case 5:
	    	ConvertedMonth = Calendar.MAY;
	        break;
	    case 6:
	    	ConvertedMonth = Calendar.JUNE;
	        break;
	    case 7:
	    	ConvertedMonth = Calendar.JULY;
	        break;
	    case 8:
	    	ConvertedMonth = Calendar.AUGUST;
	        break;
	    case 9:
	    	ConvertedMonth = Calendar.SEPTEMBER;
	        break;
	    case 10:
	    	ConvertedMonth = Calendar.OCTOBER;
	        break;
	    case 11:
	    	ConvertedMonth = Calendar.NOVEMBER;
	        break;
	    case 12:
	    	ConvertedMonth = Calendar.DECEMBER;
	        break;
	    }
		
		calendar2.set(this.syear, ConvertedMonth, this.sday, this.shour, this.sminute, this.ssecond); // init calendar2
		//calendar2.set(0, this.smonth, this.sday, this.shour, this.sminute, this.ssecond);
		//calendar2.set(Calendar.DAY_OF_WEEK, calendar2.get(Calendar.DAY_OF_WEEK)-2);
		
		System.out.println("ssecond is: " + ssecond);
		
		timer2 = new Timer();
		task2 = new TimerTask() { // create another timer task
			int sec=ssecond-1;
			public void run() {
				
				if(timerCancle2 == false) //condition to run timer
				{ 							// same upper timer....
					sec++; 
					if(sec==61)
					{
						sec-=60;
					}
					
					calendar2.set(Calendar.SECOND, sec);

					String nowString = calendar2.getTime().toString();
					nowString.trim();
					String[] nowString2 = nowString.split(" ");
					String day = nowString2[0];
					String month = nowString2[1];
					String date = nowString2[2];  
					String time = nowString2[3]; 
					String country = nowString2[4]; 
					String year = nowString2[5]; 
					String ampmModel="A.M";
					String[] timeModelArr = time.split(":");
					
					int hourModel = Integer.parseInt(timeModelArr[0]);
					if(hourModel<12 || ampm == false )//오전 
					{
						ampmModel="A.M";
					}
					else if(hourModel<12 || ampm == true ) //오후
					{
					ampmModel="P.M";
					hourModel-=12;
					}
					
					//ampmModel am이고 hour가 12넘으면 pm셋팅 
					if(ampmModel.equals("A.M") && hourModel ==12)
					{
						hourModel -=12;
						ampmModel="pm";
					}
					
					//ampmModel pm이고 hour이 12넘으면 am셋팅, 다음날 
					if(ampmModel.equals("P.M") && hourModel ==12)
					{
						
					}
					
					String minuteModel = timeModelArr[1];
					String secondModel = timeModelArr[2];
					
					if(model24 == true)//24시간으로 표시
					{
					lbl_Time.setText(time);
					lbl_Date.setText(day + "," + month +","+ date +"," + (Integer.parseInt(year)));
					}
					
					else if(model24 == false)//12시간으로 표시
					{		
						lbl_Time.setText(ampmModel+" "+hourModel +":"+ minuteModel+":"+secondModel);
						lbl_Date.setText(day + "," + month+"," + date +"," + (Integer.parseInt(year)));
					}
					Alarming();
				}

				else
				{
					timer2.cancel();
				}
			}
			};

			timer2.schedule(task2, 100,1000);
			
	}
	

	
	public int convertMonth(String i) // convert Month Jan -> 1 , Feb -> 2.... 
	{
		int i2=1;
		
		if(i.equals("Jan"))
			i2=1;
		if(i.equals("Feb"))
			i2=2;
		if(i.equals("Mar"))
			i2=3;
		if(i.equals("Apr"))
			i2=4;
		if(i.equals("May"))
			i2=5;
		if(i.equals("Jun"))
			i2=6;
		if(i.equals("Jul"))
			i2=7;
		if(i.equals("Aug"))
			i2=8;
		if(i.equals("Sep"))
			i2=9;
		if(i.equals("Oct"))
			i2=10;
		if(i.equals("Nov"))
			i2=11;
		if(i.equals("Dec"))
			i2=12;
		
		return i2;
	}
	
	public void SaveData() throws IOException //Save datas
	{
		FileWriter fw = new FileWriter("C:/AlarmSetting.txt"); // create path
		BufferedWriter bw = new BufferedWriter(fw); // file buffer
		//버퍼를 사용하여 버퍼에 담긴 문자열을 fw에 저장된 txt문서에 저장
		
		ckbox_M_Check.toString(); // to convert
		
		for(int i=0; i<5; i++){ // save data, data, .... Alarmnum total 5
			
			bw.write(AlarmName[i]+",");
			bw.write(spinner_H_Check[i]+",");
			bw.write(spinner_M_Check[i]+",");
			bw.write(spinner_Day_Check[i]+",");
			bw.write(textField_FromCal_Check[i]+",");
			bw.write(textField_ToCal_Check[i]+",");
			bw.write(textField_MusicPath[i]+",");
			
			bw.write(ckbox_M_Check[i]+",");
			bw.write(ckbox_Tue_Check[i]+",");
			bw.write(ckbox_W_Check[i]+",");
			bw.write(ckbox_Thu_Check[i]+",");
			bw.write(ckbox_F_Check[i]+",");
			bw.write(ckbox_Sat_Check[i]+",");
			bw.write(ckbox_Sun_Check[i]+",");
			
			bw.write(ckbox_onoff_Check[i]+",");
			bw.write(ckbox_Repeat_Check[i]+",");
			
		}
		
		bw.write(AlarmNum+""); //last Write total Alarmnum
		bw.flush();//flush
		
		System.out.println("Saved Data");
		
		bw.close();//close file buffer
		fw.close();//close file writer
	}
	
	public void LoadData() throws IOException // to load data
	{
		FileInputStream fis = new FileInputStream("C:/AlarmSetting.txt"); // load path
		
		BufferedInputStream bis = new BufferedInputStream(fis); // buffer
		int i =0;
		String InputData="";
		String[] SplitedData = new String[81];
		while((i=bis.read())!=-1)
		{ // to end... do 
			InputData+=(char)i;//1 char read
			System.out.print((char)i);
		}

		bis.close();
		fis.close();
		
		SplitedData = InputData.split(","); //spliting data
		
		
			for(int x1=0; x1<5 ; x1++) // to input read data -> my app 
			{
			int x2=16;
			AlarmName[x1] = SplitedData[x1*x2]; 
			spinner_H_Check[x1]=SplitedData[x1*x2+1]; 
			spinner_M_Check[x1]= SplitedData[x1*x2+2]; 
			spinner_Day_Check[x1] = SplitedData[x1*x2+3]; 
			textField_FromCal_Check[x1]= SplitedData[x1*x2+4];
			textField_ToCal_Check[x1]= SplitedData[x1*x2+5]; 
			textField_MusicPath[x1]= SplitedData[x1*x2+6];  
			ckbox_M_Check[x1]= SplitedData[x1*x2+7].equals("true"); 
			ckbox_Tue_Check[x1]= SplitedData[x1*x2+8].equals("true"); 
			ckbox_W_Check[x1] = SplitedData[x1*x2+9].equals("true"); 
			ckbox_Thu_Check[x1] = SplitedData[x1*x2+10].equals("true"); 
			ckbox_F_Check[x1] = SplitedData[x1*x2+11].equals("true"); 
			ckbox_Sat_Check[x1] = SplitedData[x1*x2+12].equals("true");
			ckbox_Sun_Check[x1] = SplitedData[x1*x2+13].equals("true");
			ckbox_onoff_Check[x1] = SplitedData[x1*x2+14].equals("true");
			ckbox_Repeat_Check[x1] = SplitedData[x1*x2+15].equals("true");
			
			}
		
		//AlarmNum = Integer.parseInt(SplitedData[80]);
		ShowAlamArr();//to test... print func
		}
	
	
	public class counter extends Thread { // Thread Stop Watch
		  public void run() {  
		   while (flag) {
		    end = System.currentTimeMillis(); //end time
		    ms = (int) ((end - start) / 10); //milisecond
		    h = ms / (3600 * 100); 						//time...
		    m = (ms - h * 3600 * 100) / (60 * 100);
		    s = (ms - h * 3600 * 100 - m * 60 * 100) / 100;
		    ms = ms - h * 3600 * 100 - m * 60 * 100 - s * 100;

		    if(ms < 0)
		    {
		    	Msecond = "0" + ms;
		    }
		    else
		    {
		    	Msecond = ms + "";
		    }
		    if(s <0)
		    {
		    	Second = "0" + s;
		    }
		    else
		    {
		    	Second = s +  "";
		    }
		    if(m < 0)
		    {
		    	Minute = "0" + m;
		    }
		    else
		    {
		    	Minute = m + "";
		    }
		    
		    if(h < 0)
		    {
		    	Hour = "0" + h;
		    }
		    else
		    {
		    	Hour = h + "";
		    }
		    
		    output = Hour + ":" + Minute + ":" +Second + ":" + Msecond; // output ?? : ?? : ??
		    
		    textFiled_StopWatch.setText(output);//to show set text
		    try {
		      Thread.sleep(5); 
		    } catch (InterruptedException e) {
		     e.printStackTrace();
		    }
		   }
		  }
		 }
	
	////////////////////////////////////////set and get method///////////////////////
	
	public void setTimerCencel2() 
	{
		this.timerCancle2= true;
		
	}
	
	public void setAlarmName(int i,String alarmName) {
		AlarmName[i] = alarmName;
	}
	
	public String getAlarmName(int i) {
		return AlarmName[i];
	}
	
	public void setSpinner_H_Check(int i ,String spinner_H_Check) {
		this.spinner_H_Check[i] = spinner_H_Check;
	}

	public void setSpinner_M_Check(int i,String spinner_M_Check) {
		this.spinner_M_Check[i] = spinner_M_Check;
	}
	
	public void setSpinner_Day_Check(int i,String spinner_Day_Check) {
		this.spinner_Day_Check[i] = spinner_Day_Check;
	}

	public void setTextField_FromCal_Check(int i,String textField_FromCal_Check) {
		this.textField_FromCal_Check[i] = textField_FromCal_Check;
	}

	public void setTextField_ToCal_Check(int i,String textField_ToCal_Check) {
		this.textField_ToCal_Check[i] = textField_ToCal_Check;
	}

	public void setTextField_MusicPath(int i,String textField_MusicPath) {
		this.textField_MusicPath[i] = textField_MusicPath;
	}

	public void setCkbox_M_Check(int i,boolean ckbox_M_Check) {
		this.ckbox_M_Check[i] = ckbox_M_Check;
	}

	public void setCkbox_Tue_Check(int i,boolean ckbox_Tue_Check) {
		this.ckbox_Tue_Check[i] = ckbox_Tue_Check;
	}

	public void setCkbox_W_Check(int i,boolean ckbox_W_Check) {
		this.ckbox_W_Check[i] = ckbox_W_Check;
	}

	public void setCkbox_Thu_Check(int i,boolean ckbox_Thu_Check) {
		this.ckbox_Thu_Check[i] = ckbox_Thu_Check;
	}

	public void setCkbox_F_Check(int i,boolean ckbox_F_Check) {
		this.ckbox_F_Check[i] = ckbox_F_Check;
	}

	public void setCkbox_Sat_Check(int i,boolean ckbox_Sat_Check) {
		this.ckbox_Sat_Check[i] = ckbox_Sat_Check;
	}

	public void setCkbox_Sun_Check(int i,boolean ckbox_Sun_Check) {
		this.ckbox_Sun_Check[i] = ckbox_Sun_Check;
	}

	public void setCkbox_onoff_Check(int i,boolean ckbox_onoff_Check) {
		this.ckbox_onoff_Check[i] = ckbox_onoff_Check;
	}

	public void setCkbox_Repeat_Check(int i,boolean ckbox_Repeat_Check) {
		this.ckbox_Repeat_Check[i] = ckbox_Repeat_Check;
	}

	public String getSpinner_H_Check(int i) {
		return spinner_H_Check[i];
	}

	public String getSpinner_M_Check(int i) {
		return spinner_M_Check[i];
	}

	public String getSpinner_Day_Check(int i) {
		return spinner_Day_Check[i];
	}

	public String getTextField_FromCal_Check(int i) {
		return textField_FromCal_Check[i];
	}

	public String getTextField_ToCal_Check(int i) {
		return textField_ToCal_Check[i];
	}

	public String getTextField_MusicPath(int i) {
		return textField_MusicPath[i];
	}

	public boolean getCkbox_M_Check(int i) {
		return ckbox_M_Check[i];
	}

	public boolean getCkbox_Tue_Check(int i) {
		return ckbox_Tue_Check[i];
	}

	public boolean getCkbox_W_Check(int i) {
		return ckbox_W_Check[i];
	}

	public boolean getCkbox_Thu_Check(int i) {
		return ckbox_Thu_Check[i];
	}
	
	public boolean getCkbox_F_Check(int i) {
		return ckbox_F_Check[i];
	}


	public boolean getCkbox_Sat_Check(int i) {
		return ckbox_Sat_Check[i];
	}

	public boolean getCkbox_Sun_Check(int i) {
		return ckbox_Sun_Check[i];
	}

	public boolean getCkbox_onoff_Check(int i) {
		return ckbox_onoff_Check[i];
	}

	public boolean getCkbox_Repeat_Check(int i) {
		return ckbox_Repeat_Check[i];
	}
	
	
	public void setMusicPath(String para)
	{
		pathVariable = para;
	}
	
	public int getSyear() {
		return syear;
	}

	public void setSyear(int syear) {
		this.syear = syear;
	}

	public int getSmonth() {
		return smonth;
	}

	public void setSmonth(int smonth) {
		this.smonth = smonth;
	}

	public int getSday() {
		return sday;
	}

	public void setSday(int sday) {
		this.sday = sday;
	}

	public int getShour() {
		return shour;
	}

	public void setShour(int shour) {
		this.shour = shour;
	}

	public int getSminute() {
		return sminute;
	}

	public void setSminute(int sminute) {
		this.sminute = sminute;
	}

	public int getSsecond() {
		return ssecond;
	}

	public void setSsecond(int ssecond) {
		this.ssecond = ssecond;
	}
	
	public boolean isModel24() {
		return model24;
	}

	public void setModel24(boolean model24) {
		this.model24 = model24;
	}

	public boolean isAmpm() {
		return ampm;
	}

	public void setAmpm(boolean ampm) {
		this.ampm = ampm;
	}
	////////////////////////////////////////set and get method///////////////////////
	
	
}


