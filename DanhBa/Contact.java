package DanhBa;

import java.util.ArrayList;

public class Contact {
    public Contact() {}
    private String name;
    private ArrayList<String> numbers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<String> numbers) {
        this.numbers = numbers;
    }
}
