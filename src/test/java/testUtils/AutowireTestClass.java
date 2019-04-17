package testUtils;

import org.springframework.stereotype.Component;

@Component
public class AutowireTestClass {

    public String getMyText() {
        return myText;
    }

    public void setMyText(String myText) {
        this.myText = myText;
    }

    private String myText;

}
