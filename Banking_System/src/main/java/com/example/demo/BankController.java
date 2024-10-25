package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BankController {
	private BankService service;

	public BankController(BankService service) {
		super();
		this.service = service;
	}

	
	@GetMapping("/addNew")
	public String addNewBank(Model model) {
		Bank b = new Bank();
		model.addAttribute("bank", b);
		return "addBank";
	}
	
	
	@GetMapping("/updateBank/{id}")
	public String updateBank(@PathVariable int id,Model model) {
		Bank b = service.retrieveById(id);
		model.addAttribute("bank", b);
		return "addBank";
	}
	
	
	@GetMapping(path = {"/","/bank"})
	public String getAllBank(Model model) {
		model.addAttribute("list_of_customer", service.retrieveAll());
				return "index";
	}
	
	@PostMapping("/save")
	public String createBank(@ModelAttribute Bank bank) {
		service.savebank(bank);
		return "redirect:/";
	}
	
	@GetMapping("/modifydeposit/{id}")
	public String modifydeposit(@PathVariable int id, Model model)
	{
		Bank b = service.retrieveById(id);
		model.addAttribute("bank",b);
		return "deposit";
	}
	
	
	@PostMapping("/modifydeposit/{id}")
	public String modifydepositBank(@PathVariable int id, @RequestParam("amount") int amount )
	{
		Bank b = service.retrieveById(id);
		int a = b.getAmount() ;
		a = a + amount; 
		b.setAmount(a);
		service.savebank(b);
		return "redirect:/bank";
	}
	
	
	@GetMapping("/modifywithdraw/{id}")
	public String modifywithdraw(@PathVariable int id, Model model)
	{
		Bank b = service.retrieveById(id);
		model.addAttribute("bank",b);
		return "withdraw";
	}
	
	
	@PostMapping("/modifywithdraw/{id}")
	public String modifywithdrawBank(@PathVariable int id, @RequestParam("amount") int amount )
	{
		Bank b = service.retrieveById(id);
		int a = b.getAmount() ;
		if (a<amount)
		{
			return"redirect:/bank";
		}
		a = a - amount; 
		b.setAmount(a);
		service.savebank(b);
		return "redirect:/bank";
	}
	
	@GetMapping("/deleteBank/{id}")
	public String getstudent(@PathVariable int id)
	{
		service.deleteBank(id);
		return "redirect:/";
	}
	
	
}
