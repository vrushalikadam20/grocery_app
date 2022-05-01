package app.grocery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.grocery.entities.Seller;
import app.grocery.repository.SellerRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/grocery/v1")
public class SellerConntroller {

	@Autowired
	SellerRepository sellerRepo;
	
	
	@GetMapping("/getallseller")
	public List<Seller> getAllSeller()
	{
		return (List<Seller>)sellerRepo.findAll();
	}
	
	@GetMapping("/getseller/{sellerId}")
	public Seller getSeller(@PathVariable("sellerId") long sellerId )
	{
		
		 if(sellerRepo.findById(sellerId).isPresent())
		 {
			 return sellerRepo.findById(sellerId).get();
		 }
		 else
		 {
			 return null;
		 }
	}
	
	@PostMapping("/addseller")
	public Seller addSeller(@RequestBody Seller seller)
	{
		return sellerRepo.save(seller);
	}
	
	@PutMapping("/updateseller/{sellerId}")
	public Seller updateSeller(@RequestBody Seller seller,@PathVariable("sellerId")long sellerId)
	{
	Optional<Seller> s=sellerRepo.findById(sellerId);
	if(s.isPresent())
	{
		Seller object=s.get();
		object.setSellerName(seller.getSellerName());
		object.setSellerContact(seller.getSellerContact());
		
		return object;
		
	}
	else
	{
		return null;
	}
		
	}
	@DeleteMapping("/deleteseller/{sellerId}")
	public void deleteSeller(@PathVariable("sellerId")long sellerId)
	{
		
		sellerRepo.deleteById(sellerId);
	}
}
