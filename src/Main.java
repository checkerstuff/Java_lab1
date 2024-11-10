class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class Container<T> {
    private Node<T> head;

    public Container() {
        this.head = null;
    }

    // Добавить элемент в контейнер
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Извлечь элемент по индексу
    public T get(int index) {
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
    }

    // Удалить элемент по индексу
    public void remove(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("Container is empty");
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;
        int count = 0;

        while (current != null && count < index) {
            previous = current;
            current = current.next;
            count++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }

        previous.next = current.next;
    }

    // Получить размер контейнера
    public int size() {
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Container<String> container = new Container<>();

        container.add("Первый");
        container.add("Второй");
        container.add("Третий");

}}