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

    public int hashCode() {
        final int prime = 31; //
        int result = 1;
        result = prime * result + key; //Multiply the key by a prime number
        result = prime * result + ((value == null) ? 0 : value.hashCode()); // adding hash code of value
        return result;
    }
}
