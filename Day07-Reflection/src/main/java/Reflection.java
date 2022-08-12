import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reflection {
    private Scanner scanner;
    private Class<?> mClassObject;
    private Field[] fields;
    private Method[] methods;
    private Object inst;

    private List<Method> methodsClass;

    public Reflection() {
        System.out.println("Classes:");
        System.out.println("  - User");
        System.out.println("  - Car");
        System.out.println("---------------------");
        System.out.println("Enter class name:");

        scanner = new Scanner(System.in);
        initClass();
    }

    private void initClass() {
        String className = scanner.nextLine();
        try {
            getMethodsAndFields(className);
            createObject();
            changeField();
            callMethod();
        } catch (ClassNotFoundException e) {

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        scanner.close();
    }

    private void getMethodsAndFields(String className) throws ClassNotFoundException {
        mClassObject = Class.forName("classes." + className);

        fields = mClassObject.getDeclaredFields();
        System.out.println("---------------------");
        System.out.println("fields:");
        for (Field field : fields) {
            System.out.println("\t" + field.getType().getSimpleName() + " " + field.getName());
        }

        methods = mClassObject.getDeclaredMethods();
        System.out.println("methods:");
        methodsClass = new ArrayList<>();
        for (Method method : methods) {
            if (!(isOverriddenObject(method))) {
                methodsClass.add(method);
                System.out.print("\t" + method.getReturnType() + " ");
                String tmp = method.getName() + "(";
                int length = method.getParameters().length;
                for (Parameter param : method.getParameters()) {
                    tmp += param.getType();
                    if (length > 1) {
                        tmp += ", ";
                        length--;
                    }
                }
                tmp += ")";
                System.out.println(tmp);
            }
        }
    }

    private boolean isOverriddenObject(Method method) {
        Class<Object> objectClass = Object.class;
        Method[] objectMethod = objectClass.getDeclaredMethods();

        for (Method m : objectMethod) {
            if (m.getName().equals(method.getName())) {
                return true;
            }
        }
        return false;
    }

    private void createObject() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("---------------------");
        System.out.println("Let’s create an object.");
        Constructor<?>[] constructors = mClassObject.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterTypes().length == mClassObject.getDeclaredFields().length) {
                List<Object> obj = new ArrayList<>();
                for (Field field : fields) {
                    System.out.println(field.getName() + ":");
                    obj.add(castObjects(scanner.nextLine(), field.getType()));
                }
                inst = constructor.newInstance(obj.toArray());
                System.out.print("Object created: ");
                System.out.println(inst);
                return;
            }
        }
    }

    private Object castObjects(String str, Class type) {
        if (Boolean.class == type || boolean.class == type) {
            return Boolean.parseBoolean(str);
        }
        if (Byte.class == type || byte.class == type) {
            return Byte.parseByte(str);
        }
        if (Short.class == type || short.class == type) {
            return Short.parseShort(str);
        }
        if (Integer.class == type || int.class == type) {
            return Integer.parseInt(str);
        }
        if (Long.class == type || long.class == type) {
            return Long.parseLong(str);
        }
        if (Float.class == type || float.class == type) {
            return Float.parseFloat(str);
        }
        if (Double.class == type || double.class == type) {
            return Double.parseDouble(str);
        }
        return str;
    }

    private void changeField() throws IllegalAccessException {
        System.out.println("---------------------");
        System.out.println("Enter name of the field for changing:");
        String field = scanner.nextLine();
        for (int i = 0; i < fields.length; i++) {
            if (field.equals(fields[i].getName())) {
                System.out.println("Enter " + fields[i].getType().getSimpleName() + " value");
                fields[i].setAccessible(true);
                fields[i].set(inst, scanner.nextLine());
                System.out.println("Object updated: " + inst);
            }
        }
    }

    private void callMethod() throws InvocationTargetException, IllegalAccessException {
        System.out.println("Enter name of the method for call: ");
        String method = scanner.nextLine();
        for (int i = 0; i < methodsClass.size(); i++) {
            if (method.equals(methodsClass.get(i).toString())) {
                Class<?>[] parameters = methodsClass.get(i).getParameterTypes();
                Object[] args = new Object[parameters.length];
                for (int j = 0; j < parameters.length; j++) {
                    System.out.println("Enter " + parameters[j].getSimpleName() + " value");
                    args[j] = castObjects(scanner.nextLine(), parameters[j]);
                }
                methodsClass.get(i).setAccessible(true);
                Object obj = methodsClass.get(i).invoke(inst, args);
                System.out.println("Method returned:");
                System.out.println(obj);
            }
        }

    }
}
