public class MyTestingClass {
    private int key;
    private String value;
    private MyTestingClass(int key){
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
