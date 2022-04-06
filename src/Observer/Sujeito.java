package Observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Sujeito {
    Collection observers = new ArrayList();

    public void add(Observador o){
        observers.add(o);
    }

    public void remove(Observador o){
        observers.remove(o);
    }

    public void notificar(){
        Iterator it = observers.iterator();
        while(it.hasNext()){
            Observador o = (Observador)it.next();
            o.atualizar(this);
        }
    }
}
