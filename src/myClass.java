@myType(brokers = "localhost:8080",_continue=true)
public class myClass {
    @myField(enabled= true)
    public String myname="damitha";

    public int age;

    @myMethod
    public void sayName(){
        System.out.println(myname);
    }

    public int getAge() {
        return age;
    }

    @set
    public void setAge(int age) {
        this.age = age;
    }
}