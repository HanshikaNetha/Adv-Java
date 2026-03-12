package com.example.SpringMvcProductApp.Repository;

import com.example.SpringMvcProductApp.Model.Product;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private List<Product> productList=new ArrayList<>();
    private Long idCounter=1L;

    public List<Product> findAll(){
        return productList;
    }
    public void save(Product product){
        if(product.getId()==null){
            product.setId(idCounter++);
            productList.add(product);
        }else{
            update(product);
        }
    }
    public Optional<Product> findById(Long id){
        return productList.stream().filter(i->i.getId().equals(id)).findFirst();
    }
    public void deleteById(Long id){
        productList.removeIf(i->i.getId().equals(id));
    }
    private void update(Product updatedProduct){
        for(int i=0; i<productList.size(); i++){
            if(productList.get(i).getId().equals(updatedProduct.getId())){
                productList.set(i, updatedProduct);
                break;
            }
        }
    }
}
