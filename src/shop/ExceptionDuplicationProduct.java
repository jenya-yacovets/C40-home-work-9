package shop;

public class ExceptionDuplicationProduct extends Exception{
    private int id;

    public ExceptionDuplicationProduct(int id) {
        this.id = id;
    }

    public ExceptionDuplicationProduct() {}

    @Override
    public String getMessage() {
        return "Продукт с id - " + this.id + " уже имеется в базе.";
    }
}
