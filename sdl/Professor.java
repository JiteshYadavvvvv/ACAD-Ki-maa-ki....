
interface Teacher {
    void teach();
}

interface Researcher {
    void research();
}

class Professor implements Teacher, Researcher {
    public void teach() {
        System.out.println("Professor is teaching");
    }

    public void research() {
        System.out.println("Professor is researching");
    }
}

class Main {
    public static void main(String args[]) {
        Professor p = new Professor();

        Teacher t = p;
        Researcher r = p;

        t.teach();
        r.research();
    }
}
