package com.example.part_1.part1_extra_store_optional;


import rx.Observable;

public class UserActivityUtils {

    public static Observable<Product> findMostExpansivePurchase(Observable<Order> ordersHistory) {
        // TODO: flatten all Products inside Orders and using reduce find one with the highest price

        return ordersHistory
                .flatMapIterable(Order::getProductsIds)
                .map(ProductsCatalog::findById)
                .reduce(new Product("", "", 0), (me, next) -> next.getPrice() > me.getPrice() ? next : me);

    }
}
