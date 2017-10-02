package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit() {
        Map<Date, Double> adsProfit = StatisticManager.getInstance().getAdsProfit();
        double totalAmount = 0d;
        for (Map.Entry<Date, Double> entry : adsProfit.entrySet()) {
            double amount = (double) entry.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", dateFormat.format(entry.getKey()), amount));
//            ConsoleHelper.writeMessage(String.format("%1$te-%1$tb-%1$tY - %2$.2f", entry.getKey(), amount));
            totalAmount += amount;
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", totalAmount));
    }
    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> cookWorkloading = StatisticManager.getInstance().getCookWorkloading();
        for (Map.Entry<Date, Map<String, Integer>> mapEntry : cookWorkloading.entrySet()) {
            ConsoleHelper.writeMessage(dateFormat.format(mapEntry.getKey()));
            for (Map.Entry<String, Integer> entry : mapEntry.getValue().entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", entry.getKey(), entry.getValue()/60));
            }
        }
    }
    public void printActiveVideoSet() {
        List<Advertisement> adList = StatisticAdvertisementManager.getInstance().getActiveVideoSet();
        if (adList.isEmpty()) return;
        Collections.sort(adList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement ad : adList) {
            ConsoleHelper.writeMessage(String.format("%s - %d", ad.getName(), ad.getHits()));
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> inactiveVideos = StatisticAdvertisementManager.getInstance().getInactiveVideoSet();
        Collections.sort(inactiveVideos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement advertisement : inactiveVideos) {
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }
}
