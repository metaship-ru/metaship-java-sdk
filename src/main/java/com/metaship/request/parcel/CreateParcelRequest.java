package com.metaship.request.parcel;

import java.util.List;

public class CreateParcelRequest {
    public static final String  PATH = "/v1/parcels";
    public static final String  METHOD = "POST";

    public List orderNumbers;
}
