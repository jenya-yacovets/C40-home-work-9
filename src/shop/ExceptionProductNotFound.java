package shop;

public class ExceptionProductNotFound extends Exception {
    private int id;

    public ExceptionProductNotFound(int id) {
        this.id = id;
    }

    public ExceptionProductNotFound() {}

    public String getMessage() {
        return "Продукт с id - " + this.id + " не найден в базе.";
    }
}
