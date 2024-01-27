package by.vp.homeremotecontroller.Devices;
public class Light extends Device implements OnOffManipulation {
    private boolean isOn = false;

    public Light(String name) {
        super(name);
    }

    @Override
    public String on() {
        if (isOn){
            return this.name + " is already ON";
        }
        isOn = true;
        return this.name + " is ON";
    }
    @Override
    public String off() {
        if (!isOn){
            return this.name + " is already OFF";
        }
        isOn = false;
        return this.name + " is OFF";
    }
}
