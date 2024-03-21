package becker.zacarias.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import becker.zacarias.restaurante.food.Food;
import becker.zacarias.restaurante.food.FoodRepository;
import becker.zacarias.restaurante.food.FoodRequestDTO;
import becker.zacarias.restaurante.food.FoodResponseDTO;

@RestController
@RequestMapping("food")
public class FoodController {

	@Autowired
	private FoodRepository foodRepository;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void saveFood(@RequestBody FoodRequestDTO data) {
		Food foodData = new Food(data);
		foodRepository.save(foodData);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<FoodResponseDTO> getAll() {
		List<FoodResponseDTO> foodList = foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
		return foodList;
	}
}
