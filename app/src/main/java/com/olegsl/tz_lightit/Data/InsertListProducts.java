package com.olegsl.tz_lightit.Data;

import com.olegsl.tz_lightit.ListAdapter.PostData;
import com.olegsl.tz_lightit.R;

import java.util.ArrayList;
import java.util.Random;
/**
 * Created by olegs_000 on 22.07.2015.
 */
public class InsertListProducts extends ArrayList<PostData> {

    private ArrayList<PostData> listData;
    PostData data;
    private static final Random RANDOM = new Random();

    public ArrayList<PostData> InsertList(){
        listData = new ArrayList<>();

        for (int i =0;i<=30;i++){

            data = new PostData();
            data.setIdProduct(i);
            data.setPostTitleProduct(getRandomTitle()+i);
            data.setPostDescriptionProduct(getRandomDescription()+i);
            data.setPostImageProduct(getRandomImage());
            listData.add(i,data);}

        return listData;

    }

    private static String getRandomDescription() {
        switch (RANDOM.nextInt(5)) {
            default:
            case 0:
                return "Brand: Apple Processor Speed:2.50GHz";
            case 1:
                return "Wireless Band : LTE 750 / 1700 WCDMA 850 / 900 / 1900 / 2100 CDMA 850 / 1900 GSM 850 / 900 / 1800 / 1900.\n" +
                        "Weight : 7.65 oz (217 g).\n" +
                        "Size : 6.48\" x 3.25\" x 0.41\" (165 x 83 x 10.3 mm).\n" +
                        "Form Factor : Bar.\n" +
                        "Battery :\n" +
                        "Talk: 28 hours max. (1680 minutes).\n" +
                        "Standby: 393 hours max. (16.4 days).\n" +
                        "mAh LiPolymer, Non-removable.\n" +
                        "Display : LCD (Color TFT/TFD) Resolution: 1080 x 1920 pixels 5.9\" diagonal Colors: 16.7 million (24-bit) Super LCD 3.\n" +
                        "Platform / OS : Android version 4.3.\n" +
                        "Memory :\n" +
                        "16 GB internal storage, raw hardware.\n" +
                        "10 GB internal storage, available to user.\n" +
                        "2 GB RAM.\n" +
                        "Processor : 1.7 GHz Qualcomm Snapdragon 600 quad-core.\n" +
                        "GPS : A-GPS.\n" +
                        "Bluetooth : HSP 1.2, HFP 1.6, OPP, FTP, PBA, A2DP 1.2, AVRC 1.3, HID, PAN, MAP version 4.0 / supports aptX.\n" +
                        "Wi-Fi : a,ac,b,g,n.\n" +
                        "Navigation : Touch screen.\n" +
                        "Camera : 4+ megapixel UltraPixel BSI sensor, auto-focus, optical stabilization, LED flash, f/2.0 lens, HTC ImageChip 2 / can capture photo+video simultaneously, sweep panorama, dual-camera capture.\n" +
                        "Video : Video Capture Resolution: 1080p HD supports HDR video, slow-motion, can take stills while recording video.\n" +
                        "Audio :\n" +
                        "FM Radio.\n" +
                        "Headphone Jack (3.5mm).\n" +
                        "HD Voice.";
            case 2:
                return "Brand New(No used,New in original box) \n" +
                        "\n" +
                        "Accessories :EF-M18-55mm F3.5-5.6 IS STM, EF-M22mm F2 STM, Mount Adapter EF-EOS M, Speedlite 90EX, Battery Charger LC-E12, Battery Pack LP-E12, interface cable, EOS DIGITAL Solution Disk, Neck Strap EM-100DB, (Japanese, English) CD-ROM";
            case 3:
                return "\n" +
                        "Brand:\t\n" +
                        "Apple\n" +
                        "Storage Capacity:\t64GB\n" +
                        "Product Line:\tiPad Air 2\tResolution:\t2048 x 1536\n" +
                        "Type:\tTablet\tScreen Size:\t9.7\"\n" +
                        "Internet Connectivity:\tWi-Fi\tHardware Connectivity:\tBluetooth, Lightning connector\n" +
                        "Carrier:\tNot Applicable\tOperating System:\tiOS";
            case 4:
                return "Google Glass V1 Charcoal  \n" +
                        "\n" +
                        "Fit: \n" +
                        "Adjustable nosepads and durable frame fits any face. Extra nosepads in two sizes. \n" +
                        "\n" +
                        "Display: \n" +
                        "High resolution display is the equivalent of a 25 inch high definition screen from eight feet away. \n" +
                        "\n" +
                        "Camera: \n" +
                        "Photos – 5 MP \n" +
                        "Videos – 720p \n" +
                        "\n" +
                        "Audio: \n" +
                        "Bone Conduction Transducer \n" +
                        "\n" +
                        "Connectivity:\n" +
                        "Wifi – 802.11b/g \n" +
                        "Bluetooth \n" +
                        "\n" +
                        "Storage: \n" +
                        "12 GB of usable memory, synced with Google cloud storage. \n" +
                        "16 GB Flash total. \n" +
                        "\n" +
                        "Battery: \n" +
                        "One full day of typical use. Some features, like Hangouts and video recording, are more battery intensive. \n" +
                        "\n" +
                        "Charger: \n" +
                        "Included Micro USB cable and charger. While there are thousands of Micro USB chargers out there, Glass is designed and tested with the included charger in mind. Use it and preserve long and prosperous Glass use. ";
        }


    }

    public static int getRandomImage() {
        switch (RANDOM.nextInt(5)) {
            default:
            case 0:
                return R.drawable.iphone;
            case 1:
                return R.drawable.ipad2;
            case 2:
                return R.drawable.camera;
            case 3:
                return R.drawable.googleglass;
            case 4:
                return R.drawable.macbook;
        }
    }

    public static  String getRandomTitle() {
        switch (RANDOM.nextInt(5)) {
            default:
            case 0:
                return "camera";
            case 1:
                return "ipad";
            case 2:
                return "iphone";
            case 3:
                return "googleglass";
            case 4:
                return "macbook";
        }
    }



}
