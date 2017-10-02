package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
@XmlType(name = "shop")
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    static class Goods {
        public List<String> names;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String name : goods.names) {
            stringBuffer.append("\ngood="+name);
        }
        stringBuffer.append("\ncount="+count).append("\nprofit="+profit);
        for (String secretDatum : secretData) {
            stringBuffer.append("\nsecretData="+secretDatum);
        }
        return stringBuffer.toString();
    }
}
