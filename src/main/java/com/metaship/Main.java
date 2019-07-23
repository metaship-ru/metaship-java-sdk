package com.metaship;

import com.metaship.entity.pickupPoint.PickupPoint;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {

        MetaShipApiClient metaShipApiClient = new MetaShipApiClient(
                "url",
                "your key",
                "your password"
        );
        try {
            PickupPoint pickupPoint = metaShipApiClient.searchPickupPoint("7702-001", "17");
            System.out.println(pickupPoint.toString());
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}




