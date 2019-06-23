import android.text.Layout;
import android.view.View;
 
/**
 * Created by a on 2017/4/15.
 */
 
 //配置当前游戏内玩家类型
public class ConfigHelper {
    //参与玩家数
    private int LocalHumanNum,OnlineHumanNum,AINum;
    private int GameType;//
    private int PlayerType[]=new int[4];
    private boolean Host;
    //private int redType,yellowType,blueType,greenType;
 
    public ConfigHelper(int GAMETYPE){
        GameType=GAMETYPE;
        if(GAMETYPE==Value.Online){
            LocalHumanNum=1;
            OnlineHumanNum=3;
            AINum=0;
        }
        else if(GAMETYPE==Value.Local){
            LocalHumanNum=4;
            OnlineHumanNum=0;
            AINum=0;
        }
        Host=true;//默认为主机
        PlayerType[Value.red]=Value.LocalHuman;
        PlayerType[Value.yellow]=Value.LocalHuman;
        PlayerType[Value.blue]=Value.LocalHuman;
        PlayerType[Value.green]=Value.LocalHuman;
    }
    //托管模式下，切换棋子模式
    public void cgPlayerType(int FACTION,int TYPE){
        if(TYPE==Value.LocalHuman) LocalHumanNum++;
        else if(TYPE==Value.OnlineHuman) OnlineHumanNum++;
        else if(TYPE==Value.AI) AINum++;
 
        int t=0;
        if(FACTION==Value.red){
            t=PlayerType[Value.red];//获取该棋子原本的类型
            setRedType(TYPE);
        }
        else if(FACTION==Value.yellow){
            t=PlayerType[Value.yellow];
            setYellowType(TYPE);
        }
        else if(FACTION==Value.blue){
            t=PlayerType[Value.blue];
            setBlueType(TYPE);
        }
        else if(FACTION==Value.green){
            t=PlayerType[Value.green];
            setGreenType(TYPE);
        }

        //根据该棋子原本的类型，减少对应的玩家类型数
        switch(t){
            case Value.LocalHuman:
                LocalHumanNum--;
                break;
            case Value.OnlineHuman:
                OnlineHumanNum--;
                break;
            case Value.AI:
                AINum--;
                break;
        }
    }

    //重置所有棋子的模式
    public void resetStatusALL(){
        if(GameType==Value.Online){
            LocalHumanNum=1;
            OnlineHumanNum=3;
            AINum=0;
        }
        else if(GameType==Value.Local){
            LocalHumanNum=4;
            OnlineHumanNum=0;
            AINum=0;
        }
        PlayerType[Value.red]=Value.LocalHuman;
        PlayerType[Value.yellow]=Value.LocalHuman;
        PlayerType[Value.blue]=Value.LocalHuman;
        PlayerType[Value.green]=Value.LocalHuman;
    }
    //设置各个阵营棋子的游戏模式
    public void setRedType(int TYPE){
        PlayerType[Value.red]=TYPE;
    }
    public void setYellowType(int TYPE){
        PlayerType[Value.yellow]=TYPE;
    }
    public void setBlueType(int TYPE){
        PlayerType[Value.blue]=TYPE;
    }
    public void setGreenType(int TYPE){
        PlayerType[Value.green]=TYPE;
    }
    public void setHost(boolean host) {
        Host = host;
    }
 
    public int getGameType(){
        return GameType;
    }
    public boolean isHost() {
        return Host;
    }
    public int getPlayerType(int FACTION) {
        return PlayerType[FACTION];
    }
 
    public int getRedType(){
        return PlayerType[Value.red];
    }
    public int getYellowType(){
        return PlayerType[Value.yellow];
    }
    public int getBlueType(){
        return PlayerType[Value.blue];
    }
    public int getGreenType(){
        return PlayerType[Value.green];
    }
}