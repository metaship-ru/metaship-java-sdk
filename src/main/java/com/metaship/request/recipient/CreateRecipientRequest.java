package com.metaship.request.recipient;

import com.metaship.request.address.CreateAddressRequest;

public class CreateRecipientRequest {
    public String firstName;
    public String middleName;
    public String lastName;
    public String comment;
    public String phone;
    public String email;
    public int pickupPointId;
    public String pickupPointServiceNumber;
    public CreateAddressRequest address;
}
