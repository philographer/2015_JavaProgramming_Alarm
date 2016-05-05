package Alarm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SpinnerModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.xml.ws.handler.MessageContext;

import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;


public class setTimeFrame extends JFrame implements ActionListener { //Set time date Frame

	private Mainform parent = null; //부모프레임
	String [] days = {"일", "월" , "화", "수" ,"목" ,"금" , "토"}; //mon tue wed thu...
	int year, month, day, todays, memoday = 0;
	Font f; //font
	Color bc,fc; //color
	Calendar today; // now
	Calendar cal; // calendar
	JButton[] calBtn = new JButton[49];
	
	public static String sMonth; // String Date data
	public static String sYear;		
	public static String sDay;
	public static String sHour;
	public static String sMinitue;
	public static String sSecond;
	
	//component
	private JPanel contentPane;
	private JCheckBox ckbox_24format;
	private JSpinner spinner_hour;
	private JSpinner spinner_minute;
	private JSpinner spinner_second;
	private JButton btn_Save;
	private JButton btn_Cancel;
	private JSpinner spinner_day;
	private JPanel panel_North;
	private JButton Btn_Before;
	private JButton btn_After;
	private JTextField textField_Year;
	private JTextField textField_Month;
	private JPanel panel_West;
	private JTextField textField_ShowDate;


