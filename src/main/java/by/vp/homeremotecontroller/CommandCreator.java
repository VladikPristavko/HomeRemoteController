package by.vp.homeremotecontroller;
import by.vp.homeremotecontroller.Buildings.Building;
import by.vp.homeremotecontroller.Commands.Command;
import by.vp.homeremotecontroller.Commands.UniversalCommand;
import by.vp.homeremotecontroller.Devices.Device;
import java.util.HashMap;
import java.util.Map;

public class CommandCreator {

    public static Map<String, String[]> labelsAndButtons = new HashMap<>();
    public static Map<String, Command> commands = new HashMap<>();
    public static Command create(Building building, String command, Device... devices){
        return new UniversalCommand(building, devices, command);
    }
}
