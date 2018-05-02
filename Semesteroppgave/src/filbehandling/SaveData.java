package filbehandling;

import java.io.Serializable;

public class SaveData implements Serializable {

    private final static long serialVersionUID = 1L;
    private String name1 = "New String";
    private String name2 = "Other New String";
    private int hp = 58235;

    public SaveData () {
        this.name1 = name1;
        this.name2 = name2;
        this.hp = hp;
    }

    public String getName1 (){
        return name1;
    }

    public String getName2(){
        return name2;
    }

    public int getHp (){
        return hp;
    }

    public String toString(){

        StringBuilder out = new StringBuilder();

        out.append(name1 + "\n");
        out.append(name2 + "\n");
        out.append(hp + "\n");

        return out.toString();
    }
}
