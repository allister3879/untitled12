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

    public boolean equals(Object obj) { // method if diff keys have same index
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyTestingClass other = (MyTestingClass) obj;
        if (key != other.key)
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
