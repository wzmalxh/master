package javatest.exception.java;

import javatest.exception.BaseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartExceptionDemo {
    public static void main(String[] args) throws BaseException {
        Cart item = new Cart();
        item.setProductName("wang");
        item.setQuantity(10);
        List<Cart> cartList = new ArrayList<>();
        for (Cart cartItem : cartList) {
            if (Objects.equals(cartItem.getProductName(), item.getProductName())) {
                int newQuantity = cartItem.getQuantity() + item.getQuantity();
                if (newQuantity >= 11) {
                    throw new BaseException("商品数量超过限制");
                }
                cartItem.setQuantity(newQuantity);
                return;
            }
        }
        cartList.add(item);
    }
}
