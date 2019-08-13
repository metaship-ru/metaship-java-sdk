# MetaShipJavaSDK
## Установка

> Минимальные требования — JAVA 1.8+.

### Использование

```php
 MetaShipApiClient metaShipApiClient = new MetaShipApiClient(
                "url",
                "your key",
                "your password"
        );
```

### Получение вариантов доставки

```php
OfferRequest offerRequest = new OfferRequest();
offerRequest.width = 10;
offerRequest.height = 10;
offerRequest.length = 10;
offerRequest.weight = 5;
offerRequest.paymentSum = 1000;
offerRequest.kladrIdFrom = 7700000000000L;
offerRequest.kladrIdTo = 7700000000000L;
offerRequest.zipTo = 125009;
offerRequest.deliveryType = "courier";
return offerRequest;

try {
        List<Offer> offers = metaShipApiClient.getOffers(offerRequest);
        offers.forEach(offer -> System.out.println(offer.toString()));
    } catch (Exception e) {
            e.printStackTrace();
}
```

### Создание заказа

```php
CreateOrderRequest createOrderRequest = new CreateOrderRequest();
createOrderRequest.deliveryType = "courier";
createOrderRequest.width = 10;
createOrderRequest.height = 10;
createOrderRequest.weight = 1.2f;
createOrderRequest.length = 10;
createOrderRequest.paymentSum = 1000;
createOrderRequest.assessedValue = 1000;
createOrderRequest.deliveryName = "Boxberry";
createOrderRequest.shopNumber = "Test-order-3";
createOrderRequest.deliveryCost = 200;
createOrderRequest.shopServiceCode = "3";
createOrderRequest.prepaidValue = 0;

CreateRecipientRequest createRecipientRequest = new CreateRecipientRequest();
createRecipientRequest.email = "test@test.com";
createRecipientRequest.firstName = "Иван";
createRecipientRequest.middleName = "Иванович";
createRecipientRequest.lastName = "Иванов";
createRecipientRequest.phone = "7(926)777-77-77";

CreateAddressRequest createAddressRequest = new CreateAddressRequest();
createAddressRequest.zip = 115612;
createAddressRequest.city = "Москва";
createAddressRequest.street = "Тверская";
createAddressRequest.house = "43";
createAddressRequest.housing = "3";
createAddressRequest.apartment = "кв 14";

createRecipientRequest.address = createAddressRequest;

createOrderRequest.recipient = createRecipientRequest;

CreateItemRequest createItemRequest = new CreateItemRequest();
createItemRequest.name = "iPhone 6s";
createItemRequest.weight = 1;
createItemRequest.cost = 100;
createItemRequest.quantity = 1;
createItemRequest.vatCode = "20";
createItemRequest.vendorCode = "W234HH-12";

createOrderRequest.items = new CreateItemRequest[]{createItemRequest};

try {
        Order responseOrder = metaShipApiClient.createOrder(prepareOrder());
        System.out.println(responseOrder.toString());
    } catch (Exception e) {
            e.printStackTrace();
}
```
