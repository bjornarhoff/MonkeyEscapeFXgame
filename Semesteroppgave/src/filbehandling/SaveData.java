package filbehandling;

import java.io.Serializable;

public class SaveData implements Serializable {

    private final static long serialVersionUID = 1L;
    private String name;
    private int hp;

    public SaveData () {
        this.name = name;
        this.hp = hp;
    }

    public String getName (){
        return name;
    }

    public int getHp (){
        return hp;
    }
}
