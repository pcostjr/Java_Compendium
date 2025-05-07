public class Cube
{
    private int sides = 6;
    private String color;
    private String material;
    private String property;
    private int side_length;
    private int id;

    private static int idNum;

    public Cube(String color, String material, String property, int side_length) {
        this.color = color;
        this.material = material;
        this.property = property;
        this.side_length = side_length;

        idNum++;
        id = idNum;

    }

    public Cube() {
        this.color = new String();
        this.material = new String();
        this.property = new String();
        this.side_length = 5;
        idNum++;
        id = idNum;

    }

    public String getColor() {
        return color;
    }

    public int getSide() {
        return side_length;
    }

    public String getMaterial() {
        return material;
    }

    public String getProperty() {
        return property;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setSide(int side_length) {
        this.side_length = side_length;
    }

    public double surfaceArea() {
        return 6 * Math.pow(side_length,2);
    }

    public double volume() {
        return Math.pow(side_length,3);
    }

    public void enlarge() {
        side_length++;
    }

    public void diminish() {
        side_length--;
    }

    public String toString() {
        String outString = "Cube Object:\n";
        outString = outString + "Color: " + this.color + "\n";
        outString = outString + "Material: " + this.material + "\n";
        outString = outString + "Special Properties: " + this.property + "\n";
        outString = outString + "Side Length: " + this.side_length + "\n";
        outString = outString + "ID: " + id + "/" + idNum;
        return outString;
    }


}
