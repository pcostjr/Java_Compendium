/*
RubberDuck.java
@description: A simple class instantiation to show how objects work.
@author: pcostjr
@created: 10.14.2025
@last-update: 10.14.2025
*/

// all Java classes are housed in between this class declaration
public class RubberDuck
{
    // instance variables, or attributes, are the variables and structues that will
    // store the unique details of the object itself
    // each one must follow the following:
    // [SCOPE] [DATATYPE] name

    // The scope of the attribute denotes its accessibility outside the class

    // Objects can have unique values assigned here as well, but often we simply
    // just declare them, and assign them in the constructor.
    private String color;
    private String material;
    private int size;
    private int volume;
    private boolean sunglasses;

    // CLASS CONSTRUCTOR
    // Note: Since these each have the same number of attributes, only the top one can be invoked.
    // Comment out this one and the bottom one will work the same.
    // Each constructor defines the object in memory, and assigns its variables
    public RubberDuck(boolean sunglasses, int volume, int size, String material, String color) {
        // in this case, we can use the same variable names, so long as we use the 'this' keyword to specify
        // when we want to use the instance variables vs the local variables.
        this.sunglasses = sunglasses;
        this.volume = volume;
        this.size = size;
        this.material = material;
        this.color = color;
    }

    // default class constructor
    public RubberDuck() {
        sunglasses = true;
        volume = 2;
        size = 1;
        material = "rubber";
        color = "yellow";
    }

    // CLASS ACCESSORS
    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public boolean isSunglasses() {
        return sunglasses;
    }

    public String getSize() {
        String result = "";
        if(size == 1)
            result = "Small";
        else if(size == 2)
            result = "Medium";
        else if(size == 3)
            result = "Large";
        return result;
    }

    public String getVolume() {
        String result;
        switch(volume) {
            // if volume == 0
            case 0:
                result = "silent";
                break;
            // if volume == 1
            case 1:
                result = "quiet";
                break;
            // we need to have a default, but the only other case for volume would be 2
            default:
                result = "loud";
                break;
        }
        return result;
    }

    public String toString() {
        String result = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡶⠿⠿⠷⣶⣄⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⡿⠁⠀⠀⢀⣀⡀⠙⣷⡀⠀⠀⠀\n" +
                "⠀⠀⠀⡀⠀⠀⠀⠀⠀⢠⣿⠁⠀⠀⠀⠘⠿⠃⠀⢸⣿⣿⣿⣿\n" +
                "⠀⣠⡿⠛⢷⣦⡀⠀⠀⠈⣿⡄⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⠟\n" +
                "⢰⡿⠁⠀⠀⠙⢿⣦⣤⣤⣼⣿⣄⠀⠀⠀⠀⠀⢴⡟⠛⠋⠁⠀\n" +
                "⣿⠇⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠈⣿⡀⠀⠀⠀\n" +
                "⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡇⠀⠀⠀\n" +
                "⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡇⠀⠀⠀\n" +
                "⠸⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡿⠀⠀⠀⠀\n" +
                "⠀⠹⣷⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣰⡿⠁⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠉⠙⠛⠿⠶⣶⣶⣶⣶⣶⠶⠿⠟⠛⠉⠀⠀⠀⠀⠀⠀";

        result = result + "\n" + getSize() +"\nRubber Duck\nColor: " + color;
        result = result + "\nMaterial: " + material + "\n";
        result = result + "This rubber duck is " + getVolume();
        result = result + ( sunglasses ? "\nThis duck is very cool. B)" : "\nThis duck is not cool. :(" );
        return result;
    }

    // CLASS MUTATORS
    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void toggleSunglasses() {
        sunglasses = !sunglasses;
    }

    public void setSize(String size) {
        switch(size) {
            case "small":
                this.size = 1;
                break;
            case "medium":
                this.size = 2;
                break;
            default:
                this.size = 3;
        }
    }

    public void setSize(int size) {
        if(size <= 1)
            this.size = 1;
        else if(size >= 3)
            this.size = 3;
        else
            this.size = size;
    }

    public void setVolume(String volume) {
        switch(volume) {
            case "silent":
                this.volume = 0;
                break;
            case "quiet":
                this.volume = 1;
                break;
            default:
                this.volume = 2;
        }
    }

    public void setVolume(int volume) {
        if(volume <= 0)
            this.volume = 0;
        else if(volume >= 2)
            this.volume = 2;
        else
            this.volume = volume;
    }

    // ADDITIONAL METHODS
    public void quack() {

    }






    //   NOT NECESSARY BUT INCLUDED
//    public RubberDuck(String p_color, String p_material, int p_size, int p_volume, boolean p_sunglasses) {
//        // in this case, the local variables and instance variables have different names, so Java
//        // assumes we are invoking the instance variables here. Note how they are the same color as the
//        // this.x variables above.
//        color = p_color;
//        material = p_material;
//        size = p_size;
//        volume = p_volume;
//        sunglasses = p_sunglasses;
//    }


}
