package BeanLifecycle;

public class Count {

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        Count.count = count;
    }

    private static int count;

    public int plus() {
        return count++;
    }
    public Count(){

    }
    private void destroyCount() {
        System.out.println("Destroy method Count.Class. Текущее значение = " + count + ". Destroy метод запустился, потому что scope = singleton.");
    }
}
