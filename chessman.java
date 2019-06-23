import android.widget.ImageView;
 
/**
 * Created by Shenpibaipao
 */
 
public class Cheesman {
 
    private boolean completed,flying;//棋子状态
    private int now_pos;//当前已移动步数
 
    private int faction,num;//棋子阵营，编号
    private ImageView img;//绑定棋子id
    private static int kuan, left_top_pos;//棋局格子宽度 和左上角坐标
    //ok
    public Cheesman(int FACTION,int NUM,ImageView IMAGEVIEW){
        resetStatusALL();
        faction=FACTION;
        img=IMAGEVIEW;
        num=NUM;
        now_pos=0;
    }
    //ok
    public void resetStatusALL(){
        completed=false;
        flying=false;
        now_pos=0;
    }

    //还有问题，左上角坐标不是应该有两个点吗？
    public void move(int POSX,int POSY){
        img.setX(POSX*kuan);
        img.setY(left_top_pos+POSY*kuan); //????
    }

    public void move(int steps){
        //最多57格 0~26
        int cha=now_pos+steps-Value.Teminal;  //超过终点的步数
        if(cha<0)cha=0;
        if(isFlying()){
            switch(Faction){
                case Value.red:
                //超过终点则要回返
                    move(Value.redPathx[now_pos+steps-cha],Value.redPathy[now_pos+steps-cha]);
                    break;
                case Value.yellow:
                    move(Value.yellowPathx[now_pos+steps-cha],Value.yellowPathy[now_pos+steps-cha]);
                    break;
                case Value.blue:
                    move(Value.bluePathx[now_pos+steps-cha],Value.bluePathy[now_pos+steps-cha]);
                    break;
                case Value.green:
                    move(Value.greenPathx[now_pos+steps-cha],Value.greenPathy[now_pos+steps-cha]);
                    break;
            }
        }
        now_pos+=steps;
    }
    public int getX(){
        return (int)img.getX()/kuan;
    }
    public int getY(){
        return (int)(img.getY()-left_top_pos)/kuan;
    }
    public int getFaction(){
        return faction;
    }
    public int getNum(){
        return num;
    }
    public int getNow_pos(){
        return now_pos;
    }
 
    public boolean isCompleted(){
        return completed;
    }
    public boolean isFlying(){
        return flying;
    }
    //将该棋子标记为已完成，初始化参数
    public void CompletedTour(){
        now_pos=0;
        setFlying(false);
        setcompleted(true);
    }
    //棋子可以开始行动，设置他们的初始位置
    public void Fly(){
        now_pos=0;
        switch (Faction){
            case Value.red:
                move(Value.redPathx[now_pos],Value.redPathy[now_pos]);
                break;
            case Value.yellow:
                move(Value.yellowPathx[now_pos],Value.yellowPathy[now_pos]);
                break;
            case Value.blue:
                move(Value.bluePathx[now_pos],Value.bluePathy[now_pos]);
                break;
            case Value.green:
                move(Value.greenPathx[now_pos],Value.greenPathy[now_pos]);
                break;
            default:
                System.out.println("发动机故障，起飞失败");
        }
        setFlying(true);
    }
    //被击杀，初始化参数
    public void Killed(){
        now_pos=0;
        setFlying(false);
        System.out.println("我方军机已被击毁");
    }
    //设置棋格宽度，以及棋盘左上角坐标
    public static void load_qipan(int KUAN,int LEFT_TOP_POS){
        kuan=KUAN;
        left_top_pos=LEFT_TOP_POS;
    }
    public ImageView getImg(){
        return img;
    }
    private void setFlying(boolean bool){
        flying=bool;
    }
    private void setCompleted(boolean bool){
        completed=bool;
    }
 
}

