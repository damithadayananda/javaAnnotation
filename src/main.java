import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class main {
    public static void main(String[] args){
        System.out.println("ddd");
        Class<myClass> obj = myClass.class;
        if(obj.isAnnotationPresent(myType.class)){
            System.out.println("class level annotation found");
            Annotation annotation = obj.getAnnotation(myType.class);
            myType myType = (myType)annotation;
            System.out.println(myType.brokers());
            System.out.println(myType._continue());
        }
        for(Field field:obj.getDeclaredFields()){
            if(field.isAnnotationPresent(myField.class)) {
                System.out.println("field level annotation found");
                Annotation annotation = field.getAnnotation(myField.class);
                myField myField = (myField) annotation;
                System.out.println(myField.enabled());
            }
        }
        for(Method method:obj.getDeclaredMethods()){
            System.out.println("method level annotation found");
            if(method.isAnnotationPresent(myMethod.class)){
                Annotation annotation = method.getAnnotation(myMethod.class);
                myMethod myMethod=(myMethod)annotation;
                try {
                    method.invoke(obj.newInstance());
                }catch (Exception ex){
                    System.out.println(ex);
                }
            }else if(method.isAnnotationPresent(set.class)){
                try {
                    myClass myClass=obj.newInstance();
                    myClass.setAge(56);
                    System.out.println(myClass.getAge());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
