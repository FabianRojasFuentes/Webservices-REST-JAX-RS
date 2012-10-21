package se.groupRed.maven.jpa.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.groupRed.maven.model.Product;

@Service
public class ProductService
{

	@Autowired
	private ProductRepository productRepository;

	public Product getProductWithReferenceNumber(final String referenceNumber)
	{
		return productRepository.findByReferenceNumber(referenceNumber);
	}

	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}

	public Product addProduct(String productName, String price, String brand, String referenceNumber,
			String description, String genre, String state)
	{
		Product product = new Product(productName, price, brand, referenceNumber, description, genre, state);
		return productRepository.save(product);
	}

	public void updateProduct(final Product product)
	{
		productRepository.updateProduct(product.getProductName(), product.getPrice(), product.getBrand(),
				product.getReferenceNumber(), product.getDescription(), product.getGenre(), product.getState());
	}

	public void deleteProduct(final String referenceNumber, final String state)
	{
		productRepository.deleteProduct(referenceNumber, state);
	}

	public boolean checkProduct(String referenceNumber)
	{
		if (productRepository.findByReferenceNumber(referenceNumber) != null)
		{
			return true;
		} else
			return false;
	}

	public Product getProduct(Long id)
	{
		return productRepository.findById(id);
	}

}
