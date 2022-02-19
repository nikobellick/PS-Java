package br.com.supera.game.store;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;


public class Carrinho {
    
   
    public long id;
    
    private BigDecimal price;
    
   
    List<Produtocarrinho> products = new ArrayList<Produtocarrinho>();
    
    private int shipping; 
    
    private BigDecimal totalPrice;
    
    
    public BigDecimal getTotalPrice(){
            totalPrice = new BigDecimal(0);
            totalPrice = totalPrice.add(getPrice().add(new BigDecimal(getShipping())));
        return totalPrice;
    }
    
    public BigDecimal getPrice(){
        price = new BigDecimal(0);
        for(Produtocarrinho p : products){
            price = price.add(new BigDecimal(p.product.price.doubleValue() * p.quantity));
        }
        return price;
    }
    
    private int getShipping(){
        shipping = 0;
        if(getPrice().doubleValue() > 250){
            return shipping;
        
        }
        for(Produtocarrinho p : products){
            shipping += 10;
        }
        return shipping;
    }
}