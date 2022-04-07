package Observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Sujeito {
    Collection observers = new ArrayList();

    public void addObservador(Observador o){
        observers.add(o);
    }

    public void removeObservador(Observador o){
        observers.remove(o);
    }

    public void notificarObservador(){
        Iterator it = observers.iterator();
        while(it.hasNext()){
            Observador o = (Observador)it.next();
            o.atualizar(this);
        }
    }
}
