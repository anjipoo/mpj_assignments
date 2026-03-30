class Shapes {
    double length, breadth, height;
    Shapes(double l, double b) {
        length=l;
        breadth=b;
    }

    Shapes(double side) {
        length=side;
    }

    Shapes(double r, boolean iscircle) {
        length=r;
    }

    double area(double l, double b) {
        return l*b;
    }

    double area(double side) {
        return side*side;
    }

    double areacircle(double r) {
        return r*r*3.14;
    }
}

class Hillstations {
    void famousfood() {
        System.out.println("general hill station food");
    }

    void famousfor() {
        System.out.println("natural beauty");
    }
}

class Mussoorie extends Hillstations {
    void famousfood() {
        System.out.println("mussoorie famous food: momo");
    }

    void famousfor() {
        System.out.println("mussoorie famous for: waterfalls");
    }
}

class Ooty extends Hillstations {
    void famousfood() {
        System.out.println("ooty famous food: chocolates");
    }

    void famousfor() {
        System.out.println("ooty famous for: gardens");
    }
}

class Manali extends Hillstations {
    void famousfood() {
        System.out.println("manali famous food: siddu");
    }

    void famousfor() {
        System.out.println("manali famous for: snow mountains");
    }
}

public class MPJLab3 {
    public static void main(String[] args) {
        System.out.println("shapes overloading ->");
        Shapes rect=new Shapes(10,5);
        Shapes sq=new Shapes(4);
        Shapes circ=new Shapes(3, true);

        System.out.println("rectangle area: "+rect.area(10,5));
        System.out.println("square area: "+sq.area(4));
        System.out.println("circle area: "+circ.areacircle(3));


        System.out.println("hillstations overriding ->");

        Hillstations hs;

        hs=new Mussoorie();
        hs.famousfood();
        hs.famousfor();

        hs=new Ooty();
        hs.famousfood();
        hs.famousfor();

        hs=new Manali();
        hs.famousfood();
        hs.famousfor();
    }
}