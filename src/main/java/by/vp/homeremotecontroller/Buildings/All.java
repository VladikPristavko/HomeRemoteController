package by.vp.homeremotecontroller.Buildings;

import by.vp.homeremotecontroller.Devices.Light;
import static by.vp.homeremotecontroller.CommandCreator.*;
public class All extends Building{
    public All(Light... lights){
        super(lights);
        commands.put("AllLightOn", create(this, "on", lights));
        commands.put("AllLightOff", create(this, "off", lights));
    }
}
