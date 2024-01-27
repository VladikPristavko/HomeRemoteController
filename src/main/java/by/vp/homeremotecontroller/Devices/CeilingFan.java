package by.vp.homeremotecontroller.Devices;
public class CeilingFan extends Device implements OnOffManipulation{
    private FanConditions currentCondition;
    public CeilingFan(String name){
        super(name);
        this.currentCondition = FanConditions.Off;
    }
    @Override
    public String on() {
        if (this.currentCondition.equals(FanConditions.On)){
            return this.name + " is already ON";
        }
        this.currentCondition = FanConditions.On;
        return this.name + " is ON";
    }
    @Override
    public String off() {
        if (this.currentCondition.equals(FanConditions.Off)){
            return this.name + " is already OFF";
        }
        this.currentCondition = FanConditions.Off;
        return this.name + " is OFF";
    }
    public String next() {
        if (this.currentCondition.equals(FanConditions.Off)){
            return this.name + " is OFF, press ON";
        }
        int length = FanConditions.values().length;
        if (this.currentCondition.getValue() == length - 1){
            this.currentCondition = FanConditions.Off;
        } else {
            this.currentCondition = FanConditions.values()[currentCondition.getValue() + 1];
        }
        return this.name + " set condition on " + this.currentCondition.name();
    }
}
