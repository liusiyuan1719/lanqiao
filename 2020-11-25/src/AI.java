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

Image currentImg;
//Image currentImg,downImg1,leftImg1,upImg1,rightImg1,downImg2,leftImg2,upImg2,rightImg2,downImg3,leftImg3,upImg3,rightImg3;

Image heroImg[][]=new Image[4][3];//0left,1down,2up,3right
int x=105,y=180;
int flag=1,i,j;
//int leftflag=1,upflag=1,downflag=1,rightflag=1,i,j;
public MainCanvas()
{
	try
    {
    for(i=0;i<4;i++)
		{
		for(j=0;j<3;j++)
		{
        heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
		}
        }


	currentImg=heroImg[2][1];
    }
    catch (IOException e)

    {
	 e.printStackTrace();
    }
}
        public void paint(Graphics g){
		g.setColor(200,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void changeImageAndDirect(int  direction){
    if(flag==1)
		{
		currentImg=heroImg[direction][0];
        flag++;
		}
		else if(flag==2)
		{
        currentImg=heroImg[direction][2];
        flag=1;
		}
	}

    public void keyPressed(int keyCode)
	{
	int action=getGameAction(keyCode);
	if(action==LEFT){
		changeImageAndDirect(0);
        x=x-1;
	}
	if(action==UP)
		{
        changeImageAndDirect(2);
		y--;
		}
	if(action==DOWN){
		changeImageAndDirect(1);
		y++;
		}
	if(action==RIGHT){
		changeImageAndDirect(3);
		x++;
		}
		repaint();
	}

}