	public setTimeFrame(final Mainform parent) { 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // closing...
				System.out.println("closing");
				parent.setVisible(true);//show mainform
			}
		});
		
		this.parent = parent; // parnet form
		today = Calendar.getInstance(); //today
		cal = new GregorianCalendar(); //calendar
		year = today.get(Calendar.YEAR); //set date
		month = today.get(Calendar.MONTH)+1;
		setTitle("Set Time");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 774, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ckbox_24format = new JCheckBox("Use 24 hour format");
		ckbox_24format.setSelected(true);
		ckbox_24format.setBounds(526, 149, 226, 29);
		ckbox_24format.addActionListener(this);
		contentPane.add(ckbox_24format);
		
		spinner_hour = new JSpinner();
		spinner_hour.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner_hour.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				//String a = spinner_hour.getValue();
			}
		});
		spinner_hour.setBounds(461, 110, 48, 28);
		contentPane.add(spinner_hour);
		
		spinner_minute = new JSpinner();
		spinner_minute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_minute.setBounds(536, 110, 48, 28);
		contentPane.add(spinner_minute);
		
		spinner_second = new JSpinner();
		spinner_second.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_second.setBounds(601, 110, 48, 28);
		contentPane.add(spinner_second);
		
		btn_Save = new JButton("Save");
		btn_Save.setBounds(468, 202, 125, 29);
		contentPane.add(btn_Save);
		btn_Save.addActionListener(this);
		
		btn_Cancel = new JButton("Cancel");
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // cancel.. -> parent show
				//dispose();
				//new Mainform();
				parent.setvisibleMain();
				dispose();
				
			}
		});
		btn_Cancel.setBounds(610, 202, 125, 29);
		contentPane.add(btn_Cancel);
		
		spinner_day = new JSpinner();
		spinner_day.setEnabled(false);
		spinner_day.setModel(new SpinnerListModel(new String[] {"A.M", "P.M"}));
		spinner_day.setBounds(664, 110, 71, 28);
		contentPane.add(spinner_day);
		
		panel_North = new JPanel();
		panel_North.setBounds(0, 0, 380, 84);
		contentPane.add(panel_North);
		panel_North.setLayout(null);
		
		Btn_Before = new JButton("Before");
		Btn_Before.setBounds(0, 27, 95, 29);
		panel_North.add(Btn_Before);
		Btn_Before.addActionListener(this);
		
		btn_After = new JButton("After");
		btn_After.setBounds(270, 27, 95, 29);
		panel_North.add(btn_After);
		btn_After.addActionListener(this);
		
		textField_Year = new JTextField(year + "년");
		textField_Year.setEditable(false);
		textField_Year.setBounds(102, 28, 74, 27);
		panel_North.add(textField_Year);
		textField_Year.setColumns(10);
		
		textField_Month = new JTextField(month +"월");
		textField_Month.setEditable(false);
		textField_Month.setBounds(180, 28, 84, 27);
		panel_North.add(textField_Month);
		textField_Month.setColumns(10);
		
		panel_West = new JPanel();
		panel_West.setBounds(0, 91, 380, 243);
		contentPane.add(panel_West);
		panel_West.setLayout(new GridLayout(7, 7));
		
		textField_ShowDate = new JTextField();
		textField_ShowDate.setEditable(false);
		textField_ShowDate.setBounds(461, 49, 156, 27);
		contentPane.add(textField_ShowDate);
		textField_ShowDate.setColumns(10);
		
		gridInit(); // calendar make 1-31 or 1- 30
		calset();//calender set
		hideInit();//useless btn hide
		setVisible(true);
	}//end gridInit()
	
	public void gridInit(){ // pane initialize...
		for(int i = 0; i < days.length; i++)
		{
			panel_West.add(calBtn[i] = new JButton(days[i])); //월 화 수 목 금 토 생성
			calBtn[i].setContentAreaFilled(false);
			calBtn[i].setBorderPainted(false);
		}
		
		for(int i = days.length; i < 49; i++)
		{
			panel_West.add(calBtn[i] = new JButton(""));//버튼 49개 만들기
			calBtn[i].addActionListener(this);
		}
	}
	
	public void calset()// calculate month
	{
		cal.set(Calendar.YEAR, year);// calender initialize
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // mon tue wed.
		
		int j=0;//jump 
		int hopping=0;
		calBtn[6].setForeground(new Color(0,0,255));//Sat blue
		calBtn[0].setForeground(new Color(255,0,0));//Sun Red
		for(int i=cal.getFirstDayOfWeek(); i<dayOfWeek;i++ )
		{
			j++;
		}
		
		hopping=j;
		
		for(int kk=0; kk<hopping;kk++)
		{
			calBtn[kk+7].setText("");
		}
		
		for(int i =cal.getMinimum(Calendar.DAY_OF_MONTH);
			i<=cal.getMaximum(Calendar.DAY_OF_MONTH);
				i++)
		{
			cal.set(Calendar.DATE, i);
			if(cal.get(Calendar.MONTH) != month-1)
			{
				break;
			}
			
			todays=i;
			if(memoday==1)//before month
			{
				calBtn[i+6+hopping].setForeground(new Color(0,255,0));
			}
			else{
				calBtn[i+6+hopping].setForeground(new Color(0,0,0));//week day black
				if((i+hopping)%7==0)
				{
					calBtn[i+6+hopping].setForeground(new Color(0,0,255));//sat blue
				}
				if((i+hopping)%7==1)
				{
					calBtn[i+6+hopping].setForeground(new Color(255,0,0));//Sun red
				}
			}
			calBtn[i+6+hopping].setText((i)+"");
		}	
	}//end of calset();
	
	public void panelInit(){
		GridLayout gridLayout1 = new GridLayout(7,7);
		panel_West.setLayout(gridLayout1);
	}//end of pnanelInit();
	
	public void calInput(int gap)// calculate month, year
	{
		month+=(gap);
		if(month<=0)
		{
			month = 12;
			year = year-1;
		}
		
		else if (month >=13)
		{
			month = 1;
			year = year + 1;
		}
	}//end of calInput();
	
	public void hideInit(){
		for(int i=0; i< calBtn.length; i++)
		{
			if((calBtn[i].getText()).equals(""))
				calBtn[i].setEnabled(false);
		}
	}//end hideInit();

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Btn_Before)
		{
			this.panel_West.removeAll();
			calInput(-1);
			gridInit();
			panelInit();
			calset();
			hideInit();
			this.textField_Year.setText(year +"년");
			this.textField_Month.setText(month+"월");
		}
		else if (e.getSource() == btn_After)
		{
				this.panel_West.removeAll();
				calInput(1);
				gridInit();
				panelInit();
				calset();
				hideInit();
				this.textField_Year.setText(year +"년");
				this.textField_Month.setText(month+"월");
		}
		
		else if(e.getSource() == btn_Save) //click save btn
		{
			
			
			if(textField_ShowDate.getText().toString().contains("-") == false) //if not select data
			{
				
				System.out.print("데이터없음");
				JOptionPane.showMessageDialog(null,"please select Date!");
			}
			
			else if(ckbox_24format.isSelected() == true) //if check 24 data... 
			{
			
			System.out.print("데이터있음");
			 sHour = spinner_hour.getValue().toString();
			 sMinitue = spinner_minute.getValue().toString();
			 sSecond = spinner_second.getValue().toString();
			
			
			String[] Date = textField_ShowDate.getText().toString().split("-");
			
			 sYear = Date[0];
			 sMonth = Date[1];
			 sDay = Date[2];
			
			System.out.printf("sYear:%s sMonth:%s sDay:%s\n",sYear,sMonth,sDay);
			System.out.printf("sHour:%s sMinute:%s sSecond:%s\n",sHour,sMinitue,sSecond);
			
			parent.setTimerCancel();
			
			
			
			parent.initTimeVal(Integer.parseInt(sYear),Integer.parseInt(sMonth),Integer.parseInt(sDay),Integer.parseInt
					(sHour),Integer.parseInt(sMinitue),Integer.parseInt(sSecond),true,false); // last true, false -> 24 model, 12model.
			parent.newTimeSet(); // set Time
			parent.setvisibleMain(); // visible
			dispose(); 
			}
			
			else if(ckbox_24format.isSelected() == false && spinner_day.isEnabled()) //if  24 type not checked -> 12model
			{
				if(spinner_day.getValue().toString() == "A.M") // A.M
				{
				System.out.print("데이터있음");
				 sHour = spinner_hour.getValue().toString();
				 sMinitue = spinner_minute.getValue().toString();
				 sSecond = spinner_second.getValue().toString();
				
				
				String[] Date = textField_ShowDate.getText().toString().split("-"); // Split
				
				 sYear = Date[0];
				 sMonth = Date[1];
				 sDay = Date[2];
				
				System.out.printf("sYear:%s sMonth:%s sDay:%s\n",sYear,sMonth,sDay);
				System.out.printf("sHour:%s sMinute:%s sSecond:%s\n",sHour,sMinitue,sSecond);
				
				parent.setTimerCancel();
				
				parent.initTimeVal(Integer.parseInt(sYear),Integer.parseInt(sMonth),Integer.parseInt(sDay),Integer.parseInt
							(sHour),Integer.parseInt(sMinitue),Integer.parseInt(sSecond),false,false); // set A.M data
				parent.newTimeSet();
				parent.setvisibleMain();
				dispose();
				}
				
				else if(spinner_day.getValue().toString() == "P.M" && spinner_day.isEnabled()) //12model Pm
				{
					System.out.print("데이터있음");
					 
					
					int hour1 = Integer.parseInt(spinner_hour.getValue().toString())+ 12; // pm + 12 -> 24 model
					 sHour = hour1+"";
					 sMinitue = spinner_minute.getValue().toString();
					 sSecond = spinner_second.getValue().toString();
					
					
					String[] Date = textField_ShowDate.getText().toString().split("-"); // split data
					
					 sYear = Date[0];
					 sMonth = Date[1];
					 sDay = Date[2];
					
					System.out.printf("sYear:%s sMonth:%s sDay:%s\n",sYear,sMonth,sDay);
					System.out.printf("sHour:%s sMinute:%s sSecond:%s\n",sHour,sMinitue,sSecond);
					
					parent.setTimerCancel(); //existing alarm clear 
					
					parent.initTimeVal(Integer.parseInt(sYear),Integer.parseInt(sMonth),Integer.parseInt(sDay),Integer.parseInt
							(sHour),Integer.parseInt(sMinitue),Integer.parseInt(sSecond),false,true); // 
					parent.newTimeSet(); // set time
					parent.setvisibleMain();
					
					dispose();
				}
			}
			
		}
	
		else if(e.getSource() == ckbox_24format) 
		{
			if(ckbox_24format.isSelected()) // if 24time
			{
				spinner_day.setEnabled(false);
				SpinnerNumberModel hourModel=
			            new SpinnerNumberModel(0,0,23,1); //max 23 h
				spinner_hour.setModel(hourModel);
				
			}
			
			else // 12 time
			{
				spinner_day.setEnabled(true);
				SpinnerNumberModel hourModel=
						new SpinnerNumberModel(0,0,11,1); // max 11h
				spinner_hour.setModel(hourModel);
			}
		}
		
		else if(Integer.parseInt(e.getActionCommand()) >= 1 && Integer.parseInt(e.getActionCommand()) <= 31) // 1~ 30 click
		{
			day = Integer.parseInt(e.getActionCommand()); //set day
			System.out.println(year+" "+month+" "+day); //
			textField_ShowDate.setText(year+"-"+month+"-"+day);// show datas
            calset();
		}
		

	}
}
