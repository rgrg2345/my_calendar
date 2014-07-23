package calendar;

public class my_calendar {

	//�p���~�e�`�@���h�֤�
	public static int yearday(int year)
	{
		int day=0;
		int baseyear=1900;//�H1900�����
		for(;year>baseyear;baseyear++)
			day+=365+((Isleap(baseyear)==true)?1:0);
		return day;
	}
	
	//�P�_�|�~
	public static boolean Isleap(int year)
	{
		return ((year%4==0&&year%100!=0)||(year%400==0));
	}
	
	//���w����e���Ѽ��`�M
	public static int monthday(int year ,int month)
	{
		int cntday=0;
		for(int i=1;i<month;i++)
			cntday+=getmonthday(year,i);
		return cntday;
	}
	
	//������Ѽ�
	public static int getmonthday(int year,int month)
	{
		int Month[]={31,28,31,30,31,30,31,31,30,31,30,31};
		return Month[month-1]+((Isleap(year)==true&&month==2)?1:0);
	}
	//�o����1���P���X
	public static int getWeek(int year,int month)
	{
		int allday=yearday(year)+monthday(year,month);
		int week=(allday+1)%7;
		return week;
	}
	public static void calendar(int year ,int month)
	{
		int monthday=getmonthday(year,month)+1;
		int week=getWeek(year,month);//1���P���X
		System.out.println(year+"/"+month);
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		for(int i=0;i<week*4;i++)
			System.out.print(" ");
		for(int i=1;i<monthday;i++)
		{
			System.out.print(" ");
			System.out.print(i);
			if(i<10) System.out.print(" ");
			week=(++week)%7;
			if(week==0)
				System.out.println("");
			else
				System.out.print(" ");
		}
	}
	public static void main(String args[] )
	{
		String stri []={"year(at least 1900)","month"};
		int year=0,mon=0;
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		for(int i=0;;){
			System.out.println("Please input "+stri[i]);
			mon=scanner.nextInt();
			if(i==0&&mon>=1900){
			year=mon;
			i++;
			}else if(i!=0&&mon<13&&mon>1)
				break;
			else
				continue;
		}
		
		calendar(year,mon);
	}
}
