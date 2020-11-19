import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas{
Image heroLeftImg[]= new Image[3];
Image heroDownImg[]= new Image[3];
Image heroUpImg[]= new Image[3];
Image heroRightImg[]= new Image[3];
Image currentImg;
//Image currentImg,downImg1,leftImg1,upImg1,rightImg1,downImg2,leftImg2,upImg2,rightImg2,downImg3,leftImg3,upImg3,rightImg3;
int x=100,y=120;

int leftflag=1,upflag=1,downflag=1,rightflag=1,i;
public MainCanvas(){
	try
    {
    for(i=0;i<heroLeftImg.length;i++)
		{
        heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
		}
    for(i=0;i<heroDownImg.length;i++)
		{
        heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
		}
    for(i=0;i<heroUpImg.length;i++)
		{
        heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
		}

    for(i=0;i<heroRightImg.length;i++)
		{
        heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
		}


/*
	downImg1= Image.createImage("/sayo10.png");
    downImg2= Image.createImage("/sayo00.png");

    leftImg1= Image.createImage("/sayo12.png");
    leftImg2= Image.createImage("/sayo02.png");
   
	upImg1= Image.createImage("/sayo14.png");
    upImg2= Image.createImage("/sayo04.png");

	rightImg1= Image.createImage("/sayo16.png");
    rightImg2= Image.createImage("/sayo06.png");

*/

	currentImg=heroDownImg[1];
    }
    catch (IOException e)

    {
	 e.printStackTrace();
    }
}
        public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
    public void keyPressed(int keyCode)
	{
	int action=getGameAction(keyCode);
	if(action==LEFT){
		if(leftflag==1)
		{
		currentImg=heroLeftImg[0];
        leftflag++;
		}
		else if(leftflag==2)
		{
        currentImg=heroLeftImg[2];
         leftflag=1;
		}
        x=x-1;
	}
	else if(action==UP)
		{
        if(upflag==1)
		{
		currentImg=heroUpImg[0];
        upflag++;
		}
        else if(upflag==2)
		{
        currentImg=heroUpImg[2];
        upflag=1;
		}
		y--;
		}
	else if(action==DOWN){
		if(downflag==1)
		{
		currentImg=heroDownImg[0];
        downflag++;
		}
		else if(downflag==2)
		{ 
		currentImg=heroDownImg[2];
        downflag=1;
		}
		y++;
		}
	else if(action==RIGHT){
        if(rightflag==1)
		{
		currentImg=heroRightImg[0];
        rightflag++;
		}
        else if(rightflag==2)
		{
        currentImg=heroRightImg[2];
		rightflag=1;
		}
		x++;
		}
		repaint();
	}

}