package by.vp.homeremotecontroller.Commands;
import by.vp.homeremotecontroller.Buildings.Building;
import by.vp.homeremotecontroller.Devices.Device;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class UniversalCommand implements Command{
    private Building building;
    private Device[] devices;
    private String command;
    @Override
    public String execute() {
        StringBuilder result = new StringBuilder(/*building.getClass().getSimpleName()).append(" "*/);
        try {
            for (int i = 0; i < devices.length; i++) {
                result.append(devices[i].getClass().getDeclaredMethod(command).invoke(devices[i]))
                        .append(" ");
            }
            return result.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Error in " + result + "-"
                + devices[0].getClass().getSimpleName() + " command";
    }
    public String toString(){
        return building.getClass().getSimpleName() + " [ " + Arrays.toString(devices) + " ] " + command;
    }
}