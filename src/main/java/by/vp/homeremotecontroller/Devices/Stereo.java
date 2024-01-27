package by.vp.homeremotecontroller.Devices;
public class Stereo extends Device implements OnOffManipulation{
    private boolean isOn = false;

    public Stereo(String name) {
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
        isOn = true;
        return this.name + " is OFF";
    }
}
