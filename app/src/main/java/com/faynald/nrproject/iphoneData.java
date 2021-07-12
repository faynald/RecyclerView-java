package com.faynald.nrproject;

import java.util.ArrayList;

public class iphoneData {
    private static String[] iphoneNames = {
            "Iphone 5s",
            "Iphone SE",
            "Iphone 6",
            "Iphone 6s",
            "Iphone 6s Plus",
            "Iphone 7",
            "Iphone 7 Plus",
            "Iphone 8",
            "Iphone 8 Plus",
            "Iphone X",
            "Iphone XR",
            "Iphone XS",
            "Iphone SE 2020",
            "Iphone 11",
            "Iphone 11 Pro",
            "Iphone 11 Pro Max",
            "Iphone 12",
            "Iphone 12 Mini",
            "Iphone 12 Pro",
            "Iphone 12 Pro Max"
    };

    private static String[] iphoneDetails = {
            "Iphone keluaran 2015 yang bertenaga Processor Dual Core dengan Skor Antutu 100k ini mempunyai RAM sebesar 1 GB",
            "Iphone keluaran 2016 yang bertenaga Processor Dual Core dengan Skor Antutu 170k ini mempuynai RAM sebesar 2 GB",
            "Iphone dengan desain baru ini bertenaga Processor Dual Core seperti generasi sebelumnya meraih Skor Antutu 100k",
            "Iphone versi S ini meraih Skor Antutu sebesar 170k dengan RAM 2 GB",
            "Iphone versi besar ini meraih Skor Antutu yang sama seperti versi S",
            "Iphone generasi baru ini bertenaga Processor Quad Core dengan Skor Antutu sebesar 200k menyosong RAM 2 GB",
            "Iphone versi besar ini meraih Skor Antutu sebesar 230k dengan tenaga Quad Core seperti versi kecilnya namun mempunyai 3 GB RAM untuk versi ini",
            "Iphone versi baru ini meraih skor 270k dengan tenaga Processor Hexa Core dan RAM sebesar 2 GB",
            "Iphone versi besar ini bertenaga Processor 6 Core dengan Skor Antutu 300k dan mempunyai RAM sebesar 3 GB",
            "Iphone mungil ini bertenaga Processor yang sama seperti sebelumnya dengan skor Antutu 300k dan RAM sebesar 3 GB",
            "iphone versi R ini mempunyai body yang lebih besar dari versi biasa yaitu iphone X",
            "Iphone versi S ini lebih besar dari kedua versi iphone X lainnya",
            "Iphone mungil ini adalah generasi terakhir yang mempunyai desain seperti ini",
            "Iphone ini didesain seperti generasi sebelumnya hanya saja kameranya lebih menarik",
            "Iphone versi Pro ini mempunyai kamera lebih banyak dan tentunya fiturnya lebih banyak juga",
            "Iphone versi MAX ini mempunyai peforma yang MAX dari generasi kali ini",
            "Iphone ini merupakan lanjutan dari generasi sebelumnya",
            "Iphone versi Mini ini mempunyai body yang lebih mungil namun peforma yang ada di dalamnya menggelegar",
            "Iphone versi Pro ini mempunyai desain seperti sebelumnya hanya saja kameranya ada 3",
            "Iphone versi Pro Max ini mempunyai peforma yang lebih MAX"
    };

    private static int[] iphoneImages = {
            R.drawable.iphone5s,
            R.drawable.iphonese2016,
            R.drawable.iphone6,
            R.drawable.iphone6s,
            R.drawable.iphone6splus,
            R.drawable.iphone7,
            R.drawable.iphone7plus,
            R.drawable.iphone8,
            R.drawable.iphone8plus,
            R.drawable.iphonex,
            R.drawable.iphonexr,
            R.drawable.iphonexs,
            R.drawable.iphonese2020,
            R.drawable.iphone11,
            R.drawable.iphone11pro,
            R.drawable.iphone11promax,
            R.drawable.iphone12,
            R.drawable.iphone12mini,
            R.drawable.iphone12pro,
            R.drawable.iphone12promax
    };

    static ArrayList<iphone> getListData() {
        ArrayList<iphone> list = new ArrayList<>();
        for (int position = 0; position < iphoneNames.length; position++) {
            iphone ipin = new iphone();
            ipin.setName(iphoneNames[position]);
            ipin.setDetail(iphoneDetails[position]);
            ipin.setPhoto(iphoneImages[position]);
            list.add(ipin);
        }
        return list;
    }
}
