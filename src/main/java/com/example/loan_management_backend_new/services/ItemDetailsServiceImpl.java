

package com.example.loan_management_backend_new.services;


import java.util.List;


import com.example.loan_management_backend_new.entities.ItemDetails;


import com.example.loan_management_backend_new.repositories.ItemDetailsRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Getter
@Setter
@Service
public class ItemDetailsServiceImpl implements ItemDetailsService {
    @Autowired
    private ItemDetailsRepository itemDetailsRepository;


    public void setItemDetailsRepository(ItemDetailsRepository itemDetailsRepository) {
        this.itemDetailsRepository =itemDetailsRepository;
    }


    @Override
    public ItemDetails addItemDetails(ItemDetails itemDetails) {
        // TODO Auto-generated method stub
        return itemDetailsRepository.save(itemDetails);

    }

    @Override
    public ItemDetails getItemDetailsById(int id) {
        // TODO Auto-generated method stub
        return itemDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public List<ItemDetails> getAllItemDetails() {
        // TODO Auto-generated method stub
        return  itemDetailsRepository.findAll();
    }


	@Override
	public void removeItemDetails(ItemDetails itemDetails) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		itemDetailsRepository.delete(itemDetails);
	}

}
