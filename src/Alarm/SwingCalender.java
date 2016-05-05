package Alarm;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import javax.swing.*;

class SwingCalender extends JFrame implements ActionListener

{
		//I Write This code From Google. and Set my Style and Code
       String [] days = {"일","월","화","수","목","금","토"};// set day mon tue wed....
       int year ,month,day,todays,memoday=0;//initialize day
       Font f; 
       Color bc,fc; //Colors..
       Calendar today; // date
       Calendar cal;	// date
       JButton btnBefore,btnAfter;
       JButton[] calBtn = new JButton[49];// all btn.. 
       JLabel thing;
       JLabel time;
       JPanel panWest;
       JPanel panSouth;
       JPanel panNorth;
       JTextField txtMonth,txtYear;
       JTextField txtTime;
       BorderLayout bLayout= new BorderLayout();
       private AddAlarms parent = null;
       private int par_Val = 0;
       ////////////////////////////////////////
       public SwingCalender(AddAlarms parent,int i){ 
    	   par_Val = i;
    	   this.parent = parent;
             today = Calendar.getInstance();  //today date
             cal = new GregorianCalendar();		
             year = today.get(Calendar.YEAR);		//get year and month
             month = today.get(Calendar.MONTH)+1;
             panNorth = new JPanel();
			 panNorth.add(btnBefore = new JButton("Before"));            
             panNorth.add(txtYear = new JTextField(year+"년"));
             panNorth.add(txtMonth = new JTextField( month+"월",3));
             txtYear.setEnabled(false);
			 txtMonth.setEnabled(false);
             panNorth.add(btnAfter = new JButton("After"));
             f=new Font("Sherif",Font.BOLD,18); //set font
             txtYear.setFont(f);
             txtMonth.setFont(f);       
             getContentPane().add(panNorth,"North");
             
             panWest = new JPanel(new GridLayout(7,7));
             f=new Font("Sherif",Font.BOLD,12);
             gridInit(); //initialize panel
             calSet();	//calender set up
             hideInit();	//hide useless btn
             getContentPane().add(panWest,"Center");
             
             btnBefore.addActionListener(this);
             btnAfter.addActionListener(this);       
             setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             setTitle("Swing");
             setBounds(200,200,461,308);
             setVisible(true);   
       }//end constuctor
     
	public void calSet(){
    	  cal.set(Calendar.YEAR, year); // calender initialize
   		cal.set(Calendar.MONTH, month-1);
   		cal.set(Calendar.DATE, 1);
   		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // mon tue wed...
   		
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
   		
   		for(int i =cal.getMinimum(Calendar.DAY_OF_MONTH); // to calculate Month , date
   			i<=cal.getMaximum(Calendar.DAY_OF_MONTH);
   				i++)
   		{
   			cal.set(Calendar.DATE, i);
   			if(cal.get(Calendar.MONTH) != month-1)
   			{
   				break;
   			}
   			
   			todays=i;
   			if(memoday==1)
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
       }//end Calset()
       public void actionPerformed(ActionEvent ae){         
            if(ae.getSource() == btnBefore){ //before month
                    this.panWest.removeAll();
                    calInput(-1);
                    gridInit();
                    panelInit();               
                    calSet();
                    hideInit();
                    this.txtYear.setText(year+"년");
                    this.txtMonth.setText(month+"월");                   
             }                   
             else if(ae.getSource() == btnAfter){//after month
                    this.panWest.removeAll();
                    calInput(1);
                    gridInit();
                    panelInit();
                    calSet();
                    hideInit();
                    this.txtYear.setText(year+"년");
                    this.txtMonth.setText(month+"월");                                       
             }
           else if(Integer.parseInt(ae.getActionCommand()) >= 1 &&  //If click Date btn -> to throw Value parent form 
                    Integer.parseInt(ae.getActionCommand()) <= 31){
                    day = Integer.parseInt(ae.getActionCommand());
                    System.out.println(year+"-"+month+"-"+day);
                   
                    calSet();
                    if(par_Val ==1) //If input from date
            	   	parent.setCalendar_From(year+"-"+month+"-"+day); //set func
                    
                    else if(par_Val ==2)//if input to date
                    parent.setCalendar_To(year+"-"+month+"-"+day); // setfunc
                    this.dispose();
             }      
      }//end actionperformed()
       public void hideInit(){ // hide useless btn
            for(int i = 0 ; i < calBtn.length;i++){
                    if((calBtn[i].getText()).equals(""))
                           calBtn[i].setEnabled(false);
                   
             }//end for
       }//end hideInit()

       public void gridInit(){ // initialize btn...

         for(int i = 0 ; i < days.length;i++)
		   {
              panWest.add(calBtn[i] = new JButton(days[i]));
			  calBtn[i].setContentAreaFilled(false);
			  calBtn[i].setBorderPainted(false);
		   }	
			  for(int i = days.length ; i < 49;i++){                
                    panWest.add(calBtn[i] = new JButton(""));                   
                    calBtn[i].addActionListener(this);
             }              
       }//end gridInit()
	   public void panelInit(){ // pane initialize...
         GridLayout gridLayout1 = new GridLayout(7,7);
         panWest.setLayout(gridLayout1);   
       }//end panelInit()
       public void calInput(int gap){ // calculate month, year
             month+=(gap);
             if (month<=0){
                           month = 12;
                           year  =year- 1;
             }else if (month>=13){
                           month = 1;
                           year =year+ 1;
             }
       }//end calInput()
       
       /*
       public static void main(String[] args){
           SwingCalender jdbc = new SwingCalender();  
           */


}//end class


      