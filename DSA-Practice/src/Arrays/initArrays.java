//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Arrays;

public class initArrays {
    private int[] array = new int[10];
    private int size = 0;

    public initArrays() {
    }

    public void addFirst(int value) {
        this.ensureCapacity(this.size + 1);

        for(int i = this.size - 1; i >= 0; --i) {
            this.array[i + 1] = this.array[i];
        }

        this.array[0] = value;
        ++this.size;
    }

    public void addLast(int value) {
        this.ensureCapacity(this.size + 1);
        this.array[this.size++] = value;
    }

    public void removeAt(int index) {
        for(int i = index; i < this.size - 1; ++i) {
            this.array[i] = this.array[i + 1];
        }

        this.array[this.size - 1] = 0;
        --this.size;
    }

    public void insertAt(int index, int value) {
        this.ensureCapacity(this.size + 1);

        for(int i = this.size - 1; i >= index; --i) {
            this.array[i + 1] = this.array[i];
        }

        this.array[index] = value;
        ++this.size;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > this.array.length) {
            int newCapacity = Math.max(this.array.length * 2, minCapacity);
            int[] newArray = new int[newCapacity];

            for(int i = 0; i < this.size; ++i) {
                newArray[i] = this.array[i];
            }

            this.array = newArray;
        }

    }

    public void printArray() {
        for(int i = 0; i < this.size; ++i) {
            int var10001 = this.array[i];
            System.out.print("" + var10001 + " ");
        }

        System.out.println();
    }

    public int getSize() {
        return this.size;
    }

    public static void main(String[] args) {
        initArrays customArray = new initArrays();
        customArray.addLast(10);
        customArray.addLast(20);
        customArray.addLast(30);
        customArray.printArray();
        customArray.addFirst(5);
        customArray.printArray();
        customArray.insertAt(2, 15);
        customArray.printArray();
        customArray.removeAt(3);
        customArray.printArray();
    }
}
