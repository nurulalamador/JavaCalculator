import java.util.ArrayList;
import java.util.Collections;

class Ador implements Comparable<Ador> {
    int x = 0;

    Ador(int x) {
        this.x = x;
    }

    public int compareTo (Ador ador) {
        if(this.x > ador.x) {
            return +1;
        }
        else if(this.x < ador.x) {
            return -                                                                                           1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        ArrayList<Ador> ador = new ArrayList<Ador>();

        System.out.println("Bador".compareTo("Bador"));

        ador.add(new Ador(5));
        ador.add(new Ador(1));
        ador.add(new Ador(2));
        ador.add(new Ador(6));
        ador.add(new Ador(0));

        Collections.sort(ador);

        for(int i=0; i<ador.size(); i++) {
            System.out.println(ador.get(i).x);
        }
    }
}

