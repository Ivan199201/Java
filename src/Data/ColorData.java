package Data;

public enum ColorData {

    RED("Красный"),
    WHITE("Белый"),
    BLACK("Черный"),
    GREY("Серый"),
    BLU("Синий");

    private String name;

    ColorData(String name) {

        this.name = name;
    }

    public String getColor() {

        return name;
    }

}
