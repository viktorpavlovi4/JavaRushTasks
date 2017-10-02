package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
        try {
            //1
            Solution solution = new Solution("C:\\1.txt");
            //2
            solution.writeObject("HELLO!");
            //3
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\0.txt"));
            oos.writeObject(solution);
            oos.close();
            //4
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\0.txt"));
            Solution newSol = (Solution) ois.readObject();
            ois.close();
            //5
            newSol.writeObject("!!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
