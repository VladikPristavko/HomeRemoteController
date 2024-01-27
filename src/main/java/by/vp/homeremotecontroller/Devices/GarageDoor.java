package by.vp.homeremotecontroller.Devices;
public class GarageDoor extends Device implements OpenCloseManipulation{
    private boolean isUp = false;
    private boolean isStop = false;

    public GarageDoor(String name) {
        super(name);
    }

    @Override
    public String open() {
        if(isUp){
            return this.name + " is already up";
        }
        isUp = true;
        isStop = false;
        return this.name + " is UP";
    }
    public String stop(){
        if (isStop){
            return this.name + " is already STOP";
        }
        isStop = true;
        return this.name + " is STOP";
    }
    @Override
    public String close() {
        if(!isUp){
            return this.name + " is already DOWN";
        }
        isUp = false;
        isStop = false;
        return this.name + " is DOWN";
    }


}
