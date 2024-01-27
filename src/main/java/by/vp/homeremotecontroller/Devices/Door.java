package by.vp.homeremotecontroller.Devices;
public class Door extends Device implements OpenCloseManipulation{
    private boolean isOpen = false;

    public Door(String name) {
        super(name);
    }

    @Override
    public String open() {
        if (isOpen){
            return this.name + " is already open";
        }
        isOpen = true;
        return this.name + " is OPEN";
    }

    @Override
    public String close() {
        if (!isOpen){
            return this.name + " is already close";
        }
        isOpen = false;
        return this.name + " is CLOSE";
    }
}
