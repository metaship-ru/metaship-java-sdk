package com.metaship;

import com.metaship.entity.pickupPoint.PickupPoint;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

interface IMetaShipApiClient {
    PickupPoint searchPickupPoint(String serviceNumber, String externalNumber) throws IOException, NoSuchAlgorithmException, InvalidKeyException;
}
